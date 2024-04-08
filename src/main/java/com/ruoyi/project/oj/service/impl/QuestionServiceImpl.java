package com.ruoyi.project.oj.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.oj.vo.question.QuestionSimpleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.oj.mapper.QuestionMapper;
import com.ruoyi.project.oj.domain.Question;
import com.ruoyi.project.oj.service.IQuestionService;

/**
 * 题目中心Service业务层处理
 *
 * @author lizhiwei
 * @date 2024-04-02
 */
@Service("iQuestionService")
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 查询题目中心
     *
     * @param id 题目中心主键
     * @return 题目中心
     */
    @Override
    public Question selectQuestionById(Long id) {
        return questionMapper.selectQuestionById(id);
    }

    /**
     * 查询题目中心列表
     *
     * @param question 题目中心
     * @return 题目中心
     */
    @Override
    public List<Question> selectQuestionList(Question question) {
        return questionMapper.selectQuestionList(question);
    }

    /**
     * 新增题目中心
     *
     * @param question 题目中心
     * @return 结果
     */
    @Override
    public int insertQuestion(Question question) {
        question.setCreateTime(DateUtils.getNowDate());
        return questionMapper.insertQuestion(question);
    }

    /**
     * 修改题目中心
     *
     * @param question 题目中心
     * @return 结果
     */
    @Override
    public int updateQuestion(Question question) {
        question.setUpdateTime(DateUtils.getNowDate());
        return questionMapper.updateQuestion(question);
    }

    /**
     * 批量删除题目中心
     *
     * @param ids 需要删除的题目中心主键
     * @return 结果
     */
    @Override
    public int deleteQuestionByIds(Long[] ids) {
        return questionMapper.deleteQuestionByIds(ids);
    }

    /**
     * 删除题目中心信息
     *
     * @param id 题目中心主键
     * @return 结果
     */
    @Override
    public int deleteQuestionById(Long id) {
        return questionMapper.deleteQuestionById(id);
    }


    @Override
    public QuestionSimpleVO getQuestionSimpleVOById(Long questionId) {
        Question question = this.getById(questionId);
        QuestionSimpleVO simpleVO = new QuestionSimpleVO();
        if (question != null) {
            BeanUtils.copyProperties(question, simpleVO);
        }
        return simpleVO;
    }
}
