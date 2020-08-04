package nfit.phone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nfit.phone.bean.Phone;
import nfit.phone.dao.PhoneDAO;

@WebServlet("/edit")
public class PhoneEditServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		try {
			Phone phone = new PhoneDAO().get(Integer.parseInt(id));
			req.setAttribute("phone", phone);
			req.getRequestDispatcher("/jsp/phoneEdit.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("message", e.getLocalizedMessage());
			req.getRequestDispatcher("/jsp/message.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		
		try {
			new PhoneDAO().update(Integer.parseInt(id), name, Float.parseFloat(price));
			req.setAttribute("message", "更新成功");
			req.getRequestDispatcher("/jsp/message.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("message", e.getLocalizedMessage());
			req.getRequestDispatcher("/jsp/message.jsp").forward(req, resp);
		}
	}
}
