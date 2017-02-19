package xianhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xianhuo.entity.Club;
import xianhuo.service.ClubServiceImp;

/**
 * Created by hongjiayong on 2017/2/19.
 */
@Controller
@RequestMapping("/club")
public class ClubCtrl {
    @Autowired
    private ClubServiceImp clubServiceImp;

    /**
     * 返回俱乐部信息
     * @param id
     * 俱乐部id
     * @return
     * 俱乐部实体
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    @ResponseBody
    public Club getProfile(Long id){
        Club club = clubServiceImp.findByMId(id);

        return club;
    }
}
