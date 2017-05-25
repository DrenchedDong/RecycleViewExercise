package dongting.bwei.com.recycleviewexercise;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.aspsine.irecyclerview.OnRefreshListener;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import dongting.bwei.com.recycleviewexercise.footer.LoadMoreFooterView;

public class MainActivity extends Activity {
    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    refresh=false;
                    initData();
                    recyclerView.setRefreshing(false);

                    break;
                case 2:
                    refresh=false;
                    initData();

                    loadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);

                    break;
            }
        }
    } ;
    private LoadMoreFooterView loadMoreFooterView;
    private IRecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    List<NewsBean.ListBean> listall=new ArrayList<>();
    boolean refresh=true;
    private RecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (IRecyclerView) findViewById(R.id.recycleview_id);
        loadMoreFooterView = (LoadMoreFooterView)recyclerView.getLoadMoreFooterView();

        initData();

        //设置布局管理器
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //上拉加载更多
       recyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                loadMoreFooterView.setStatus(LoadMoreFooterView.Status.LOADING);
                handler.sendEmptyMessageDelayed(2,2000);

            }
        });

//下拉刷新
        recyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {

                recyclerView.setRefreshing(true);
                listall.clear();

                handler.sendEmptyMessageDelayed(1,2000);

            }
        });
    }

    private void goAdapter(boolean refresh) {
        if(refresh==true){
            adapter = new RecycleViewAdapter(this,listall);
            recyclerView.setIAdapter(adapter);

        }else{
            adapter.notifyDataSetChanged();

        }
    }


    private void initData() {
        String url="http://qhb.2dyt.com/Bwei/news?postkey=1503d&page=1&type=1";
        RequestParams requestParams=new RequestParams(url);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                NewsBean newsBean = gson.fromJson(result, NewsBean.class);
                List<NewsBean.ListBean> list = newsBean.getList();
                listall.addAll(list);
                Log.e("--",result);
                goAdapter(refresh);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {

            }
        });
    }
}
