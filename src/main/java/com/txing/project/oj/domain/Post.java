package com.txing.project.oj.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.txing.framework.aspectj.lang.annotation.Excel;
import com.txing.framework.web.domain.BaseEntity;

/**
 * 文章对象 tx_oj_post
 *
 * @author lizhiwei
 * @date 2024-04-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tx_oj_post")
public class Post extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 简介
     */
    @Excel(name = "简介")
    private String intro;

    /**
     * 正文
     */
    private String content;

    /**
     * 封面
     */
    @Excel(name = "封面")
    private String coverImg;

    /**
     * 标签
     */
    private String tags;

    /**
     * 点赞数
     */
    @Excel(name = "点赞数")
    private Long thumbNum;

    /**
     * 收藏数
     */
    @Excel(name = "收藏数")
    private Long favourNum;

    /**
     * 评论数
     */
    @Excel(name = "评论数")
    private Long commentNum;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

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

    /**
     * 备注
     *
     * @param id
     */
    @Excel(name = "备注")
    private String remark;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("intro", getIntro())
                .append("content", getContent())
                .append("coverImg", getCoverImg())
                .append("tags", getTags())
                .append("thumbNum", getThumbNum())
                .append("favourNum", getFavourNum())
                .append("commentNum", getCommentNum())
                .append("userId", getUserId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .append("status", getStatus())
                .toString();
    }
}
