package xianhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xianhuo.entity.Club;
import xianhuo.entity.Teacher;
import xianhuo.repository.TeacherRep;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherRep teacherRep;

    @Override
    public boolean save(Teacher teacher) {
        try {
            Teacher tea = teacherRep.findByMName(teacher.getmName()).iterator().next();
        }catch (NoSuchElementException e){
            teacherRep.save(teacher);
            return true;
        }
        return false;
    }

    @Override
    public Teacher findByMName(String name) {
        try {
            return teacherRep.findByMName(name).iterator().next();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public List<Teacher> findByLikeName(String likeName) {
        try {
            return teacherRep.findByLikeName(likeName);
        }catch (NoSuchElementException e){
            return null;
        }
    }
}
