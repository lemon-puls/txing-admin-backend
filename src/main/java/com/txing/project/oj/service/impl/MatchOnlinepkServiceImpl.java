package com.txing.project.oj.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.txing.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.txing.project.oj.mapper.MatchOnlinepkMapper;
import com.txing.project.oj.domain.MatchOnlinepk;
import com.txing.project.oj.service.IMatchOnlinepkService;

/**
 * 在线PKService业务层处理
 * 
 * @author lizhiwei
 * @date 2024-04-08
 */
@Service
public class MatchOnlinepkServiceImpl extends ServiceImpl<MatchOnlinepkMapper, MatchOnlinepk> implements IMatchOnlinepkService
{
    @Autowired
    private MatchOnlinepkMapper matchOnlinepkMapper;

    /**
     * 查询在线PK
     * 
     * @param id 在线PK主键
     * @return 在线PK
     */
    @Override
    public MatchOnlinepk selectMatchOnlinepkById(Long id)
    {
        return matchOnlinepkMapper.selectMatchOnlinepkById(id);
    }

    /**
     * 查询在线PK列表
     * 
     * @param matchOnlinepk 在线PK
     * @return 在线PK
     */
    @Override
    public List<MatchOnlinepk> selectMatchOnlinepkList(MatchOnlinepk matchOnlinepk)
    {
        return matchOnlinepkMapper.selectMatchOnlinepkList(matchOnlinepk);
    }

    /**
     * 新增在线PK
     * 
     * @param matchOnlinepk 在线PK
     * @return 结果
     */
    @Override
    public int insertMatchOnlinepk(MatchOnlinepk matchOnlinepk)
    {
        matchOnlinepk.setCreateTime(DateUtils.getNowDate());
        return matchOnlinepkMapper.insertMatchOnlinepk(matchOnlinepk);
    }

    /**
     * 修改在线PK
     * 
     * @param matchOnlinepk 在线PK
     * @return 结果
     */
    @Override
    public int updateMatchOnlinepk(MatchOnlinepk matchOnlinepk)
    {
        matchOnlinepk.setUpdateTime(DateUtils.getNowDate());
        return matchOnlinepkMapper.updateMatchOnlinepk(matchOnlinepk);
    }

    /**
     * 批量删除在线PK
     * 
     * @param ids 需要删除的在线PK主键
     * @return 结果
     */
    @Override
    public int deleteMatchOnlinepkByIds(Long[] ids)
    {
        return matchOnlinepkMapper.deleteMatchOnlinepkByIds(ids);
    }

    /**
     * 删除在线PK信息
     * 
     * @param id 在线PK主键
     * @return 结果
     */
    @Override
    public int deleteMatchOnlinepkById(Long id)
    {
        return matchOnlinepkMapper.deleteMatchOnlinepkById(id);
    }
}
