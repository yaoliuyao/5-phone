package nfit.phone.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nfit.phone.bean.Phone;
import nfit.phone.dao.PhoneDAO;

@WebServlet("/list")
public class PhoneListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tiaojian = req.getParameter("tiaojian");
		try {
			List<Phone> phones = null;
			
			if (tiaojian == null || tiaojian.equals("")) {
				phones = new PhoneDAO().list();
			} else {
				phones= new PhoneDAO().list(tiaojian);
			}

			req.setAttribute("xxx", phones);
			req.getRequestDispatcher("/jsp/phoneList.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("message", "Error Ocurred.");
			req.getRequestDispatcher("/jsp/message.jsp").forward(req, resp);
		}
	}
}
