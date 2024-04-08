package com.ruoyi.project.oj.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.oj.mapper.MatchWeekMapper;
import com.ruoyi.project.oj.domain.MatchWeek;
import com.ruoyi.project.oj.service.IMatchWeekService;

/**
 * 周赛Service业务层处理
 * 
 * @author lizhiwei
 * @date 2024-04-07
 */
@Service
public class MatchWeekServiceImpl extends ServiceImpl<MatchWeekMapper, MatchWeek> implements IMatchWeekService
{
    @Autowired
    private MatchWeekMapper matchWeekMapper;

    /**
     * 查询周赛
     * 
     * @param id 周赛主键
     * @return 周赛
     */
    @Override
    public MatchWeek selectMatchWeekById(Long id)
    {
        return matchWeekMapper.selectMatchWeekById(id);
    }

    /**
     * 查询周赛列表
     * 
     * @param matchWeek 周赛
     * @return 周赛
     */
    @Override
    public List<MatchWeek> selectMatchWeekList(MatchWeek matchWeek)
    {
        return matchWeekMapper.selectMatchWeekList(matchWeek);
    }

    /**
     * 新增周赛
     * 
     * @param matchWeek 周赛
     * @return 结果
     */
    @Override
    public int insertMatchWeek(MatchWeek matchWeek)
    {
        matchWeek.setCreateTime(DateUtils.getNowDate());
        return matchWeekMapper.insertMatchWeek(matchWeek);
    }

    /**
     * 修改周赛
     * 
     * @param matchWeek 周赛
     * @return 结果
     */
    @Override
    public int updateMatchWeek(MatchWeek matchWeek)
    {
        matchWeek.setUpdateTime(DateUtils.getNowDate());
        return matchWeekMapper.updateMatchWeek(matchWeek);
    }

    /**
     * 批量删除周赛
     * 
     * @param ids 需要删除的周赛主键
     * @return 结果
     */
    @Override
    public int deleteMatchWeekByIds(Long[] ids)
    {
        return matchWeekMapper.deleteMatchWeekByIds(ids);
    }

    /**
     * 删除周赛信息
     * 
     * @param id 周赛主键
     * @return 结果
     */
    @Override
    public int deleteMatchWeekById(Long id)
    {
        return matchWeekMapper.deleteMatchWeekById(id);
    }
}
