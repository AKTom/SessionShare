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

@WebServlet(name = "LoginServlet", urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private SessionHandle<UserVO> sessionHandle = new SessionHandle<UserVO>();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserVO userVO = new UserVO(username, password);
        System.out.println("用户登录信息:" + username + " " + password);
        //检验账户合法性
        //.....
        //检验通过,放入共享session
        sessionHandle.setSessionObject(response, userVO, SessionConstant.SESSION_USER);
        request.setAttribute("user", userVO);
        response.sendRedirect("/messageServlet");
//        request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
