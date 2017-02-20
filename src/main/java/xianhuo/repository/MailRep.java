package xianhuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import xianhuo.entity.Mail;

import java.util.List;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Repository
public interface MailRep extends JpaRepository<Mail, Long>, JpaSpecificationExecutor<Mail> {

    List<Mail> findByMId(Long id);
}
