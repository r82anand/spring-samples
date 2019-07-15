package com.sivadas.anand.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;

@Configuration
public class HazelcastCacheConfiguration {

	@Bean
	public Config hazelcastConfig() {
		
        Config config = new Config();
        config.setInstanceName("hazelcast-cache");

        MapConfig contentsCache = new MapConfig();
        contentsCache.setTimeToLiveSeconds(2000);
        contentsCache.setEvictionPolicy(EvictionPolicy.LFU);
        MaxSizeConfig maxSizeConfig = new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE);
        contentsCache.setMaxSizeConfig(maxSizeConfig);
        config.getMapConfigs().put("contentsCache",contentsCache);

//        MapConfig usercache = new MapConfig();
//        usercache.setTimeToLiveSeconds(20);
//        usercache.setEvictionPolicy(EvictionPolicy.LFU);
//        config.getMapConfigs().put("usercache",usercache);

        return config;
	}
}
