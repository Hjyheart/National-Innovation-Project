package xianhuo.service;

import xianhuo.entity.Activity;
import xianhuo.entity.Club;
import xianhuo.entity.Mail;

/**
 * Created by hongjiayong on 2017/2/17.
 */
public interface MailService {
    void save(Mail mail);

    Mail findByMId(Long id);

    boolean createMailForAct(Activity activity);

    boolean createMailForClub(Club club);
}
