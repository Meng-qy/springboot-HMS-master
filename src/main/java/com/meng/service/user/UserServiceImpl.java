package com.meng.service.user;

import com.meng.mapper.UserMapper;
import com.meng.pojo.User;
import com.meng.pojo.UserRole;
import com.meng.pojo.UserUpdateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserRole> queryUserRoleList() {
        return userMapper.queryUserRoleList();
    }

    @Override
    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public List<UserRole> queryUserLikeUsername(String username) {
        return userMapper.queryUserLikeUsername(username);
    }

    @Override
    public User queryUserByUsername(String username) {
        return userMapper.queryUserByUsername(username);
    }

    @Override
    public int updateUser(UserUpdateInfo userUpdateInfo) {
        return userMapper.updateUser(userUpdateInfo);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int addUser(User user) {
        System.out.println(user);
        return userMapper.addUser(user);
    }

    @Override
    public String MaxUserId() {
        return userMapper.MaxUserId();
    }
}
