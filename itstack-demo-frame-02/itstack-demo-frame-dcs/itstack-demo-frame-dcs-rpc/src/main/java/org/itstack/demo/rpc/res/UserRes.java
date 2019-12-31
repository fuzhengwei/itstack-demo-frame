package org.itstack.demo.rpc.res;

import org.itstack.demo.frame.common.domain.Result;
import org.itstack.demo.rpc.dto.UserDto;

import java.util.List;

public class UserRes implements java.io.Serializable{

    private static final long serialVersionUID = -6764782345715366841L;
    
    private Result result;
    private Long count;
    private List<UserDto> list;

    public UserRes() {
    }

    public UserRes(Result result) {
        this.result = result;
    }

    public UserRes(Result result, Long count, List<UserDto> list) {
        this.result = result;
        this.count = count;
        this.list = list;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<UserDto> getList() {
        return list;
    }

    public void setList(List<UserDto> list) {
        this.list = list;
    }
}
