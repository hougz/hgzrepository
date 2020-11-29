package com.hgz.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
@Data
@Entity
@Table(name="tb_user")
@ApiModel
public class TbUser {

    @Id
    @ApiModelProperty(value = "用户Id")
    private Long id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "用户年龄")
    private Integer age;
    @ApiModelProperty(value = "用户余额")
    private BigDecimal balance;
    @ApiModelProperty(value = "用户地址")
    private String address;


}