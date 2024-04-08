package com.ruoyi.project.oj.vo.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.project.oj.domain.Post;
import com.ruoyi.project.oj.vo.user.UserShowVO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class PostVO implements Serializable {

    private final static Gson GSON = new Gson();

    /**
     * id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;
    /**
     * 简介
     */
    private String intro;

    /**
     * 点赞数
     */
    private Long thumbNum;

    /**
     * 收藏数
     */
    private Long favourNum;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 标签列表
     */
    private List<String> tagList;

    /**
     * 创建人信息
     */
    private UserShowVO user;


    /**
     * 评论数
     */
    private Long commentNum;
    /**
     * 封面图
     */
    private String coverImg;

    /**
     * 是否已点赞
     */
    private Boolean hasThumb;
    /**
     * 是否已收藏
     */
    private Boolean hasFavour;
    /**
     * 审核状态
     */
    private Long status;

    /**
     * 备注
     *
     * @param id
     */
    private String remark;

    /**
     * 包装类转对象
     *
     * @param postVO
     * @return
     */
    public static Post voToObj(PostVO postVO) {
        if (postVO == null) {
            return null;
        }
        Post post = new Post();
        BeanUtils.copyProperties(postVO, post);
        List<String> tagList = postVO.getTagList();
        if (tagList != null) {
            post.setTags(GSON.toJson(tagList));
        }
        return post;
    }

    /**
     * 对象转包装类
     *
     * @param post
     * @return
     */
    public static PostVO objToVo(Post post) {
        if (post == null) {
            return null;
        }
        PostVO postVO = new PostVO();
        BeanUtils.copyProperties(post, postVO);
//        postVO.setTagList(GSON.fromJson(post.getTags(), new TypeToken<List<String>>() {
//        }.getType()));
        return postVO;
    }
}
