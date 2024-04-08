package com.ruoyi.project.oj.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.oj.domain.Question;
import com.ruoyi.project.oj.service.IQuestionService;
import com.ruoyi.project.oj.vo.question.QuestionSimpleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.oj.mapper.MatchWeekQuestionRelateMapper;
import com.ruoyi.project.oj.domain.MatchWeekQuestionRelate;
import com.ruoyi.project.oj.service.IMatchWeekQuestionRelateService;

/**
 * 周赛题目关联Service业务层处理
 *
 * @author lizhiwei
 * @date 2024-04-07
 */
@Service
public class MatchWeekQuestionRelateServiceImpl
        extends ServiceImpl<MatchWeekQuestionRelateMapper, MatchWeekQuestionRelate> implements IMatchWeekQuestionRelateService {
    @Autowired
    private MatchWeekQuestionRelateMapper matchWeekQuestionRelateMapper;
    @Autowired
    IQuestionService questionService;

    /**
     * 查询周赛题目关联
     *
     * @param id 周赛题目关联主键
     * @return 周赛题目关联
     */
    @Override
    public MatchWeekQuestionRelate selectMatchWeekQuestionRelateById(Long id) {
        return matchWeekQuestionRelateMapper.selectMatchWeekQuestionRelateById(id);
    }

    /**
     * 查询周赛题目关联列表
     *
     * @param matchWeekQuestionRelate 周赛题目关联
     * @return 周赛题目关联
     */
    @Override
    public List<MatchWeekQuestionRelate> selectMatchWeekQuestionRelateList(MatchWeekQuestionRelate matchWeekQuestionRelate) {
        return matchWeekQuestionRelateMapper.selectMatchWeekQuestionRelateList(matchWeekQuestionRelate);
    }

    /**
     * 新增周赛题目关联
     *
     * @param matchWeekQuestionRelate 周赛题目关联
     * @return 结果
     */
    @Override
    public int insertMatchWeekQuestionRelate(MatchWeekQuestionRelate matchWeekQuestionRelate) {
        matchWeekQuestionRelate.setCreateTime(DateUtils.getNowDate());
        return matchWeekQuestionRelateMapper.insertMatchWeekQuestionRelate(matchWeekQuestionRelate);
    }

    /**
     * 修改周赛题目关联
     *
     * @param matchWeekQuestionRelate 周赛题目关联
     * @return 结果
     */
    @Override
    public int updateMatchWeekQuestionRelate(MatchWeekQuestionRelate matchWeekQuestionRelate) {
        matchWeekQuestionRelate.setUpdateTime(DateUtils.getNowDate());
        return matchWeekQuestionRelateMapper.updateMatchWeekQuestionRelate(matchWeekQuestionRelate);
    }

    /**
     * 批量删除周赛题目关联
     *
     * @param ids 需要删除的周赛题目关联主键
     * @return 结果
     */
    @Override
    public int deleteMatchWeekQuestionRelateByIds(Long[] ids) {
        return matchWeekQuestionRelateMapper.deleteMatchWeekQuestionRelateByIds(ids);
    }

    /**
     * 删除周赛题目关联信息
     *
     * @param id 周赛题目关联主键
     * @return 结果
     */
    @Override
    public int deleteMatchWeekQuestionRelateById(Long id) {
        return matchWeekQuestionRelateMapper.deleteMatchWeekQuestionRelateById(id);
    }

    @Override
    public List<QuestionSimpleVO> getQuestionSimpleVO(long matchId) {
        QueryWrapper<MatchWeekQuestionRelate> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(MatchWeekQuestionRelate::getMatchId, matchId)
                .orderByAsc(MatchWeekQuestionRelate::getQuestionOrder);
        List<MatchWeekQuestionRelate> list = this.list(wrapper);
        List<QuestionSimpleVO> collect = list.stream().map(item -> {
                    Question question = questionService.getById(item.getQuestionId());
                    QuestionSimpleVO simpleVO = new QuestionSimpleVO();
                    if(question != null) {
                        BeanUtils.copyProperties(question, simpleVO);
                    }
                    return simpleVO;
                }).collect(Collectors.toList());
        return collect;
    }
}
