package top.yuyufeng.sessionshare.core;


import top.yuyufeng.sessionshare.constant.SessionConstant;
import top.yuyufeng.sessionshare.util.CookieUtil;
import top.yuyufeng.sessionshare.util.JedisUtil;
import top.yuyufeng.sessionshare.util.UUIDUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Seession处理类
 * Created by yuyufeng on 2017/8/2.
 */
public class SessionHandle<T> {

    //采用单点登录
    public T getSessionObject(HttpServletRequest httpServletRequest, String sessionKey, Class clazz) {
        //使用cookie获取 原Seession的key
        String cookieValue = CookieUtil.getCookieValue(httpServletRequest, sessionKey);
        if (cookieValue == null) {
            return null;
        }
        T t = null;
        try {
            //使用redis获取原cookie的value
            t = JedisUtil.getObject(SessionConstant.SESSION_PREFIX + cookieValue, clazz);
        } catch (Exception e) {
            System.out.println("从redis获取用户失败 " + e);
        }
        return t;
    }

    public void setSessionObject(HttpServletResponse httpServletResponse, T t, String sessionKey) {
        String uuid = UUIDUtil.getUUIDString();
        //使用cookie存储 原Seession的key
        CookieUtil.setCookie(httpServletResponse, sessionKey, uuid);
        //使用redis存储原cookie的value
        JedisUtil.setObject(SessionConstant.SESSION_PREFIX + uuid, t, 60000 * 30);
    }

    public void removeSessionObject(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String sessionKey) {
        String cookieValue = CookieUtil.getCookieValue(httpServletRequest, sessionKey);
        if (cookieValue != null && cookieValue.length() > 0) {
            try {
                //删除redis记录的session value
                JedisUtil.remove(SessionConstant.SESSION_PREFIX + cookieValue);
            } catch (Exception e) {
                System.out.println("从redis删除用户失败 " + e);
            }
        }
        //删除cookie记录的session key
        CookieUtil.deleteCookie(httpServletResponse, sessionKey);
    }


}
