package top.yuyufeng.sessionshare.filter;

import top.yuyufeng.sessionshare.constant.SessionConstant;
import top.yuyufeng.sessionshare.core.SessionHandler;
import top.yuyufeng.sessionshare.vo.UserVO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "SessionFilter", urlPatterns = "/*")
public class SessionFilter implements Filter {
    private SessionHandler<UserVO> sessionHandle = new SessionHandler<UserVO>();
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        UserVO userVO = sessionHandle.getSessionObject((HttpServletRequest) req, SessionConstant.SESSION_USER, UserVO.class);
        req.setAttribute(SessionConstant.SESSION_USER, userVO);
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
