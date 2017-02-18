package xianhuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xianhuo.entity.Club;

import java.util.List;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Repository
public interface ClubRep extends JpaRepository<Club, Long>, JpaSpecificationExecutor<Club>{

    List<Club> findByMId(Long id);
    List<Club> findByMName(String name);

    @Query("select c from club c where c.mName like ?1%")
    List<Club> findByLikeName(String likeName);

}
