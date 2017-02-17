package xianhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xianhuo.entity.Teacher;
import xianhuo.repository.TeacherRep;

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
}
