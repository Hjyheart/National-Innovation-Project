package xianhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xianhuo.entity.Teacher;
import xianhuo.service.TeacherServiceImp;

/**
 * Created by hongjiayong on 2017/2/23.
 */
@Controller
@RequestMapping("/tea")
public class TeacherCtrl {
    @Autowired
    private TeacherServiceImp teacherServiceImp;

    @RequestMapping(value = "profile", method = RequestMethod.GET)
    @ResponseBody
    public Teacher getProfile(String name){
        return teacherServiceImp.findByMName(name);
    }
}
