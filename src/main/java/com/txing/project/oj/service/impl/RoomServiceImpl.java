package com.txing.project.oj.service.impl;

import java.util.List;
import com.txing.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.txing.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.txing.project.oj.domain.RoomGroup;
import com.txing.project.oj.mapper.RoomMapper;
import com.txing.project.oj.domain.Room;
import com.txing.project.oj.service.IRoomService;

/**
 * 聊天房间Service业务层处理
 * 
 * @author lizhiwei
 * @date 2024-04-07
 */
@Service
public class RoomServiceImpl implements IRoomService 
{
    @Autowired
    private RoomMapper roomMapper;

    /**
     * 查询聊天房间
     * 
     * @param id 聊天房间主键
     * @return 聊天房间
     */
    @Override
    public Room selectRoomById(Long id)
    {
        return roomMapper.selectRoomById(id);
    }

    /**
     * 查询聊天房间列表
     * 
     * @param room 聊天房间
     * @return 聊天房间
     */
    @Override
    public List<Room> selectRoomList(Room room)
    {
        return roomMapper.selectRoomList(room);
    }

    @Override
    public List<Room> selectRoomFriendList(Room room) {
        return roomMapper.selectRoomFriendList(room);
    }

    /**
     * 新增聊天房间
     * 
     * @param room 聊天房间
     * @return 结果
     */
    @Transactional
    @Override
    public int insertRoom(Room room)
    {
        room.setCreateTime(DateUtils.getNowDate());
        int rows = roomMapper.insertRoom(room);
        insertRoomGroup(room);
        return rows;
    }

    /**
     * 修改聊天房间
     * 
     * @param room 聊天房间
     * @return 结果
     */
    @Transactional
    @Override
    public int updateRoom(Room room)
    {
        room.setUpdateTime(DateUtils.getNowDate());
        roomMapper.deleteRoomGroupByRoomId(room.getId());
        insertRoomGroup(room);
        return roomMapper.updateRoom(room);
    }

    /**
     * 批量删除聊天房间
     * 
     * @param ids 需要删除的聊天房间主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteRoomByIds(Long[] ids)
    {
        roomMapper.deleteRoomGroupByRoomIds(ids);
        return roomMapper.deleteRoomByIds(ids);
    }

    /**
     * 删除聊天房间信息
     * 
     * @param id 聊天房间主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteRoomById(Long id)
    {
        roomMapper.deleteRoomGroupByRoomId(id);
        return roomMapper.deleteRoomById(id);
    }

    /**
     * 新增群聊房间信息
     * 
     * @param room 聊天房间对象
     */
    public void insertRoomGroup(Room room)
    {
        List<RoomGroup> roomGroupList = room.getRoomGroupList();
        Long id = room.getId();
        if (StringUtils.isNotNull(roomGroupList))
        {
            List<RoomGroup> list = new ArrayList<RoomGroup>();
            for (RoomGroup roomGroup : roomGroupList)
            {
                roomGroup.setRoomId(id);
                list.add(roomGroup);
            }
            if (list.size() > 0)
            {
                roomMapper.batchRoomGroup(list);
            }
        }
    }


}
