package cn.yznu.brs.controller.actioncontroller;

import cn.yznu.brs.bean.Order;
import cn.yznu.brs.bean.User;
import cn.yznu.brs.service.BRSService;
import cn.yznu.brs.util.constants.Constant;
import cn.yznu.brs.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    /**
     * 自动注入brsService
     */
    @Autowired
    @Qualifier("brsService")
    private BRSService brsService;

    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "commonPage/main";
    }


}
