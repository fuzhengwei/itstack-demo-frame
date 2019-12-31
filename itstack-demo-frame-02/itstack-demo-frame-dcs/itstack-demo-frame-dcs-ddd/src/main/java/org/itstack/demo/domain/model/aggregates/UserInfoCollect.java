package org.itstack.demo.domain.model.aggregates;

import org.itstack.demo.domain.model.vo.UserInfo;

import java.util.List;

/**
 * 微信公众号：bugstack虫洞栈 | 欢迎关注学习专题案例
 * 论坛：http://bugstack.cn
 * Create by 付政委 on @2019
 */
public class UserInfoCollect {

    private Long count;
    private List<UserInfo> userInfoList;

    public UserInfoCollect() {
    }

    public UserInfoCollect(Long count, List<UserInfo> userInfoList) {
        this.count = count;
        this.userInfoList = userInfoList;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }
}
