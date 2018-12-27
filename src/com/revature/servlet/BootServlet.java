package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bean.Boot;
import com.revature.service.BootService;

/**
 * Servlet implementation class BootServlet
 */
@WebServlet({ "/BootServlet", "/boot" })
public class BootServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BootService bs;
	private ObjectMapper om;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BootServlet() {
		super();
		bs = new BootService();
		om = new ObjectMapper();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("id");
		if (idString != null) {
			try {
				int bootId = Integer.parseInt(idString);
				Boot boot = bs.getBootById(bootId);
				if (boot != null) {
					response.getWriter().write(om.writeValueAsString(boot));
				} else {
					response.getWriter().write("Boot not Found");
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
				response.getWriter().write("Invalid Request!");
			}
		} else {
			List<Boot> bootList = bs.getAllBoots();
			response.getWriter().write(om.writeValueAsString(bootList));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (bs.addBoot(om.readValue(request.getReader(), Boot.class))) {
				response.getWriter().write("Boot Added");
			} else {
				response.getWriter().write("Failed to Add Boot");
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			response.getWriter().write("Invalid Request");
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
