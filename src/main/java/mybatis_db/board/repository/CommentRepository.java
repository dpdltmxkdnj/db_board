package mybatis_db.board.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis_db.board.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor

public class CommentRepository {
    private final CommentMapper commentMapper;

    public void addParentComment(Comment comment) {
        commentMapper.addParentComment(comment);
    }
    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }

    public List<Comment> findCommentById(Long id) {
        return commentMapper.findCommentById(id);
    }
    public Comment findCommentParentId(Long id) {
        return commentMapper.findCommentParentId(id);
    }
}
