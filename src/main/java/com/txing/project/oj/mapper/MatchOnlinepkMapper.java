package com.txing.project.oj.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.txing.project.oj.domain.MatchOnlinepk;
import org.apache.ibatis.annotations.Mapper;

/**
 * 在线PKMapper接口
 *
 * @author lizhiwei
 * @date 2024-04-08
 */
@Mapper
public interface MatchOnlinepkMapper extends BaseMapper<MatchOnlinepk> {
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
     * 删除在线PK
     *
     * @param id 在线PK主键
     * @return 结果
     */
    public int deleteMatchOnlinepkById(Long id);

    /**
     * 批量删除在线PK
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMatchOnlinepkByIds(Long[] ids);
}
