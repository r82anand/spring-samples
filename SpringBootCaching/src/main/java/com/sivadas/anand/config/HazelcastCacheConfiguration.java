package com.sivadas.anand.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;

@Configuration
public class HazelcastCacheConfiguration {

	@Bean
	public Config hazelcastConfig() {

		final Config config = new Config();
		config.setInstanceName("hazelcast-cache");

		final MapConfig contentsCache = new MapConfig();
		contentsCache.setEvictionPolicy(EvictionPolicy.LFU);
		config.getMapConfigs().put("contentsCache", contentsCache);

		final MapConfig topicCache = new MapConfig();
		topicCache.setEvictionPolicy(EvictionPolicy.LFU);
		config.getMapConfigs().put("topicCache", topicCache);

		final MapConfig chapterCache = new MapConfig();
		chapterCache.setEvictionPolicy(EvictionPolicy.LFU);
		config.getMapConfigs().put("chapterCache", chapterCache);

		return config;
	}
}
