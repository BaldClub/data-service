package com.pearadmin.modules.data.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.modules.data.domain.DataBacterialRoomEnvironment;
import com.pearadmin.modules.data.service.IDataBacterialRoomEnvironmentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 菌房Controller
 *
 * @author leo
 * @date 2023-02-23
 */
@RestController
@RequestMapping("/data/bacterialRoomEnvironment")
public class DataBacterialRoomEnvironmentController extends BaseController {

    private String prefix = "data/bacterialRoomEnvironment";

    @Resource
    private IDataBacterialRoomEnvironmentService dataBacterialRoomEnvironmentService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/data/bacterialRoomEnvironment/main','data:bacterialRoomEnvironment:main')")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询菌房列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/data/bacterialRoomEnvironment/data','data:bacterialRoomEnvironment:data')")
    public ResultTable list(@ModelAttribute DataBacterialRoomEnvironment dataBacterialRoomEnvironment, PageDomain pageDomain) {
        PageInfo<DataBacterialRoomEnvironment> pageInfo = dataBacterialRoomEnvironmentService.selectDataBacterialRoomEnvironmentPage(dataBacterialRoomEnvironment, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增菌房
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/data/bacterialRoomEnvironment/add','data:bacterialRoomEnvironment:add')")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增菌房
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/data/bacterialRoomEnvironment/add','data:bacterialRoomEnvironment:add')")
    public Result save(@RequestBody DataBacterialRoomEnvironment dataBacterialRoomEnvironment) {
        return decide(dataBacterialRoomEnvironmentService.save(dataBacterialRoomEnvironment));
    }

    /**
     * 修改菌房
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/data/bacterialRoomEnvironment/edit','data:bacterialRoomEnvironment:edit')")
    public ModelAndView edit(String id, ModelMap map) {
        DataBacterialRoomEnvironment dataBacterialRoomEnvironment =dataBacterialRoomEnvironmentService.getById(id);
        map.put("dataBacterialRoomEnvironment", dataBacterialRoomEnvironment);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改菌房
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/data/bacterialRoomEnvironment/edit','data:bacterialRoomEnvironment:edit')")
    public Result update(@RequestBody DataBacterialRoomEnvironment dataBacterialRoomEnvironment) {
        return decide(dataBacterialRoomEnvironmentService.updateById(dataBacterialRoomEnvironment));
    }

    /**
     * 删除菌房
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasPermission('/data/bacterialRoomEnvironment/remove','data:bacterialRoomEnvironment:remove')")
    public Result batchRemove(String ids) {
        return decide(dataBacterialRoomEnvironmentService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 删除菌房
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/data/bacterialRoomEnvironment/remove','data:bacterialRoomEnvironment:remove')")
    public Result remove(@PathVariable("id") Long id) {
        return decide(dataBacterialRoomEnvironmentService.removeById(id));
    }
}
