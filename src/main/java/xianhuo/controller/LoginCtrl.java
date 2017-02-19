package xianhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xianhuo.service.LoginServiceImp;

import java.io.IOException;

/**
 * Created by hongjiayong on 2017/2/19.
 */
@Controller
@RequestMapping("/login")
public class LoginCtrl {
    @Autowired
    private LoginServiceImp loginServiceImp;

    /**
     * 确认登入
     * @param id
     * 学号
     * @param password
     * 密码
     * @return
     * 是否登入
     */
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ResponseBody
    public boolean login(@RequestParam(name = "ID") String id, @RequestParam(name = "PASSWORD") String password) throws IOException {
       return loginServiceImp.login(id, password);
    }
}
