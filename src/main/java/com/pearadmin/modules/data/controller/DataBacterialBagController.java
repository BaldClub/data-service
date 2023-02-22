package com.pearadmin.modules.data.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.context.UserContext;
import com.pearadmin.modules.data.domain.DataBacterialBag;
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
import com.pearadmin.modules.data.service.IDataBacterialBagService;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 菌包Controller
 *
 * @author leo
 * @date 2023-02-23
 */
@RestController
@RequestMapping("/data/bacterialBag")
public class DataBacterialBagController extends BaseController {

    private String prefix = "data/bacterialBag";

    @Autowired
    private IDataBacterialBagService dataBacterialBagService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/data/bacterialBag/main','data:bacterialBag:main')")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询菌包列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/data/bacterialBag/data','data:bacterialBag:data')")
    public ResultTable list(@ModelAttribute DataBacterialBag dataBacterialBag, PageDomain pageDomain) {
        PageInfo<DataBacterialBag> pageInfo = dataBacterialBagService.selectDataBacterialBagPage(dataBacterialBag, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增菌包
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/data/bacterialBag/add','data:bacterialBag:add')")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增菌包
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/data/bacterialBag/add','data:bacterialBag:add')")
    public Result save(@RequestBody DataBacterialBag dataBacterialBag) {
        return decide(dataBacterialBagService.save(dataBacterialBag));
    }

    /**
     * 修改菌包
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/data/bacterialBag/edit','data:bacterialBag:edit')")
    public ModelAndView edit(Long id, ModelMap map) {
        DataBacterialBag dataBacterialBag =dataBacterialBagService.getById(id);
        map.put("dataBacterialBag", dataBacterialBag);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改菌包
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/data/bacterialBag/edit','data:bacterialBag:edit')")
    public Result update(@RequestBody DataBacterialBag dataBacterialBag) {
        return decide(dataBacterialBagService.updateById(dataBacterialBag));
    }

    /**
     * 删除菌包
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasPermission('/data/bacterialBag/remove','data:bacterialBag:remove')")
    public Result batchRemove(String ids) {
        return decide(dataBacterialBagService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 删除菌包
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/data/bacterialBag/remove','data:bacterialBag:remove')")
    public Result remove(@PathVariable("id") Long id) {
        return decide(dataBacterialBagService.removeById(id));
    }
}
