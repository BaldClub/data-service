package com.pearadmin.modules.data.controller.frontend;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.modules.data.domain.DataInternetOfThingsDevices;
import com.pearadmin.modules.data.domain.DataPark;
import com.pearadmin.modules.data.domain.DataStrains;
import com.pearadmin.modules.data.domain.frontend.Device;
import com.pearadmin.modules.data.domain.frontend.Strains;
import com.pearadmin.modules.data.service.IDataInternetOfThingsDevicesService;
import com.pearadmin.modules.data.service.IDataParkService;
import com.pearadmin.modules.data.service.IDataStrainsService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = {"前端主页数据"})
@RequestMapping("/api/homepage")
public class HomepageController extends BaseController {

    private final String[] deviceTypeList = new String[]{"环境监测设备", "远程监控设备", "食用菌生产设备", "溯源设备"};

    private final String[] strainsTypeList = new String[]{"平菇", "香菇", "茶树菇", "木耳", "金针菇", "杏鲍菇"};

    private final String online = "在线";

    @Resource
    private IDataParkService parkService;

    @Resource
    private IDataInternetOfThingsDevicesService devicesService;

    @Resource
    private IDataStrainsService strainsService;

    /**
     * 查询园区数据
     */
    @GetMapping("/park")
    public ResultTable park() {
        return dataTable(parkService.getOne(new QueryWrapper<DataPark>().last("limit 1")));
    }

    /**
     * 查询园区数据
     *
     * @param id 园区编号
     */
    @GetMapping("/park/{id}")
    public ResultTable park(@PathVariable("id") Long id) {
        return dataTable(parkService.getById(id));
    }

    /**
     * 物联网设备统计
     */
    @GetMapping("/device")
    public ResultTable device() {
        List<DataInternetOfThingsDevices> list = devicesService.list(new QueryWrapper<DataInternetOfThingsDevices>().isNotNull("status"));
        List<Device> resultList = new ArrayList<>();
        Device device;
        long onlineCount = 0;

        for (String type : deviceTypeList) {
            device = new Device();
            device.setName(type);
            device.setCount(list.stream()
                    .filter(item -> type.equals(item.getType()))
                    .count());
            onlineCount = list.stream()
                    .filter(item -> type.equals(item.getType()))
                    .filter(item -> online.equals(item.getStatus()))
                    .count();
            device.setOnline(device.getCount() == 0
                    ? "0"
                    : String.valueOf(1d * onlineCount / device.getCount()));
            resultList.add(device);
        }

        return dataTable(resultList);
    }

    /**
     * 查询菌株数据
     */
    @GetMapping("/strains")
    public ResultTable strains() {
        List<DataStrains> list = strainsService.list();
        List<Strains> resultList = new ArrayList<>();
        Strains strains;

        for (String type : strainsTypeList) {
            strains = new Strains();
            strains.setType(type);
            strains.setCount(list.stream().filter(item -> type.equals(item.getType())).count());
            resultList.add(strains);
        }

        return dataTable(resultList);
    }
}
