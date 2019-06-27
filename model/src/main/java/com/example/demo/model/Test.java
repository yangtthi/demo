package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @Author wyatt
 * @Data 2019/05/08 12:17
 */
@NoArgsConstructor
@Data
public class Test {


    /**
     * customerType : 1
     * pid : 100000461310
     * tableName : point_lock_log
     */

    private int customerType;
    private long pid;
    private String tableName;
}
