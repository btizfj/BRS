package cn.yznu.brs.dao;

import cn.yznu.brs.bean.Message;
import cn.yznu.brs.bean.Order;
import cn.yznu.brs.bean.User;
import cn.yznu.brs.dao.provider.UserDynamicSqlProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import static cn.yznu.brs.util.constants.Constant.*;

public interface UserDao {

    @SelectProvider(type= UserDynamicSqlProvider.class,method="selectUserByAccount")
    User selectUserByAccount(String username, String password);

    @Select("select count(*) from " + MESSAGETABLE + " where user_id=#{id}" )
    int countMessageByUserId(Integer id);

    @SelectProvider(type= UserDynamicSqlProvider.class,method="selectMessageByPage")
    List<Message> selectMessageByPage(Map<String, Object> params);

    @Delete("delete from " + MESSAGETABLE + " where id=#{id}")
    void deleteMessageById(Integer id);

    @Select("select count(*) from " + ORDERTABLE + " where user_id=#{id}" )
    int countOrderByUserId(int id);

    @SelectProvider(type= UserDynamicSqlProvider.class,method="selectOrderByPage")
    List<Order> selectOrderByPage(Map<String, Object> params);

    @Delete("delete from " + ORDERTABLE + " where id=#{id}")
    void deleteOrderById(Integer id);

    @Select("select * from " + USERTABLE + " where usertype=1" )
    List<User> selectAllBarber();

    @SelectProvider(type= UserDynamicSqlProvider.class,method="insertOrder")
    void insertOrder(int id, Integer barber_id, Integer r_time, Integer r_price, Date time);

    @SelectProvider(type= UserDynamicSqlProvider.class,method="insertMessage")
    void insertMessage(Integer barber_id, String s, Date time);

    @Select("select count(*) from " + ORDERTABLE + " where barber_id=#{id}" )
    int countBarberOrderByUserId(int id);

    @SelectProvider(type= UserDynamicSqlProvider.class,method="selectBarberOrderByPage")
    List<Order> selectBarberOrderByPage(Map<String, Object> params);

    @Update("update " + ORDERTABLE + " set isProcess=1 where id=#{id}")
    void acceptOrderViaId(Integer id);

    @Update("update " + ORDERTABLE + " set isProcess=2 where id=#{id}")
    void cancelOrderViaId(Integer id);

    @Select("select * from " + ORDERTABLE + " where id=#{id}" )
    Order selectOrderById(Integer id);

    @SelectProvider(type= UserDynamicSqlProvider.class,method="insertAcceptOrderMessageById")
    void insertAcceptOrderMessageById(Integer user_id, Date date);

    @SelectProvider(type= UserDynamicSqlProvider.class,method="insertCancelOrderMessageById")
    void insertCancelOrderMessageById(Integer user_id, Date date);

    @Select("select count(*) from " + USERTABLE +" where usertype=0")
    int countAllUser();

    @SelectProvider(type= UserDynamicSqlProvider.class,method="selectAllUserByPage")
    List<User> selectAllUserByPage(Map<String, Object> params);

    @Delete("delete from " + USERTABLE + " where id=#{id}")
    void deleteUserById(Integer id);

    @Select("select count(*) from " + USERTABLE +" where usertype=1")
    int countAllBarber();

    @SelectProvider(type= UserDynamicSqlProvider.class,method="selectAllBarberByPage")
    List<User> selectAllBarberByPage(Map<String, Object> params);

    @Select("select count(*) from " + ORDERTABLE)
    int countAllOrder();

    @SelectProvider(type= UserDynamicSqlProvider.class,method="selectAllOrderByPage")
    List<Order> selectAllOrderByPage(Map<String, Object> params);

    @SelectProvider(type= UserDynamicSqlProvider.class,method="insertBarberToDB")
    void insertBarberToDB(String username, String password, String b_name, String b_description, String phonenumber);

    @Select("select * from " + USERTABLE+" where id=#{id}")
    User selectUserById(Integer id);
}
