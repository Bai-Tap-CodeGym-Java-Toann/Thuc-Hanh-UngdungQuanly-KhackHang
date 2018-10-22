package toandz.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher rq = request.getRequestDispatcher("/login.jsp");
        boolean accoutCheck = username.equals("admin") && password.equals("123456");
        if (accoutCheck) {
            request.setAttribute("action", "list");
            rq.forward(request,response);
        } else {
            String error = "Tài khoản hoặc mật khẩu không khớp";
            request.setAttribute("error", error);
            rq.forward(request, response);
        }
    }
}
