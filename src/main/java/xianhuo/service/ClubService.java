package xianhuo.service;

import xianhuo.entity.Club;

import java.util.List;

/**
 * Created by hongjiayong on 2017/2/17.
 */
public interface ClubService {
    boolean save(Club club);

    void delete(Club club);

    Club findByMId(Long id);

    Club findByMName(String name);

    List<Club> findByLikeName(String likeName);

    List<Club> findAll();


}
