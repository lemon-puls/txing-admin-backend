package com.ruoyi.project.oj.domain;

import java.util.List;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.project.oj.vo.user.UserShowVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 聊天房间对象 tx_oj_room
 *
 * @author lizhiwei
 * @date 2024-04-07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 房间类型
     */
    @Excel(name = "房间类型")
    private Long type;

    /**
     * 热门房间
     */
    @Excel(name = "热门房间")
    private Long hotFlag;

    /**
     * 活跃时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "活跃时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date activeTime;

    /**
     * 消息id
     */
    @Excel(name = "消息id")
    private Long msgId;

    /**
     * 扩展消息
     */
    @Excel(name = "扩展消息")
    private String extJson;

    /**
     * 是否删除
     */
    @TableLogic
    @TableField("is_delete")
    private Long isDelete;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Long status;

    /**
     * 群聊房间信息
     */
    private List<RoomGroup> roomGroupList;

    /**
     * 群主信息
     */
    private UserShowVO userShowVO;

    /**
     * 私聊房间信息
     */
    private RoomFriend roomFriend;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("type", getType())
                .append("hotFlag", getHotFlag())
                .append("activeTime", getActiveTime())
                .append("msgId", getMsgId())
                .append("extJson", getExtJson())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .append("status", getStatus())
                .append("remark", getRemark())
                .append("roomGroupList", getRoomGroupList())
                .toString();
    }
}
