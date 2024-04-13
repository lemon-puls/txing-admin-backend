package com.txing.project.oj.controller;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.txing.project.oj.service.IQuestionService;
import com.txing.project.oj.service.IUserService;
import com.txing.project.oj.vo.question.QuestionSimpleVO;
import com.txing.project.oj.vo.user.UserShowVO;
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
import com.txing.framework.aspectj.lang.annotation.Log;
import com.txing.framework.aspectj.lang.enums.BusinessType;
import com.txing.project.oj.domain.MatchOnlinepk;
import com.txing.project.oj.service.IMatchOnlinepkService;
import com.txing.framework.web.controller.BaseController;
import com.txing.framework.web.domain.AjaxResult;
import com.txing.common.utils.poi.ExcelUtil;
import com.txing.framework.web.page.TableDataInfo;

/**
 * 在线PKController
 * 
 * @author lizhiwei
 * @date 2024-04-08
 */
@RestController
@RequestMapping("/oj/onlinepk")
public class MatchOnlinepkController extends BaseController
{
    @Autowired
    private IMatchOnlinepkService matchOnlinepkService;
    @Autowired
    IUserService userService;
    @Autowired
    IQuestionService questionService;

    /**
     * 查询在线PK列表
     */
    @PreAuthorize("@ss.hasPermi('oj:onlinepk:list')")
    @GetMapping("/list")
    @ApiOperation("查询在线PK列表")
    public TableDataInfo list(MatchOnlinepk matchOnlinepk)
    {
        startPage();
        List<MatchOnlinepk> list = matchOnlinepkService.selectMatchOnlinepkList(matchOnlinepk);
        for (MatchOnlinepk onlinepk : list) {
            UserShowVO user1 = userService.getUserShowVOById(onlinepk.getUserId1());
            UserShowVO user2 = userService.getUserShowVOById(onlinepk.getUserId2());
            QuestionSimpleVO question = questionService.getQuestionSimpleVOById(onlinepk.getQuestionId());
            onlinepk.setUser1(user1);
            onlinepk.setUser2(user2);
            onlinepk.setQuestion(question);
        }
        return getDataTable(list);
    }

    /**
     * 导出在线PK列表
     */
    @PreAuthorize("@ss.hasPermi('oj:onlinepk:export')")
    @Log(title = "在线PK", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出在线PK列表")
    public void export(HttpServletResponse response, MatchOnlinepk matchOnlinepk)
    {
        List<MatchOnlinepk> list = matchOnlinepkService.selectMatchOnlinepkList(matchOnlinepk);
        ExcelUtil<MatchOnlinepk> util = new ExcelUtil<MatchOnlinepk>(MatchOnlinepk.class);
        util.exportExcel(response, list, "在线PK数据");
    }

    /**
     * 获取在线PK详细信息
     */
    @PreAuthorize("@ss.hasPermi('oj:onlinepk:query')")
    @GetMapping(value = "/{id}")
    @ApiOperation("获取在线PK详细信息")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(matchOnlinepkService.selectMatchOnlinepkById(id));
    }

    /**
     * 新增在线PK
     */
    @PreAuthorize("@ss.hasPermi('oj:onlinepk:add')")
    @Log(title = "在线PK", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增在线PK")
    public AjaxResult add(@RequestBody MatchOnlinepk matchOnlinepk)
    {
        return toAjax(matchOnlinepkService.insertMatchOnlinepk(matchOnlinepk));
    }

    /**
     * 修改在线PK
     */
    @PreAuthorize("@ss.hasPermi('oj:onlinepk:edit')")
    @Log(title = "在线PK", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改在线PK")
    public AjaxResult edit(@RequestBody MatchOnlinepk matchOnlinepk)
    {
        return toAjax(matchOnlinepkService.updateMatchOnlinepk(matchOnlinepk));
    }

    /**
     * 删除在线PK
     */
    @PreAuthorize("@ss.hasPermi('oj:onlinepk:remove')")
    @Log(title = "在线PK", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @ApiOperation("删除在线PK")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(matchOnlinepkService.removeByIds(Arrays.asList(ids)));
    }
}
