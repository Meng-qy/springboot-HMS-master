package com.meng.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateInfo {
    private int id;
    private String password;
    private int gender;
    private int role_id;

}
