

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addProduct
 */
@WebServlet("/addProduct.do")
public class addProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String explan = request.getParameter("explan");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("	<div align=\"center\">");
		out.println("		상품<font color=\"red\">("+name+")</font>이 등록되었습니다.<br> 가격: "+price+"원<br>설명: "+explan+"<br>");
		out.println("	</div>");
		out.println("	</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String explan = request.getParameter("explan");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("	<div align=\"center\">");
		out.println("		상품<font color=\"red\">("+name+")</font>이 등록되었습니다.<br> 가격: "+price+"원<br>설명: "+explan+"<br>");
		out.println("	</div>");
		out.println("	</body>");
		out.println("</html>");
	}

}
