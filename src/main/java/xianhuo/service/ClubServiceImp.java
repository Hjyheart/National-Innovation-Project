package xianhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xianhuo.entity.Club;
import xianhuo.repository.ClubRep;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Service
public class ClubServiceImp implements ClubService {
    @Autowired
    private ClubRep clubRep;

    @Override
    public void save(Club club) {
        clubRep.save(club);
    }
}
