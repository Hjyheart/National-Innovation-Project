package xianhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xianhuo.entity.Club;
import xianhuo.entity.Student;
import xianhuo.entity.Teacher;
import xianhuo.service.ClubServiceImp;
import xianhuo.service.StudentServiceImp;
import xianhuo.service.TeacherServiceImp;

import javax.transaction.Transactional;

/**
 * Created by hongjiayong on 2017/2/19.
 */
@Controller
@RequestMapping("/club")
public class ClubCtrl {
    @Autowired
    private ClubServiceImp clubServiceImp;

    @Autowired
    private StudentServiceImp studentServiceImp;

    @Autowired
    private TeacherServiceImp teacherServiceImp;

    /**
     * 返回俱乐部信息
     * @param id
     * 俱乐部id
     * @return
     * 俱乐部实体
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    @ResponseBody
    public Club getProfile(Long id){
        Club club = clubServiceImp.findByMId(id);

        return club;
    }

    /**
     * 创建俱乐部
     * @param name
     * 俱乐部名
     * @param id
     * 主席id
     * @param teaName
     * 老师姓名
     * @return
     * 是否成功
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public boolean createClub(@RequestParam(name = "NAME") String name,
                              @RequestParam(name = "STU_ID") String id,
                              @RequestParam(name = "TEA_NAME") String teaName){
        Club club = clubServiceImp.findByMName(name);
        if (club == null){
            Student student = studentServiceImp.findByMId(id);
            Teacher teacher = teacherServiceImp.findByMName(teaName);
            if (student != null && teacher != null){
                Club club1 = new Club(name, student, teacher, false);
                clubServiceImp.save(club1);
                return true;
            }
        }
        return false;
    }

    /**
     * 删除俱乐部
     * @param id
     * 俱乐部id
     * @return
     * 是否成功
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteClub(@RequestParam(name = "ID") Long id){
        Club club = clubServiceImp.findByMId(id);

        if (club != null){
            try{
                clubServiceImp.delete(club);
                return true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 俱乐部加学生
     * @param c_id
     * 俱乐部id
     * @param s_id
     * 学生加id
     * @return
     * 是否成功
     */
    @RequestMapping(value = "/addStu", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public boolean addStudent(@RequestParam(name = "CLUB_ID") Long c_id,
                              @RequestParam(name = "STU_ID") String s_id){
        Student student = studentServiceImp.findByMId(s_id);
        Club club = clubServiceImp.findByMId(c_id);

        if (student != null && club != null){
            club.getmStudents().add(student);

            clubServiceImp.save(club);
            return true;
        }

        return false;
    }

    /**
     * 从俱乐部删除学生
     * @param c_id
     * 俱乐部id
     * @param s_id
     * 学生学号
     * @return
     * 是否成功
     */
    @RequestMapping(value = "/deleteStu", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public boolean deleteStudent(@RequestParam(name = "CLUB_ID") Long c_id,
                                 @RequestParam(name = "STU_ID") String s_id){
        Student student = studentServiceImp.findByMId(s_id);
        Club club = clubServiceImp.findByMId(c_id);

        if (student != null && club != null){
            club.getmStudents().remove(student);

            clubServiceImp.save(club);
            return true;
        }

        return false;
    }
}
