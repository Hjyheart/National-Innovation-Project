package xianhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xianhuo.entity.Student;
import xianhuo.service.LoginServiceImp;
import xianhuo.service.StudentServiceImp;

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

    @Autowired
    private StudentServiceImp studentServiceImp;

    @RequestMapping("index")
    public String index(HttpServletRequest httpServletRequest){
        Student stu = new Student(
                "1452822",
                "hjy673773",
                "洪嘉勇",
                2014,
                "软件学院",
                "15900582673");
        studentServiceImp.save(stu);
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
