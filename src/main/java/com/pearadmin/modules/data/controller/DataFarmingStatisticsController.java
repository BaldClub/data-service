package com.pearadmin.modules.data.controller;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.base.BaseController;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.common.web.domain.response.module.ResultTable;
import com.pearadmin.modules.data.domain.DataFarmingStatistics;
import com.pearadmin.modules.data.service.IDataFarmingStatisticsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 农事统计Controller
 *
 * @author leo
 * @date 2023-02-23
 */
@RestController
@RequestMapping("/data/farmingStatistics")
public class DataFarmingStatisticsController extends BaseController {

    private String prefix = "data/farmingStatistics";

    @Resource
    private IDataFarmingStatisticsService dataFarmingStatisticsService;

    @GetMapping("/main")
    @PreAuthorize("hasPermission('/data/farmingStatistics/main','data:farmingStatistics:main')")
    public ModelAndView main() {
        return jumpPage(prefix + "/main");
    }

    /**
     * 查询农事统计列表
     */
    @ResponseBody
    @GetMapping("/data")
    @PreAuthorize("hasPermission('/data/farmingStatistics/data','data:farmingStatistics:data')")
    public ResultTable list(@ModelAttribute DataFarmingStatistics dataFarmingStatistics, PageDomain pageDomain) {
        PageInfo<DataFarmingStatistics> pageInfo = dataFarmingStatisticsService.selectDataFarmingStatisticsPage(dataFarmingStatistics, pageDomain);
        return pageTable(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 新增农事统计
     */
    @GetMapping("/add")
    @PreAuthorize("hasPermission('/data/farmingStatistics/add','data:farmingStatistics:add')")
    public ModelAndView add() {
        return jumpPage(prefix + "/add");
    }

    /**
     * 新增农事统计
     */
    @ResponseBody
    @PostMapping("/save")
    @PreAuthorize("hasPermission('/data/farmingStatistics/add','data:farmingStatistics:add')")
    public Result save(@RequestBody DataFarmingStatistics dataFarmingStatistics) {
        return decide(dataFarmingStatisticsService.save(dataFarmingStatistics));
    }

    /**
     * 修改农事统计
     */
    @GetMapping("/edit")
    @PreAuthorize("hasPermission('/data/farmingStatistics/edit','data:farmingStatistics:edit')")
    public ModelAndView edit(String id, ModelMap map) {
        DataFarmingStatistics dataFarmingStatistics = dataFarmingStatisticsService.getById(id);
        map.put("dataFarmingStatistics", dataFarmingStatistics);
        return jumpPage(prefix + "/edit");
    }

    /**
     * 修改农事统计
     */
    @ResponseBody
    @PutMapping("/update")
    @PreAuthorize("hasPermission('/data/farmingStatistics/edit','data:farmingStatistics:edit')")
    public Result update(@RequestBody DataFarmingStatistics dataFarmingStatistics) {
        return decide(dataFarmingStatisticsService.updateById(dataFarmingStatistics));
    }

    /**
     * 删除农事统计
     */
    @ResponseBody
    @DeleteMapping("/batchRemove")
    @PreAuthorize("hasPermission('/data/farmingStatistics/remove','data:farmingStatistics:remove')")
    public Result batchRemove(String ids) {
        return decide(dataFarmingStatisticsService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 删除农事统计
     */
    @ResponseBody
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasPermission('/data/farmingStatistics/remove','data:farmingStatistics:remove')")
    public Result remove(@PathVariable("id") Long id) {
        return decide(dataFarmingStatisticsService.removeById(id));
    }
}
