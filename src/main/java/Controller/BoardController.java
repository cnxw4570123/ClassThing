package Controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.BoardDto;
import service.Bservice;

/**
 * Servlet implementation class BoardController
 */
@WebServlet({"/BoardList", "/BoardWrite", "/BoardInto", "/BoardSearch","/BoardModify", "/BoardUpdate", "/BoardDelete"})
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bservice bsvc = new Bservice();
		String url = request.getServletPath();
		String contextPath = request.getContextPath();
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		BoardDto board = null;
		
		switch(url) {
		case "/BoardList":
			System.out.println("글 목록 페이지 이동 요청");
			// service에 기능 호출
			ArrayList<BoardDto> boardList = bsvc.selectBoardInfo();
			request.setAttribute("boardList", boardList);
			
			//데이터 담아서 전달
			dispatcher = request.getRequestDispatcher("Board/BoardList.jsp");
			dispatcher.forward(request, response);
			break;
			
		case "/BoardWrite":
			System.out.println("글 작성 요청");
			String bwriter = request.getParameter("bwriter");
//			String bwriter = (String)session.getAttribute("uid");
			String btitle = request.getParameter("btitle");
			String bcontent = request.getParameter("bcontent");
			System.out.println("작성자 : " + bwriter + "\n 제목 : " + btitle + "\n 내용 : " + bcontent);
			board = new BoardDto();
			board.setbWriter(bwriter);
			board.setbTitle(btitle);
			board.setbContent(bcontent);
			int insertResult = bsvc.insertBoard(board);
			
			if(insertResult > 0) {
				//글 목록 이동
				response.sendRedirect(contextPath+"/BoardList?msg=" + URLEncoder.encode("새글이 등록되었습니다", "UTF-8"));
			}else {
				response.getWriter().print("<script>");
				response.getWriter().print("alert('글 작성에 실패했습니다.');");
				response.getWriter().print("history.back();");
				response.getWriter().print("</script>");
				// 뒤로가기
			}
			break;
			
		case "/BoardInto":
			System.out.println("글 내용 페이지 요청");
			int bno = Integer.parseInt(request.getParameter("bno"));
			// 1. 글 번호로 select
			System.out.println(bno);
			board = bsvc.selectOneBoard(bno, true);
			request.setAttribute("content", board);
			
			// 2. 해당 글 담긴 페이지로 forwarding
			if(board == null) {
				response.getWriter().print("<script>");
				response.getWriter().print("alert('글 보기에 실패했습니다.');");
				response.getWriter().print("history.back();");
				response.getWriter().print("</script>");
			} else {
				dispatcher = request.getRequestDispatcher("/Board/BoardContent.jsp");
				dispatcher.forward(request, response);
			}
			break;
			
		case "/BoardSearch":
			System.out.println("글 검색 요청");
			String searchType = request.getParameter("searchType");
			String searchText = request.getParameter("searchText");
			System.out.println("글 검색 형태: " + searchType +"\n글 검색 내용 : " + searchText);
			
			// 매개변수에 타입이랑 검색 내용 전달
			boardList = bsvc.selectCertainBoardInfo(searchType, searchText);
			// boardList에 dispatcher로 forwarding
			request.setAttribute("boardList", boardList);
			dispatcher = request.getRequestDispatcher("/Board/BoardList.jsp");
			dispatcher.forward(request, response);
			break;
			
		case "/BoardModify":
			System.out.println("글 수정 요청");
			int mBno = Integer.parseInt(request.getParameter("bno"));
			System.out.println(mBno);
			BoardDto mbContent = bsvc.selectOneBoard(mBno, false);
			
			request.setAttribute("board", mbContent);
			dispatcher = request.getRequestDispatcher("/Board/BoardModify.jsp");
			dispatcher.forward(request, response);
			break;
			
		case "/BoardUpdate":
			System.out.println("글 업데이트 요청");
			int uBno = Integer.parseInt(request.getParameter("bno"));
			String uBtitle = request.getParameter("btitle");
			String uBcontent = request.getParameter("bcontent");
			board = new BoardDto();
			board.setbNo(uBno); board.setbTitle(uBtitle); board.setbContent(uBcontent);
			int updateResult = bsvc.updatePage(board, true);
			if(updateResult > 0) {
				response.sendRedirect(contextPath + "/BoardList");
			} else {
				response.getWriter().print("<script>");
				response.getWriter().print("alert('글 수정에 실패했습니다.');");
				response.getWriter().print("history.back();");
				response.getWriter().print("</script>");
			}
			break;
			
		case "/BoardDelete":
			System.out.println("글 삭제 요청");
			int dBno = Integer.parseInt(request.getParameter("bno"));
			board = new BoardDto();
			board.setbNo(dBno);
			int delRs = bsvc.updatePage(board, false);
			if(delRs > 0) {
				System.out.println("삭제성공");
				response.getWriter().print("<script>");
				response.getWriter().print("alert('글 삭제성공');");
				response.getWriter().print("location.href='"+contextPath+"/BoardList';");
				response.getWriter().print("</script>");
			} else {
				System.out.println("삭제실패");
				response.getWriter().print("<script>");
				response.getWriter().print("alert('글 삭제실패');");
				response.getWriter().print("history.back();");
				response.getWriter().print("</script>");
			}
			break;
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
