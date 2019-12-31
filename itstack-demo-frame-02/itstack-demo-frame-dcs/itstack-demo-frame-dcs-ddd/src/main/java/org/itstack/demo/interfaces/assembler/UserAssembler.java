package org.itstack.demo.interfaces.assembler;

import org.itstack.demo.domain.model.aggregates.UserInfoCollect;
import org.itstack.demo.domain.model.req.UserReq;
import org.itstack.demo.domain.model.vo.UserInfo;
import org.itstack.demo.frame.common.domain.Result;
import org.itstack.demo.rpc.dto.UserDto;
import org.itstack.demo.rpc.res.UserRes;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信公众号：bugstack虫洞栈 | 欢迎关注学习专题案例
 * 论坛：http://bugstack.cn
 * Create by 付政委 on @2019
 */
public class UserAssembler {

    public static UserReq buildUserReq(org.itstack.demo.rpc.req.UserReq req) {
        org.itstack.demo.domain.model.req.UserReq userReq = new UserReq();
        userReq.setName(req.getName());
        userReq.setStatus(req.getStatus());
        userReq.setPageStart(req.getPageStart());
        userReq.setPageEnd(req.getPageEnd());
        return userReq;
    }

    public static UserRes buildUserInfoCollect(UserInfoCollect userInfoCollect) {
        List<UserDto> dtoList = new ArrayList<>();
        List<UserInfo> userInfoList = userInfoCollect.getUserInfoList();
        for (UserInfo userInfo : userInfoList) {
            UserDto userDto = new UserDto();
            userDto.setName(userInfo.getName());
            userDto.setStatus(userInfo.getStatus());
            dtoList.add(userDto);
        }
        return new UserRes(Result.buildSuccessResult(), userInfoCollect.getCount(), dtoList);
    }

}
