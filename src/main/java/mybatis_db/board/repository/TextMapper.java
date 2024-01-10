package mybatis_db.board.repository;

import mybatis_db.board.domain.Comment;
import mybatis_db.board.domain.Text;
import mybatis_db.board.dto.TextUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TextMapper {
    void save(Text text);

    Text findById(Long id);

    List<Text> findAll();

    void update(@Param("id") Long id, @Param("textUpdateDto") TextUpdateDto textUpdateDto);
    int allTextCount();

    void increaseViewCount(Long id);
    void increaseLikeCount(Long id);

    void addComment(Comment comment);
    List<Comment> findCommentById(Long id);
}
