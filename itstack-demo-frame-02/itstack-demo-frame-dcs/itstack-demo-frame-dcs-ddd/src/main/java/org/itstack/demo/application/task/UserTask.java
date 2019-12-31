package org.itstack.demo.application.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserTask {

    private Logger logger = LoggerFactory.getLogger(UserTask.class);

    public void execute() throws Exception{
        logger.info("定时处理用户信息任务：0/5 * * * * ?");
    }

}
