package com.txing.project.oj.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.txing.project.oj.domain.MatchWeek;

/**
 * 周赛Service接口
 * 
 * @author lizhiwei
 * @date 2024-04-07
 */
public interface IMatchWeekService extends IService<MatchWeek>
{
    /**
     * 查询周赛
     * 
     * @param id 周赛主键
     * @return 周赛
     */
    public MatchWeek selectMatchWeekById(Long id);

    /**
     * 查询周赛列表
     * 
     * @param matchWeek 周赛
     * @return 周赛集合
     */
    public List<MatchWeek> selectMatchWeekList(MatchWeek matchWeek);

    /**
     * 新增周赛
     * 
     * @param matchWeek 周赛
     * @return 结果
     */
    public int insertMatchWeek(MatchWeek matchWeek);

    /**
     * 修改周赛
     * 
     * @param matchWeek 周赛
     * @return 结果
     */
    public int updateMatchWeek(MatchWeek matchWeek);

    /**
     * 批量删除周赛
     * 
     * @param ids 需要删除的周赛主键集合
     * @return 结果
     */
    public int deleteMatchWeekByIds(Long[] ids);

    /**
     * 删除周赛信息
     * 
     * @param id 周赛主键
     * @return 结果
     */
    public int deleteMatchWeekById(Long id);

    boolean createWeekMatch();

    MatchWeek getLastSessionMatch();
}
