package com.txing.project.oj.service;

import java.util.List;
import com.txing.project.oj.domain.Room;

/**
 * 聊天房间Service接口
 * 
 * @author lizhiwei
 * @date 2024-04-07
 */
public interface IRoomService 
{
    /**
     * 查询聊天房间
     * 
     * @param id 聊天房间主键
     * @return 聊天房间
     */
    public Room selectRoomById(Long id);

    /**
     * 查询聊天房间列表
     * 
     * @param room 聊天房间
     * @return 聊天房间集合
     */
    public List<Room> selectRoomList(Room room);

    /**
     * 新增聊天房间
     * 
     * @param room 聊天房间
     * @return 结果
     */
    public int insertRoom(Room room);

    /**
     * 修改聊天房间
     * 
     * @param room 聊天房间
     * @return 结果
     */
    public int updateRoom(Room room);

    /**
     * 批量删除聊天房间
     * 
     * @param ids 需要删除的聊天房间主键集合
     * @return 结果
     */
    public int deleteRoomByIds(Long[] ids);

    /**
     * 删除聊天房间信息
     * 
     * @param id 聊天房间主键
     * @return 结果
     */
    public int deleteRoomById(Long id);

    List<Room> selectRoomFriendList(Room room);
}
