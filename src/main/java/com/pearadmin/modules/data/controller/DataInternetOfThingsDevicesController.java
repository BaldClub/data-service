package com.pearadmin.modules.data.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.modules.data.domain.DataInternetOfThingsDevices;
import com.pearadmin.modules.data.service.IDataInternetOfThingsDevicesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 物联网设备数据Controller
 *
 * @author leo
 * @date 2023-02-23
 */
@RestController
@RequestMapping("/data/internetOfThingsDevices")
public class DataInternetOfThingsDevicesController extends BaseController {

    private String prefix = "data/internetOfThingsDevices";

    @Resource
    private IDataInternetOfThingsDevicesService dataInternetOfThingsDevicesService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/data/internetOfThingsDevices/main','data:internetOfThingsDevices:main')")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询物联网设备数据列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/data/internetOfThingsDevices/data','data:internetOfThingsDevices:data')")
    public ResultTable list(@ModelAttribute DataInternetOfThingsDevices dataInternetOfThingsDevices, PageDomain pageDomain) {
        PageInfo<DataInternetOfThingsDevices> pageInfo = dataInternetOfThingsDevicesService.selectDataInternetOfThingsDevicesPage(dataInternetOfThingsDevices, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增物联网设备数据
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/data/internetOfThingsDevices/add','data:internetOfThingsDevices:add')")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增物联网设备数据
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/data/internetOfThingsDevices/add','data:internetOfThingsDevices:add')")
    public Result save(@RequestBody DataInternetOfThingsDevices dataInternetOfThingsDevices) {
        return decide(dataInternetOfThingsDevicesService.save(dataInternetOfThingsDevices));
    }

    /**
     * 修改物联网设备数据
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/data/internetOfThingsDevices/edit','data:internetOfThingsDevices:edit')")
    public ModelAndView edit(String id, ModelMap map) {
        DataInternetOfThingsDevices dataInternetOfThingsDevices =dataInternetOfThingsDevicesService.getById(id);
        map.put("dataInternetOfThingsDevices", dataInternetOfThingsDevices);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改物联网设备数据
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/data/internetOfThingsDevices/edit','data:internetOfThingsDevices:edit')")
    public Result update(@RequestBody DataInternetOfThingsDevices dataInternetOfThingsDevices) {
        return decide(dataInternetOfThingsDevicesService.updateById(dataInternetOfThingsDevices));
    }

    /**
     * 删除物联网设备数据
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasPermission('/data/internetOfThingsDevices/remove','data:internetOfThingsDevices:remove')")
    public Result batchRemove(String ids) {
        return decide(dataInternetOfThingsDevicesService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 删除物联网设备数据
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/data/internetOfThingsDevices/remove','data:internetOfThingsDevices:remove')")
    public Result remove(@PathVariable("id") Long id) {
        return decide(dataInternetOfThingsDevicesService.removeById(id));
    }
}
