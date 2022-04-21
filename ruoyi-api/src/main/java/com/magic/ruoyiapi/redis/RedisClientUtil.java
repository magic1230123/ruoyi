package com.magic.ruoyiapi.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by S on 2017/5/27.
 */
@Component
public class RedisClientUtil {

    private static final Logger logger = LoggerFactory.getLogger(RedisClientUtil.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private String key;

    private static int EXPIRE_PERIOD_MIS = 60 * 1000 * 60 * 2;

    /**
     * 页面缓存
     *
     * @param prex
     * @return
     */
    public void deleteByPrex(String prex) {
        String key = prex+"*";
        Set<String> keys=stringRedisTemplate.keys(key);
        stringRedisTemplate.delete(keys);
    }

    public void deleteBySuffix(String suffix) {
        Set<String> keys=redisTemplate.keys("*"+suffix);
        redisTemplate.delete(keys);
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, String value) {
        boolean result = false;
        try {
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存设置时效时间
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, String value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(key, value);
            stringRedisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<String> keys = stringRedisTemplate.keys(pattern);
        if (keys.size() > 0)
            stringRedisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        boolean flag =exists(key);
        if (flag) {
            stringRedisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return stringRedisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public String get(final String key) {
        String result = null;
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public <T> T getByKey(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return (T) result;
    }

    /**
     * 哈希 添加
     *
     * @param key
     * @param hashKey
     * @param value
     */
    public void hmSet(String key, Object hashKey, Object value) {
        HashOperations<String, Object, Object> hash = stringRedisTemplate.opsForHash();
        hash.put(key, hashKey, value);
    }

    /**
     * 哈希 添加
     *
     * @param key
     * @param hashKey
     * @param value
     */
    public void hmSet(String key, Object hashKey, Object value, long ntt) {
        HashOperations<String, Object, Object> hash = stringRedisTemplate.opsForHash();
        hash.put(key, hashKey, value);
        stringRedisTemplate.expire(key, ntt, TimeUnit.MILLISECONDS);
    }

    /**
     * 哈希 数量
     *
     * @param key
     */
    public long hlen(String key) {
        return stringRedisTemplate.boundHashOps(key).size();
    }

    /**
     * 获取key的生命周期
     */
    public long getNtt(String key) {
        return stringRedisTemplate.getExpire(key, TimeUnit.MILLISECONDS);
    }

    /**
     * 哈希获取数据
     *
     * @param key
     * @param hashKey
     * @return
     */
    public Object hmGet(String key, Object hashKey) {
        HashOperations<String, Object, Object> hash = stringRedisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    /**
     * 哈希获取数据
     *
     * @param key
     * @return
     */
    public Map<Object, Object> hmGetAll(String key) {
        HashOperations<String, Object, Object> hash = stringRedisTemplate.opsForHash();
        return hash.entries(key);
    }

    /**
     * 列表添加
     *
     * @param k
     * @param v
     */
    public void lPush(String k, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k, v);
    }

    /**
     * 列表获取
     *
     * @param k
     * @param l
     * @param l1
     * @return
     */
    public List<Object> lRange(String k, long l, long l1) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k, l, l1);
    }

    /**
     * 集合添加
     *
     * @param key
     * @param value
     */
    public void add(String key, Object value) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key, value);
    }

    /**
     * 集合获取
     *
     * @param key
     * @return
     */
    public Set<Object> setMembers(String key) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * 有序集合添加
     *
     * @param key
     * @param value
     * @param scoure
     */
    public void zAdd(String key, Object value, double scoure) {
        ZSetOperations<String, Object> set = redisTemplate.opsForZSet();
        set.add(key, value, scoure);
    }

    /**
     * 有序集合获取
     *
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public Set<Object> rangeByScore(String key, double scoure, double scoure1) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }

    /**
     * 哈希 删除
     *
     * @param key
     * @param hashKey
     */
    public void hmDel(String key, Object hashKey) {
        HashOperations<String, Object, Object> hash = stringRedisTemplate.opsForHash();
        hash.delete(key, hashKey);
    }

    /**
     * @param key
     * @param key
     * @param val
     */
    public boolean setNX(final String key, final Object val) {
        Boolean flag = (Boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<Object> serializer = redisTemplate.getStringSerializer();
                byte[] serializeKey = serializer.serialize(key);
                byte[] serializeVal = serializer.serialize(val);
                return connection.setNX(serializeKey, serializeVal);
            }
        });
        return flag;
    }


    /**
     * @param key
     * @param value
     * @return
     */
    public boolean setNXStr(final String key, final String value) {
        Object obj = null;
        try {
            obj = redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    StringRedisSerializer serializer = new StringRedisSerializer();
                    Boolean success = connection.setNX(serializer.serialize(key), serializer.serialize(value));
                    connection.close();
                    return success;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj != null ? (Boolean) obj : false;
    }

    public synchronized void unlock(String lockKey) {
        try {
            String expireTime = this.get(lockKey);
            if (expireTime != null && (System.currentTimeMillis() - Long.parseLong(expireTime)) > EXPIRE_PERIOD_MIS) {
                this.remove(lockKey);
                logger.info("解锁成功 lockKey:{}",lockKey);
            }
        }catch (Exception e){
            logger.error("e:{}",e);
        }
    }

    public synchronized boolean unlock(String lockKey, long lockTime) {
        try {
            String expireTime = this.get(lockKey);
            if (expireTime != null && (System.currentTimeMillis() - Long.parseLong(expireTime)) > lockTime) {
                this.remove(lockKey);
                logger.info("解锁成功 lockKey:{}",lockKey);
                return true;
            }
        }catch (Exception e){
            logger.error("e:{}",e);
            return false;
        }
        return false;
    }

    public synchronized boolean lock(String lockKey, long lockTime) throws InterruptedException {
        Boolean flag = (Boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisSerializer serializer = new StringRedisSerializer();
                Boolean success = connection.setNX(serializer.serialize(lockKey), serializer.serialize(String.valueOf(lockTime)));
                connection.close();
                return success;
            }
        });
        //设置超时时间，释放内存
        if (flag){
            stringRedisTemplate.expire(lockKey, lockTime, TimeUnit.MILLISECONDS);
        }
        return flag;
    }

    public synchronized void delLock(String lock) {
        try {
            stringRedisTemplate.delete(lock);
        } catch (Exception e) {

        }
    }

    public Set<String> keys(String key) {
        return stringRedisTemplate.keys(key);
    }

    /**
     * 计数
     * @param key
     * @param ttl
     * @param count
     */
    public void incr(String key, long ttl, int count){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.increment(key , count);
        stringRedisTemplate.expire(key,ttl, TimeUnit.SECONDS);
    }
}
