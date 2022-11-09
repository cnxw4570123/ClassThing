package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDto;
import service.Mservice;

/**
 * Servlet implementation class MemberController
 */
@WebServlet({"/MemberController", "/MemberLogin", "/MemberJoin" , "/MemberIdCheck", "/MemberLogout"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		Mservice msvc = new Mservice();
		String contextPath = request.getContextPath();
		switch(url) {
		case "/MemberJoin":
			System.out.println("회원가입 기능 호출");
			String mid = request.getParameter("mid");
			String mpw = request.getParameter("mpw");
			String mname = request.getParameter("mname");
			String maddr = request.getParameter("maddr");
			String mbirth = request.getParameter("mbirth");
			String memail = request.getParameter("meid") + "@"+request.getParameter("mdomain");
			System.out.println(memail);
			MemberDto member = new MemberDto(mid, mpw, mname, mbirth, maddr, memail, "0");
			
			int insertResult = msvc.insertMemberInfo(member);
			if(insertResult > 0) {
				response.sendRedirect("MainPage.jsp");
			} else {
				response.getWriter().print("<script>");
				response.getWriter().print("alert('회원가입에 실패했습니다');");
				response.getWriter().print("history.back();");
				response.getWriter().print("</script>");
			}
			break;
			
		case "/MemberLogin":
			System.out.print("로그인 기능 호출");
			String logMemId = request.getParameter("mid");
			String logMemPw = request.getParameter("mpw");
			
			String lgResult = msvc.selectMemberInfo(logMemId, logMemPw); 
			
			if(lgResult != null) {
				System.out.println("성공");
				session.setAttribute("uid", lgResult);
				response.sendRedirect("BoardList");
			}else {
				System.out.println("실패");
				response.getWriter().print("<script>");
				response.getWriter().print("alert('로그인 실패');");
				response.getWriter().print("history.back();");
				response.getWriter().print("<script>");
			}
			break;
			
		case "/MemberLogout":
//			session.removeAttribute("uid");
			session.invalidate();
			response.sendRedirect(contextPath + "/MainPage.jsp");
			break;
			
		case "/MemberIdCheck":
			System.out.println("아이디 중복 요청");
			String inputId = request.getParameter("inputId");
			System.out.println("중복 확인할 아이디 : " + inputId);
			String checkResult = msvc.selectIdCheck(inputId);
			response.getWriter().print(checkResult);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
