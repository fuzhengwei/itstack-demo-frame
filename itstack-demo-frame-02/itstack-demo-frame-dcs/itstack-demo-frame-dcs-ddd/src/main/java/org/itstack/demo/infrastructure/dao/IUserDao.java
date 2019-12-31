package org.itstack.demo.infrastructure.dao;

import org.itstack.demo.domain.model.req.UserReq;
import org.itstack.demo.infrastructure.po.User;

import java.util.List;

/**
 * 微信公众号：bugstack虫洞栈 | 欢迎关注学习专题案例
 * 论坛：http://bugstack.cn
 * Create by 付政委 on @2019
 */
public interface IUserDao {

    List<User> queryUserInfoList(UserReq req);

    Long queryUserInfoCount(UserReq req);

}
