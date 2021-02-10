package syed.jafar.rizvi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloJafar
 */
@WebServlet("/HelloJafar")
public class HelloJafar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloJafar() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Registration Form</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Student Registration Form </h1>");
        out.println("<form>");
        out.println(" <label for=\"name\">Name:</label><br>");
        out.println("<input type=\"text\" id=\"name\" name=\"name\"><br>");
        out.println("<label for=\"Score\">Score:</label><br>");
        out.println("<input type=\"text\" id=\"Score\" name=\"Score\"><br>");
        out.println("<label for=\"Attendance\">Attendance:</label><br>");
        out.println("<input type=\"text\" id=\"Attendance\"name=\"Attendance\"><br>");
        out.println("<label for=\"Grade\">Grade:</label><br>");
        out.println("<input type=\"text\" id=\"Grade\"name=\"Grade\"><br>");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>");       
        String name = request.getParameter("name");
        String Score = request.getParameter("Score");
        String Attendance = request.getParameter("Attendance");
        String Grade = request.getParameter("Grade");
        out.println(name + "<br>");
        out.println(Score + "<br>");
        out.println(Attendance + "<br>");
        out.println(Grade + "<br>");
        out.println("</body>");
        out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
