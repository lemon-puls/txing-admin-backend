package com.ruoyi.project.oj.controller;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.collection.CollectionUtil;
import com.ruoyi.common.utils.ThrowUtils;
import com.ruoyi.project.oj.adapter.TopicAdapter;
import com.ruoyi.project.oj.service.IUserService;
import com.ruoyi.project.oj.vo.forum.TopicDetailVO;
import com.ruoyi.project.oj.vo.forum.TopicVO;
import com.ruoyi.project.oj.vo.user.UserShowVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.oj.domain.Topic;
import com.ruoyi.project.oj.service.ITopicService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 帖子Controller
 *
 * @author lizhiwei
 * @date 2024-04-06
 */
@RestController
@RequestMapping("/oj/forum")
public class TopicController extends BaseController {
    @Autowired
    private ITopicService topicService;
    @Autowired
    TopicAdapter topicAdapter;
    @Autowired
    IUserService userService;

    /**
     * 查询帖子列表
     */
    @PreAuthorize("@ss.hasPermi('oj:forum:list')")
    @GetMapping("/list")
    @ApiOperation("查询帖子列表")
    public TableDataInfo list(Topic topic) {
        startPage();
        List<Topic> list = topicService.selectTopicList(topic);
        for (Topic topic1 : list) {
            UserShowVO user = userService.getUserShowVOById(topic1.getUserId());
            topic1.setUser(user);
        }
        return getDataTable(list);
    }

    /**
     * 导出帖子列表
     */
    @PreAuthorize("@ss.hasPermi('oj:forum:export')")
    @Log(title = "帖子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出帖子列表")
    public void export(HttpServletResponse response, Topic topic) {
        List<Topic> list = topicService.selectTopicList(topic);
        ExcelUtil<Topic> util = new ExcelUtil<Topic>(Topic.class);
        util.exportExcel(response, list, "帖子数据");
    }

    /**
     * 获取帖子详细信息
     */
    @PreAuthorize("@ss.hasPermi('oj:forum:query')")
    @GetMapping(value = "/{id}")
    @ApiOperation("获取帖子详情")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(topicService.selectTopicById(id));
    }

    /**
     * 新增帖子
     */
    @PreAuthorize("@ss.hasPermi('oj:forum:add')")
    @Log(title = "帖子", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增帖子")
    public AjaxResult add(@RequestBody Topic topic) {
        return toAjax(topicService.insertTopic(topic));
    }

    /**
     * 修改帖子
     */
    @PreAuthorize("@ss.hasPermi('oj:forum:edit')")
    @Log(title = "帖子", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改帖子")
    public AjaxResult edit(@RequestBody Topic topic) {
        return toAjax(topicService.updateTopic(topic));
    }

    /**
     * 删除帖子
     */
    @PreAuthorize("@ss.hasPermi('oj:forum:remove')")
    @Log(title = "帖子", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    @ApiOperation("删除帖子")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(topicService.deleteTopicByIds(ids));
    }


    /**
     * 获取帖子详情 用于展示
     *
     * @param id
     * @return
     */
    @GetMapping("/detail/get")
    @ApiOperation("获取帖子详情 用于展示")
    public AjaxResult getTopicById(@RequestParam("id") Long id) {
        Topic topic = topicService.getById(id);
        ThrowUtils.throwIf(topic == null, "该帖子不存在！");
        TopicVO topicVO = CollectionUtil.getFirst(topicAdapter.buildTopicVOsByTopics(Arrays.asList(topic)));
//        List<TopicCommentVO> commentVOS = topicAppService.getCommentsByTopicId(id);
        TopicDetailVO build = TopicDetailVO.builder()
                .topicVO(topicVO)
//                .commentVOS(commentVOS)
                .build();
        return success(build);
    }
}
