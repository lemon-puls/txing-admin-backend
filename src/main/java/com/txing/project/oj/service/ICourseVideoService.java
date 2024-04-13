package com.txing.project.oj.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.txing.project.oj.domain.CourseVideo;

/**
 * 课程视频Service接口
 * 
 * @author lizhiwei
 * @date 2024-04-06
 */
public interface ICourseVideoService extends IService<CourseVideo>
{
    /**
     * 查询课程视频
     * 
     * @param id 课程视频主键
     * @return 课程视频
     */
    public CourseVideo selectCourseVideoById(Long id);

    /**
     * 查询课程视频列表
     * 
     * @param courseVideo 课程视频
     * @return 课程视频集合
     */
    public List<CourseVideo> selectCourseVideoList(CourseVideo courseVideo);

    /**
     * 新增课程视频
     * 
     * @param courseVideo 课程视频
     * @return 结果
     */
    public int insertCourseVideo(CourseVideo courseVideo);

    /**
     * 修改课程视频
     * 
     * @param courseVideo 课程视频
     * @return 结果
     */
    public int updateCourseVideo(CourseVideo courseVideo);

    /**
     * 批量删除课程视频
     * 
     * @param ids 需要删除的课程视频主键集合
     * @return 结果
     */
    public int deleteCourseVideoByIds(Long[] ids);

    /**
     * 删除课程视频信息
     * 
     * @param id 课程视频主键
     * @return 结果
     */
    public int deleteCourseVideoById(Long id);

    List<CourseVideo> listByCourseId(Long courseId);
}
