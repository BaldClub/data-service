package com.pearadmin.modules.data.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.modules.data.domain.DataPolice;
import com.pearadmin.modules.data.service.IDataPoliceService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 报警Controller
 *
 * @author leo
 * @date 2023-02-23
 */
@RestController
@RequestMapping("/data/police")
public class DataPoliceController extends BaseController {

    private String prefix = "data/police";

    @Resource
    private IDataPoliceService dataPoliceService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/data/police/main','data:police:main')")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询报警列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/data/police/data','data:police:data')")
    public ResultTable list(@ModelAttribute DataPolice dataPolice, PageDomain pageDomain) {
        PageInfo<DataPolice> pageInfo = dataPoliceService.selectDataPolicePage(dataPolice, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增报警
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/data/police/add','data:police:add')")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增报警
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/data/police/add','data:police:add')")
    public Result save(@RequestBody DataPolice dataPolice) {
        return decide(dataPoliceService.save(dataPolice));
    }

    /**
     * 修改报警
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/data/police/edit','data:police:edit')")
    public ModelAndView edit(String id, ModelMap map) {
        DataPolice dataPolice =dataPoliceService.getById(id);
        map.put("dataPolice", dataPolice);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改报警
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/data/police/edit','data:police:edit')")
    public Result update(@RequestBody DataPolice dataPolice) {
        return decide(dataPoliceService.updateById(dataPolice));
    }

    /**
     * 删除报警
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasPermission('/data/police/remove','data:police:remove')")
    public Result batchRemove(String ids) {
        return decide(dataPoliceService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 删除报警
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/data/police/remove','data:police:remove')")
    public Result remove(@PathVariable("id") Long id) {
        return decide(dataPoliceService.removeById(id));
    }
}
