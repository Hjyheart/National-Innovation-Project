package xianhuo.service;

import xianhuo.entity.Activity;

import java.util.List;

/**
 * Created by hongjiayong on 2017/2/17.
 */
public interface ActivityService {
    void save(Activity activity);

    void delete(Activity activity);

    Activity findByMId(Long id);

    List<Activity> findByMName(String name);

    List<Activity> findByLikeName(String likeName);

}
