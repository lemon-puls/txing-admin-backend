package com.txing.project.oj.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.txing.framework.aspectj.lang.annotation.Excel;
import com.txing.framework.web.domain.BaseEntity;

/**
 * 周赛题目关联对象 tx_oj_match_week_question_relate
 * 
 * @author lizhiwei
 * @date 2024-04-07
 */
@TableName("tx_oj_match_week_question_relate")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchWeekQuestionRelate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 比赛id */
    @Excel(name = "比赛id")
    private Long matchId;

    /** 题目id */
    @Excel(name = "题目id")
    private Long questionId;

    /** 题目序号 */
    @Excel(name = "题目序号")
    private Integer questionOrder;

    /** 是否删除 */
    @Excel(name = "是否删除")
    @TableLogic
    @TableField("is_delete")
    private Long isDelete;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("matchId", getMatchId())
            .append("questionId", getQuestionId())
            .append("questionOrder", getQuestionOrder())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
