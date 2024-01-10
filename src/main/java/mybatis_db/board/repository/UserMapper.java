package mybatis_db.board.repository;

import mybatis_db.board.domain.PageRequest;
import mybatis_db.board.domain.Text;
import mybatis_db.board.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User findById(String id);

    void save(User user);
    List<User> findAllUserText();
    User findUserText(Long id);
    List<User> findAllUserTextByTitle(String title);

    List<User> findAllUserTextByUsername(String username);
    List<User> findAllUserTextByUsernameAndTitle(String usernameAndTitle);
    List<User> selectWithPaging(PageRequest pageRequest);
}
