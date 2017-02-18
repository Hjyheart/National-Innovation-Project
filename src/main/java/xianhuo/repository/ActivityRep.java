package xianhuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xianhuo.entity.Activity;

import java.util.List;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Repository
public interface ActivityRep extends JpaRepository<Activity, Long>, JpaSpecificationExecutor<Activity>{

    List<Activity> findByMId(Long id);

    List<Activity> findByMName(String name);

    @Query("select a from activity a where a.mName like ?1%")
    List<Activity> findByLikeName(String likeName);
}
