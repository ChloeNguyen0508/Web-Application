package controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SurveyServlet")
public class SurveyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Hỗ trợ tiếng Việt
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // 1. Lấy dữ liệu khớp với thuộc tính "name" bên index.html
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String hear = request.getParameter("hear");
        String contactMethod = request.getParameter("contactMethod");

        // Gộp họ và tên
        String fullName = firstName + " " + lastName;

        // 2. Đưa dữ liệu vào request để gửi sang trang JSP
        request.setAttribute("fullName", fullName);
        request.setAttribute("email", email);
        request.setAttribute("dob", dob);
        request.setAttribute("hear", hear);
        request.setAttribute("contactMethod", contactMethod);

        // 3. Chuyển sang file results.jsp (đảm bảo file này nằm trong thư mục webapp)
        // Nếu bạn để results.jsp trong WEB-INF thì sửa thành "/WEB-INF/results.jsp"
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}