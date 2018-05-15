package cn.gdou.service.impl;

import cn.gdou.DAO.domain.User;
import cn.gdou.DAO.repository.UserRepository;
import cn.gdou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public int updUsr(User user) {
        return userRepository.updateUser(user.getUsername(),user.getPassword(),
                user.getAge(),user.getGender(),user.getId());
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findAfriend(String friendName) {
        return userRepository.findAfriend(friendName);
    }

    @Override
    public List<User> showAllFriends(String username) {
        return userRepository.showAllFriends(username);
    }
}
