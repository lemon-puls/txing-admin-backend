package com.ruoyi.project.oj.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.oj.domain.MatchOnlinepk;

/**
 * 在线PKService接口
 * 
 * @author lizhiwei
 * @date 2024-04-08
 */
public interface IMatchOnlinepkService extends IService<MatchOnlinepk>
{
    /**
     * 查询在线PK
     * 
     * @param id 在线PK主键
     * @return 在线PK
     */
    public MatchOnlinepk selectMatchOnlinepkById(Long id);

    /**
     * 查询在线PK列表
     * 
     * @param matchOnlinepk 在线PK
     * @return 在线PK集合
     */
    public List<MatchOnlinepk> selectMatchOnlinepkList(MatchOnlinepk matchOnlinepk);

    /**
     * 新增在线PK
     * 
     * @param matchOnlinepk 在线PK
     * @return 结果
     */
    public int insertMatchOnlinepk(MatchOnlinepk matchOnlinepk);

    /**
     * 修改在线PK
     * 
     * @param matchOnlinepk 在线PK
     * @return 结果
     */
    public int updateMatchOnlinepk(MatchOnlinepk matchOnlinepk);

    /**
     * 批量删除在线PK
     * 
     * @param ids 需要删除的在线PK主键集合
     * @return 结果
     */
    public int deleteMatchOnlinepkByIds(Long[] ids);

    /**
     * 删除在线PK信息
     * 
     * @param id 在线PK主键
     * @return 结果
     */
    public int deleteMatchOnlinepkById(Long id);
}
