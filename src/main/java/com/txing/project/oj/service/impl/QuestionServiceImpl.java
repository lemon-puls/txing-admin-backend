package com.txing.project.oj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.txing.common.utils.DateUtils;
import com.txing.project.oj.vo.question.QuestionSimpleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.txing.project.oj.mapper.QuestionMapper;
import com.txing.project.oj.domain.Question;
import com.txing.project.oj.service.IQuestionService;

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

    /**
     * 随机抽选任意道题目
     *
     * @return
     */
    @Override
    public List<Question> getQuestionsByRandom(Integer count) {
        // 抽选题目
        List<Question> questions = this.list(new QueryWrapper<Question>().lambda().select(Question::getId));
        List<Question> randomQuestions = selectRandomQuestions(questions, count);
        return randomQuestions;
    }

    /**
     * 抽选题目
     */
    public List<Question> selectRandomQuestions(List<Question> list, int count) {
        List<Question> selectedItems = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < count && !list.isEmpty(); i++) {
            int randomIndex = rand.nextInt(list.size());
            selectedItems.add(list.get(randomIndex));
            list.remove(randomIndex); // Ensure no duplicates
        }
        return selectedItems;
    }
}
