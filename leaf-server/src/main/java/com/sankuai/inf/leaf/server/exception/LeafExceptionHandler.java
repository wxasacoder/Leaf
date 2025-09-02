package com.sankuai.inf.leaf.server.exception;

import com.sankuai.inf.leaf.server.commons.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author wuxin
 * @date 2025/09/02 10:12:04
 *
 */
@ControllerAdvice
public class LeafExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(LeafExceptionHandler.class);

    @ExceptionHandler(value = LeafServerException.class)
    @ResponseBody
    public Result handler(LeafServerException e) {
        logger.error("生产id异常 -->{},{}", e, e.getMessage());
        return Result.error(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(value = NoKeyException.class)
    @ResponseBody
    public Result handler(NoKeyException e) {
        logger.error("key不存在 --> {},{}", e.getMessage(), e);
        return Result.error(e.getErrorCode(), e.getMessage());
    }


}
