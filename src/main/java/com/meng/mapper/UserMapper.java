package com.meng.mapper;

import com.meng.pojo.User;
import com.meng.pojo.UserRole;
import com.meng.pojo.UserUpdateInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {

    /**
     * user表连接role表查询所有字段
     * @return
     */
    @Select(value ="SELECT \n" +
            "\ta.id,a.user_id,a.username,a.`password`,a.gender,a.create_time,b.role_name \n" +
            "FROM \n" +
            "\tuser a\n" +
            "LEFT JOIN\n" +
            "  role b\n" +
            "ON \n" +
            "\ta.role_id = b.id\n" +
            "ORDER BY\n" +
            "\ta.user_id\n" +
            "ASC")
    List<UserRole> queryUserRoleList();

    /**
     * 通过id查询user表中对应的数据
     * @param id
     * @return
     */
    @Select("select * from user where id =#{id}")
    User queryUserById(int id);


    /**
     * 通过username模糊查询
     * @param username
     * @return
     */
    @Select(value = "select * from `user` where username LIKE CONCAT('%',#{username},'%') ")
    List<UserRole> queryUserLikeUsername(String username);


    /**
     * 通过username精准查询
     * @param username
     * @return
     */
    @Select(value = "select * from `user` where username = #{username}")
    User queryUserByUsername(String username);

    /**
     * 更新表中部分数据的数据
     * @param userUpdateInfo
     * @return
     */
    @Update(value = "update user set password=#{info.password},gender=#{info.gender},role_id=#{info.role_id} where id =#{info.id}")
    int updateUser(@Param("info") UserUpdateInfo userUpdateInfo);


    /**
     * 通过id删除对应的记录
     * @param id
     * @return
     */
    @Delete(value = "delete from user where id =#{id}")
    int deleteUser(Integer id);


    /**
     * 插入数据
     * @param user
     * @return
     */
    @Insert("   INSERT INTO user\n" +
                "       (id,user_id,username,password,gender,create_time,role_id)\n" +
                "       VALUES\n" +
                "       (#{user.id},#{user.user_id},#{user.username},#{user.password},#{user.gender},#{user.create_time},#{user.role_id})")
    public int addUser(@Param("user") User user);


    /**
     * 查找user_id的最大值
     * @return
     */
    @Select(value = "SELECT MAX(user_id) as MaxUserId FROM `user`")
    public String MaxUserId();
}
