package xianhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xianhuo.entity.*;
import xianhuo.repository.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.NoSuchElementException;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Service
public class MailServiceIml implements MailService{
    @Autowired
    MailRep mailRep;

    @Autowired
    ActivityRep activityRep;

    @Autowired
    ClubRep clubRep;

    @Autowired
    StudentRep studentRep;

    @Autowired
    TeacherRep teacherRep;

    public static Integer APPLY_ACT = 1;
    public static Integer APPLY_CLUB = 2;
    public static Integer CLUB_STU = 3;
    public static Integer ACT_STU = 4;
    public static boolean UNDEAL = false;
    public static boolean DEALED = true;

    @Override
    public void save(Mail mail) {
        mailRep.save(mail);
    }

    @Override
    public Mail findByMId(Long id) {
        try {
            Mail mail = mailRep.findByMId(id).iterator().next();

            return mail;
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public boolean createMailForAct(Activity activity) {
        try{
            Club club = activity.getmClub();

            Mail mail = new Mail(APPLY_ACT, club.getmHostStudent().getmId(), club.getmHostTeacher().getmName(),
                    activity.getmName(), new Date(), UNDEAL);
            Student student = club.getmHostStudent();
            student.getmSends().add(mail);
            Teacher teacher = club.getmHostTeacher();
            teacher.getmMail().add(mail);

            mailRep.save(mail);
            studentRep.save(student);
            teacherRep.save(teacher);

            return true;
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional
    public boolean createMailForClub(Club club) {
        try{
            Mail mail = new Mail(APPLY_CLUB, club.getmHostStudent().getmId(), club.getmHostTeacher().getmName(),
                    club.getmName(), new Date(), UNDEAL);
            Student student = club.getmHostStudent();
            student.getmSends().add(mail);
            Teacher teacher = club.getmHostTeacher();
            teacher.getmMail().add(mail);

            mailRep.save(mail);
            studentRep.save(student);
            teacherRep.save(teacher);

            return true;
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return false;
        }
    }


}
