package xianhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xianhuo.entity.Student;
import xianhuo.service.StudentServiceImp;

/**
 * Created by hongjiayong on 2017/2/19.
 */
@Controller
@RequestMapping("/stu")
public class StudentCtrl {
    @Autowired
    private StudentServiceImp studentServiceImp;

    /**
     * 获取学生具体信息
     * @param id
     * 学生id
     * @return
     * 学生实体
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    @ResponseBody
    public Student getProfile(String id){
        Student stu = studentServiceImp.findByMId(id);

        return stu;
    }


}
