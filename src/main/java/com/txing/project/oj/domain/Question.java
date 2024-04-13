package com.txing.project.oj.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.txing.framework.aspectj.lang.annotation.Excel;
import com.txing.framework.web.domain.BaseEntity;

/**
 * 题目中心对象 tx_oj_question
 * 
 * @author lizhiwei
 * @date 2024-04-02
 */
@TableName("tx_oj_question")
public class Question extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 标签 */
    @Excel(name = "标签")
    private String tags;

    /** 答案 */
    @Excel(name = "答案")
    private String answer;

    /** 提交数 */
    @Excel(name = "提交数")
    private Long submitNum;

    /** 通过数 */
    @Excel(name = "通过数")
    private Long acceptedNum;

    /** 判题用例 */
    @Excel(name = "判题用例")
    private String judgeCase;

    /** 判题配置 */
    @Excel(name = "判题配置")
    private String judgeConfig;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long thumbNum;

    /** 收藏数 */
    @Excel(name = "收藏数")
    private Long favourNum;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 是否删除 */
    @TableLogic
    @TableField("is_delete")
    private Long isDelete;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setTags(String tags) 
    {
        this.tags = tags;
    }

    public String getTags() 
    {
        return tags;
    }
    public void setAnswer(String answer) 
    {
        this.answer = answer;
    }

    public String getAnswer() 
    {
        return answer;
    }
    public void setSubmitNum(Long submitNum) 
    {
        this.submitNum = submitNum;
    }

    public Long getSubmitNum() 
    {
        return submitNum;
    }
    public void setAcceptedNum(Long acceptedNum) 
    {
        this.acceptedNum = acceptedNum;
    }

    public Long getAcceptedNum() 
    {
        return acceptedNum;
    }
    public void setJudgeCase(String judgeCase) 
    {
        this.judgeCase = judgeCase;
    }

    public String getJudgeCase() 
    {
        return judgeCase;
    }
    public void setJudgeConfig(String judgeConfig) 
    {
        this.judgeConfig = judgeConfig;
    }

    public String getJudgeConfig() 
    {
        return judgeConfig;
    }
    public void setThumbNum(Long thumbNum) 
    {
        this.thumbNum = thumbNum;
    }

    public Long getThumbNum() 
    {
        return thumbNum;
    }
    public void setFavourNum(Long favourNum) 
    {
        this.favourNum = favourNum;
    }

    public Long getFavourNum() 
    {
        return favourNum;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setIsDelete(Long isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() 
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("tags", getTags())
            .append("answer", getAnswer())
            .append("submitNum", getSubmitNum())
            .append("acceptedNum", getAcceptedNum())
            .append("judgeCase", getJudgeCase())
            .append("judgeConfig", getJudgeConfig())
            .append("thumbNum", getThumbNum())
            .append("favourNum", getFavourNum())
            .append("userId", getUserId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
