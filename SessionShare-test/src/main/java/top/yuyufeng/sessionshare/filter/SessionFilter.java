package top.yuyufeng.sessionshare.filter;

import top.yuyufeng.sessionshare.constant.SessionConstant;
import top.yuyufeng.sessionshare.core.SessionHandle;
import top.yuyufeng.sessionshare.vo.UserVO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "SessionFilter", urlPatterns = "/*")
public class SessionFilter implements Filter {
    private SessionHandle<UserVO> sessionHandle = new SessionHandle<UserVO>();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        UserVO userVO = sessionHandle.getSessionObject((HttpServletRequest) req, SessionConstant.SESSION_USER, UserVO.class);
        req.setAttribute(SessionConstant.SESSION_USER, userVO);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
