package fish01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet01_1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String provice = request.getParameter("province");
		System.out.println(provice);
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.write("<?xml version='1.0' encoding='UTF-8'?>");
		printWriter.write("<root>");
		if("广东".equals(provice)) {
			printWriter.write("<city>广州</city>");
			printWriter.write("<city>深圳</city>");
			printWriter.write("<city>中山</city>");
		} else if("湖南".equals(provice)) {
			printWriter.write("<city>长沙</city>");
			printWriter.write("<city>岳阳</city>");
			printWriter.write("<city>湘潭</city>");
		}
		printWriter.write("</root>");
		System.out.println("111111111111");
		printWriter.flush();
		printWriter.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
