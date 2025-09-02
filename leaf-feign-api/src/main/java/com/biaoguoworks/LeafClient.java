package com.biaoguoworks;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author wuxin
 * @date 2025/09/02 11:36:54
 *
 */
@FeignClient(contextId = "leafClient", value = "leaf")
public interface LeafClient {

    /**
     * 根据业务KEY生产snowflakeId
     */
    @GetMapping(value = "/api/snowflake/get")
    Long getDistributeIdViaSnowflakeByKey(@RequestParam("key")  String key);

}
