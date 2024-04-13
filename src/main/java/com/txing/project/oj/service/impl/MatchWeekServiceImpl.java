package com.txing.project.oj.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.txing.common.utils.DateUtils;
import com.txing.project.oj.service.IMatchWeekQuestionRelateService;
import com.txing.project.oj.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.txing.project.oj.mapper.MatchWeekMapper;
import com.txing.project.oj.domain.MatchWeek;
import com.txing.project.oj.service.IMatchWeekService;

/**
 * 周赛Service业务层处理
 *
 * @author lizhiwei
 * @date 2024-04-07
 */
@Service
public class MatchWeekServiceImpl extends ServiceImpl<MatchWeekMapper, MatchWeek> implements IMatchWeekService {
    @Autowired
    private MatchWeekMapper matchWeekMapper;
    @Autowired
    IQuestionService questionService;
    @Autowired
    IMatchWeekQuestionRelateService matchQuestionRelateService;

    /**
     * 查询周赛
     *
     * @param id 周赛主键
     * @return 周赛
     */
    @Override
    public MatchWeek selectMatchWeekById(Long id) {
        return matchWeekMapper.selectMatchWeekById(id);
    }

    /**
     * 查询周赛列表
     *
     * @param matchWeek 周赛
     * @return 周赛
     */
    @Override
    public List<MatchWeek> selectMatchWeekList(MatchWeek matchWeek) {
        return matchWeekMapper.selectMatchWeekList(matchWeek);
    }

    /**
     * 新增周赛
     *
     * @param matchWeek 周赛
     * @return 结果
     */
    @Override
    public int insertMatchWeek(MatchWeek matchWeek) {
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
    public int updateMatchWeek(MatchWeek matchWeek) {
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
    public int deleteMatchWeekByIds(Long[] ids) {
        return matchWeekMapper.deleteMatchWeekByIds(ids);
    }

    /**
     * 删除周赛信息
     *
     * @param id 周赛主键
     * @return 结果
     */
    @Override
    public int deleteMatchWeekById(Long id) {
        return matchWeekMapper.deleteMatchWeekById(id);
    }

    @Override
    public boolean createWeekMatch() {
        return false;
    }

//    public void createMatch() {
//        // 创建周赛
//        Date[] dates = getStartEndTime();
//        // 获取上一场周赛信息
//        MatchWeek lastWeekMatch = this.getLastSessionMatch();
//        Integer sessionNo = lastWeekMatch != null ? lastWeekMatch.getSessionNo() + 1 : 1;
//        MatchWeek curMatch = MatchWeek.builder()
//                .startTime(dates[0])
//                .endTime(dates[1])
//                .sessionNo(sessionNo)
//                .name("第" + sessionNo + "场周赛")
//                .status(MatchStatusEnum.NOSTART.getCode())
//                .joinCount(0)
//                .build();
//        this.save(curMatch);
//        // 抽选题目
//        List<Question> randomQuestions = questionService.getQuestionsByRandom(5);
//        matchQuestionRelateService.saveMatchQuestions(curMatch.getId(), randomQuestions);
//        // 发送消息到 延时交换机 用于比赛结束后检查比赛状态以及统计比赛结果
//        long delayTimes = curMatch.getEndTime().getTime() - System.currentTimeMillis() + (1000 * 10);
//        rabbitTemplate.convertAndSend(MyMqConfig.DELAYED_EXCHANGE, MyMqConfig.MATCH_WEEK_CHECK_ROUTTINGKEY, curMatch.getId(),
//                correlationData -> {
//                    correlationData.getMessageProperties().setDelay((int) delayTimes);
//                    return correlationData;
//                });
//    }

    /**
     * 获取比赛开始时间和结束时间
     *
     * @return
     */
    public Date[] getStartEndTime() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        int diffDays = 7 - i + 7;
        calendar.add(Calendar.DAY_OF_MONTH, diffDays);
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date startTime = calendar.getTime();
        calendar.add(Calendar.HOUR, 1);
        calendar.set(Calendar.MINUTE, 30);
        Date endTime = calendar.getTime();
        Date[] res = new Date[]{startTime, endTime};
        return res;
    }

    @Override
    public MatchWeek getLastSessionMatch() {
        MatchWeek matchWeek = this.lambdaQuery()
                .orderByDesc(MatchWeek::getSessionNo)
                .last("limit 1").one();
        return matchWeek;
    }

}
