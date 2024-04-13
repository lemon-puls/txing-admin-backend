package com.txing.project.oj.domain;

import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.txing.framework.aspectj.lang.annotation.Excel;
import com.txing.framework.web.domain.BaseEntity;

/**
 * 用户对象 tx_oj_user
 * 
 * @author lizhiwei
 * @date 2024-04-06
 */
@TableName("tx_oj_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 账号 */
    @Excel(name = "账号")
    private String userAccount;

    /** 密码 */
    private String userPassword;

    /** $column.columnComment */
    private String unionId;

    /** $column.columnComment */
    private String mpOpenId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 头像 */
    @Excel(name = "头像")
    private String userAvatar;

    /** $column.columnComment */
    private String userProfile;

    /** 角色 */
    @Excel(name = "角色")
    private String userRole;

    /** 学校 */
    @Excel(name = "学校")
    private String school;

    /** 专业 */
    @Excel(name = "专业")
    private String profession;

    /** 工作经验 */
    @Excel(name = "工作经验")
    private Long workExperience;

    /** 做题数 */
    @Excel(name = "做题数")
    private Long questionCount;

    /** 通过率 */
    @Excel(name = "通过率")
    private Long acceptedRate;

    /** 个性签名 */
    @Excel(name = "个性签名")
    private String personSign;

    /** 是否删除 */
    @TableLogic
    @TableField("is_delete")
    private Long isDelete;

    /** 提交数 */
    @Excel(name = "提交数")
    private Long submitCount;

    /** 通过数 */
    @Excel(name = "通过数")
    private Long acceptedCount;

    /** 在线状态 */
    @Excel(name = "在线状态")
    private Long activeStatus;

    /** 最近上下线时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "最近上下线时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastOpsTime;

    /** 竞赛积分 */
    @Excel(name = "竞赛积分")
    private Long matchScore;

    /** 用户状态 0: 正常 1：封禁 */
    @Excel(name = "用户状态")
    private Integer status;
    @Excel(name = "备注")
    private String remark;

    /** 排序参数 */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @TableField(exist = false)
    private Map<String, String> sortParams;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userAccount", getUserAccount())
            .append("userPassword", getUserPassword())
            .append("unionId", getUnionId())
            .append("mpOpenId", getMpOpenId())
            .append("userName", getUserName())
            .append("userAvatar", getUserAvatar())
            .append("userProfile", getUserProfile())
            .append("userRole", getUserRole())
            .append("school", getSchool())
            .append("profession", getProfession())
            .append("workExperience", getWorkExperience())
            .append("questionCount", getQuestionCount())
            .append("acceptedRate", getAcceptedRate())
            .append("personSign", getPersonSign())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDelete", getIsDelete())
            .append("submitCount", getSubmitCount())
            .append("acceptedCount", getAcceptedCount())
            .append("activeStatus", getActiveStatus())
            .append("lastOpsTime", getLastOpsTime())
            .append("matchScore", getMatchScore())
            .toString();
    }
}
