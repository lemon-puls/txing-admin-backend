package com.txing.project.oj.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.txing.project.oj.vo.user.UserShowVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Lizhiwei
 * @date 2023/12/28 9:08:12
 * 注释：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tx_oj_room_friend")
public class RoomFriend {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 房间id
     */
    private Long roomId;
    /**
     * 用户id(较小)
     */
    private Long userId1;
    /**
     * 用户id（较大）
     */
    private Long userId2;
    /**
     * 状态：0：正常 1：禁用
     */
    private Integer status;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 是否删除
     */
    @TableLogic
    @TableField("is_delete")
    private Integer isDelete;
    @TableField(exist = false)
    private UserShowVO user1;

    @TableField(exist = false)
    private UserShowVO user2;

}
