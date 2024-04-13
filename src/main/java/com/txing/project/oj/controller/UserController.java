package com.txing.project.oj.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.txing.project.oj.adapter.UserAdapter;
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
import com.txing.project.oj.domain.User;
import com.txing.project.oj.service.IUserService;
import com.txing.framework.web.controller.BaseController;
import com.txing.framework.web.domain.AjaxResult;
import com.txing.common.utils.poi.ExcelUtil;
import com.txing.framework.web.page.TableDataInfo;

/**
 * 用户Controller
 *
 * @author lizhiwei
 * @date 2024-04-06
 */
@RestController
@RequestMapping("/oj/user")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    /**
     * 查询用户列表
     */
    @PreAuthorize("@ss.hasPermi('oj:user:list')")
    @GetMapping("/list")
    @ApiOperation("查看用户列表")
    public TableDataInfo list(User user) {
        startPage();
        List<User> list = userService.selectUserList(user);
        return getDataTable(list);
    }


    /**
     * 查询UserShow列表
     */
    @PreAuthorize("@ss.hasPermi('oj:user:list')")
    @GetMapping("/show/list")
    @ApiOperation("查询UserShow列表")
    public AjaxResult getUserShowList() {
        List<User> list = userService.list();
        List<UserShowVO> userShowVOS = UserAdapter.buildUserShowVOs(list);
        return success(userShowVOS);
    }


    /**
     * 导出用户列表
     */
    @PreAuthorize("@ss.hasPermi('oj:user:export')")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出用户列表")
    public void export(HttpServletResponse response, User user) {
        List<User> list = userService.selectUserList(user);
        ExcelUtil<User> util = new ExcelUtil<User>(User.class);
        util.exportExcel(response, list, "用户数据");
    }

    /**
     * 获取用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('oj:user:query')")
    @GetMapping(value = "/{id}")
    @ApiOperation("获取用户详情信息")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(userService.selectUserById(id));
    }

    /**
     * 新增用户
     */
    @PreAuthorize("@ss.hasPermi('oj:user:add')")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增用户")
    public AjaxResult add(@RequestBody User user) {
        return toAjax(userService.insertUser(user));
    }

    /**
     * 修改用户
     */
    @PreAuthorize("@ss.hasPermi('oj:user:edit')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改用户")
    public AjaxResult edit(@RequestBody User user) {
        return toAjax(userService.updateUser(user));
    }

    /**
     * 删除用户
     */
    @PreAuthorize("@ss.hasPermi('oj:user:remove')")
    @Log(title = "用户", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    @ApiOperation("删除用户")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(userService.deleteUserByIds(ids));
    }
}
