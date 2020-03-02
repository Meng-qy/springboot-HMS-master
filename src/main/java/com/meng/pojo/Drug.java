package com.meng.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Drug {
    private Integer id;
    private String drug_name;
    private String drug_code;
    private String price;
    private String add_time;
}
