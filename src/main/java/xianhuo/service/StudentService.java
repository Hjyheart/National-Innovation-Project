package xianhuo.service;

import xianhuo.entity.Student;

import java.util.List;

/**
 * Created by hongjiayong on 2017/2/13.
 */
public interface StudentService {

    boolean save(Student student);

    List<Student> findByMName(String name);

    Student findByMId(String id);

    List<Student> findByLikeName(String name);

}
