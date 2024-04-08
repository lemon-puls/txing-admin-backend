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
 * 帖子对象 tx_oj_topic
 * 
 * @author lizhiwei
 * @date 2024-04-06
 */
@TableName("tx_oj_topic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 标签 */
    private String tags;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long thumbNum;

    /** 收藏数 */
    @Excel(name = "收藏数")
    private Long favourNum;

    /** 评论数 */
    @Excel(name = "评论数")
    private Long commentNum;

    /** 用户Id */
    @Excel(name = "用户Id")
    private Long userId;

    /** 是否删除 */
    @TableLogic
    @TableField("is_delete")
    private Long isDelete;

    /** 图片 */
    @Excel(name = "图片")
    private String imgs;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private Long status;

    @TableField(exist = false)
    private UserShowVO user;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("tags", getTags())
            .append("thumbNum", getThumbNum())
            .append("favourNum", getFavourNum())
            .append("commentNum", getCommentNum())
            .append("userId", getUserId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDelete", getIsDelete())
            .append("imgs", getImgs())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
