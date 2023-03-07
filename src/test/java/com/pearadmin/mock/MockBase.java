package com.pearadmin.mock;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 基础模拟类
 */
public abstract class MockBase<D> extends FakerUtil {

    public abstract <D> D createData();
}
