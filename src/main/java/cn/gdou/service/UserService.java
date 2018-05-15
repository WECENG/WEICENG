package cn.gdou.service;

import cn.gdou.DAO.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    void delUser(User user);
    int updUsr(User user);
    User findByUsername(String username);
    User findAfriend(String friendName);
    List<User> showAllFriends(String username);
}
