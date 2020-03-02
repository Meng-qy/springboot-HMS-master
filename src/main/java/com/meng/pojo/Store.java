package com.meng.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Store {

    private int store_id;
    private String drug_code;
    private String drug_count;
    private String last_time;
}
