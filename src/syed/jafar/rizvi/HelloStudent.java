package syed.jafar.rizvi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
        
        Map<String,String[]> map = request.getParameterMap();
        Set<String> keys = map.keySet();
        
          
        out.println("Student Name: " + name + "<br>");
        out.println("Student Score: " + Score + "<br>");
        out.println("Student Attendance: " + Attendance + "<br>");
        out.println("Student Grade: " + Grade + "<br>");
        out.println("all the keys are: " + keys.toString() + "<br>");
        
        for (String parameterName :keys) {
            String[] values = map.get(parameterName);
            if (values != null && values.length > 0) {
            	out.println(parameterName + ": " + values[0] + "<br>");
              
            } 
          }
        
        out.println("REQUEST INFO FROM REQUEST OBJECT" + "<br>");
        out.println("Method: " + request.getMethod() + "<br>");
        out.println("Request URI: " + request.getRequestURI() + "<br>");
        out.println("Protocol: " + request.getProtocol() + "<br>");
        out.println("PathInfo: " + request.getPathInfo() + "<br>");
        out.println("Remote Address: " + request.getRemoteAddr() + "<br>");
        out.println("REQUEST HEADER INFO" + "<br>");
        Enumeration e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String nameH = (String)e.nextElement();
            String valueH = request.getHeader(nameH);
            out.println(nameH + " = " + valueH + "<br>");
        }
        
        // set a cookie

        String cname = "userName";
        String cvalue ="sbaqirnaqvi";
        String passw ="password";
        String passwval = "baqir1234567";
       
         Cookie c1 = new Cookie(cname, cvalue);
         Cookie c2 = new Cookie(passw, passwval);
         response.addCookie(c1);
         response.addCookie(c2);
        
    
     // print out cookies

        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie c = cookies[i];
            String name2 = c.getName();
            String value2 = c.getValue();
            out.println(name2 + " = " + value2  + "<br>");
        }

        
        out.println("<a href=\"http://localhost:8080/HelloWorldJafar/StudentRegForm.html\">Student Registration Form</a>");
        //out.println("<a href="+"http://localhost:8080/HelloWorldJafar/StudentRegForm.html"+"> Student Registration Form" + "</a>");
        out.println("</body>");       
        out.println("</html>");
        //response.sendRedirect("http://www.google.com");
        String studentRecord =  name + " " + Score + " " + Grade + " " + Attendance + "\n" +;  
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
