package xianhuo.service;

import xianhuo.entity.Comment;

/**
 * Created by hongjiayong on 2017/2/17.
 */
public interface CommentService {
    void save(Comment comment);

    void delete(Comment comment);

    Comment findByMId(Long id);
}
