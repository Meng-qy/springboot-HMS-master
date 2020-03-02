package com.meng.service.role;

import com.meng.mapper.RoleMapper;
import com.meng.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role queryRoles() {

        return roleMapper.AllRole() ;
    }

    @Override
    public Role roleById(int id) {
        return roleMapper.RoleById(id);
    }
}
