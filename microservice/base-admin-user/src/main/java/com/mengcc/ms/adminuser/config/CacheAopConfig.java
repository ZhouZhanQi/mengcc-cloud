package com.mengcc.ms.adminuser.config;


import com.mengcc.ms.adminuser.constants.CacheKeys;
import com.mengcc.cache.aspect.CacheHandleAspect;
import com.mengcc.cache.config.RedisConfigHelper;
import com.mengcc.cache.storage.CacheStorage;
import com.mengcc.cache.storage.impl.LocalMemoryCacheStorage;
import com.mengcc.cache.storage.impl.RedisCacheStorage;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Bernix Ning
 * @date 2018-01-08
 */
@Configuration
@EnableAspectJAutoProxy
public class CacheAopConfig {

    private static final Logger log = LoggerFactory.getLogger(CacheAopConfig.class);

    @Value("${mengcc.cache.type}")
    private String cacheType;

    @Value("${mengcc.cache.enable}")
    private boolean enable;

    @Value("${mengcc.cache.clear-on-startup}")
    private boolean clearOnStartup;

    @Autowired(required = false)
    private RedisTemplate<String, Object> redisTemplate;



    @Bean
    public CacheHandleAspect cacheHandleAspect() {
        CacheStorage cacheStorage = cacheStorage();
        if (cacheStorage == null) {
            return null;
        }
        if (clearOnStartup) {
            clearOldCacheOnStartup(cacheStorage);
        }
        return new CacheHandleAspect(cacheStorage);
    }

    @SuppressWarnings("unchecked")
    private void clearOldCacheOnStartup(CacheStorage cacheStorage) {
        try {
            log.info(">> 开始清除旧缓存...");
            // 删除角色已授权操作列表缓存
            cacheStorage.deleteByPattern(CacheKeys.ROLE_GRANTED_ACTIONS + "*");
            // 删除系统/模块/操作/角色列表缓存
            Set<String> keys = new HashSet<>();
            keys.add(CacheKeys.SYS_ALL);
            keys.add(CacheKeys.MODULE_ALL);
            keys.add(CacheKeys.ACTION_ALL);
            keys.add(CacheKeys.ROLE_ALL);
            cacheStorage.deleteWithPrex(keys);
            log.info(">> 清除旧缓存成功");
        } catch (Exception e) {
            log.error(">> 启动时清除旧缓存失败", e);
        }
    }

    private CacheStorage cacheStorage() {
        if (StringUtils.isBlank(cacheType)) {
            log.warn(">> mengcc.cache.type未配置, 不启用缓存");
            return null;
        }
        if (!enable) {
            log.warn(">> mengcc.cache.enable设置为false, 缓存关闭");
            return null;
        }

        if (RedisConfigHelper.TYPE_LOCAL.equals(cacheType.toLowerCase())) {
            log.info(">> 使用本地内存作为缓存");
            return new LocalMemoryCacheStorage(CacheKeys.PREFIX);
        } else if (redisTemplate == null) {
            log.warn(">> redisTemplate为null, 启用redis缓存失败");
            return null;
        } else {
            log.info(">> 使用redis作为缓存");
            return new RedisCacheStorage(CacheKeys.PREFIX, redisTemplate);
        }
    }

}
