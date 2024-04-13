package com.txing.project.oj.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.txing.project.oj.domain.Question;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目中心Mapper接口
 *
 * @author lizhiwei
 * @date 2024-04-02
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {
    /**
     * 查询题目中心
     *
     * @param id 题目中心主键
     * @return 题目中心
     */
    public Question selectQuestionById(Long id);

    /**
     * 查询题目中心列表
     *
     * @param question 题目中心
     * @return 题目中心集合
     */
    public List<Question> selectQuestionList(Question question);

    /**
     * 新增题目中心
     *
     * @param question 题目中心
     * @return 结果
     */
    public int insertQuestion(Question question);

    /**
     * 修改题目中心
     *
     * @param question 题目中心
     * @return 结果
     */
    public int updateQuestion(Question question);

    /**
     * 删除题目中心
     *
     * @param id 题目中心主键
     * @return 结果
     */
    public int deleteQuestionById(Long id);

    /**
     * 批量删除题目中心
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQuestionByIds(Long[] ids);
}
