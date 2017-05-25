package dongting.bwei.com.recycleviewexercise;

import java.util.List;

/**
 * 作者:${董婷}
 * 日期:2017/5/23
 * 描述:
 */

public class NewsBean {

    /**
     * ret_code : 200
     * ret_msg : ok
     * list : [{"date":"333","id":3,"pic":"http://p1.pstatp.com/large/22c90001cf8b5388ce33","title":"  他\u201c秘书圈\u201d的人数规模，赶上了周永康","type":1},{"date":"5555","id":5,"pic":"http://p3.pstatp.com/large/22c70005e93dcaf6bfa8|http://p1.pstatp.com/list/190x124/22b400060773190f7816","title":" \n袁世凯临终前，在传位名单上写下三个人的名字，众人看了敬佩不已","type":2},{"date":"6666","id":6,"pic":"http://p3.pstatp.com/list/190x124/216d001357929b02f476","title":" \n张爱朋首回应白百何绯闻事件，短短二句话，白百何后悔看错了吧！","type":1},{"date":"7777","id":7,"pic":"http://p3.pstatp.com/list/190x124/213300016c777190f9ed","title":" \n曾经的歌星，落魄到参加选秀，结果唱一半却被韩红喊停","type":1},{"date":"99","id":9,"pic":"http://p3.pstatp.com/list/190x124/22c700036549c9b5ff07","title":"中国第一黑老大东北王乔四爷 最终也逃不过法网恢恢","type":1},{"date":"111","id":10,"pic":"http://p3.pstatp.com/list/190x124/22c6000628d79850e6d7","title":"号称中国关系最硬的人，奶奶是慈禧，大伯是光绪，哥哥是宣统！","type":1}]
     */

    private int ret_code;
    private String ret_msg;
    private List<ListBean> list;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * date : 333
         * id : 3
         * pic : http://p1.pstatp.com/large/22c90001cf8b5388ce33
         * title :   他“秘书圈”的人数规模，赶上了周永康
         * type : 1
         */

        private String date;
        private int id;
        private String pic;
        private String title;
        private int type;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
