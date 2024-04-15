package com.txing.project.oj.controller;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.json.JSONUtil;
import com.txing.common.utils.SecurityUtils;
import com.txing.common.utils.ThrowUtils;
import com.txing.framework.security.LoginUser;
import com.txing.project.oj.dto.question.JudgeCase;
import com.txing.project.oj.dto.question.JudgeConfig;
import com.txing.project.oj.dto.question.QuestionAddRequest;
import com.txing.project.oj.dto.question.QuestionUpdateRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
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
import com.txing.project.oj.domain.Question;
import com.txing.project.oj.service.IQuestionService;
import com.txing.framework.web.controller.BaseController;
import com.txing.framework.web.domain.AjaxResult;
import com.txing.common.utils.poi.ExcelUtil;
import com.txing.framework.web.page.TableDataInfo;

/**
 * 题目中心Controller
 *
 * @author lizhiwei
 * @date 2024-04-02
 */
@Api("题目信息管理")
@RestController
@RequestMapping("/oj/question")
public class QuestionController extends BaseController {
    @Autowired
    private IQuestionService questionService;

    /**
     * 查询题目列表
     */
    @ApiOperation("获取题目列表")
    @PreAuthorize("@ss.hasPermi('oj:question:list')")
    @GetMapping("/list")
    public TableDataInfo list(Question question) {
        startPage();
        List<Question> list = questionService.selectQuestionList(question);
        return getDataTable(list);
    }

    /**
     * 导出题目列表
     */
    @ApiOperation("导出题目列表")
//    @PreAuthorize("@ss.hasPermi('oj:question:export')")
    @Log(title = "题目中心", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Question question) {
        List<Question> list = questionService.selectQuestionList(question);
        ExcelUtil<Question> util = new ExcelUtil<Question>(Question.class);
        util.exportExcel(response, list, "题目中心数据");
    }

    /**
     * 获取题目详细信息
     */
//    @PreAuthorize("@ss.hasPermi('oj:question:query')")
    @GetMapping(value = "/{id}")
    @ApiOperation("通过id获取题目")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(questionService.selectQuestionById(id));
    }

    /**
     * 新增题目
     */
//    @PreAuthorize("@ss.hasPermi('oj:question:add')")
    @Log(title = "题目中心", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增题目")
    public AjaxResult add(@RequestBody QuestionAddRequest questionAddRequest) {
        LoginUser loginUser1 = SecurityUtils.getLoginUser();
        ThrowUtils.throwIf(questionAddRequest == null, "题目数据不得为空");
        Question question = new Question();
        BeanUtils.copyProperties(questionAddRequest, question);
        List<String> tags = questionAddRequest.getTags();
        if (tags != null) {
            question.setTags(JSONUtil.toJsonStr(tags));
        }
        List<JudgeCase> judgeCase = questionAddRequest.getJudgeCase();
        if (judgeCase != null) {
            question.setJudgeCase(JSONUtil.toJsonStr(judgeCase));
        }
        JudgeConfig judgeConfig = questionAddRequest.getJudgeConfig();
        if (judgeConfig != null) {
            question.setJudgeConfig(JSONUtil.toJsonStr(judgeConfig));
        }
        question.setUserId(loginUser1.getUserId());
        question.setFavourNum(0L);
        question.setThumbNum(0L);
        question.setSubmitNum(0L);
        question.setAcceptedNum(0L);
        boolean result = questionService.save(question);
        ThrowUtils.throwIf(!result, "保存失败");
        long newQuestionId = question.getId();
        return success(newQuestionId);
    }

    /**
     * 修改题目
     */
//    @PreAuthorize("@ss.hasPermi('oj:question:edit')")
    @Log(title = "题目中心", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("更新题目")
    public AjaxResult edit(@RequestBody QuestionUpdateRequest questionUpdateRequest) {
        ThrowUtils.throwIf(questionUpdateRequest == null || questionUpdateRequest.getId() <= 0, "提交数据异常");
        Question question = new Question();
        BeanUtils.copyProperties(questionUpdateRequest, question);
        List<String> tags = questionUpdateRequest.getTags();
        if (tags != null) {
            question.setTags(JSONUtil.toJsonStr(tags));
        }
        List<JudgeCase> judgeCase = questionUpdateRequest.getJudgeCase();
        if (judgeCase != null) {
            question.setJudgeCase(JSONUtil.toJsonStr(judgeCase));
        }
        JudgeConfig judgeConfig = questionUpdateRequest.getJudgeConfig();
        if (judgeConfig != null) {
            question.setJudgeConfig(JSONUtil.toJsonStr(judgeConfig));
        }
        long id = questionUpdateRequest.getId();
        // 判断是否存在
        Question oldQuestion = questionService.getById(id);
        ThrowUtils.throwIf(oldQuestion == null, "题目不存在");
        boolean result = questionService.updateById(question);
        return success(result);
    }

    /**
     * 删除题目中心
     */
//    @PreAuthorize("@ss.hasPermi('oj:question:remove')")
    @Log(title = "题目中心", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    @ApiOperation("删除题目Batch")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(questionService.removeByIds(Arrays.asList(ids)));
    }
}
