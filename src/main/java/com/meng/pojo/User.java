package com.meng.pojo;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String user_id;
    private String username;
    private String password;
    private Integer gender;
    private String create_time;
    private Integer role_id;
}
