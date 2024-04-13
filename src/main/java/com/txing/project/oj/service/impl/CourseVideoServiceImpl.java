package com.txing.project.oj.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.txing.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.txing.project.oj.mapper.CourseVideoMapper;
import com.txing.project.oj.domain.CourseVideo;
import com.txing.project.oj.service.ICourseVideoService;

/**
 * 课程视频Service业务层处理
 * 
 * @author lizhiwei
 * @date 2024-04-06
 */
@Service
public class CourseVideoServiceImpl extends ServiceImpl<CourseVideoMapper, CourseVideo> implements ICourseVideoService
{
    @Autowired
    private CourseVideoMapper courseVideoMapper;

    /**
     * 查询课程视频
     * 
     * @param id 课程视频主键
     * @return 课程视频
     */
    @Override
    public CourseVideo selectCourseVideoById(Long id)
    {
        return courseVideoMapper.selectCourseVideoById(id);
    }

    /**
     * 查询课程视频列表
     * 
     * @param courseVideo 课程视频
     * @return 课程视频
     */
    @Override
    public List<CourseVideo> selectCourseVideoList(CourseVideo courseVideo)
    {
        return courseVideoMapper.selectCourseVideoList(courseVideo);
    }

    /**
     * 新增课程视频
     * 
     * @param courseVideo 课程视频
     * @return 结果
     */
    @Override
    public int insertCourseVideo(CourseVideo courseVideo)
    {
        courseVideo.setCreateTime(DateUtils.getNowDate());
        return courseVideoMapper.insertCourseVideo(courseVideo);
    }

    /**
     * 修改课程视频
     * 
     * @param courseVideo 课程视频
     * @return 结果
     */
    @Override
    public int updateCourseVideo(CourseVideo courseVideo)
    {
        courseVideo.setUpdateTime(DateUtils.getNowDate());
        return courseVideoMapper.updateCourseVideo(courseVideo);
    }

    /**
     * 批量删除课程视频
     * 
     * @param ids 需要删除的课程视频主键
     * @return 结果
     */
    @Override
    public int deleteCourseVideoByIds(Long[] ids)
    {
        return courseVideoMapper.deleteCourseVideoByIds(ids);
    }

    /**
     * 删除课程视频信息
     * 
     * @param id 课程视频主键
     * @return 结果
     */
    @Override
    public int deleteCourseVideoById(Long id)
    {
        return courseVideoMapper.deleteCourseVideoById(id);
    }

    @Override
    public List<CourseVideo> listByCourseId(Long courseId) {
        QueryWrapper<CourseVideo> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(CourseVideo::getCourseId, courseId)
                .orderByAsc(CourseVideo::getOrderNo);
        return this.list(wrapper);
    }

}
