package com.ruoyi.project.oj.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.project.oj.domain.Topic;
import org.apache.ibatis.annotations.Mapper;

/**
 * 帖子Mapper接口
 *
 * @author lizhiwei
 * @date 2024-04-06
 */
@Mapper
public interface TopicMapper extends BaseMapper<Topic> {
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
     * 删除帖子
     *
     * @param id 帖子主键
     * @return 结果
     */
    public int deleteTopicById(Long id);

    /**
     * 批量删除帖子
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTopicByIds(Long[] ids);
}
