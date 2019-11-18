package com.mengcc.admingateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.List;

/**
 * @author zhouzq
 * @date 2019/11/9
 * @desc 配置信息
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = "mengcc")
public class MengccConfigProperties {

    private List<String> openUrls;

    private List<String> pubilcUrls;
}
