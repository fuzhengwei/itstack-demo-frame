package org.itstack.demo.test;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.rpc.IUserRpc;
import org.itstack.demo.rpc.req.UserReq;
import org.itstack.demo.rpc.res.UserRes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    private IUserRpc userRpc;

    @Test
    public void test_queryUserInfoList() {
        UserReq req = new UserReq();
        req.setName("豆豆");
        req.setPage("1", "5");
        UserRes res = userRpc.queryUserInfoList(req);
        logger.info("\r\n测试结果 req：{} res：{}", JSON.toJSONString(req), JSON.toJSONString(res));
    }

}
