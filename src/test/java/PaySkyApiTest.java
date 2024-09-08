import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class PaySkyApiTest {

private static final String BASE_URL = "https://reqres.in/";
    private static final String CREATE_USER_API_URL = BASE_URL + "api/users";

    public static void main(String[] args) {
        RestAssured.baseURI = BASE_URL;
        addUser();
    }

    private static int addUser() {
        // Prepare the request
        RequestSpecification request = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(createUserJSON());

        // Send the POST request
        Response response = request.post(CREATE_USER_API_URL);

        // Print the response body
        String responseBody = response.getBody().asString();
        System.out.println("Response: " + responseBody);

        // Assert response status code
        if (response.getStatusCode() == 201) {
            JSONObject jsonResponse = new JSONObject(responseBody);

            // Validate response body contains required data
            if (jsonResponse.has("id") && jsonResponse.has("first_name") && jsonResponse.has("job")) {
                int id = jsonResponse.getInt("id");
                String name = jsonResponse.getString("first_name") +" "+jsonResponse.getString("last_name") ;
                String job = jsonResponse.getString("job");
                String email = jsonResponse.getString("email");
                System.out.println("Created User ID: " + id);
                System.out.println("Created User Name: " + name);
                System.out.println("Created User Job: " + job);
                return id;
            } else {
                System.out.println("Response body does not contain required fields.");
            }
        } else {
            System.out.println("Failed to add candidate. Status code: " + response.getStatusCode());
        }
        return -1;
    }

    private static String createUserJSON() {
        // Create JSON object with correct fields
        return new JSONObject()
                .put("first_name", "John")
                .put("last_name", "Doe")
                .put("email", "john_doe@test.com")
                .put("job", "Software Engineer")
                .put("avatar", "https://reqres.in/img/faces/1-image.jpg")
                .toString();
    }


}

