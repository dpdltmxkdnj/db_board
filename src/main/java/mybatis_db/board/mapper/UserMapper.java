package mybatis_db.board.mapper;

import mybatis_db.board.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findById(String id);

    void save(User user);

}
