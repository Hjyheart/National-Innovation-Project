package xianhuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xianhuo.entity.Teacher;

import java.util.List;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Repository
public interface TeacherRep extends JpaRepository<Teacher, Long>, JpaSpecificationExecutor<Teacher> {
    List<Teacher> findByMName(String name);

    @Query("select t from teacher t where t.mName like ?1%")
    List<Teacher> findByLikeName(String likeName);
}
