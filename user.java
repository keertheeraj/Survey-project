package kera;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/users")
public class user extends HttpServlet {
	private final static String query = "select question,anstype from new_table";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
        pw.println("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Sofia\">");
        pw.println("<style>");
        pw.println("body {\r\n"
        		+ "    background-image: url(\"https://images.pexels.com/photos/821649/pexels-photo-821649.jpeg?auto=compress&cs=tinysrgb&w=1600\");\r\n"
        		+ "    background-repeat: no-repeat;\r\n"
        		+ "    background-size: cover;\r\n"
        		+ "  }\r\n"
        		+ "  .h{\r\n"
        		+ "  font-family: \"Sofia\", sans-serif;\r\n"
        		+ "  text-shadow: 3px 3px 3px #ababab;\r\n"
        		+ "  text-align: center;\r\n"
        		+ "  margin: 25px;\r\n"
        		+ "  }");
        pw.println("</style>");
        pw.println("<body class='bg-dark'>");
        pw.println("<h2 class='h' class='text-white text-center'>Survey</h2>");
        pw.println("<div class=\"toast\" role=\"alert\" aria-live=\"assertive\" aria-atomic=\"true\" data-delay=\"3000\">");
        pw.println(" <div class=\"toast-header\">");
        pw.println("<strong class=\"mr-auto\">Notification</strong>");
        pw.println("<button type=\"button\" class=\"ml-2 mb-1 close\" data-dismiss=\"toast\" aria-label=\"Close\">");
        pw.println("<span aria-hidden=\"true\">&times;</span>");
        pw.println("</button>");
        pw.println("</div>");
        pw.println("<div class=\"toast-body\" id=\"notificationContent\">");
        pw.println("</div>");
        pw.println("</div>");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/postques","root","12345");
                PreparedStatement ps = con.prepareStatement(query);){
        	 ResultSet rs = ps.executeQuery();
             while (rs.next()) {
            	 pw.println("<div class='container border border-dark rounded mb-3 bg-light'>");
            	 pw.println("<div class='form-group'>");
            	 pw.println("<p>" + rs.getString(1) + "</p>");
            	 if (rs.getString(2).equals("Yes or No")) {
            	     pw.println("<form action='userresponse' method='post' class='mb-4'>");
            	     pw.println("<div class='form-check'>");
            	     pw.println("<input class='form-check-input' type='radio' name='response' value='yes' id='responseYes'>");
            	     pw.println("<label class='form-check-label' for='responseYes'>Yes</label>");
            	     pw.println("</div>");
            	     pw.println("<div class='form-check'>");
            	     pw.println("<input class='form-check-input' type='radio' name='response' value='no' id='responseNo'>");
            	     pw.println("<label class='form-check-label' for='responseNo'>No</label>");
            	     pw.println("</div>");
            	     pw.println("<button class='btn btn-danger mt-3'>Submit</button>");
            	     
            	     pw.println("</form>");
            	 } else if (rs.getString(2).equals("Text box")) {
            	     pw.println("<form action='userresponse' method='post' class='mb-4'>");
            	     pw.println("<input class='border border-dark rounded form-control' type='text' name='response'>");
            	     pw.println("<button class='btn btn-danger mt-3'>Submit</button>");
            	     pw.println("</form>");
            	 }
            	 pw.println("</div>");
            	 pw.println("</div>");

             }
        	
        } catch (SQLException e) {
			
			e.printStackTrace();
		}
        pw.println("<button class = 'btn btn-danger' style='margin-left:1450px'><a href=\"login.jsp\" class=\" text-white\"><i>Logout</i></a></button>");
        pw.println("</body>");
        String script = "<script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\r\n"
        		+ "  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n"
        		+ "  <script>\r\n"
        		+ "    $(document).ready(function() {\r\n"
        		+ "      var notification = localStorage.getItem('notification');\r\n"
        		+ "\r\n"
        		+ "      if (notification) {\r\n"
        		+ "        $('#notificationContent').text(notification);\r\n"
        		+ "        \r\n"
        		+ "        $('.toast').toast('show');\r\n"
        		+ "        \r\n"
        		+ "        localStorage.removeItem('notification');\r\n"
        		+ "      }\r\n"
        		+ "    });\r\n"
        		+ "  </script>";
        
        pw.println(script);
        
        pw.close();
}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }
    
}
