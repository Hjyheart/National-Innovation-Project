package xianhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xianhuo.entity.Activity;
import xianhuo.service.ActivityServiceImp;

/**
 * Created by hongjiayong on 2017/2/19.
 */
@Controller
@RequestMapping("/act")
public class ActivityCtrl {
    @Autowired
    private ActivityServiceImp activityServiceImp;

    /**
     * 返回活动详情
     * @param id
     * 活动id
     * @return
     * 活动实体
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    @ResponseBody
    public Activity getProfile(Long id){
        Activity act = activityServiceImp.findByMId(id);

        return act;
    }
}
