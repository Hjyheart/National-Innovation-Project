package xianhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xianhuo.service.LoginServiceImp;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by hongjiayong on 2017/2/13.
 */
@Controller
@RequestMapping("/")
public class HomePageCtrl {
    @Autowired
    private LoginServiceImp loginServiceImp;

    @RequestMapping("index")
    public String index(HttpServletRequest httpServletRequest){
        return "index";
    }

    @RequestMapping("login")
    public String loginTest(HttpServletRequest httpServletRequest){
        return "login";
    }

    @RequestMapping("loginTest")
    public String login(@RequestParam(name = "id") String id,
                        @RequestParam(name = "password") String password) throws IOException {
        if (loginServiceImp.Login(id, password)){
            return "true";
        }else{
            return "false";
        }
    }
}
