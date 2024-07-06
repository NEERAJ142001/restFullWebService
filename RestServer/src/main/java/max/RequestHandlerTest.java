package max;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;

import max.bean.Customer;
import max.services.ServiceClass;

@Path("request")
public class RequestHandlerTest {

	@POST
	@Path("getData")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject fetch(String Userdata) {
		JSONObject response = new JSONObject();

		try {
			JSONObject jsonObject = new JSONObject(Userdata);
			String name = jsonObject.getString("name");
			String dob = jsonObject.getString("date");
			String address = jsonObject.getString("address");
			String aadhar = jsonObject.getString("aadhar");

			// Create Customer object and invoke service class
			Customer customer = new Customer();
			customer.setAadhar(aadhar);
			customer.setAddress(address);
			customer.setDob(dob);
			customer.setName(name);

			ServiceClass serviceClass = new ServiceClass();
			String res = serviceClass.isEligible(customer);
			int age = serviceClass.ageFinder(customer.getDob());

			// Add all fields to the response
			response.put("name", name);
			response.put("date", dob);
			response.put("address", address);
			response.put("aadhar", aadhar);
			response.put("age", age);
			response.put("status", res);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;
	}
}
