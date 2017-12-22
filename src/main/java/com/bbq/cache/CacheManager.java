package com.bbq.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheManager<T> {
    private Map<String, T> cache = new ConcurrentHashMap<String, T>();

    public T getValue(String key) {
        return cache.get(key);
    }

    public void addOrUpdateCache(String key, T value) {
        cache.put(key, value);
    }

    public void clearCache(String key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
    }
    public void clearCache() {
        cache.clear();
    }
}
