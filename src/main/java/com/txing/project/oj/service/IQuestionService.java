package com.txing.project.oj.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.txing.project.oj.domain.Question;
import com.txing.project.oj.vo.question.QuestionSimpleVO;

/**
 * 题目中心Service接口
 *
 * @author lizhiwei
 * @date 2024-04-02
 */
public interface IQuestionService extends IService<Question> {
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
     * 批量删除题目中心
     *
     * @param ids 需要删除的题目中心主键集合
     * @return 结果
     */
    public int deleteQuestionByIds(Long[] ids);

    /**
     * 删除题目中心信息
     *
     * @param id 题目中心主键
     * @return 结果
     */
    public int deleteQuestionById(Long id);

    QuestionSimpleVO getQuestionSimpleVOById(Long questionId);

    List<Question> getQuestionsByRandom(Integer count);
}
