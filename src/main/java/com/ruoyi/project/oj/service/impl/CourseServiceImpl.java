package com.ruoyi.project.oj.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ThrowUtils;
import com.ruoyi.project.oj.adapter.CourseAdapter;
import com.ruoyi.project.oj.domain.CourseVideo;
import com.ruoyi.project.oj.domain.User;
import com.ruoyi.project.oj.service.ICourseVideoService;
import com.ruoyi.project.oj.service.IUserService;
import com.ruoyi.project.oj.vo.course.CourseSearchItemVO;
import com.ruoyi.project.oj.vo.course.CourseVideoPlayVO;
import com.ruoyi.project.oj.vo.course.CourseVideoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.oj.mapper.CourseMapper;
import com.ruoyi.project.oj.domain.Course;
import com.ruoyi.project.oj.service.ICourseService;

/**
 * 课程Service业务层处理
 *
 * @author lizhiwei
 * @date 2024-04-06
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    IUserService userService;
    @Autowired
    ICourseVideoService courseVideoService;

    /**
     * 查询课程
     *
     * @param id 课程主键
     * @return 课程
     */
    @Override
    public Course selectCourseById(Long id) {
        return courseMapper.selectCourseById(id);
    }

    /**
     * 查询课程列表
     *
     * @param course 课程
     * @return 课程
     */
    @Override
    public List<Course> selectCourseList(Course course) {
        return courseMapper.selectCourseList(course);
    }

    /**
     * 新增课程
     *
     * @param course 课程
     * @return 结果
     */
    @Override
    public int insertCourse(Course course) {
        course.setCreateTime(DateUtils.getNowDate());
        return courseMapper.insertCourse(course);
    }

    /**
     * 修改课程
     *
     * @param course 课程
     * @return 结果
     */
    @Override
    public int updateCourse(Course course) {
        course.setUpdateTime(DateUtils.getNowDate());
        return courseMapper.updateCourse(course);
    }

    /**
     * 批量删除课程
     *
     * @param ids 需要删除的课程主键
     * @return 结果
     */
    @Override
    public int deleteCourseByIds(Long[] ids) {
        return courseMapper.deleteCourseByIds(ids);
    }

    /**
     * 删除课程信息
     *
     * @param id 课程主键
     * @return 结果
     */
    @Override
    public int deleteCourseById(Long id) {
        return courseMapper.deleteCourseById(id);
    }

    @Override
    public CourseVideoPlayVO getVideoPlayVO(Long courseId) {
        Course course = this.getById(courseId);
        ThrowUtils.throwIf(course == null, "课程不存在");
        List<CourseSearchItemVO> items = this.getCourseSearchItemVOsByCourse(Arrays.asList(course));
        CourseSearchItemVO searchItemVO = CollectionUtil.getFirst(items);
        CourseVideoPlayVO playVO = new CourseVideoPlayVO();
        BeanUtils.copyProperties(searchItemVO, playVO);
        // 获取各小节信息
        List<CourseVideo> courseVideos = courseVideoService.listByCourseId(courseId);
        if (!courseVideos.isEmpty()) {
            List<CourseVideoVO> videoVOS = CourseAdapter.buildCourseVideoVOsByVideo(courseVideos);
            playVO.setVideoVOS(videoVOS);
        }
        return playVO;
    }

    @Override
    public List<CourseSearchItemVO> getCourseSearchItemVOsByCourse(List<?> list) {
        List<CourseSearchItemVO> collect = list.stream().map(item -> {
            Course course = (Course) item;
            User user = userService.selectUserById(course.getUserId());
            CourseSearchItemVO courseSearchItemVO = CourseAdapter.buildCourseSearchItemVOByCourse(course, user, null);
            return courseSearchItemVO;
        }).collect(Collectors.toList());
        return collect;
    }
}
