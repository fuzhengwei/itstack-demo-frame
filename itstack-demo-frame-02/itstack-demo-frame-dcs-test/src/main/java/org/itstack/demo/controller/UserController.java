package org.itstack.demo.controller;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.frame.common.domain.Result;
import org.itstack.demo.rpc.IUserRpc;
import org.itstack.demo.rpc.req.UserReq;
import org.itstack.demo.rpc.res.UserRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 微信公众号：bugstack虫洞栈 | 欢迎关注学习专题案例
 * 论坛：http://bugstack.cn
 * Create by 付政委 on @2019
 */
@Controller
@RequestMapping("/api/user/")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private IUserRpc userRpc;

    @RequestMapping(path = "queryUserInfoList", method = RequestMethod.GET)
    @ResponseBody
    public UserRes queryUserInfoList(String json, String page, String limit) {
        try {
            logger.info("查询用户信息列表开始。json：{}", json);
            UserReq req = JSON.parseObject(json, UserReq.class);
            if (null == req) req = new UserReq();
            req.setPage(page, limit);
            UserRes userRes = userRpc.queryUserInfoList(req);
            logger.info("查询用户信息列表完成。userRes：{}", JSON.toJSONString(userRes));
            return userRes;
        } catch (Exception e) {
            logger.error("查询用户信息列表失败。json：{}", json, e);
            return new UserRes(Result.buildErrorResult());
        }
    }

}
