package top.yuyufeng.sessionshare.util;

import redis.clients.jedis.Jedis;

/**
 * 简单jedis封装
 *
 * @author yuyufeng
 * @param <T>
 */
public class JedisUtil<T> {
    private static Jedis jedis;

    public static void init(Jedis jedis) {
        jedis =  jedis;
    }

    public static void setObject(String key, Object object, int expire) {
        jedis.setex(key.getBytes(), expire, ProtostuffUtil.serializer(object));
    }

    public static <T> T getObject(String key, Class clazz) {
        Object object = ProtostuffUtil.deserializer(jedis.get(key.getBytes()), clazz);
        return (T) object;
    }

    public static void remove(String cookieValue) {
        jedis.del(cookieValue);
    }
}
