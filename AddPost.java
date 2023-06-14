package kera;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddPost")
public class AddPost extends HttpServlet {
	
	private final static String query = "insert into new_table(question,anstype) values(?,?)";
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
        pw.println("<h3 class='h' style='margin-top:75px'>Posted Successfully</h3>");
        pw.println("<button class = \"btn btn-danger\" style='margin-left:900px'><a href='demoaddPost.jsp' class=\" text-white\"><i>Back</i></a></button>");
        pw.println("<button class = \"btn btn-danger\" ><a href=\"login.jsp\" class=\" text-white\"><i>Logout</i></a></button>");
        String question = req.getParameter("question");
        String anstype = req.getParameter("anstype");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/postques","root","12345");
                PreparedStatement ps = con.prepareStatement(query);){
                ps.setString(1, question);
                ps.setString(2, anstype);
                int count = ps.executeUpdate();
                if(count==1) {
                    System.out.println("inserted");
                }else {
                    System.out.println("not inserted");
                }
        }catch(SQLException se) {
            pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        pw.println("</body>");
}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }

}
