package com.lq.springboot.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * Created by wzd on 2018/8/13.
 */
@Data
@TableName("tbl_user")
public class User {
    @TableId("user_id")
    private Integer id;
    @TableField("user_name")
    private String userName;
    @TableField("user_age")
    private Integer userAge;


}
