import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.member.dto.MemberDto;

@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		if ("login".equals(act)) {
			login(request, response);
		}
		else if ("logout".equals(act)) {
			logout(request, response);
		}
		else if ("save".equals(act)) {
			save(request, response);
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pass = request.getParameter("userpwd");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto memberDto = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "1234");
			String sql = "select username, email \n";
			sql += "from ssafy_member \n";
			sql += "where userid = ? and userpwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserName(rs.getString("username"));
				memberDto.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		String path = "/main.jsp";
		if (memberDto != null) { // 성공
//			session 설정
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", memberDto);
		}
		else { // 실패
			request.setAttribute("msg", "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		session.removeAttribute("userinfo");
		session.invalidate();
		
		response.sendRedirect(request.getContextPath()+"/main.jsp"); // session은 Redirect or forward 상관 없음
	}
	
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Cookie 설정
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String desc = request.getParameter("desc");
		
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		
		Cookie cookieNum = new Cookie("lastNum", num);
		cookieNum.setPath(request.getContextPath());
		cookieNum.setMaxAge(60 * 60 * 24 * 365 * 40);
		response.addCookie(cookieNum); // 쿠키 응답페이지에 추가
		
		Cookie cookieName = new Cookie("lastName", name);
		cookieName.setPath(request.getContextPath());
		cookieName.setMaxAge(60 * 60 * 24 * 365 * 40);
		response.addCookie(cookieName); // 쿠키 응답페이지에 추가
		
		Cookie cookiePrice = new Cookie("lastPrice", price);
		cookiePrice.setPath(request.getContextPath());
		cookiePrice.setMaxAge(60 * 60 * 24 * 365 * 40);
		response.addCookie(cookiePrice); // 쿠키 응답페이지에 추가
		
		Cookie cookieDesc = new Cookie("lastDesc", desc);
		cookieDesc.setPath(request.getContextPath());
		cookieDesc.setMaxAge(60 * 60 * 24 * 365 * 40);
		response.addCookie(cookieDesc); // 쿠키 응답페이지에 추가
		
		RequestDispatcher disp = request.getRequestDispatcher("/main.jsp");
		disp.forward(request, response);
	}
}
