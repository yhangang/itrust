package com.itrust.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class AjaxUtil {
	/**
	 * ��json���ݴ��䵽ǰ̨
	 * @param response
	 * @param json
	 */
	public static void transferJson(HttpServletResponse response,String json){
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
