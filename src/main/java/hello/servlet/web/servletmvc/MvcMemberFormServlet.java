package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath); // controller -> view 이동
        dispatcher.forward(req, resp); // 다른 서블릿이나 jsp로 이동할 수 있음
        //redirect - 클라이언트에 응답이 나갔다가 클라이언트가 다시 redirect 경로로 요청 (클라이언트가 인지 o, URL 경로도 변경)
        //forward - 서버 내부에서 다른 서블릿이나 jsp로 이동한 후 최종 반환 (클라이언트가 인지 x)
    }
}
