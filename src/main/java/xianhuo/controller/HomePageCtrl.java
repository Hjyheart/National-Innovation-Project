package xianhuo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hongjiayong on 2017/2/13.
 */
@Controller
@RequestMapping("/")
public class HomePageCtrl {

    @RequestMapping("index")
    public String index(HttpServletRequest httpServletRequest){
        return "index";
    }
}
