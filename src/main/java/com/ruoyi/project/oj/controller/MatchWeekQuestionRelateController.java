package com.ruoyi.project.oj.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.oj.domain.MatchWeekQuestionRelate;
import com.ruoyi.project.oj.service.IMatchWeekQuestionRelateService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 周赛题目关联Controller
 * 
 * @author lizhiwei
 * @date 2024-04-07
 */
@RestController
@RequestMapping("/oj/MatchWeekQuestionRelate")
public class MatchWeekQuestionRelateController extends BaseController
{
    @Autowired
    private IMatchWeekQuestionRelateService matchWeekQuestionRelateService;

    /**
     * 查询周赛题目关联列表
     */
    @PreAuthorize("@ss.hasPermi('oj:MatchWeekQuestionRelate:list')")
    @GetMapping("/list")
    public TableDataInfo list(MatchWeekQuestionRelate matchWeekQuestionRelate)
    {
        startPage();
        List<MatchWeekQuestionRelate> list = matchWeekQuestionRelateService.selectMatchWeekQuestionRelateList(matchWeekQuestionRelate);
        return getDataTable(list);
    }

    /**
     * 导出周赛题目关联列表
     */
    @PreAuthorize("@ss.hasPermi('oj:MatchWeekQuestionRelate:export')")
    @Log(title = "周赛题目关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MatchWeekQuestionRelate matchWeekQuestionRelate)
    {
        List<MatchWeekQuestionRelate> list = matchWeekQuestionRelateService.selectMatchWeekQuestionRelateList(matchWeekQuestionRelate);
        ExcelUtil<MatchWeekQuestionRelate> util = new ExcelUtil<MatchWeekQuestionRelate>(MatchWeekQuestionRelate.class);
        util.exportExcel(response, list, "周赛题目关联数据");
    }

    /**
     * 获取周赛题目关联详细信息
     */
    @PreAuthorize("@ss.hasPermi('oj:MatchWeekQuestionRelate:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(matchWeekQuestionRelateService.selectMatchWeekQuestionRelateById(id));
    }

    /**
     * 新增周赛题目关联
     */
    @PreAuthorize("@ss.hasPermi('oj:MatchWeekQuestionRelate:add')")
    @Log(title = "周赛题目关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MatchWeekQuestionRelate matchWeekQuestionRelate)
    {
        return toAjax(matchWeekQuestionRelateService.insertMatchWeekQuestionRelate(matchWeekQuestionRelate));
    }

    /**
     * 修改周赛题目关联
     */
    @PreAuthorize("@ss.hasPermi('oj:MatchWeekQuestionRelate:edit')")
    @Log(title = "周赛题目关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MatchWeekQuestionRelate matchWeekQuestionRelate)
    {
        return toAjax(matchWeekQuestionRelateService.updateMatchWeekQuestionRelate(matchWeekQuestionRelate));
    }

    /**
     * 删除周赛题目关联
     */
    @PreAuthorize("@ss.hasPermi('oj:MatchWeekQuestionRelate:remove')")
    @Log(title = "周赛题目关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(matchWeekQuestionRelateService.deleteMatchWeekQuestionRelateByIds(ids));
    }
}
