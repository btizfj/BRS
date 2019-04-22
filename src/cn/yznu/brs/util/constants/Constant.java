package cn.yznu.brs.util.constants;

public class Constant {

    //当前页面
    public static String curPage = "";

    public static final String USERTABLE = "brs_user";//用户表
    public static final String MESSAGETABLE = "brs_message";//歌曲表
    public static final String ORDERTABLE = "brs_order";//歌曲表

    //订单处理状态
    public static final String orderState[] = {"未处理","已接受","已取消"};
    public static final String reservationTime[] = {"8:00-10:00","10:00-12:00","14:00-16:00","16:00-18:00"};

    public static final String userType[] = {"用户","理发师","管理员"};


    public static final int TYPE_STUDENT = 0;//学生类型
    public static final int TYPE_TEACHER = 1;//老师类型
    public static final int TYPE_ADMIN = 2;//管理员

    //学院及其编号                              0           1           2           3        4          5           6           7               8
    public static final String colleges[] = {"文学院","传媒学院","计算机学院","财经学院","管理学院","美术学院","体育学院","化工化学学院","外国语学院"};

    //每一页显示的最大条目数量
    public static int PAGE_DEFAULT_SIZE = 5;

    //是否为优秀项目
    public static final String isGoodResule[] = {"否","是"};
    //通知类型
    public static final String resultType[] = {"通知公告","公开信息"};
    //用户类型
//    public static final String userType[] = {"学生","老师","管理员"};

    //审核状态
    public static final String trail_state[] = {"正在审核","审核失败","审核通过"};
    //成果大类                                      1              2             3
    public static final String type_big[] = {"基础理论成果","应用技术成果","软科学成果"};
    //成果小类                                     1(1)        1(2)         1(3)           1(4)               2(5)                 2(6)           3(7)       3(8)     4(9)
    public static final String type_small[] = {"论文和专著","发明专利","实用新型专利","外观设计专利","自主研发的新产品原型","自主开发的新技术","基础软件","应用软件","其他"};
}
