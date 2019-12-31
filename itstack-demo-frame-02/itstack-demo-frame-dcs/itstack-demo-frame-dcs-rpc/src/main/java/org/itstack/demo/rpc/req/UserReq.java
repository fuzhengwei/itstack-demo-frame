package org.itstack.demo.rpc.req;

import org.itstack.demo.frame.common.domain.PageRequest;

import java.io.Serializable;

public class UserReq extends PageRequest implements Serializable {

    private static final long serialVersionUID = -1781606436664906783L;

    private String name;
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
