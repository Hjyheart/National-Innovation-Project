package xianhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xianhuo.entity.Student;
import xianhuo.repository.StudentRep;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRep studentRep;

    @Override
    public void save(Student student) {
        studentRep.save(student);
    }
}