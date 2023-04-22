package com.pearadmin.modules.data.controller.frontend;

import com.pearadmin.common.aop.annotation.Log;
import com.pearadmin.common.aop.enums.BusinessType;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.modules.data.domain.frontend.User;
import com.pearadmin.modules.sys.domain.SysUser;
import com.pearadmin.modules.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(tags = {"5. 前端用户"})
@RequestMapping("/api")
public class UserController extends BaseController {

    @Resource
    SysUserService sysUserService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @PostMapping("signin")
    @ApiOperation(value = "登录")
    public Result signin(@RequestBody User user) {
        SysUser sysUser = sysUserService.getUserByUsername(user.getUsername());

        if (sysUser == null) {
            return failure("用户名不存在");
        }

        if (passwordEncoder.matches(user.getPassword(), sysUser.getPassword())) {
            return success("登录成功");
        }

        return success("密码不正确");
    }

    @PostMapping("signup")
    @ApiOperation(value = "注册")
    @Log(title = "新增用户", describe = "新增用户", type = BusinessType.ADD)
    public Result signup(@RequestBody SysUser sysUser) {
        if (sysUserService.getUserByUsername(sysUser.getUsername()) != null) {
            return failure("用户名已存在");
        }

        sysUser.setLogin("0");
        sysUser.setEnable("1");
        sysUser.setStatus("1");
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        sysUserService.save(sysUser);
        return success("注册成功");
    }
}
