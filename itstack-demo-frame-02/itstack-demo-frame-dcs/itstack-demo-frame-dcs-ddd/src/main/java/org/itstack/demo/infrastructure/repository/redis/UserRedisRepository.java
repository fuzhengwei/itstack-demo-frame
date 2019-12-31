package org.itstack.demo.infrastructure.repository.redis;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.itstack.demo.domain.model.aggregates.UserInfoCollect;
import org.itstack.demo.domain.model.req.UserReq;
import org.itstack.demo.domain.repostory.IUserRepository;
import org.itstack.demo.infrastructure.util.Redis;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 微信公众号：bugstack虫洞栈 | 欢迎关注学习专题案例
 * 论坛：http://bugstack.cn
 * Create by 付政委 on @2019
 */
@Repository("userRedisRepository")
public class UserRedisRepository implements IUserRepository {

    @Resource
    private Redis redis;

    @Override
    public UserInfoCollect queryUserInfoList(UserReq req) {
        if (StringUtils.isBlank(req.getName())) return null;
        Object obj = redis.get(req.getName());
        if (null == obj) return null;
        return JSON.parseObject(obj.toString(), UserInfoCollect.class);
    }

}
