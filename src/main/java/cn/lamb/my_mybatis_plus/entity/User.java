package cn.lamb.my_mybatis_plus.entity;

import lombok.Data;

/**
 * @Description TODO
 * @Date 2020/3/28 23:39
 * @Creator Lambert
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
