package org.itstack.demo.domain.service;

import org.itstack.demo.application.UserService;
import org.itstack.demo.domain.model.aggregates.UserInfoCollect;
import org.itstack.demo.domain.model.req.UserReq;
import org.itstack.demo.domain.model.vo.UserInfo;
import org.itstack.demo.domain.repostory.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 微信公众号：bugstack虫洞栈 | 欢迎关注学习专题案例
 * 论坛：http://bugstack.cn
 * Create by 付政委 on @2019
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userRepository")
    private IUserRepository userRepository;

    @Override
    public UserInfoCollect queryUserInfoList(UserReq req) {
        return userRepository.queryUserInfoList(req);
    }

}
