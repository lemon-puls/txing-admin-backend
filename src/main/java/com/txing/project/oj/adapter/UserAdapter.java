package com.txing.project.oj.adapter;

import com.txing.project.oj.domain.User;
import com.txing.project.oj.vo.user.UserShowVO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhiwei
 * @date 2024/4/6 21:55
 * 注释：
 */
public class UserAdapter {
    public static UserShowVO buildUserShowVO(User user) {
        UserShowVO userShowVO = new UserShowVO();
        BeanUtils.copyProperties(user, userShowVO);
        return userShowVO;
    }

    public static List<UserShowVO> buildUserShowVOs(List<User> userList) {
        List<UserShowVO> collect = userList.stream().map(user -> buildUserShowVO(user)).collect(Collectors.toList());
        return collect;
    }
}
