
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>게시판</h1>");
		out.println("제목 : " + title + "<p>");
		out.println("작성자 : " + writer + "<p>");
		out.println("작성일 : " + new Date() + "<p>");
		out.println("내용 <br><pre>" + content + "</pre>");
		out.println("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>게시판</h1>");
		out.println("제목 : " + title + "<p>");
		out.println("작성자 : " + writer + "<p>");
		out.println("작성일 : " + new Date() + "<p>");
		out.println("내용 <br><pre>" + content + "</pre>");
		out.println("</body></html>");
		out.close();

	}

}
