package xianhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xianhuo.entity.Mail;
import xianhuo.repository.MailRep;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Service
public class MailServiceIml implements MailService{
    @Autowired
    MailRep mailRep;


    @Override
    public void save(Mail mail) {
        mailRep.save(mail);
    }
}
