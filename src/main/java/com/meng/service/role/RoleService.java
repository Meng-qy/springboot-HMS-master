package com.meng.service.role;


import com.meng.pojo.Role;

public interface RoleService {

    public Role queryRoles();

    public Role roleById(int id);
}
