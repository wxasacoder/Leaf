package com.sankuai.inf.leaf.server.controller;

import com.sankuai.inf.leaf.common.IdResult;
import com.sankuai.inf.leaf.common.Status;
import com.sankuai.inf.leaf.server.commons.Result;
import com.sankuai.inf.leaf.server.exception.ExceptionCode;
import com.sankuai.inf.leaf.server.exception.LeafServerException;
import com.sankuai.inf.leaf.server.exception.NoKeyException;
import com.sankuai.inf.leaf.server.service.SegmentService;
import com.sankuai.inf.leaf.server.service.SnowflakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeafController {
    @Autowired
    private SegmentService segmentService;
    @Autowired
    private SnowflakeService snowflakeService;

    @GetMapping(value = "/api/segment/get")
    public Result<String> getSegmentId(@RequestParam("key") String key) {
        return new Result<>(get(key, segmentService.getId(key)));
    }

    @GetMapping(value = "/api/snowflake/get")
    public Result<String> getSnowflakeId(@RequestParam("key") String key) {
        return new Result<>(get(key, snowflakeService.getId(key)));
    }

    private String get(String key, IdResult id) {
        IdResult result;
        if (key == null || key.isEmpty()) {
            throw new NoKeyException(ExceptionCode.KEY_IS_EMPTY_ERROR.getCode());
        }
        result = id;
        if (result.getStatus().equals(Status.EXCEPTION)) {
            throw new LeafServerException(ExceptionCode.ID_GEN_ERROR.getCode(), result.getMessage());
        }
        return String.valueOf(result.getId());
    }
}
