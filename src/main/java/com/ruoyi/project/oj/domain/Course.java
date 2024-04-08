package com.ruoyi.project.oj.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.project.oj.vo.user.UserShowVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 课程对象 tx_oj_course_course
 *
 * @author lizhiwei
 * @date 2024-04-06
 */
@TableName("tx_oj_course_course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 名称
     */
    @Excel(name = "名称")
    private String name;

    /**
     * 封面
     */
    @Excel(name = "封面")
    private String coverUrl;

    /**
     * 时长
     */
    @Excel(name = "时长")
    private Long times;

    /**
     * 节数
     */
    @Excel(name = "节数")
    private Long noduleCount;

    /**
     * 收藏数
     */
    @Excel(name = "收藏数")
    private Long favourCount;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    /**
     * 简介
     */
    @Excel(name = "简介")
    private String intro;

    /**
     * 是否删除
     */
    @TableLogic
    @TableField("is_delete")
    private Long isDelete;

    /**
     * 审核状态
     */
    @Excel(name = "审核状态")
    private Long status;

    @TableField(exist = false)
    private UserShowVO user;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("coverUrl", getCoverUrl())
                .append("times", getTimes())
                .append("noduleCount", getNoduleCount())
                .append("favourCount", getFavourCount())
                .append("userId", getUserId())
                .append("intro", getIntro())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .append("status", getStatus())
                .append("remark", getRemark())
                .toString();
    }
}
