package com.txing.project.oj.adapter;

import com.txing.project.oj.domain.Course;
import com.txing.project.oj.domain.CourseVideo;
import com.txing.project.oj.domain.User;
import com.txing.project.oj.vo.course.CourseSearchItemVO;
import com.txing.project.oj.vo.course.CourseVideoVO;
import com.txing.project.oj.vo.user.UserShowVO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhiwei
 * @date 2024/4/6 13:34
 * 注释：
 */
public class CourseAdapter {

    public static CourseSearchItemVO buildCourseSearchItemVOByCourse(Course course, User user, Boolean isFavour) {
        CourseSearchItemVO searchItemVO = new CourseSearchItemVO();
        BeanUtils.copyProperties(course, searchItemVO);
        UserShowVO userShowVO = new UserShowVO();
        BeanUtils.copyProperties(user, userShowVO);
        searchItemVO.setUserShowVO(userShowVO);
        searchItemVO.setFavour(isFavour);
        return searchItemVO;
    }

    public static List<CourseVideoVO> buildCourseVideoVOsByVideo(List<CourseVideo> list) {
        return list.stream().map(video -> {
            CourseVideoVO videoVO = new CourseVideoVO();
            BeanUtils.copyProperties(video, videoVO);
            return videoVO;
        }).collect(Collectors.toList());
    }


}
