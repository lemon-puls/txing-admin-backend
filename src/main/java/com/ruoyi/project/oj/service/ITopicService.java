package com.ruoyi.project.oj.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.oj.domain.Topic;

/**
 * 帖子Service接口
 * 
 * @author lizhiwei
 * @date 2024-04-06
 */
public interface ITopicService extends IService<Topic>
{
    /**
     * 查询帖子
     * 
     * @param id 帖子主键
     * @return 帖子
     */
    public Topic selectTopicById(Long id);

    /**
     * 查询帖子列表
     * 
     * @param topic 帖子
     * @return 帖子集合
     */
    public List<Topic> selectTopicList(Topic topic);

    /**
     * 新增帖子
     * 
     * @param topic 帖子
     * @return 结果
     */
    public int insertTopic(Topic topic);

    /**
     * 修改帖子
     * 
     * @param topic 帖子
     * @return 结果
     */
    public int updateTopic(Topic topic);

    /**
     * 批量删除帖子
     * 
     * @param ids 需要删除的帖子主键集合
     * @return 结果
     */
    public int deleteTopicByIds(Long[] ids);

    /**
     * 删除帖子信息
     * 
     * @param id 帖子主键
     * @return 结果
     */
    public int deleteTopicById(Long id);
}
