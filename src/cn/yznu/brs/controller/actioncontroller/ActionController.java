package cn.yznu.brs.controller.actioncontroller;

import cn.yznu.brs.bean.Message;
import cn.yznu.brs.bean.Order;
import cn.yznu.brs.bean.User;
import cn.yznu.brs.service.BRSService;
import cn.yznu.brs.util.constants.Constant;
import cn.yznu.brs.util.tag.PageModel;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.geometry.Pos;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static cn.yznu.brs.util.constants.Constant.*;

@Controller
public class ActionController {

    /**
     * 自动注入brsService
     */
    @Autowired
    @Qualifier("brsService")
    private BRSService brsService;

    /**
     * 进入主界面
     * @return
     */
    @RequestMapping(value = "/main")
    public String main(){
        return "commonPage/main";
    }

    /**
     * 进入登录界面
     */
    @RequestMapping(value = "/login")
    public String login(){
        return "commonPage/login";
    }

    /**
     * 进入注册界面
     */
    @RequestMapping(value = "/register")
    public String register(){
        return "commonPage/register";
    }

    /**
     * 注册账户
     */
    @RequestMapping(value = "/registerAccount")
    public String registerAccount(String username, String password, String email){
//        mscPlayerService.saveAccount(username,password,email,0);
//        Constant.curPage = "";
        return "commonPage/success";
    }

    @RequestMapping(value = "/sesetPassword")
    public String sesetPassword(Integer id){
        return "commonPage/sesetPassword";
    }

    /**
     * 账号密码登录
     */
    @RequestMapping(value = "/loginByAccount",method= RequestMethod.POST)
    public String loginByAccount(String username, String password, HttpSession session, Model model){
        String url = null;
        User user = brsService.findUserByAccount(username,password);
        if (user != null){
            session.setAttribute("user",user);
            if (user.getUsertype()==0){//用户
                url="userPage/welcome";
            }else if (user.getUsertype()==1){//理发师
                url="barberPage/welcome";
            }else {//管理员
                url="adminPage/welcome";
            }
        }else {
            url = "commonPage/accountError";
        }
        model.addAttribute("user",user);
        return url;
    }

    /**
     * 消息管理（用户和理发师）
     * @return
     */
    @RequestMapping(value = "/messagePage")
    public String messagePage(Integer pageIndex,HttpSession session, Model model){
        // 创建分页对象
        PageModel pageModel = new PageModel();
        // 如果参数pageIndex不为null，设置pageIndex，即显示第几页
        if(pageIndex != null){
            pageModel.setPageIndex(pageIndex);
        }
        List<Message> messages = null;
        String url = null;
        User user = (User) session.getAttribute("user");
        messages = brsService.findMessageByPage(user.getId(),pageModel);
        switch (user.getUsertype()){
            case 0:
                url = "userPage/messagePage";
                break;
            case 1:
                url = "barberPage/messagePage";
                break;
        }
        model.addAttribute("pageModel", pageModel);
        model.addAttribute("messages",messages);
        model.addAttribute("user",user);
        return url;
    }

    /**
     * 用户管理（管理员）
     * @return
     */
    @RequestMapping(value = "/adminUserManagement")
    public String adminUserManagement(Integer pageIndex,Model model){
        // 创建分页对象
        PageModel pageModel = new PageModel();
        // 如果参数pageIndex不为null，设置pageIndex，即显示第几页
        if(pageIndex != null){
            pageModel.setPageIndex(pageIndex);
        }
        List<User> users = brsService.findAllUserByPage(pageModel);
        model.addAttribute("pageModel", pageModel);
        model.addAttribute("users",users);
        model.addAttribute("userType",userType);
        return "adminPage/userManagement";
    }

    /**
     * 理发师管理（管理员）
     * @return
     */
    @RequestMapping(value = "/adminBarberManagement")
    public String adminBarberManagement(Integer pageIndex,Model model){
        // 创建分页对象
        PageModel pageModel = new PageModel();
        // 如果参数pageIndex不为null，设置pageIndex，即显示第几页
        if(pageIndex != null){
            pageModel.setPageIndex(pageIndex);
        }
        List<User> users = brsService.findAllBarberByPage(pageModel);
        model.addAttribute("pageModel", pageModel);
        model.addAttribute("users",users);
        model.addAttribute("userType",userType);
        return "adminPage/barberManagement";
    }

    /**
     * 订单管理（管理员）
     * @return
     */
    @RequestMapping(value = "/adminOrderManagement")
    public String adminOrderManagement(Integer pageIndex,Model model){
        // 创建分页对象
        PageModel pageModel = new PageModel();
        // 如果参数pageIndex不为null，设置pageIndex，即显示第几页
        if(pageIndex != null){
            pageModel.setPageIndex(pageIndex);
        }
        List<Order> orders = brsService.findAllOrderByPage(pageModel);
        model.addAttribute("pageModel", pageModel);
        model.addAttribute("orders",orders);
        model.addAttribute("reservationTime",reservationTime);
        model.addAttribute("orderState",orderState);
        return "adminPage/orderManagement";
    }

