import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Run extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		res.setContentType("text/html");
		//String path=req.getServletContext().getRealPath("/");
		PrintWriter jspout=res.getWriter();
		String filename=req.getParameter("className").trim();
		String command="C:\\Program Files\\Java\\jdk1.8.0_171\\bin\\java "+filename;
		Process out=Runtime.getRuntime().exec(command);
		try{
			out.waitFor();
			BufferedReader output=new BufferedReader(new InputStreamReader(out.getInputStream()));
			BufferedReader error=new BufferedReader(new InputStreamReader(out.getErrorStream()));

			String result="";
			String result1="";
			while(true){
				String temp=output.readLine();
				if(temp!=null)
				{
					result+=temp;
					result+="\n";
				}
				else
				{
					break;
				}
			}
			while(true){
				String temp=error.readLine();
				if(temp!=null){
					result1+=temp;
				}
				else{
					break;
				}
			}
	jspout.println(result+"\n"+result1);
	output.close();
	error.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
