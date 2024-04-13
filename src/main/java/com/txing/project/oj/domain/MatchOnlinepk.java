package com.txing.project.oj.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.txing.project.oj.vo.question.QuestionSimpleVO;
import com.txing.project.oj.vo.user.UserShowVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.txing.framework.aspectj.lang.annotation.Excel;
import com.txing.framework.web.domain.BaseEntity;

/**
 * 在线PK对象 tx_oj_match_onlinepk
 * 
 * @author lizhiwei
 * @date 2024-04-08
 */
@TableName("tx_oj_match_onlinepk")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchOnlinepk extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户ID1 */
    @Excel(name = "用户ID1")
    private Long userId1;

    /** 用户ID2 */
    @Excel(name = "用户ID2")
    private Long userId2;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 提交时间1 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "提交时间1", width = 30, dateFormat = "yyyy-MM-dd")
    private Date submitTime1;

    /** 提交时间2 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "提交时间2", width = 30, dateFormat = "yyyy-MM-dd")
    private Date submitTime2;

    /** 提交ID1 */
    @Excel(name = "提交ID1")
    private Long submitId1;

    /** 提交ID2 */
    @Excel(name = "提交ID2")
    private Long submitId2;

    /** 赢家id */
    @Excel(name = "赢家id")
    private Long winnerId;

    /** 竞赛题目 */
    @Excel(name = "竞赛题目")
    private Long questionId;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 分数1 */
    @Excel(name = "分数1")
    private Long score1;

    /** 分数2 */
    @Excel(name = "分数2")
    private Long score2;

    /** 是否删除 */
    @TableLogic
    @TableField("is_delete")
    private Long isDelete;

    @TableField(exist = false)
    private UserShowVO user1;
    @TableField(exist = false)
    private UserShowVO user2;
    @TableField(exist = false)
    private QuestionSimpleVO question;



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId1", getUserId1())
            .append("userId2", getUserId2())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("submitTime1", getSubmitTime1())
            .append("submitTime2", getSubmitTime2())
            .append("submitId1", getSubmitId1())
            .append("submitId2", getSubmitId2())
            .append("winnerId", getWinnerId())
            .append("questionId", getQuestionId())
            .append("status", getStatus())
            .append("score1", getScore1())
            .append("score2", getScore2())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
