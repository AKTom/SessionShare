package top.yuyufeng.sessionshare.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie工具
 * @author yuyufeng
 */
public class CookieUtil {
    public static void setCookie(HttpServletResponse httpServletResponse, String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        httpServletResponse.addCookie(cookie);
    }

    public static String getCookieValue(HttpServletRequest httpServletRequest, String cookieName) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies == null) {
            return null;
        }
        for (int i = 0; i < cookies.length; i++) {
            if (cookieName.equals(cookies[i].getName())) {
                return cookies[i].getValue();
            }
        }
        return null;
    }

    public static void deleteCookie(HttpServletResponse httpServletResponse, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        httpServletResponse.addCookie(cookie);
    }

}
