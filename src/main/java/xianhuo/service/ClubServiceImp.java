package xianhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xianhuo.entity.Club;
import xianhuo.repository.ClubRep;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Service
public class ClubServiceImp implements ClubService {
    @Autowired
    private ClubRep clubRep;

    @Override
    public boolean save(Club club) {
        try {
            Club c = clubRep.findByMName(club.getmName()).iterator().next();
        }catch (NoSuchElementException e){
            clubRep.save(club);
            return true;
        }
        return false;
    }

    @Override
    public void delete(Club club) {
        clubRep.delete(club);
    }

    @Override
    public Club findByMId(Long id) {
        try {
            return clubRep.findByMId(id).iterator().next();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public Club findByMName(String name) {
        try {
            return clubRep.findByMName(name).iterator().next();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public List<Club> findByLikeName(String likeName) {
        try {
            return clubRep.findByLikeName(likeName);
        }catch (NoSuchElementException e){
            return null;
        }
    }
}
