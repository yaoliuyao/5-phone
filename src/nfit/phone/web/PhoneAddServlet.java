package nfit.phone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nfit.phone.dao.PhoneDAO;

@WebServlet("/add")
public class PhoneAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String price = req.getParameter("price");

		if (name == null || price == null) {
			req.setAttribute("message", "参数不对");
			req.getRequestDispatcher("/jsp/message.jsp").forward(req, resp);
			return;
		}

		try {
			new PhoneDAO().insert(name, Float.parseFloat(price));

			req.setAttribute("message", "保存成功");
			req.getRequestDispatcher("/jsp/message.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("message", e.getLocalizedMessage());
			req.getRequestDispatcher("/jsp/message.jsp").forward(req, resp);
		}
	}
}
