package com.txing.project.oj.mapper;

import java.util.List;
import com.txing.project.oj.domain.Room;
import com.txing.project.oj.domain.RoomGroup;
import org.apache.ibatis.annotations.Mapper;

/**
 * 聊天房间Mapper接口
 * 
 * @author lizhiwei
 * @date 2024-04-07
 */
@Mapper
public interface RoomMapper 
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

    List<Room> selectRoomFriendList(Room room);

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
     * 删除聊天房间
     * 
     * @param id 聊天房间主键
     * @return 结果
     */
    public int deleteRoomById(Long id);

    /**
     * 批量删除聊天房间
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRoomByIds(Long[] ids);

    /**
     * 批量删除群聊房间
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRoomGroupByRoomIds(Long[] ids);
    
    /**
     * 批量新增群聊房间
     * 
     * @param roomGroupList 群聊房间列表
     * @return 结果
     */
    public int batchRoomGroup(List<RoomGroup> roomGroupList);
    

    /**
     * 通过聊天房间主键删除群聊房间信息
     * 
     * @param id 聊天房间ID
     * @return 结果
     */
    public int deleteRoomGroupByRoomId(Long id);

}
