package com.txing.project.oj.controller;

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
import com.txing.framework.aspectj.lang.annotation.Log;
import com.txing.framework.aspectj.lang.enums.BusinessType;
import com.txing.project.oj.domain.CourseVideo;
import com.txing.project.oj.service.ICourseVideoService;
import com.txing.framework.web.controller.BaseController;
import com.txing.framework.web.domain.AjaxResult;
import com.txing.common.utils.poi.ExcelUtil;
import com.txing.framework.web.page.TableDataInfo;

/**
 * 课程视频Controller
 * 
 * @author lizhiwei
 * @date 2024-04-06
 */
@RestController
@RequestMapping("/oj/CourseVideo")
public class CourseVideoController extends BaseController
{
    @Autowired
    private ICourseVideoService courseVideoService;

    /**
     * 查询课程视频列表
     */
    @PreAuthorize("@ss.hasPermi('oj:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(CourseVideo courseVideo)
    {
        startPage();
        List<CourseVideo> list = courseVideoService.selectCourseVideoList(courseVideo);
        return getDataTable(list);
    }

    /**
     * 导出课程视频列表
     */
//    @PreAuthorize("@ss.hasPermi('oj:course:export')")
    @Log(title = "课程视频", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CourseVideo courseVideo)
    {
        List<CourseVideo> list = courseVideoService.selectCourseVideoList(courseVideo);
        ExcelUtil<CourseVideo> util = new ExcelUtil<CourseVideo>(CourseVideo.class);
        util.exportExcel(response, list, "课程视频数据");
    }

    /**
     * 获取课程视频详细信息
     */
//    @PreAuthorize("@ss.hasPermi('oj:course:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(courseVideoService.selectCourseVideoById(id));
    }

    /**
     * 新增课程视频
     */
//    @PreAuthorize("@ss.hasPermi('oj:course:add')")
    @Log(title = "课程视频", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CourseVideo courseVideo)
    {
        return toAjax(courseVideoService.insertCourseVideo(courseVideo));
    }

    /**
     * 修改课程视频
     */
//    @PreAuthorize("@ss.hasPermi('oj:course:edit')")
    @Log(title = "课程视频", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CourseVideo courseVideo)
    {
        return toAjax(courseVideoService.updateCourseVideo(courseVideo));
    }

    /**
     * 删除课程视频
     */
//    @PreAuthorize("@ss.hasPermi('oj:course:remove')")
    @Log(title = "课程视频", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(courseVideoService.deleteCourseVideoByIds(ids));
    }
}
