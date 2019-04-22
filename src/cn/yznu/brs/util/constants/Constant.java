package cn.yznu.brs.util.constants;

public class Constant {

    //当前页面
    public static String curPage = "";

    public static final String USERTABLE = "brs_user";//用户表
    public static final String MESSAGETABLE = "brs_message";//歌曲表
    public static final String ORDERTABLE = "brs_order";//歌曲表

    //订单处理状态
    public static final String orderState[] = {"未处理", "已接受", "已取消"};
    public static final String reservationTime[] = {"8:00-10:00", "10:00-12:00", "14:00-16:00", "16:00-18:00"};

    public static final String userType[] = {"用户", "理发师", "管理员"};

    //每一页显示的最大条目数量
    public static int PAGE_DEFAULT_SIZE = 5;

}
