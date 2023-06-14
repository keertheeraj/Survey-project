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
@WebServlet("/userdata")
public class showUsersData extends HttpServlet {
	private final static String query2 = "select question from new_table";
	private final static String query3 = "select response from user_response";
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
        pw.println("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n"
        		+ "  <div class=\"container\">\r\n"
        		+ "    <a class=\"navbar-brand\" href=\"welcome.jsp\">Admin</a>\r\n"
        		+ "    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
        		+ "      <span class=\"navbar-toggler-icon\"></span>\r\n"
        		+ "    </button>\r\n"
        		+ "    <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n"
        		+ "      <ul class=\"navbar-nav\">\r\n"
        		+ "        <li class=\"nav-item\">\r\n"
        		+ "          <a class=\"nav-link\" href=\"demoaddPost.jsp\">Publish Survey</a>\r\n"
        		+ "        </li>\r\n"
        		+ "        <li class=\"nav-item\">\r\n"
        		+ "          <a class=\"nav-link\" href=\"userdata\">User Response</a>\r\n"
        		+ "        </li>\r\n"
        		+ "        <li class=\"nav-item\">\r\n"
        		+ "          <a class=\"nav-link\" href=\"show\">Posted Surveys</a>\r\n"
        		+ "        </li>\r\n"
        		+ "      </ul>\r\n"
        		+ "    </div>\r\n"
        		+ "    <a href=\"login.jsp\" class=\"btn btn-danger ml-auto\">Logout</a>\r\n"
        		+ "  </div>\r\n"
        		+ "</nav>");
        pw.println("<h2 class='h' class='text-white text-center'>Survey Data</h2>");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/postques","root","12345");
                PreparedStatement ps = con.prepareStatement(query2);
        		PreparedStatement px = con.prepareStatement(query3);){
            ResultSet rs = ps.executeQuery();
            ResultSet rx = px.executeQuery();
            pw.println("<div style='margin:auto;width:1500px;margin-top:70px;'>");
            pw.println("<table class='bg-light rounded table-bordered table table-hover table-striped'>");
            pw.println("<tr>");
            while(rs.next()) {
            	pw.println("<th class='text-center p-3'>"+rs.getString(1)+"</th>");
            }
            pw.println("</tr>");
            pw.println("<tr>");
            while(rx.next()) {
            	pw.println("<td class='text-center p-4'>"+rx.getString(1)+"</td>");
            }
            pw.println("</tr>");
            pw.println("</table>");
        }catch(SQLException se) {
            pw.println("<h2>"+se.getMessage()+"</h2>");
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        pw.println("</div>");
        pw.println("</body>");
        pw.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }
}
