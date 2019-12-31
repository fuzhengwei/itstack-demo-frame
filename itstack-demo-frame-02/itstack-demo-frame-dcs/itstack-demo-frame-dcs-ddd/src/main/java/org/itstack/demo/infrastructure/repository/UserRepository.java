package org.itstack.demo.infrastructure.repository;

import org.itstack.demo.domain.model.aggregates.UserInfoCollect;
import org.itstack.demo.domain.model.req.UserReq;
import org.itstack.demo.domain.repostory.IUserRepository;
import org.itstack.demo.infrastructure.repository.mysql.UserDBRepository;
import org.itstack.demo.infrastructure.repository.redis.UserRedisRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 微信公众号：bugstack虫洞栈 | 欢迎关注学习专题案例
 * 论坛：http://bugstack.cn
 * Create by 付政委 on @2019
 */
@Repository("userRepository")
public class UserRepository implements IUserRepository {

    @Resource
    private UserDBRepository userDBRepository;
    @Resource
    private UserRedisRepository userRedisRepository;

    @Override
    public UserInfoCollect queryUserInfoList(UserReq req) {
        UserInfoCollect userInfoCollect = userRedisRepository.queryUserInfoList(req);
        if (null != userInfoCollect) return userInfoCollect;
        return userDBRepository.queryUserInfoList(req);
    }

}
