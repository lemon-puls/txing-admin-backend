package com.txing.project.oj.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.txing.project.oj.service.IUserService;
import com.txing.project.oj.vo.user.UserShowVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.txing.framework.aspectj.lang.annotation.Log;
import com.txing.framework.aspectj.lang.enums.BusinessType;
import com.txing.project.oj.domain.Room;
import com.txing.project.oj.service.IRoomService;
import com.txing.framework.web.controller.BaseController;
import com.txing.framework.web.domain.AjaxResult;
import com.txing.common.utils.poi.ExcelUtil;
import com.txing.framework.web.page.TableDataInfo;

/**
 * 聊天房间Controller
 *
 * @author lizhiwei
 * @date 2024-04-07
 */
@RestController
@RequestMapping("/oj/room")
public class RoomController extends BaseController {
    @Autowired
    private IRoomService roomService;
    @Autowired
    IUserService userService;

    /**
     * 查询群聊聊天房间列表
     */
    @PreAuthorize("@ss.hasPermi('oj:room:list')")
    @GetMapping("/list")
    @ApiOperation("查询群聊聊天房间列表")
    public TableDataInfo list(Room room) {
        startPage();
        List<Room> list = roomService.selectRoomList(room);
        for (Room room1 : list) {
            if (room1.getUserShowVO() != null) {
                Long userId = room1.getUserShowVO().getId();
                UserShowVO userShowVO = userService.getUserShowVOById(userId);
                room1.setUserShowVO(userShowVO);
            }
        }
        return getDataTable(list);
    }

    /**
     * 查询私聊房间列表
     */
    @PreAuthorize("@ss.hasPermi('oj:room:list')")
    @GetMapping("/friend/list")
    @ApiOperation("查询私聊房间列表")
    public TableDataInfo listGroupFriend(Room room) {
        startPage();
        List<Room> list = roomService.selectRoomFriendList(room);
        for (Room room1 : list) {
            Long userId1 = room1.getRoomFriend().getUserId1();
            Long userId2 = room1.getRoomFriend().getUserId2();
            room1.getRoomFriend().setUser1(userService.getUserShowVOById(userId1));
            room1.getRoomFriend().setUser2(userService.getUserShowVOById(userId2));
        }
        return getDataTable(list);
    }


    /**
     * 导出聊天房间列表
     */
//    @PreAuthorize("@ss.hasPermi('oj:room:export')")
    @Log(title = "聊天房间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出聊天房间列表")
    public void export(HttpServletResponse response, Room room) {
        List<Room> list = roomService.selectRoomList(room);
        ExcelUtil<Room> util = new ExcelUtil<Room>(Room.class);
        util.exportExcel(response, list, "聊天房间数据");
    }

    /**
     * 获取聊天房间详细信息
     */
    @ApiOperation("获取聊天房间详细信息")
//    @PreAuthorize("@ss.hasPermi('oj:room:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(roomService.selectRoomById(id));
    }

    /**
     * 新增聊天房间
     */
    @ApiOperation("新增聊天房间")
//    @PreAuthorize("@ss.hasPermi('oj:room:add')")
    @Log(title = "聊天房间", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Room room) {
        return toAjax(roomService.insertRoom(room));
    }

    /**
     * 修改聊天房间
     */
    @ApiOperation("修改聊天房间")
//    @PreAuthorize("@ss.hasPermi('oj:room:edit')")
    @Log(title = "聊天房间", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Room room) {
        return toAjax(roomService.updateRoom(room));
    }

    /**
     * 删除聊天房间
     */
    @ApiOperation("删除聊天房间")
//    @PreAuthorize("@ss.hasPermi('oj:room:remove')")
    @Log(title = "聊天房间", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(roomService.deleteRoomByIds(ids));
    }
}
