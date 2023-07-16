package com.example.demo.pojo;

import lombok.Data;

import java.sql.Date;

/**
 * @author hewenji
 * @Date 2023/7/15 19:38
 */
@Data
public class Log {
    private Integer id;
    private String info;
    private Date createDate;
}
