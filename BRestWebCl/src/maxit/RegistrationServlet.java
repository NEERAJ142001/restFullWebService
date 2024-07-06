package maxit;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@WebServlet("/information")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Print or use the extracted fields
		PrintWriter out = response.getWriter();

//		response.setContentType("text/html;charset=UTF-8");

		try {
			String name = request.getParameter("name");
			String date = request.getParameter("dob");
			String aadhar = request.getParameter("aadhar");
			String address = request.getParameter("address");

			String url = "http://localhost:8080/RestServer/ok/request/getData";

			// Create JSON object with required fields
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("name", name);
			jsonObject.put("date", date);
			jsonObject.put("address", address);
			jsonObject.put("aadhar", aadhar);

			// Create Jersey client and resource
			Client client = Client.create();
			WebResource webResource = client.resource(url);

			// Perform POST request with JSON object in the body
			ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class,
					jsonObject.toString());

			// Process response
			if (clientResponse.getStatus() == 200 ) {
				String jsonResponse = clientResponse.getEntity(String.class);
				JSONObject responseJson = new JSONObject(jsonResponse);

				// Extract fields from response
				String status = responseJson.getString("status");
				String nameFromServer = responseJson.getString("name");
				String dateFromServer = responseJson.getString("date");
				String addressFromServer = responseJson.getString("address");
				String aadharFromServer = responseJson.getString("aadhar");
				int age = responseJson.getInt("age");

				out.println("<html><body>");
				out.println("<h2>Response from Server:</h2>");
				
				out.println("<p>Name: " + nameFromServer + "</p>");
				out.println("<p>Date of Birth: " + dateFromServer + "</p>");
				out.println("<p>Age is : " + age + "</p>");
				out.println("<p>Address: " + addressFromServer + "</p>");
				out.println("<p>Aadhar Number: " + aadharFromServer + "</p>");
				out.println("<p>Status: " + status + "</p>");
				out.println("</body></html>");
			} else {
				out.println("<html><body>");
				out.println("<h2>Server Error ! come back later</h2>");
				out.println("</body></html>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
