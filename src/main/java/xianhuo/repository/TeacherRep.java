package xianhuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xianhuo.entity.Teacher;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Repository
public interface TeacherRep extends JpaRepository<Teacher, Long>, JpaSpecificationExecutor<Teacher> {
    @Query("select s from teacher s where s.mName = :teaName")
    public Teacher findBymName(@Param("teaName")String name);
}
