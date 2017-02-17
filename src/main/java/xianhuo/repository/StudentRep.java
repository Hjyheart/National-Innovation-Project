package xianhuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xianhuo.entity.Student;

import java.util.List;

/**
 * Created by hongjiayong on 2017/2/13.
 */
@Repository
public interface StudentRep extends JpaRepository<Student, String>, JpaSpecificationExecutor<Student> {
    @Query("select stu from student stu where stu.mName = :stuName")
    public List<Student> findByStuName(@Param("stuName") String name);
}
