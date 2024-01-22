package mybatis_db.board.service;

import lombok.RequiredArgsConstructor;
import mybatis_db.board.domain.Comment;
import mybatis_db.board.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final CommentRepository commentRepository;
    public void addParentComment(Comment comment) {
        commentRepository.addParentComment(comment);
    }
    public void addComment(Comment comment) {
        commentRepository.addComment(comment);
    }
    @Transactional(readOnly = true)
    public List<Comment> findCommentById(Long id) {
        return commentRepository.findCommentById(id);
    }

}
