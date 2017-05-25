package dongting.bwei.com.recycleviewexercise;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 作者:${董婷}
 * 日期:2017/5/23
 * 描述:
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    int header = 0;
    int content_one =1;
    int content_two = 2;
    int footer = 3;

    List<NewsBean.ListBean> newsBeanList;
    MainActivity context;
    LayoutInflater inflater;

    public RecycleViewAdapter(MainActivity context, List<NewsBean.ListBean> newsBeanList) {
        this.context = context;
        this.newsBeanList = newsBeanList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {

            View view = inflater.inflate(R.layout.header, parent, false);

           HViewHolder hViewHolder=new HViewHolder(view);

            return hViewHolder;

        } else if(viewType==1){
            View view = inflater.inflate(R.layout.one_layout, parent, false);

            OneViewHolder one=new OneViewHolder(view);

            return one;

        }else if(viewType==2){
            View view = inflater.inflate(R.layout.two_layout, parent, false);

            TwoViewHolder two=new TwoViewHolder(view);

            return two;

        }else{
            View view = inflater.inflate(R.layout.footer, parent, false);

            FViewHolder fViewHolder=new FViewHolder(view);

            return fViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof HViewHolder){

            HViewHolder hViewHolder = (HViewHolder) holder ;

            hViewHolder.htv.setText("header");
        }

        if(holder instanceof TwoViewHolder){
            TwoViewHolder twoViewHolder = (TwoViewHolder) holder ;
            twoViewHolder.tv_two.setText(newsBeanList.get(position).getTitle());

            String pic = newsBeanList.get(position).getPic();

            String[] split = pic.split("\\|");

            Glide.with(context).load(split[0])
                    .error(R.mipmap.ic_launcher)
                    .into(twoViewHolder.iv_two1);
            Glide.with(context).load(split[1])
                    .error(R.mipmap.ic_launcher)
                    .into(twoViewHolder.iv_two2);
        }

        if(holder instanceof OneViewHolder){
                OneViewHolder oneViewHolder = (OneViewHolder) holder ;
                oneViewHolder.tv_one.setText(newsBeanList.get(position).getTitle());

                Glide.with(context).load(newsBeanList.get(position).getPic())
                        .error(R.mipmap.ic_launcher)
                        .into(oneViewHolder.iv_one);
    }

        if(holder instanceof FViewHolder){
            FViewHolder fViewHolder = (FViewHolder) holder ;
            fViewHolder.ftv.setText("footer");
        }
    }

    @Override
    public int getItemCount() {
        return newsBeanList!=null?newsBeanList.size()+2:0;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return header;
        } else if (newsBeanList.get(position).getType()==1) {
            return content_one;
        } else if(newsBeanList.get(position).getType()==2){
            return content_two;
        } else if (position == newsBeanList.size() + 1) {
            return footer;
        }
        return 8;
    }

        class TwoViewHolder extends RecyclerView.ViewHolder {

            private final TextView tv_two;
            private final ImageView iv_two1;
            private final ImageView iv_two2;


            public TwoViewHolder(View itemView) {
                super(itemView);

                tv_two = (TextView) itemView.findViewById(R.id.tv_two);
                iv_two1 = (ImageView) itemView.findViewById(R.id.iv_two1);
                iv_two2 = (ImageView) itemView.findViewById(R.id.iv_two2);

            }
        }
        class OneViewHolder extends RecyclerView.ViewHolder {

            private final TextView tv_one;
            private final ImageView iv_one;

            public OneViewHolder(View itemView) {
                super(itemView);

                tv_one = (TextView) itemView.findViewById(R.id.tv_one);
                iv_one = (ImageView) itemView.findViewById(R.id.iv_one);
            }
        }

    class HViewHolder extends RecyclerView.ViewHolder {

        private final TextView htv;

        public HViewHolder(View itemView) {
            super(itemView);

            htv = (TextView) itemView.findViewById(R.id.header);
        }
    }

    class FViewHolder extends RecyclerView.ViewHolder {

        private final TextView ftv;

        public FViewHolder(View itemView) {
            super(itemView);

            ftv = (TextView) itemView.findViewById(R.id.footer);
        }
    }

    //添加数据
    public void add(int position){
        //newsBeanList.add(position,new NewsBean.ListBean());
    }

    //删除数据
    public void delete(){

    }

    }