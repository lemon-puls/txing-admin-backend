package com.txing.project.oj.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.txing.project.oj.domain.Post;
import com.txing.project.oj.vo.post.PostVO;

/**
 * 文章Service接口
 * 
 * @author lizhiwei
 * @date 2024-04-06
 */
public interface IPostService extends IService<Post>
{
    /**
     * 查询文章
     * 
     * @param id 文章主键
     * @return 文章
     */
    public Post selectPostById(Long id);

    /**
     * 查询文章列表
     * 
     * @param post 文章
     * @return 文章集合
     */
    public List<Post> selectPostList(Post post);

    /**
     * 新增文章
     * 
     * @param post 文章
     * @return 结果
     */
    public int insertPost(Post post);

    /**
     * 修改文章
     * 
     * @param post 文章
     * @return 结果
     */
    public int updatePost(Post post);

    /**
     * 批量删除文章
     * 
     * @param ids 需要删除的文章主键集合
     * @return 结果
     */
    public int deletePostByIds(Long[] ids);

    /**
     * 删除文章信息
     * 
     * @param id 文章主键
     * @return 结果
     */
    public int deletePostById(Long id);

    PostVO getPostVO(Post post);

    List<PostVO> buildPostVOsByPosts(List<Post> list);
}
