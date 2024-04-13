package com.txing.project.oj.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.txing.common.utils.DateUtils;
import com.txing.project.oj.domain.User;
import com.txing.project.oj.service.IUserService;
import com.txing.project.oj.vo.post.PostVO;
import com.txing.project.oj.vo.user.UserShowVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.txing.project.oj.mapper.PostMapper;
import com.txing.project.oj.domain.Post;
import com.txing.project.oj.service.IPostService;

/**
 * 文章Service业务层处理
 * 
 * @author lizhiwei
 * @date 2024-04-06
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService
{
    @Autowired
    private PostMapper postMapper;
    @Autowired
    IUserService userService;

    /**
     * 查询文章
     * 
     * @param id 文章主键
     * @return 文章
     */
    @Override
    public Post selectPostById(Long id)
    {
        return postMapper.selectPostById(id);
    }

    /**
     * 查询文章列表
     * 
     * @param post 文章
     * @return 文章
     */
    @Override
    public List<Post> selectPostList(Post post)
    {
        return postMapper.selectPostList(post);
    }

    /**
     * 新增文章
     * 
     * @param post 文章
     * @return 结果
     */
    @Override
    public int insertPost(Post post)
    {
        post.setCreateTime(DateUtils.getNowDate());
        return postMapper.insertPost(post);
    }

    /**
     * 修改文章
     * 
     * @param post 文章
     * @return 结果
     */
    @Override
    public int updatePost(Post post)
    {
        post.setUpdateTime(DateUtils.getNowDate());
        return postMapper.updatePost(post);
    }

    /**
     * 批量删除文章
     * 
     * @param ids 需要删除的文章主键
     * @return 结果
     */
    @Override
    public int deletePostByIds(Long[] ids)
    {
        return postMapper.deletePostByIds(ids);
    }

    /**
     * 删除文章信息
     * 
     * @param id 文章主键
     * @return 结果
     */
    @Override
    public int deletePostById(Long id)
    {
        return postMapper.deletePostById(id);
    }

    @Override
    public PostVO getPostVO(Post post) {
        PostVO postVO = PostVO.objToVo(post);
        long postId = post.getId();
        // 1. 关联查询用户信息
        Long userId = post.getUserId();
        User user = null;
        if (userId != null && userId > 0) {
            user = userService.getById(userId);
        }
        UserShowVO userShowVO = new UserShowVO();
        BeanUtils.copyProperties(user, userShowVO);
        postVO.setUser(userShowVO);
        return postVO;
    }

    @Override
    public List<PostVO> buildPostVOsByPosts(List<Post> list) {
        return list.stream().map(post -> getPostVO(post))
                .collect(Collectors.toList());
    }
}
