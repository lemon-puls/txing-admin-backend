package com.txing.project.oj.adapter;

import cn.hutool.json.JSONUtil;
import com.txing.project.oj.domain.Topic;
import com.txing.project.oj.domain.User;
import com.txing.project.oj.service.IUserService;
import com.txing.project.oj.vo.forum.TopicVO;
import com.txing.project.oj.vo.user.UserShowVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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