package com.pearadmin.modules.data.controller.frontend;

import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.modules.data.mapper.DataInternetOfThingsDevicesMapper;
import com.pearadmin.modules.data.service.IDataInternetOfThingsDevicesService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = {"3. 智能监控页面数据"})
@RequestMapping("/api/monitor")
public class MonitorController extends BaseController {

    @Resource
    private DataInternetOfThingsDevicesMapper devicesMapper;

    @Resource
    private IDataInternetOfThingsDevicesService devicesService;

    /**
     * 设备状态（监控）
     */
    @GetMapping("status")
    public ResultTable status() {
        return dataTable(devicesMapper.groupByStatus());
    }

    /**
     * 查询物联网设备数据详情（监控设备列表）
     */
    @GetMapping("info")
    public ResultTable info() {
        return dataTable(devicesService.query().eq("type", "远程监控设备").list());
    }
}
