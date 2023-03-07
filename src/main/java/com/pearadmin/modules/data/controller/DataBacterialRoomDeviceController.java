package com.pearadmin.modules.data.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.modules.data.domain.DataBacterialRoomDevice;
import com.pearadmin.modules.data.service.IDataBacterialRoomDeviceService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 菌房设备Controller
 *
 * @author leo
 * @date 2023-02-23
 */
@RestController
@RequestMapping("/data/bacterialRoomDevice")
public class DataBacterialRoomDeviceController extends BaseController {

    private String prefix = "data/bacterialRoomDevice";

    @Resource
    private IDataBacterialRoomDeviceService dataBacterialRoomDeviceService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/data/bacterialRoomDevice/main','data:bacterialRoomDevice:main')")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询菌房设备列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/data/bacterialRoomDevice/data','data:bacterialRoomDevice:data')")
    public ResultTable list(@ModelAttribute DataBacterialRoomDevice dataBacterialRoomDevice, PageDomain pageDomain) {
        PageInfo<DataBacterialRoomDevice> pageInfo = dataBacterialRoomDeviceService.selectDataBacterialRoomDevicePage(dataBacterialRoomDevice, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增菌房设备
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/data/bacterialRoomDevice/add','data:bacterialRoomDevice:add')")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增菌房设备
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/data/bacterialRoomDevice/add','data:bacterialRoomDevice:add')")
    public Result save(@RequestBody DataBacterialRoomDevice dataBacterialRoomDevice) {
        return decide(dataBacterialRoomDeviceService.save(dataBacterialRoomDevice));
    }

    /**
     * 修改菌房设备
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/data/bacterialRoomDevice/edit','data:bacterialRoomDevice:edit')")
    public ModelAndView edit(String id, ModelMap map) {
        DataBacterialRoomDevice dataBacterialRoomDevice =dataBacterialRoomDeviceService.getById(id);
        map.put("dataBacterialRoomDevice", dataBacterialRoomDevice);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改菌房设备
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/data/bacterialRoomDevice/edit','data:bacterialRoomDevice:edit')")
    public Result update(@RequestBody DataBacterialRoomDevice dataBacterialRoomDevice) {
        return decide(dataBacterialRoomDeviceService.updateById(dataBacterialRoomDevice));
    }

    /**
     * 删除菌房设备
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasPermission('/data/bacterialRoomDevice/remove','data:bacterialRoomDevice:remove')")
    public Result batchRemove(String ids) {
        return decide(dataBacterialRoomDeviceService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 删除菌房设备
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/data/bacterialRoomDevice/remove','data:bacterialRoomDevice:remove')")
    public Result remove(@PathVariable("id") Long id) {
        return decide(dataBacterialRoomDeviceService.removeById(id));
    }
}
