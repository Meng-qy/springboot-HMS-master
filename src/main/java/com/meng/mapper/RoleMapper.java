package com.meng.mapper;

import com.meng.pojo.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {

    @Select(value = "select * from role")
    public Role AllRole();

    @Select(value = "select * from role where id =#{id}")
    public Role RoleById( int id);
}
