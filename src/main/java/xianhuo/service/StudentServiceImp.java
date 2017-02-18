package xianhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xianhuo.entity.Student;
import xianhuo.repository.StudentRep;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRep studentRep;

    @Override
    public boolean save(Student student) {
        try {
            Student stu = studentRep.findByMId(student.getmId()).iterator().next();
        }catch (NoSuchElementException e){
            studentRep.save(student);
            return true;
        }
        return false;
    }

    @Override
    public List<Student> findByMName(String name) {
        try {
            return studentRep.findByMName(name);
        }catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public Student findByMId(String id) {
        try {
            return studentRep.findByMId(id).iterator().next();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public List<Student> findByLikeName(String name) {
        try {
            return studentRep.findByLikeName(name);
        }catch (NoSuchElementException e){
            return null;
        }
    }

}
