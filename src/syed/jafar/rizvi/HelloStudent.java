package syed.jafar.rizvi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import syed.baqar.naqvi.StudentFileData;

/**
 * Servlet implementation class HelloStudent
 */
@WebServlet("/HelloStudent")
public class HelloStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Registration Form</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>New Student Registration </h1>");
              
        String name = request.getParameter("Studentname");
        String Score = request.getParameter("StudentScore");
        String Attendance = request.getParameter("StudentAttendance");
        String Grade = request.getParameter("StudentGrade");
        out.println("Student Name: " + name + "<br>");
        out.println("Student Score: " + Score + "<br>");
        out.println("Student Attendance: " + Attendance + "<br>");
        out.println("Student Grade: " + Grade + "<br>");
        out.println("<a href=\"http://localhost:8080/HelloWorldJafar/StudentRegForm.html\">Student Registration Form</a>");
        //out.println("<a href="+"http://localhost:8080/HelloWorldJafar/StudentRegForm.html"+"> Student Registration Form" + "</a>");
        out.println("</body>");       
        out.println("</html>");
        //response.sendRedirect("http://www.google.com");
        String studentRecord = name + " " + Score + " " + Grade + " " + Attendance + "\n";  
        StudentFileData.Writefile(StudentFileData.FILE_PATH , StudentFileData.FILE_NAME, studentRecord);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
