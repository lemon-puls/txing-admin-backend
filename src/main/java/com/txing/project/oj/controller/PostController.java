package com.txing.project.oj.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.txing.common.utils.ThrowUtils;
import com.txing.project.oj.vo.post.PostVO;
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
import com.txing.project.oj.domain.Post;
import com.txing.project.oj.service.IPostService;
import com.txing.framework.web.controller.BaseController;
import com.txing.framework.web.domain.AjaxResult;
import com.txing.common.utils.poi.ExcelUtil;
import com.txing.framework.web.page.TableDataInfo;

/**
 * 文章Controller
 *
 * @author lizhiwei
 * @date 2024-04-06
 */
@RestController
@RequestMapping("/oj/post")
public class PostController extends BaseController {
    @Autowired
    private IPostService postService;

    /**
     * 查询文章列表
     */
    @PreAuthorize("@ss.hasPermi('oj:post:list')")
    @GetMapping("/list")
    @ApiOperation("查询文章列表")
    public TableDataInfo list(Post post) {
        startPage();
        List<Post> list = postService.selectPostList(post);
        List<PostVO> postVOS = postService.buildPostVOsByPosts(list);
        return getDataTable(postVOS);
    }

    /**
     * 导出文章列表
     */
//    @PreAuthorize("@ss.hasPermi('oj:post:export')")
    @Log(title = "文章", businessType = BusinessType.EXPORT)
    @ApiOperation("导出文章列表")
    @PostMapping("/export")
    public void export(HttpServletResponse response, Post post) {
        List<Post> list = postService.selectPostList(post);
        ExcelUtil<Post> util = new ExcelUtil<Post>(Post.class);
        util.exportExcel(response, list, "文章数据");
    }

    /**
     * 获取文章详细信息
     */
//    @PreAuthorize("@ss.hasPermi('oj:post:query')")
    @GetMapping(value = "/{id}")
    @ApiOperation("获取文章详情")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(postService.selectPostById(id));
    }

    /**
     * 新增文章
     */
//    @PreAuthorize("@ss.hasPermi('oj:post:add')")
    @Log(title = "文章", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增文章")
    public AjaxResult add(@RequestBody Post post) {
        return toAjax(postService.insertPost(post));
    }

    /**
     * 修改文章
     */
//    @PreAuthorize("@ss.hasPermi('oj:post:edit')")
    @Log(title = "文章", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("更新文章")
    public AjaxResult edit(@RequestBody Post post) {
        return toAjax(postService.updatePost(post));
    }

    /**
     * 删除文章
     */
//    @PreAuthorize("@ss.hasPermi('oj:post:remove')")
    @Log(title = "文章", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    @ApiOperation("删除文章")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(postService.deletePostByIds(ids));
    }

    /**
     * 根据 id 获取VO（用于查看文章页）
     *
     * @param id
     * @return
     */
    @GetMapping("/get/vo")
    @ApiOperation("获取文章VO")
    public AjaxResult getPostVOById(long id) {
        Post post = postService.getById(id);
        ThrowUtils.throwIf(post == null, "文章不存在");
        PostVO postVO = postService.getPostVO(post);
        return success(postVO);
    }

}
