package cn.yznu.brs.service;

import cn.yznu.brs.bean.Message;
import cn.yznu.brs.bean.Order;
import cn.yznu.brs.bean.User;
import cn.yznu.brs.util.tag.PageModel;

import java.sql.Date;
import java.util.List;

public interface BRSService {


    User findUserByAccount(String username, String password);

    List<Message> findMessageByPage(Integer id, PageModel pageModel);

    void removeMessageById(Integer id);

    List<Order> findOrderByPage(int id, PageModel pageModel);

    void removeOrderById(Integer id);

    List<User> findAllBarber();

    void saveOrder(int id, Integer barber_id, Integer r_time, Integer r_price, Date time);

    void saveMessage(Integer barber_id, String s, Date time);

    List<Order> findBarberOrderByPage(int id, PageModel pageModel);

    void acceptOrderById(Integer id);

    void cancelOrderById(Integer id);

    Order findOrderById(Integer id);

    void sendAcceptOrderMessageById(Integer user_id, Date date);

    void sendCancelOrderMessageById(Integer user_id, Date date);

    List<User> findAllUserByPage(PageModel pageModel);

    void removeUserById(Integer id);

    List<User> findAllBarberByPage(PageModel pageModel);

    List<Order> findAllOrderByPage(PageModel pageModel);

    void saveBarberToDB(String username, String password, String b_name, String usertype, String phonenumber);

    User findUserById(Integer id);
}
