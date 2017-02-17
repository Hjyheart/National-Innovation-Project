package xianhuo.service;

import xianhuo.entity.Club;
import xianhuo.entity.Teacher;

import java.util.List;

/**
 * Created by hongjiayong on 2017/2/17.
 */
public interface TeacherService {
    void save(Teacher teacher);

    Teacher findByMName(String name);

    List<Teacher> findByLikeName(String likeName);

    List<Club> getClubByTeacherName(String name);
}
