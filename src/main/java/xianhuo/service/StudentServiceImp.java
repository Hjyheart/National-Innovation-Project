package xianhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xianhuo.entity.Student;
import xianhuo.repository.StudentRep;

import java.util.List;

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

    @Override
    public List<Student> findByMName(String name) {
        return studentRep.findByMName(name);
    }

    @Override
    public Student findByMId(String id) {
        return studentRep.findByMId(id).iterator().next();
    }

    @Override
    public List<Student> findByLikeName(String name) {
        return studentRep.findByLikeName(name);
    }

}