    @RequestMapping(value = "/welcome")
    public String welcome(HttpSession session){
        String url = null;
        User user = (User) session.getAttribute("user");
        if (user.getUsertype()==0){//用户
            url="userPage/welcome";
        }else if (user.getUsertype()==1){//理发师
            url="barberPage/welcome";
        }else {//管理员
            url="adminPage/welcome";
        }
        return url;
    }

    /**
     * 添加理发师界面
     */
    @RequestMapping(value = "/adminAddBarber")
    public String adminAddBarber(HttpSession session){
        return "adminPage/addBarber";
    }

    /**
     * 添加理发师
     */
    @RequestMapping(value = "/addBarberToDB",method= RequestMethod.POST)
    public String addBarberToDB(String username,String password,String b_name,Integer usertype,String phonenumber){
        brsService.saveBarberToDB(username,password,b_name,usertype,phonenumber);
        return "commonPage/success";
    }

    /**
     * 用户打开预约界面
     * @return
     */
    @RequestMapping(value = "/reservationPage")
    public String reservationPage(Integer pageIndex,HttpSession session, Model model){
        // 创建分页对象
        PageModel pageModel = new PageModel();
        // 如果参数pageIndex不为null，设置pageIndex，即显示第几页
        if(pageIndex != null){
            pageModel.setPageIndex(pageIndex);
        }
        List<Order> orders = null;
        User user = (User) session.getAttribute("user");
        String url = null;
        switch (user.getUsertype()){
            case 0:
                url = "userPage/reservationPage";
                orders = brsService.findOrderByPage(user.getId(),pageModel);
                break;
            case 1:
                url = "barberPage/reservationPage";
                orders = brsService.findBarberOrderByPage(user.getId(),pageModel);
                break;
        }
        model.addAttribute("pageModel", pageModel);
        model.addAttribute("orders",orders);
        model.addAttribute("orderState",orderState);
        model.addAttribute("reservationTime",reservationTime);

        return url;
    }

    @RequestMapping(value = "/deleteMessageById")
    public String deleteMessageById(Integer id,HttpSession session){
        brsService.removeMessageById(id);
//        User user = (User) session.getAttribute("user");
//        String url = null;
//        switch (user.getUsertype()){
//            case 0:
//                url = "userPage/messagePage";
//                break;
//            case 1:
//                url = "barberPage/messagePage";
//                break;
//        }
        return "commonPage/success";
    }

    @RequestMapping(value = "/deleteOrderById")
    public String deleteOrderById(Integer id){
        brsService.removeOrderById(id);
        return "commonPage/success";
    }


    @RequestMapping(value = "/deleteUserById")
    public String deleteUserById(Integer id){
        brsService.removeUserById(id);
        return "commonPage/success";
    }

    /**
     * 接受订单
     * @param id
     * @return
     */
    @RequestMapping(value = "/acceptOrderById")
    public String acceptOrderById(Integer id){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        brsService.acceptOrderById(id);
        Order order = brsService.findOrderById(id);
        brsService.sendAcceptOrderMessageById(order.getUser_id(),java.sql.Date.valueOf(sdf.format(d)));
        return "commonPage/success";
    }

    /**
     * 取消订单
     * @param id
     * @return
     */
    @RequestMapping(value = "/cancelOrderById")
    public String cancelOrderById(Integer id){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        brsService.cancelOrderById(id);
        Order order = brsService.findOrderById(id);
        brsService.sendCancelOrderMessageById(order.getUser_id(),java.sql.Date.valueOf(sdf.format(d)));
        return "commonPage/success";
    }

    /**
     * 打开我要预约界面
     * @return
     */
    @RequestMapping(value = "/userReservation")
    public String userReservation(Model model){
        List<User> users = brsService.findAllBarber();
        model.addAttribute("users",users);
        return "userPage/userReservation";
    }

    /**
     * 提交预约
     * @param model
     * @return
     */
    @RequestMapping(value = "/submitOrderByParams",method= RequestMethod.POST)
    public String submitOrderByParams(Integer barber_id,Integer r_time,Integer r_price,HttpSession session,Model model){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        User user = (User) session.getAttribute("user");
        brsService.saveOrder(user.getId(),barber_id,r_time,r_price,java.sql.Date.valueOf(sdf.format(d)));
        brsService.saveMessage(barber_id,"有用户提交预约，请查看！",java.sql.Date.valueOf(sdf.format(d)));
        return "commonPage/success";
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/resetPassword")
    public String resetPassword(String username,String oldpassword,String newpassword){
        return "";
//        System.out.println("111");
//        User user = mscPlayerService.findUserByAccount(username,oldpassword);
//        System.out.println(user);
//        String url = "";
//        if (user == null){
//            url = "failed";
//        }else {
//            mscPlayerService.resetPasswordById(user.getId(),username,newpassword);
//            url = "success";
//        }
//        Constant.curPage = "";
//        return url;
    }


}
