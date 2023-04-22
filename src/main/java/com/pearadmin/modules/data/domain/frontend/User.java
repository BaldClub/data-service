package com.pearadmin.modules.data.domain.frontend;

import lombok.Data;

/**
 * 用户
 */
@Data
public class User {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String captcha;
}
