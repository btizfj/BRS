package cn.yznu.brs.service.impl;

import cn.yznu.brs.bean.Message;
import cn.yznu.brs.bean.Order;
import cn.yznu.brs.bean.User;
import cn.yznu.brs.dao.UserDao;
import cn.yznu.brs.service.BRSService;
import cn.yznu.brs.util.tag.PageModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OPMS系统服务层接口实现类
 * @Service用于将当前类注释为一个Spring的bean，名为userService
 */
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("brsService")
public class BRSServiceImpl implements BRSService {

    /**
     * 自动注入持久层Dao对象
     * */
    @Resource
    private UserDao userDao;


    @Override
    public User findUserByAccount(String username, String password) {
        return userDao.selectUserByAccount(username,password);
    }

    @Override
    public List<Message> findMessageByPage(Integer id, PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        int recordCount = userDao.countMessageByUserId(id);
        pageModel.setRecordCount(recordCount);
        if(recordCount > 0){
            /** 开始分页查询数据：查询第几页的数据 */
            params.put("id", id);
            params.put("pageModel", pageModel);
        }
        List<Message> messages = userDao.selectMessageByPage(params);
        return messages;
    }

    @Override
    public void removeMessageById(Integer id) {
        userDao.deleteMessageById(id);
    }

    @Override
    public List<Order> findOrderByPage(int id, PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        int recordCount = userDao.countOrderByUserId(id);
        pageModel.setRecordCount(recordCount);
        if(recordCount > 0){
            /** 开始分页查询数据：查询第几页的数据 */
            params.put("id", id);
            params.put("pageModel", pageModel);
        }
        List<Order> orders = userDao.selectOrderByPage(params);
        return orders;
    }

    @Override
    public void removeOrderById(Integer id) {
        userDao.deleteOrderById(id);
    }

    @Override
    public List<User> findAllBarber() {
        return userDao.selectAllBarber();
    }

    @Override
    public void saveOrder(int id, Integer barber_id, Integer r_time, Integer r_price, Date time) {
        userDao.insertOrder(id,barber_id,r_time,r_price,time);
    }

    @Override
    public void saveMessage(Integer barber_id, String s, Date time) {
        userDao.insertMessage(barber_id,s,time);
    }

    @Override
    public List<Order> findBarberOrderByPage(int id, PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        int recordCount = userDao.countBarberOrderByUserId(id);
        pageModel.setRecordCount(recordCount);
        if(recordCount > 0){
            /** 开始分页查询数据：查询第几页的数据 */
            params.put("id", id);
            params.put("pageModel", pageModel);
        }
        List<Order> orders = userDao.selectBarberOrderByPage(params);
        return orders;
    }

    @Override
    public void acceptOrderById(Integer id) {
        userDao.acceptOrderViaId(id);
    }

    @Override
    public void cancelOrderById(Integer id) {
        userDao.cancelOrderViaId(id);
    }

    @Override
    public Order findOrderById(Integer id) {
        return userDao.selectOrderById(id);
    }

    @Override
    public void sendAcceptOrderMessageById(Integer user_id, Date date) {
        userDao.insertAcceptOrderMessageById(user_id,date);
    }

    @Override
    public void sendCancelOrderMessageById(Integer user_id, Date date) {
        userDao.insertCancelOrderMessageById(user_id,date);
    }

    @Override
    public List<User> findAllUserByPage(PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        int recordCount = userDao.countAllUser();
        pageModel.setRecordCount(recordCount);
        if(recordCount > 0){
            /** 开始分页查询数据：查询第几页的数据 */
            params.put("pageModel", pageModel);
        }
        List<User> users = userDao.selectAllUserByPage(params);
        return users;
    }

    @Override
    public void removeUserById(Integer id) {
        userDao.deleteUserById(id);
    }

    @Override
    public List<User> findAllBarberByPage(PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        int recordCount = userDao.countAllBarber();
        pageModel.setRecordCount(recordCount);
        if(recordCount > 0){
            /** 开始分页查询数据：查询第几页的数据 */
            params.put("pageModel", pageModel);
        }
        List<User> users = userDao.selectAllBarberByPage(params);
        return users;
    }

    @Override
    public List<Order> findAllOrderByPage(PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        int recordCount = userDao.countAllOrder();
        pageModel.setRecordCount(recordCount);
        if(recordCount > 0){
            /** 开始分页查询数据：查询第几页的数据 */
            params.put("pageModel", pageModel);
        }
        List<Order> orders = userDao.selectAllOrderByPage(params);
        return orders;
    }

    @Override
    public void saveBarberToDB(String username, String password, String b_name, Integer usertype, String phonenumber) {
        userDao.insertBarberToDB(username,password,b_name,usertype,phonenumber);
    }
}
