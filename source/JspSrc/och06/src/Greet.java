
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Greet")
public class Greet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter log;
	
	public Greet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		try {
			log = new PrintWriter(new FileWriter("c:/DevEnv/JSP/log/log.txt",true));
		} catch (Exception e) {
			System.out.println("헐....이게무슨...");
		}
	}

	public void destroy() {
		if(log != null) {
			log.println("------------- Destroy ----------------");
			log.close();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String msg = name + "님 반가워요 \r\n";
		
		GregorianCalendar gc = new GregorianCalendar();
		String date = String.format("%TF %TT\r\n", gc, gc);
		log.println(date + msg);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>인사</h2>" + msg);
		out.println("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
