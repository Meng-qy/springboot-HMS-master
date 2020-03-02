package com.meng.pojo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StoreDrug {
    private int store_id;
    private String drug_name;
    private String drug_count;
    private String last_time;
    private Integer drug_id;
    private String drug_code;
    private String price;
    private String add_time;
}
