package org.itstack.demo.rpc;

import org.itstack.demo.rpc.req.UserReq;
import org.itstack.demo.rpc.res.UserRes;

public interface IUserRpc {

    UserRes queryUserInfoList(UserReq req);

}
