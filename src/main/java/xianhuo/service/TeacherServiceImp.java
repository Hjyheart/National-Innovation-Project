package xianhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xianhuo.entity.Club;
import xianhuo.entity.Teacher;
import xianhuo.repository.TeacherRep;

import java.util.List;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherRep teacherRep;

    @Override
    public void save(Teacher teacher) {
        teacherRep.save(teacher);
    }

    @Override
    public Teacher findByMName(String name) {
        return teacherRep.findByMName(name).iterator().next();
    }

    @Override
    public List<Teacher> findByLikeName(String likeName) {
        return teacherRep.findByLikeName(likeName);
    }

    @Override
    public List<Club> getClubByTeacherName(String name) {
        Teacher teacher = teacherRep.findByMName(name).iterator().next();
        if (teacher != null){
            return teacher.getmClub();
        }else{
            return null;
        }
    }
}
