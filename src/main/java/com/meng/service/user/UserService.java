package com.meng.service.user;

import com.meng.pojo.User;
import com.meng.pojo.UserRole;
import com.meng.pojo.UserUpdateInfo;

import java.util.List;

public interface UserService {

    public List<UserRole> queryUserRoleList();

    public User queryUserById(int id);

    public List<UserRole> queryUserLikeUsername(String username);

    public User queryUserByUsername(String username);

    public int updateUser(UserUpdateInfo userUpdateInfo);

    public int deleteUser(Integer id);

    public int addUser(User user);

    public String MaxUserId();
}
