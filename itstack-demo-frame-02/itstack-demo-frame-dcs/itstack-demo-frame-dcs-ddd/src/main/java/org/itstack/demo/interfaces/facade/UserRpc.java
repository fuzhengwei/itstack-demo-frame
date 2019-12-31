package org.itstack.demo.interfaces.facade;

import org.itstack.demo.application.UserService;
import org.itstack.demo.domain.model.aggregates.UserInfoCollect;
import org.itstack.demo.interfaces.assembler.UserAssembler;
import org.itstack.demo.rpc.IUserRpc;
import org.itstack.demo.rpc.req.UserReq;
import org.itstack.demo.rpc.res.UserRes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 微信公众号：bugstack虫洞栈 | 欢迎关注学习专题案例
 * 论坛：http://bugstack.cn
 * Create by 付政委 on @2019
 */
@Service("userRpc")
public class UserRpc implements IUserRpc {

    @Resource
    private UserService userService;

    @Override
    public UserRes queryUserInfoList(UserReq req) {
        UserInfoCollect userInfoCollect = userService.queryUserInfoList(UserAssembler.buildUserReq(req));
        return UserAssembler.buildUserInfoCollect(userInfoCollect);
    }

}
