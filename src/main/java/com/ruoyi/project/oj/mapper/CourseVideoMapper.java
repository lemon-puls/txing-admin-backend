package com.ruoyi.project.oj.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.project.oj.domain.CourseVideo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程视频Mapper接口
 *
 * @author lizhiwei
 * @date 2024-04-06
 */
@Mapper
public interface CourseVideoMapper extends BaseMapper<CourseVideo> {
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
     * 删除课程视频
     *
     * @param id 课程视频主键
     * @return 结果
     */
    public int deleteCourseVideoById(Long id);

    /**
     * 批量删除课程视频
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCourseVideoByIds(Long[] ids);
}
