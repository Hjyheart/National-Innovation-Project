package xianhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xianhuo.entity.Activity;
import xianhuo.entity.Club;
import xianhuo.entity.Comment;
import xianhuo.entity.Student;
import xianhuo.service.*;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by hongjiayong on 2017/2/19.
 */
@Controller
@RequestMapping("/act")
public class ActivityCtrl {
    @Autowired
    private ActivityServiceImp activityServiceImp;

    @Autowired
    private ClubServiceImp clubServiceImp;

    @Autowired
    private StudentServiceImp studentServiceImp;

    @Autowired
    private MailServiceIml mailServiceIml;

    @Autowired
    private CommentServiceImp commentServiceImp;

    /**
     * 返回活动详情
     * @param id
     * 活动id
     * @return
     * 活动实体
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    @ResponseBody
    public Activity getProfile(Long id){
        Activity act = activityServiceImp.findByMId(id);

        return act;
    }

    /**
     * 返回所有活动
     * @return
     * 活动列表
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Activity> getAll(){
        return activityServiceImp.findAll();
    }

    /**
     * 创建活动
     * @param name
     * 活动名称
     * @param location
     * 活动地点
     * @param time
     * 活动时间
     * @param content
     * 活动内容
     * @param id
     * 主办俱乐部id
     * @return
     * 是否成功
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public boolean createActivity(@RequestParam(name = "NAME") String name,
                                  @RequestParam(name = "LOCATION") String location,
                                  @RequestParam(name = "DATE") String time,
                                  @RequestParam(name = "CONTENT") String content,
                                  @RequestParam(name = "CLUB_ID") Long id) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd_hh:mm");

        Club club = clubServiceImp.findByMId(id);

        if (club != null){
            try {
                Activity activity = new Activity(name, location, ft.parse(time), activityServiceImp.UNAPPLIED, content, club);
                if (!mailServiceIml.createMailForAct(activity)){
                    return false;
                }
                activityServiceImp.save(activity);
                return true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 删除活动
     * @param id
     * 活动id
     * @return
     * 是否成功
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteActivity(@RequestParam(name = "ID") Long id){
        try{
            Activity activity = activityServiceImp.findByMId(id);
            activityServiceImp.delete(activity);

            return true;
        }catch (Exception e){
            e.printStackTrace();

            return false;
        }
    }

    /**
     * 学生参加活动
     * @param a_id
     * 活动id
     * @param s_id
     * 学生id
     * @return
     * 是否成功
     */
    @RequestMapping(value = "/addStu", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public boolean addStudent(@RequestParam(name = "ACT_ID") Long a_id,
                              @RequestParam(name = "STU_ID") String s_id){
        Student student = studentServiceImp.findByMId(s_id);
        Activity activity = activityServiceImp.findByMId(a_id);

        if (student != null && activity != null){
            activity.getmStudents().add(student);

            activityServiceImp.save(activity);
            return true;
        }

        return false;
    }

    /**
     * 学生退出活动
     * @param a_id
     * 活动id
     * @param s_id
     * 学生学号
     * @return
     * 是否成功
     */
    @RequestMapping(value = "/deleteStu", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public boolean deleteStudent(@RequestParam(name = "ACT_ID") Long a_id,
                                 @RequestParam(name = "STU_ID") String s_id){
        Student student = studentServiceImp.findByMId(s_id);
        Activity activity = activityServiceImp.findByMId(a_id);

        if (student != null && activity != null){
            activity.getmStudents().remove(student);

            activityServiceImp.save(activity);
            return true;
        }

        return false;
    }

    /**
     * 为活动添加评论
     * @param s_id
     * 学生学号
     * @param a_id
     * 活动id
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
                              @RequestParam(name = "ACT_ID") Long a_id,
                              @RequestParam(name = "CONTENT") String content,
                              @RequestParam(name = "TIME") String time) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd_hh:mm");
        Student student = studentServiceImp.findByMId(s_id);
        Activity activity = activityServiceImp.findByMId(a_id);

        if (student != null && activity != null){
            Comment comment = new Comment(content, sf.parse(time), commentServiceImp.ACT, a_id, student);

            activity.getmComments().add(comment);

            commentServiceImp.save(comment);
            activityServiceImp.save(activity);

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
            Activity activity = activityServiceImp.findByMId(comment.getmTarget());

            if (comment != null && activity != null) {
                activity.getmComments().remove(comment);

                activityServiceImp.save(activity);
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
