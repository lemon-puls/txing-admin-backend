package com.txing.project.oj.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.txing.project.oj.domain.MatchWeek;
import org.apache.ibatis.annotations.Mapper;

/**
 * 周赛Mapper接口
 * 
 * @author lizhiwei
 * @date 2024-04-07
 */
@Mapper
public interface MatchWeekMapper extends BaseMapper<MatchWeek>
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
     * 删除周赛
     * 
     * @param id 周赛主键
     * @return 结果
     */
    public int deleteMatchWeekById(Long id);

    /**
     * 批量删除周赛
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMatchWeekByIds(Long[] ids);
}
