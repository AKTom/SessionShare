package top.yuyufeng.sessionshare.servlet;

import top.yuyufeng.sessionshare.constant.SessionConstant;
import top.yuyufeng.sessionshare.core.SessionHandler;
import top.yuyufeng.sessionshare.vo.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QuitServlet", urlPatterns = "/quitServlet")
public class QuitServlet extends HttpServlet {
    private SessionHandler<UserVO> sessionHandle = new SessionHandler<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sessionHandle.removeSessionObject(request, response, SessionConstant.SESSION_USER);
        response.sendRedirect("/messageServlet");
    }
}
