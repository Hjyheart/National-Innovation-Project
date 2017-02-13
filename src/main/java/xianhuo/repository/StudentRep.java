package xianhuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xianhuo.entity.Student;

/**
 * Created by hongjiayong on 2017/2/13.
 */

public interface StudentRep extends JpaRepository<Student, String>, JpaSpecificationExecutor<Student> {
    @Query("select student from Student student where student.mName = :stuName")
    public Student findByStuName(@Param("stuName") String name);
}
