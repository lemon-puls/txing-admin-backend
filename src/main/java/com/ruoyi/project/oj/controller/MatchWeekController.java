package com.ruoyi.project.oj.controller;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.project.oj.service.IMatchWeekQuestionRelateService;
import com.ruoyi.project.oj.vo.question.QuestionSimpleVO;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.project.oj.domain.MatchWeek;
import com.ruoyi.project.oj.service.IMatchWeekService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 周赛Controller
 *
 * @author lizhiwei
 * @date 2024-04-07
 */
@RestController
@RequestMapping("/oj/weekMatch")
public class MatchWeekController extends BaseController {
    @Autowired
    private IMatchWeekService matchWeekService;
    @Autowired
    private IMatchWeekQuestionRelateService matchWeekQuestionRelateService;

    /**
     * 查询周赛列表
     */
    @PreAuthorize("@ss.hasPermi('oj:weekMatch:list')")
    @GetMapping("/list")
    @ApiOperation("查询周赛列表")
    public TableDataInfo list(MatchWeek matchWeek) {
        startPage();
        List<MatchWeek> list = matchWeekService.selectMatchWeekList(matchWeek);
        for (MatchWeek week : list) {
            List<QuestionSimpleVO> questionSimpleVO = matchWeekQuestionRelateService.getQuestionSimpleVO(week.getId());
            week.setQuestions(questionSimpleVO);
        }
        return getDataTable(list);
    }

    /**
     * 导出周赛列表
     */
    @PreAuthorize("@ss.hasPermi('oj:weekMatch:export')")
    @Log(title = "周赛", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出周赛列表")
    public void export(HttpServletResponse response, MatchWeek matchWeek) {
        List<MatchWeek> list = matchWeekService.selectMatchWeekList(matchWeek);
        ExcelUtil<MatchWeek> util = new ExcelUtil<MatchWeek>(MatchWeek.class);
        util.exportExcel(response, list, "周赛数据");
    }

    /**
     * 获取周赛详细信息
     */
    @ApiOperation("获取周赛详细信息")
    @PreAuthorize("@ss.hasPermi('oj:weekMatch:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(matchWeekService.selectMatchWeekById(id));
    }

    /**
     * 新增周赛
     */
    @PreAuthorize("@ss.hasPermi('oj:weekMatch:add')")
    @Log(title = "周赛", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增周赛")
    public AjaxResult add(@RequestBody MatchWeek matchWeek) {
        return toAjax(matchWeekService.insertMatchWeek(matchWeek));
    }

    /**
     * 修改周赛
     */
    @PreAuthorize("@ss.hasPermi('oj:weekMatch:edit')")
    @Log(title = "周赛", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改周赛")
    public AjaxResult edit(@RequestBody MatchWeek matchWeek) {
        return toAjax(matchWeekService.updateMatchWeek(matchWeek));
    }

    /**
     * 删除周赛
     */
    @ApiOperation("删除周赛")
    @PreAuthorize("@ss.hasPermi('oj:weekMatch:remove')")
    @Log(title = "周赛", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(matchWeekService.removeByIds(Arrays.asList(ids)));
    }
}
