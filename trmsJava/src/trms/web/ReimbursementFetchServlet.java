package trms.web;

import trms.dao.ReimbursementDAO;
import trms.model.Reimbursement;
import trms.util.JsonConverter;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import trms.util.*;

@WebServlet("/fetch")
public class ReimbursementFetchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ReimbursementDAO reimbursementDAO;

	@Override
	public void init() {
		reimbursementDAO = new ReimbursementDAO();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Reimbursement reimbursement = reimbursementDAO.findById(Integer.parseInt(req.getParameter("id")));
		resp.setContentType("application/json;charset=UTF-8");
		resp.addHeader("Access-Control-Allow-Origin", "*");
		ServletOutputStream out = resp.getOutputStream();
		JsonConverter converter = new JsonConverter();
		String output = converter.convertToJson(reimbursement);
		System.out.print("Output " + output);
		out.print(output);
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		boolean isDeleted = reimbursementDAO.deleteReimbursement(Integer.parseInt(req.getParameter("id")));
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS,  DELETE");
		resp.setHeader("Access-Control-Allow-Headers", "Authorization,Content-Type, x-requested-with, Accept");
		resp.setHeader("Access-Control-Max-Age", "3600");
		ServletOutputStream out = resp.getOutputStream();
		System.out.print("Output " + isDeleted);
		out.print(isDeleted);
	}

	@Override
	public void doOptions(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		boolean isDelete = Utils.isMatch("DELETE", req);
		boolean isPut = Utils.isMatch("POST", req);
		if (isDelete) {
			doDelete(req, resp);
		} else if (isPut) {
			doPost(req, resp);
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);

		int id = Integer.parseInt(req.getParameter("id"));
		boolean isUpdated = reimbursementDAO.updateReimbursement(id, reimbursement);
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS,  DELETE");
		resp.setHeader("Access-Control-Allow-Headers", "Authorization,Content-Type, x-requested-with, Accept");
		resp.setHeader("Access-Control-Max-Age", "3600");
		ServletOutputStream out = resp.getOutputStream();
		System.out.print("Output " + isUpdated);
		out.print(isUpdated);
	}

}