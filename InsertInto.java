package student_opts;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class InsertInto extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
	    int id = Integer.parseInt(req.getParameter("studentId"));
	    String nameString = req.getParameter("studentName");
		int mob = Integer.parseInt(req.getParameter("studentNumber"));
		PrintWriter out;
		try {
			out = res.getWriter();
			
			ConnectionClass c = new ConnectionClass();
			Connection con = c.doConnect();
			if(con == null)
				system.out.println("con is null");
			PreparedStatement query = con.prepareStatement("insert into student_info values(?,?,?)");
			query.setInt(1,id);
			query.setString(2,nameString);
			query.setInt(3,mob);
			query.executeUpdate();
			out.println("Saved.....");
		}  
		catch (IOException | SQLException | NullPointerException e) {
			e.printStackTrace();
		}
	}
}
