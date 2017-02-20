package xianhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xianhuo.entity.Activity;
import xianhuo.repository.ActivityRep;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Service
public class ActivityServiceImp implements ActivityService {
    public static Integer UNAPPLIED = 0;

    public static Integer PASSED = 1;

    public static Integer REFUSED = -1;

    @Autowired
    private ActivityRep activityRep;

    @Override
    public void save(Activity activity) {
        activityRep.save(activity);
    }

    @Override
    public void delete(Activity activity) {
        activityRep.delete(activity);
    }

    @Override
    public Activity findByMId(Long id) {
        try {
            return activityRep.findByMId(id).iterator().next();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public List<Activity> findByMName(String name) {
        try{
            return activityRep.findByMName(name);
        }catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public List<Activity> findByLikeName(String likeName) {
        try{
            return activityRep.findByLikeName(likeName);
        }catch (NoSuchElementException e){
            return null;
        }
    }
}
