package com.txing.project.oj.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.txing.project.oj.service.IUserService;
import com.txing.project.oj.vo.course.CourseVideoPlayVO;
import com.txing.project.oj.vo.user.UserShowVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.txing.framework.aspectj.lang.annotation.Log;
import com.txing.framework.aspectj.lang.enums.BusinessType;
import com.txing.project.oj.domain.Course;
import com.txing.project.oj.service.ICourseService;
import com.txing.framework.web.controller.BaseController;
import com.txing.framework.web.domain.AjaxResult;
import com.txing.common.utils.poi.ExcelUtil;
import com.txing.framework.web.page.TableDataInfo;

/**
 * 课程Controller
 *
 * @author lizhiwei
 * @date 2024-04-06
 */
@RestController
@RequestMapping("/oj/course")
public class CourseController extends BaseController {
    @Autowired
    private ICourseService courseService;
    @Autowired
    IUserService userService;

    /**
     * 查询课程列表
     */
    @PreAuthorize("@ss.hasPermi('oj:course:list')")
    @GetMapping("/list")
    @ApiOperation("获取课程列表")
    public TableDataInfo list(Course course) {
        startPage();
        List<Course> list = courseService.selectCourseList(course);
        for (Course course1 : list) {
            UserShowVO user = userService.getUserShowVOById(course1.getUserId());
            course1.setUser(user);
        }
        return getDataTable(list);
    }

    /**
     * 导出课程列表
     */
//    @PreAuthorize("@ss.hasPermi('oj:course:export')")
    @Log(title = "课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出课程列表")
    public void export(HttpServletResponse response, Course course) {
        List<Course> list = courseService.selectCourseList(course);
        ExcelUtil<Course> util = new ExcelUtil<Course>(Course.class);
        util.exportExcel(response, list, "课程数据");
    }

    /**
     * 获取课程详细信息
     */
//    @PreAuthorize("@ss.hasPermi('oj:course:query')")
    @GetMapping(value = "/{id}")
    @ApiOperation("获取课程信息byId")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(courseService.selectCourseById(id));
    }

    /**
     * 新增课程
     */
    @PreAuthorize("@ss.hasPermi('oj:course:add')")
    @Log(title = "课程", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增课程")
    public AjaxResult add(@RequestBody Course course) {
        return toAjax(courseService.insertCourse(course));
    }

    /**
     * 修改课程
     */
//    @PreAuthorize("@ss.hasPermi('oj:course:edit')")
    @Log(title = "课程", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改课程")
    public AjaxResult edit(@RequestBody Course course) {
        return toAjax(courseService.updateCourse(course));
    }

    /**
     * 删除课程
     */
//    @PreAuthorize("@ss.hasPermi('oj:course:remove')")
    @Log(title = "课程", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    @ApiOperation("删除课程")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(courseService.removeByIds(Arrays.asList(ids)));
    }


    /**
     * 获取课程播放所需信息
     */
    @GetMapping("/video/play/info/get")
//    @PreAuthorize("@ss.hasPermi('oj:course:play')")
    @ApiOperation("获取课程播放所需信息")
    public AjaxResult getVideoPlayVO(@RequestParam("courseId") Long courseId) {
        CourseVideoPlayVO playVO = courseService.getVideoPlayVO(courseId);
        return success(playVO);
    }

    /**
     * 获取视频播放签名
     */
//    @PreAuthorize("@ss.hasPermi('oj:course:sign')")
    @GetMapping("/play/sign/get")
    @ApiOperation("获取视频播放签名")
    public AjaxResult getPlaySign(@RequestParam("fileId") String fileId) {
        Integer AppId = 1311424669; // 用户 appid
        String FileId = fileId; // 目标 FileId
        String AudioVideoType = "Original"; // 播放的音视频类型
        Integer RawAdaptiveDefinition = 10; // 允许输出的未加密的自适应码流模板 ID
        Integer ImageSpriteDefinition = 10; // 做进度条预览的雪碧图模板 ID
        Integer CurrentTime = 1589448067;
//        Long PsignExpire = CurrentTime + 1000 * 60 * 60 * 2; // 可任意设置过期时间
//        String UrlTimeExpire = "5ebe9423‬"; // 可任意设置过期时间
        String PlayKey = "CcqpJzaiTIuCoFBZtH4c";
        HashMap<String, Object> urlAccessInfo = new HashMap<String, Object>();
//        urlAccessInfo.put("t", UrlTimeExpire);
        HashMap<String, Object> contentInfo = new HashMap<String, Object>();
        contentInfo.put("audioVideoType", AudioVideoType);
//        contentInfo.put("rawAdaptiveDefinition", RawAdaptiveDefinition);
//        contentInfo.put("imageSpriteDefinition", ImageSpriteDefinition);


        try {
            Algorithm algorithm = Algorithm.HMAC256(PlayKey);
            String token = JWT.create().withClaim("appId", AppId).withClaim("fileId", FileId)
                    .withClaim("contentInfo", contentInfo)
                    .withClaim("currentTimeStamp", CurrentTime)
                    .withClaim("urlAccessInfo", urlAccessInfo).sign(algorithm);
            System.out.println("token:" + token);
            return success((Object) token);
        } catch (JWTCreationException exception) {
            // Invalid Signing configuration / Couldn't convert Claims.
        }
        return error();
    }

}
