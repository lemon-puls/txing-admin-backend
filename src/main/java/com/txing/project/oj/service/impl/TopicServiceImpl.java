package com.txing.project.oj.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.txing.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.txing.project.oj.mapper.TopicMapper;
import com.txing.project.oj.domain.Topic;
import com.txing.project.oj.service.ITopicService;

/**
 * 帖子Service业务层处理
 * 
 * @author lizhiwei
 * @date 2024-04-06
 */
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements ITopicService
{
    @Autowired
    private TopicMapper topicMapper;

    /**
     * 查询帖子
     * 
     * @param id 帖子主键
     * @return 帖子
     */
    @Override
    public Topic selectTopicById(Long id)
    {
        return topicMapper.selectTopicById(id);
    }

    /**
     * 查询帖子列表
     * 
     * @param topic 帖子
     * @return 帖子
     */
    @Override
    public List<Topic> selectTopicList(Topic topic)
    {
        return topicMapper.selectTopicList(topic);
    }

    /**
     * 新增帖子
     * 
     * @param topic 帖子
     * @return 结果
     */
    @Override
    public int insertTopic(Topic topic)
    {
        topic.setCreateTime(DateUtils.getNowDate());
        return topicMapper.insertTopic(topic);
    }

    /**
     * 修改帖子
     * 
     * @param topic 帖子
     * @return 结果
     */
    @Override
    public int updateTopic(Topic topic)
    {
        topic.setUpdateTime(DateUtils.getNowDate());
        return topicMapper.updateTopic(topic);
    }

    /**
     * 批量删除帖子
     * 
     * @param ids 需要删除的帖子主键
     * @return 结果
     */
    @Override
    public int deleteTopicByIds(Long[] ids)
    {
        return topicMapper.deleteTopicByIds(ids);
    }

    /**
     * 删除帖子信息
     * 
     * @param id 帖子主键
     * @return 结果
     */
    @Override
    public int deleteTopicById(Long id)
    {
        return topicMapper.deleteTopicById(id);
    }
}
