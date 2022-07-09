package com.hh.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRP 缓存
 *
 * @author HaoHao
 * @date 2022/3/22 11:14 上午
 */
public class LruCache {

    public LinkedHashMap<Integer, Integer> cache;

    public LruCache(int capacity) {
        // write code here
        this.cache = new LinkedHashMap<Integer,Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 2;
            }
        };
    }

    public int get(int key) {
        // write code here
        if (!cache.containsKey(key)) {
            return -1;
        }
        return cache.get(key);
    }

    public void set(int key, int value) {
        // write code here
        cache.put(key, value);
    }

    //["set","set","get","set","get","set","get","get","get"],[[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]],2
    public static void main(String[] args) {
        LruCache lruCache = new LruCache(2);
        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.get(1);
        lruCache.set(3, 3);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.cache.size());
    }
}
