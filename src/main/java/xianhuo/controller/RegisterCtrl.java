package xianhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xianhuo.entity.Student;
import xianhuo.entity.Teacher;
import xianhuo.service.LoginServiceImp;
import xianhuo.service.StudentServiceImp;
import xianhuo.service.TeacherServiceImp;

import javax.transaction.Transactional;
import java.io.IOException;

/**
 * Created by hongjiayong on 2017/2/19.
 */
@Controller
@RequestMapping("/register")
public class RegisterCtrl {
    @Autowired
    private LoginServiceImp loginServiceImp;

    @Autowired
    private StudentServiceImp studentServiceImp;

    @Autowired
    private TeacherServiceImp teacherServiceImp;

    /**
     * 注册学生
     * @param id
     * 学号
     * @param password
     * 密码
     * @return
     * 账号有效 -> 1 账号已经注册 -> 0 认证失败 -> -1
     * @throws IOException
     */
    @RequestMapping(value = "/stu", method = RequestMethod.POST)
    @ResponseBody
    public Integer registerForStudent(@RequestParam(name = "ID") String id, @RequestParam(name = "PASSWORD") String password) throws IOException {
        Student stu = studentServiceImp.findByMId(id);
        if (stu == null){
            if(loginServiceImp.login(id, password)){
                studentServiceImp.save(new Student(id, password));
                return 1;
            }else{
                return -1;
            }
        }else{
            return 0;
        }
    }

    /**
     * 完善信息 位于注册通过认证之后
     * @param name
     * 姓名
     * @param id
     * 学号
     * @param grade
     * 年级
     * @param major
     * 专业
     * @param contact
     * 号码
     * @return
     * 是否完善成功
     */
    @RequestMapping(value = "/stu/comp", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public boolean compStudent(@RequestParam(name = "NAME") String name,
                               @RequestParam(name = "ID") String id,
                               @RequestParam(name = "GRADE") Integer grade,
                               @RequestParam(name = "MAJOR") String major,
                               @RequestParam(name = "CONTACT") String contact){
        try {
            Student stu = studentServiceImp.findByMId(id);
            stu.setmName(name);
            stu.setmContact(contact);
            stu.setmGrade(grade);
            stu.setmMajor(major);

            studentServiceImp.save(stu);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 注册老师
     * @param name
     * 姓名
     * @param password
     * 密码
     * @return
     * 账号有效 -> 1 认证失败 -> 0
     */
    @RequestMapping(value = "/tea", method = RequestMethod.POST)
    @ResponseBody
    public Integer registerForTeacher(@RequestParam(name = "NAME") String name,
                                      @RequestParam(name = "PASSWORD") String password,
                                      @RequestParam(name = "MAJOR") String major,
                                      @RequestParam(name = "CONTACT") String contact){
        Teacher teacher = teacherServiceImp.findByMName(name);

        if (teacher == null){
            Teacher teacher1 = new Teacher(password, name, major, contact);

            teacherServiceImp.save(teacher1);
            return 1;
        }else{
            return 0;
        }
    }
}
