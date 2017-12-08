package top.yuyufeng.sessionshare.servlet;

import top.yuyufeng.sessionshare.core.SessionHandler;
import top.yuyufeng.sessionshare.vo.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuyufeng
 */
@WebServlet(name = "MessageServlet", urlPatterns = "/messageServlet")
public class MessageServlet extends HttpServlet {
    private SessionHandler<UserVO> sessionHandle = new SessionHandler<UserVO>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
    }
}
