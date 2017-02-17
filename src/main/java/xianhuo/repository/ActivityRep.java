package xianhuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import xianhuo.entity.Activity;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Repository
public interface ActivityRep extends JpaRepository<Activity, Long>, JpaSpecificationExecutor<Activity>{
}
