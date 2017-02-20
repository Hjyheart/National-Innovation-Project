package xianhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xianhuo.entity.Comment;
import xianhuo.repository.CommentRep;

import java.util.NoSuchElementException;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Service
public class CommentServiceImp implements CommentService{
    @Autowired
    private CommentRep commentRep;

    public static Integer ACT = 1;
    public static Integer CLUB = 2;

    @Override
    public void save(Comment comment) {
        commentRep.save(comment);
    }

    @Override
    public void delete(Comment comment) {
        try{
            commentRep.delete(comment);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Comment findByMId(Long id) {
        try{
            return commentRep.findByMId(id).iterator().next();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return null;
        }
    }
}
