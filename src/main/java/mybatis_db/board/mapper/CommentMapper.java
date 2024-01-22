package mybatis_db.board.mapper;

import mybatis_db.board.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void addParentComment(Comment comment);
    void addComment(Comment comment);

    List<Comment> findCommentById(Long contentId);

    Comment findCommentParentId(Long contentId);
}
