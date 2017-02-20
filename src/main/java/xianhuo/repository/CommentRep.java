package xianhuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import xianhuo.entity.Comment;

import java.util.List;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Repository
public interface CommentRep extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment>{
    List<Comment> findByMId(Long id);
}
