package com.txing.project.oj.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.txing.project.oj.domain.Course;
import com.txing.project.oj.vo.course.CourseSearchItemVO;
import com.txing.project.oj.vo.course.CourseVideoPlayVO;

/**
 * 课程Service接口
 * 
 * @author lizhiwei
 * @date 2024-04-06
 */
public interface ICourseService extends IService<Course>
{
    /**
     * 查询课程
     * 
     * @param id 课程主键
     * @return 课程
     */
    public Course selectCourseById(Long id);

    /**
     * 查询课程列表
     * 
     * @param course 课程
     * @return 课程集合
     */
    public List<Course> selectCourseList(Course course);

    /**
     * 新增课程
     * 
     * @param course 课程
     * @return 结果
     */
    public int insertCourse(Course course);

    /**
     * 修改课程
     * 
     * @param course 课程
     * @return 结果
     */
    public int updateCourse(Course course);

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的课程主键集合
     * @return 结果
     */
    public int deleteCourseByIds(Long[] ids);

    /**
     * 删除课程信息
     * 
     * @param id 课程主键
     * @return 结果
     */
    public int deleteCourseById(Long id);

    CourseVideoPlayVO getVideoPlayVO(Long courseId);

    List<CourseSearchItemVO> getCourseSearchItemVOsByCourse(List<?> list);
}
