package xianhuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xianhuo.entity.Student;

import java.util.List;

/**
 * Created by hongjiayong on 2017/2/13.
 */
@Repository
public interface StudentRep extends JpaRepository<Student, String>, JpaSpecificationExecutor<Student> {

    List<Student> findByMName(String name);
    List<Student> findByMId(String Id);

    @Query("select s from student s where s.mName like ?1%")
    List<Student> findByLikeName(String likeName);

}
