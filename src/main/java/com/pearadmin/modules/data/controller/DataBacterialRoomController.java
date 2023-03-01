package com.pearadmin.modules.data.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.context.UserContext;
import com.pearadmin.modules.data.domain.DataBacterialRoom;
import com.pearadmin.common.tools.string.Convert;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.pearadmin.modules.data.service.IDataBacterialRoomService;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 菌房Controller
 *
 * @author leo
 * @date 2023-02-23
 */
@RestController
@RequestMapping("/data/bacterialRoom")
public class DataBacterialRoomController extends BaseController {

    private String prefix = "data/bacterialRoom";

    @Autowired
    private IDataBacterialRoomService dataBacterialRoomService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/data/bacterialRoom/main','data:bacterialRoom:main')")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询菌房列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/data/bacterialRoom/data','data:bacterialRoom:data')")
    public ResultTable list(@ModelAttribute DataBacterialRoom dataBacterialRoom, PageDomain pageDomain) {
        PageInfo<DataBacterialRoom> pageInfo = dataBacterialRoomService.selectDataBacterialRoomPage(dataBacterialRoom, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增菌房
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/data/bacterialRoom/add','data:bacterialRoom:add')")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增菌房
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/data/bacterialRoom/add','data:bacterialRoom:add')")
    public Result save(@RequestBody DataBacterialRoom dataBacterialRoom) {
        return decide(dataBacterialRoomService.save(dataBacterialRoom));
    }

    /**
     * 修改菌房
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/data/bacterialRoom/edit','data:bacterialRoom:edit')")
    public ModelAndView edit(Long id, ModelMap map) {
        DataBacterialRoom dataBacterialRoom =dataBacterialRoomService.getById(id);
        map.put("dataBacterialRoom", dataBacterialRoom);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改菌房
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/data/bacterialRoom/edit','data:bacterialRoom:edit')")
    public Result update(@RequestBody DataBacterialRoom dataBacterialRoom) {
        return decide(dataBacterialRoomService.updateById(dataBacterialRoom));
    }

    /**
     * 删除菌房
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasPermission('/data/bacterialRoom/remove','data:bacterialRoom:remove')")
    public Result batchRemove(String ids) {
        return decide(dataBacterialRoomService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 删除菌房
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/data/bacterialRoom/remove','data:bacterialRoom:remove')")
    public Result remove(@PathVariable("id") Long id) {
        return decide(dataBacterialRoomService.removeById(id));
    }
}
