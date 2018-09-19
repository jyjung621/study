
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Person")
public class Person extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPro(request, response);
	}

	protected void doPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 *	request.setCharacterEncoding("utf-8");
		 *		-> Parameter 가져올 때 한글 깨짐 방지
		 *
		 *	response.setContentType("text/html;charset=utf-8");
		 *		-> Parameter 보낼때  한글 깨짐 방지
		 */
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String[] notice = request.getParameterValues("notice");
		String job = request.getParameter("job");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>개인정보</h2>");
		out.println("이름 : " + name + "<br>");
		out.println("아이디 : " + id + "<br>");
		out.println("암호 : " + password + "<br>");
		out.println("성별 : " + gender + "<br>");
		out.println("수신메일 : ");
		if (notice != null) {
			for (int i = 0; i < notice.length; i++) {
				out.print(notice[i] + " ");
			}
		} else {
			out.println("없음");
		}
		out.println("<br>직업 : " + job + "<br>");
		out.println("</body></html>");
		out.close();
	}

}
