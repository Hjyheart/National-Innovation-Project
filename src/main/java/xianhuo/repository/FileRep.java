package xianhuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import xianhuo.entity.File;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Repository
public interface FileRep extends JpaRepository<File, Long>, JpaSpecificationExecutor<File>{

}
