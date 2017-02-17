package xianhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xianhuo.entity.Comment;
import xianhuo.repository.CommentRep;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Service
public class CommentServiceImp implements CommentService{
    @Autowired
    private CommentRep commentRep;

    @Override
    public void save(Comment comment) {
        commentRep.save(comment);
    }
}
