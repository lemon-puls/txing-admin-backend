package com.ruoyi.project.oj.adapter;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.project.oj.domain.Topic;
import com.ruoyi.project.oj.domain.User;
import com.ruoyi.project.oj.service.IUserService;
import com.ruoyi.project.oj.vo.forum.TopicVO;
import com.ruoyi.project.oj.vo.user.UserShowVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhiwei
 * @date 2024/4/6 21:54
 * 注释：
 */
@Component
public class TopicAdapter {

    @Autowired
    IUserService userService;


    public List<TopicVO> buildTopicVOsByTopics(List<?> list) {
        List<TopicVO> collect = list.stream().map((item) -> {
            Topic topic = (Topic) item;
            TopicVO topicVO = new TopicVO();
            BeanUtils.copyProperties(topic, topicVO);
            // 处理图片
            List<String> strings = JSONUtil.toList(topic.getImgs(), String.class);
            topicVO.setImgs(strings);
            User user = userService.getById(topic.getUserId());
            UserShowVO userShowVO = UserAdapter.buildUserShowVO(user);
            topicVO.setUserShowVO(userShowVO);
            return topicVO;
        }).collect(Collectors.toList());
        return collect;
    }
}