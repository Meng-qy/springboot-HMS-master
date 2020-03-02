package com.meng.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StoreInput {
    private Integer id;
    private String drug_code;
    private Integer input_count;
    private String input_time;
}
