package com.meng.controller;

import com.meng.pojo.User;
import com.meng.pojo.UserRole;
import com.meng.pojo.UserUpdateInfo;
import com.meng.service.user.UserService;

import com.sun.org.apache.xpath.internal.objects.XString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户信息
     * @param model
     * @return
     */
    @RequestMapping("/user/list")
    public String userList(Model model){
        List<UserRole> userRoleList = userService.queryUserRoleList();
        model.addAttribute("userRoleList",userRoleList);
        return "user/list";
    }

    /**
     * 模糊查询
     * @param keywords
     * @return
     */
    @RequestMapping("/user/searchList")
    public String userSearchList(String keywords, Model model){
        List<UserRole> userRoleList = userService.queryUserLikeUsername(keywords);
        model.addAttribute("userRoleList",userRoleList);
        return "user/list";
    }

    /**
     * 跳转到用户信息更改页
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/user/update")
    public String updateUser(Integer id,Model model){
        User user = userService.queryUserById(id);
        model.addAttribute("queryUserById",user);
        return "user/updateUser";
    }

    /**
     * 用户信息更改处理
     * @param userUpdateInfo
     * @return
     */
    @RequestMapping("/user/update/deal")
    public String updateUserDeal(UserUpdateInfo userUpdateInfo){
        userService.updateUser(userUpdateInfo);
        return "redirect:/user/list";
    }

    /**
     * 单删
     * @param id
     * @return
     */
    @RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return "redirect:/user/list";
    }

    /**
     * 跳转到添加用户页
     * @return
     */
    @RequestMapping("/user/addUser")
    public String addUser(Model model){

        String maxUserId = userService.MaxUserId();
        Integer i = (maxUserId !=null)? Integer.parseInt(maxUserId)+1 : 100001;
        model.addAttribute("maxUserId",i);
        return "user/add";
    }

    /**
     * 添加用户处理
     * @param user_id
     * @param username
     * @param gender
     * @param role_id
     * @param password
     * @return
     */
    @RequestMapping("/user/addUser/deal")
    public String addUserDeal(
            @RequestParam("user_id") String user_id,
            @RequestParam("username") String username,
            @RequestParam("gender") Integer gender,
            @RequestParam("role_id") Integer role_id,
            @RequestParam("password") String password
    ){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dt = sdf.format(new Date());
        User user = new User();
        user.setId(null);
        user.setUser_id(user_id);
        user.setUsername(username);
        user.setGender(gender);
        user.setCreate_time(dt);
        user.setRole_id(role_id);
        user.setPassword(password);

        userService.addUser(user);
        return "redirect:/user/list";
    }



}

