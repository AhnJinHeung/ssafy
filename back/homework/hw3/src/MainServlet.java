import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.member.dto.MemberDto;
import com.ssafy.member.dto.ProductDto;
import com.ssafy.member.service.MemberServiceImpl;
import com.ssafy.member.service.ProductService;
import com.ssafy.member.service.ProductServiceImpl;

@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		else if ("registerProduct".equals(act)) {
			registerProduct(request, response);
		}
		else if ("searchProduct".equals(act)) {
			searchProduct(request, response);
		}
		else if ("listProduct".equals(act)) {
			listProduct(request, response);
		}
		else if ("deleteProduct".equals(act)) {
			deleteProduct(request, response);
		}
		else if ("modifyProduct".equals(act)) {
			modifyProduct(request, response);
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		
		MemberDto memberDto = MemberServiceImpl.getMemberService().login(userId, userPwd);
		
		String path = "/main.jsp";
		if (memberDto != null) { // 성공
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
		session.invalidate();
		
		response.sendRedirect(request.getContextPath()+"/main.jsp");
	}
	
	protected void registerProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Cookie 설정
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String discription = request.getParameter("discription");
		
		ProductDto productDto = new ProductDto();
		productDto.setDiscription(discription);
		productDto.setName(name);
		productDto.setNum(num);
		productDto.setPrice(price);
		
		ProductService service = ProductServiceImpl.getProductService();
		String path = "/main.jsp";
		try {
			service.registerProduct(productDto);
			setCookie(request, response, productDto);
		} catch (Exception e) {
			System.out.println("상품 등록 중 문제 발생");
		} 
		
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}
	
	protected void setCookie(HttpServletRequest request, HttpServletResponse response, ProductDto productDto) throws ServletException, IOException {
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		
		Cookie cookieNum = new Cookie("lastNum", productDto.getNum());
		cookieNum.setPath(request.getContextPath());
		cookieNum.setMaxAge(60 * 60 * 24 * 365 * 40);
		response.addCookie(cookieNum); // 쿠키 응답페이지에 추가
		
		String name = URLEncoder.encode(productDto.getName(), "utf-8");
		Cookie cookieName = new Cookie("lastName", name);
		cookieName.setPath(request.getContextPath());
		cookieName.setMaxAge(60 * 60 * 24 * 365 * 40);
		response.addCookie(cookieName); // 쿠키 응답페이지에 추가
		
		Cookie cookiePrice = new Cookie("lastPrice", productDto.getPrice());
		cookiePrice.setPath(request.getContextPath());
		cookiePrice.setMaxAge(60 * 60 * 24 * 365 * 40);
		response.addCookie(cookiePrice); // 쿠키 응답페이지에 추가
		
		String discription = URLEncoder.encode(productDto.getDiscription(), "utf-8");
		Cookie cookieDesc = new Cookie("lastDesc", discription);
		cookieDesc.setPath(request.getContextPath());
		cookieDesc.setMaxAge(60 * 60 * 24 * 365 * 40);
		response.addCookie(cookieDesc); // 쿠키 응답페이지에 추가
	}
	
	protected void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		String gubun = request.getParameter("gubun");
		
		List<ProductDto> list = null;
		ProductService service = ProductServiceImpl.getProductService();
		String path = "/searchProduct.jsp";
		
		try {
			list = service.serchProduct(key, gubun);
		} catch (Exception e) {
			System.out.println("상품 검색 중 문제 발생");
		}
		
		request.setAttribute("result", list);
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}
	
	protected void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProductDto> list = null;
		ProductService service = ProductServiceImpl.getProductService();
		String path = "/listProduct.jsp";
		
		try {
			list = service.listProduct();
		} catch (Exception e) {
			System.out.println("상품 목록 생성 중 문제 발생");
		}
		
		request.setAttribute("result", list);
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}
	
	protected void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		
		ProductService service = ProductServiceImpl.getProductService();
		
		try {
			service.deleteProduct(Integer.parseInt(num));
		} catch (Exception e) {
			System.out.println("상품 삭제 중 문제 발생");
		}
		
		response.sendRedirect(request.getContextPath()+"/main.jsp");
	}
	
	protected void modifyProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String discription = request.getParameter("discription");
		
		ProductDto productDto = new ProductDto();
		productDto.setDiscription(discription);
		productDto.setName(name);
		productDto.setNum(num);
		productDto.setPrice(price);
		
		ProductService service = ProductServiceImpl.getProductService();
		
		try {
			service.modifyProduct(productDto);
			setCookie(request, response, productDto);
		} catch (Exception e) {
			System.out.println("상품 수정 중 문제 발생");
		}
		
		response.sendRedirect(request.getContextPath()+"/lastProduct.jsp");
	}
}
