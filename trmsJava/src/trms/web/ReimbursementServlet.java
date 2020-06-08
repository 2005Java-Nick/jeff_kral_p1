package trms.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import trms.dao.ReimbursementDAO;
import trms.model.Reimbursement;
import trms.util.JsonConverter;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/reimbursements")
public class ReimbursementServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ReimbursementDAO reimbursementDAO;
	
	@Override
	public void init() {
		reimbursementDAO = new ReimbursementDAO();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);
		reimbursementDAO.insertReimbursement(reimbursement);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Reimbursement> allReimbursements = reimbursementDAO.getAllReimbursements();
		resp.setContentType("application/json;charset=UTF-8");
		resp.addHeader("Access-Control-Allow-Origin", "*");
		ServletOutputStream out = resp.getOutputStream();
		JsonConverter converter = new JsonConverter();
		String output = converter.convertToJson(allReimbursements);
		System.out.print("Output " + output);
		out.print(output);
	}
	
}