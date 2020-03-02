package com.meng.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class StoreOutput {
    private Integer id;
    private String drug_code;
    private Integer output_count;
    private String output_time;
}