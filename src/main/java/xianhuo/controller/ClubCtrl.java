package xianhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xianhuo.entity.Club;
import xianhuo.entity.Comment;
import xianhuo.entity.Student;
import xianhuo.entity.Teacher;
import xianhuo.service.*;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    @Autowired
    private MailServiceIml mailServiceIml;

    @Autowired
    private CommentServiceImp commentServiceImp;

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

                if(!mailServiceIml.createMailForClub(club1)){
                    return false;
                }

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

    /**
     * 评论俱乐部
     * @param s_id
     * 学生账号
     * @param c_id
     * 俱乐部账号
     * @param content
     * 内容
     * @param time
     * 时间
     * @return
     * 是否成功
     * @throws ParseException
     */
    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public boolean addComment(@RequestParam(name = "STU_ID") String s_id,
                              @RequestParam(name = "CLUB_ID") Long c_id,
                              @RequestParam(name = "CONTENT") String content,
                              @RequestParam(name = "TIME") String time) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd_hh:mm");
        Student student = studentServiceImp.findByMId(s_id);
        Club club = clubServiceImp.findByMId(c_id);

        if (student != null && club != null){
            Comment comment = new Comment(content, sf.parse(time), commentServiceImp.CLUB, c_id, student);

            club.getmComments().add(comment);

            clubServiceImp.save(club);
            commentServiceImp.save(comment);

            return true;
        }

        return false;
    }

    /**
     * 删除评论
     * @param id
     * 评论id
     * @return
     * 是否成功
     */
    @RequestMapping(value = "/deleteComment", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public boolean deleteComment(Long id){
        try {
            Comment comment = commentServiceImp.findByMId(id);
            Club club = clubServiceImp.findByMId(comment.getmTarget());

            if (comment != null && club != null){
                club.getmComments().remove(comment);

                clubServiceImp.save(club);
                commentServiceImp.delete(comment);
                return true;
            }

            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
