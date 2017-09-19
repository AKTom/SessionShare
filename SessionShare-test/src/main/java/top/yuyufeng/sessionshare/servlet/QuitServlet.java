package top.yuyufeng.sessionshare.servlet;

import top.yuyufeng.sessionshare.constant.SessionConstant;
import top.yuyufeng.sessionshare.core.SessionHandle;
import top.yuyufeng.sessionshare.vo.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QuitServlet", urlPatterns = "/quitServlet")
public class QuitServlet extends HttpServlet {
    private SessionHandle<UserVO> sessionHandle = new SessionHandle<UserVO>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sessionHandle.removeSessionObject(request, response, SessionConstant.SESSION_USER);
        response.sendRedirect("/messageServlet");
    }
}
