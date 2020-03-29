package cn.lamb.my_mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description TODO
 * @Date 2020/3/28 23:39
 * @Creator Lambert
 */
@Data
@TableName(value = "user")  //表名注解
public class User {
    @TableId(value = "id", type = IdType.AUTO)  //主键注解
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
