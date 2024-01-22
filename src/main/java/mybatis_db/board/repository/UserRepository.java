package mybatis_db.board.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis_db.board.dto.PageRequestDto;
import mybatis_db.board.domain.User;
import mybatis_db.board.domain.BoardHomeTexts;
import mybatis_db.board.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final UserMapper userMapper;

    public User save(User user) {
        userMapper.save(user);
        return user;
    }
    public User findById(String id) {
        return userMapper.findById(id);
    }

}
