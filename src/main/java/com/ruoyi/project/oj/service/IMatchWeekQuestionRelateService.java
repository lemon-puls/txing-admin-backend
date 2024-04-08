package com.ruoyi.project.oj.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.oj.domain.MatchWeekQuestionRelate;
import com.ruoyi.project.oj.vo.question.QuestionSimpleVO;

/**
 * 周赛题目关联Service接口
 * 
 * @author lizhiwei
 * @date 2024-04-07
 */
public interface IMatchWeekQuestionRelateService extends IService<MatchWeekQuestionRelate>
{
    /**
     * 查询周赛题目关联
     * 
     * @param id 周赛题目关联主键
     * @return 周赛题目关联
     */
    public MatchWeekQuestionRelate selectMatchWeekQuestionRelateById(Long id);

    /**
     * 查询周赛题目关联列表
     * 
     * @param matchWeekQuestionRelate 周赛题目关联
     * @return 周赛题目关联集合
     */
    public List<MatchWeekQuestionRelate> selectMatchWeekQuestionRelateList(MatchWeekQuestionRelate matchWeekQuestionRelate);

    /**
     * 新增周赛题目关联
     * 
     * @param matchWeekQuestionRelate 周赛题目关联
     * @return 结果
     */
    public int insertMatchWeekQuestionRelate(MatchWeekQuestionRelate matchWeekQuestionRelate);

    /**
     * 修改周赛题目关联
     * 
     * @param matchWeekQuestionRelate 周赛题目关联
     * @return 结果
     */
    public int updateMatchWeekQuestionRelate(MatchWeekQuestionRelate matchWeekQuestionRelate);

    /**
     * 批量删除周赛题目关联
     * 
     * @param ids 需要删除的周赛题目关联主键集合
     * @return 结果
     */
    public int deleteMatchWeekQuestionRelateByIds(Long[] ids);

    /**
     * 删除周赛题目关联信息
     * 
     * @param id 周赛题目关联主键
     * @return 结果
     */
    public int deleteMatchWeekQuestionRelateById(Long id);

    List<QuestionSimpleVO> getQuestionSimpleVO(long matchId);
}
