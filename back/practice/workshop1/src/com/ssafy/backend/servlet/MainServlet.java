package com.ssafy.backend.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ssafy.backend.dto.Book;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.
@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * get 방식의 요청에 대해 응답하는 메서드이다.
     * front controller pattern을 적용하기 위해 내부적으로 process를 호출한다.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    /**
     * post 방식의 요청에 대해 응답하는 메서드이다.
     * front controller pattern을 적용하기 위해 내부적으로 process를 호출한다.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // post 요청 시 한글 파라미터의 처리를 위해 encoding을 처리한다.
        request.setCharacterEncoding("utf-8");
        process(request, response);
    }

    /**
     * request 객체에서 action 파라미터를 추출해서 실제 비지니스 로직 메서드(ex: doRegist) 
     * 호출해준다.
     */
    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // request에서 action을 추출해서 실제 비지니스 로직 메서드를 호출한다.
        String action = request.getParameter("action");
        switch (action) {
            case "regist":
                doRegist(request, response);
                break;
        }
    }
    
    /**
     * 도서 정보를 등록하기 위해 파라미터가 잘 전달되는지 확인하고 전달 결과를 화면에 출력한다.
     * 이를 위해 request에서 Book의 내용을 추출해서 Book 객체를 생성한 후 response로 출력한다.
     * 특히 response 시 content의 형식에 주의한다.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doRegist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // request 객체에서 전달된 parameter를 추출한다.
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        // 문자열로 전달된 price는 숫자로 변경해준다.
        int price = Integer.parseInt(request.getParameter("price"));
        String desc = request.getParameter("desc");
        // 전달된 파라미터를 이용해서 Book 객체를 생성한다.
        Book book = new Book(isbn, title, author, price, desc);

        // 화면에 출력할 데이터를 구성한다. 이때 String 대신 StringBuilder를 사용한다.
        StringBuilder output = new StringBuilder();
        // html 태그가 적용되어야 하며 한글이 원활이 표현될 수 있도록 응답의 형태를 설정한다.
        response.setContentType("text/html; charset=UTF-8");
        output.append("<html><body>")
                .append("<h1>입력 내용</h1>")
                .append(book)
                .append("</body></html>");
        // response 객체를 통해서 생성된 html 코드를 출력한다.
        response.getWriter().write(output.toString());
    }
}
