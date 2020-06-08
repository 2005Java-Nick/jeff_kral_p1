package trms.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import trms.model.Reimbursement;

import java.util.List;

public class JsonConverter {
	
	private final Gson gson;
	
	public JsonConverter() {
		gson = new GsonBuilder().create();
	}
	
	public String convertToJson(List<Reimbursement> reimbursementList) {
		JsonArray jarray = gson.toJsonTree(reimbursementList).getAsJsonArray();
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("reimbursements", jarray);
		return jsonObject.toString();
	}
	
	public String convertToJson(Reimbursement reimbursement) {
		return gson.toJson(reimbursement);
	}
}
