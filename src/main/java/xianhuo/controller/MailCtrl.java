package xianhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xianhuo.entity.Activity;
import xianhuo.entity.Club;
import xianhuo.entity.Mail;
import xianhuo.entity.Student;
import xianhuo.service.ActivityServiceImp;
import xianhuo.service.ClubServiceImp;
import xianhuo.service.MailServiceIml;
import xianhuo.service.StudentServiceImp;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by hongjiayong on 2017/2/20.
 */
@Controller
@RequestMapping("/mail")
public class MailCtrl {
    @Autowired
    private MailServiceIml mailServiceIml;

    @Autowired
    private StudentServiceImp studentServiceImp;

    @Autowired
    private ActivityServiceImp activityServiceImp;

    @Autowired
    private ClubServiceImp clubServiceImp;

    /**
     * 获取邮件
     * @param id
     * 邮件id
     * @return
     * 邮件实体
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    @ResponseBody
    public Mail getProfile(Long id){
        Mail mail = mailServiceIml.findByMId(id);
        return mail;
    }

    /**
     * 通过某活动的申请
     * @param id
     * 活动id
     * @return
     * 是否成功
     */
    @RequestMapping(value = "/agreeAct", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public boolean agreeActApply(Long id){
        Mail mail = mailServiceIml.findByMId(id);

        if (mail != null){
            mail.setmState(mailServiceIml.DEALED);
            Student student = studentServiceImp.findByMId(mail.getmSender());

            List<Activity> activities = activityServiceImp.findByMName(mail.getmContent());

            for (Activity activity : activities){
                for (Club club : student.getmHostClubs()){
                    if (activity.getmClub().equals(club)){
                        activity.setmState(activityServiceImp.PASSED);
                        activityServiceImp.save(activity);
                        mailServiceIml.save(mail);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 拒绝活动请求
     * @param id
     * 活动的id
     * @return
     * 是否成功
     */
    @RequestMapping(value = "/refuseAct", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public boolean refuseActApply(Long id){
        Mail mail = mailServiceIml.findByMId(id);

        if (mail != null){
            mail.setmState(mailServiceIml.DEALED);
            Student student = studentServiceImp.findByMId(mail.getmSender());

            List<Activity> activities = activityServiceImp.findByMName(mail.getmContent());

            for (Activity activity : activities){
                for (Club club : student.getmHostClubs()){
                    if (activity.getmClub().equals(club)){
                        activity.setmState(activityServiceImp.REFUSED);
                        activityServiceImp.save(activity);
                        mailServiceIml.save(mail);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 同意某俱乐部的申请
     * @param id
     * 邮件编号
     * @return
     * 是否成功
     */
    @RequestMapping(value = "/agreeClub", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public boolean agreeClubApply(Long id){
        Mail mail = mailServiceIml.findByMId(id);

        if (mail != null){
            mail.setmState(mailServiceIml.DEALED);
            Student student = studentServiceImp.findByMId(mail.getmSender());

            Club club = clubServiceImp.findByMName(mail.getmContent());
            club.setmState(clubServiceImp.PASSED);

            clubServiceImp.save(club);
            mailServiceIml.save(mail);

            return true;
        }
        return false;
    }

    /**
     * 拒绝俱乐部申请
     * @param id
     * 邮件id
     * @return
     * 是否成功
     */
    @RequestMapping(value = "/refuseClub", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public boolean refuseClubApply(Long id){
        Mail mail = mailServiceIml.findByMId(id);

        if (mail != null){
            mail.setmState(mailServiceIml.DEALED);
            Student student = studentServiceImp.findByMId(mail.getmSender());

            Club club = clubServiceImp.findByMName(mail.getmContent());
            //TODO: 回执
            clubServiceImp.delete(club);
            mailServiceIml.save(mail);

            return true;
        }
        return false;
    }
}
