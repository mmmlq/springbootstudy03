package com.lq.springboot.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by wzd on 2018/8/13.
 */
@Data
public class UserVo {
    private Integer id;
    @JsonProperty("name")
    private String userName;
    @JsonProperty("age")
    private Integer userAge;


}