package xianhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xianhuo.entity.Activity;
import xianhuo.repository.ActivityRep;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Service
public class ActivityServiceImp implements ActivityService {
    @Autowired
    private ActivityRep activityRep;

    @Override
    public void save(Activity activity) {
        activityRep.save(activity);
    }
}
