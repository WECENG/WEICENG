package cn.gdou.DAO.repository;

import cn.gdou.DAO.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    @Query("update User u set u.username=?1,u.password=?2,u.age=?3,u.gender=?4 where u.id=?5")
    Integer updateUser(String username, String password, Integer age, String gender, Integer id);
    @Query("select u from User u where u.username=?1")
    User findAfriend(String friendName);
    @Query("select u.friends from User u where u.username=?1")
    List<User> showAllFriends(String username);

}
