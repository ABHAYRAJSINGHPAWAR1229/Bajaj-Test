package Q2.Q2;
//
///**
// * Hello world!
// *
// */
//public class App 
//{
//    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//    }
//}
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;

public class App {

    private static final String API_ENDPOINT = "https://bfhldevapigw.healthrx.co.in/automation-campus/create/user";
    
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";

    public static void main(String[] args) throws IOException, JSONException {
        HttpClient client = HttpClientBuilder.create().build();

        // Test Case 1: Successful User Creation
        testSuccessfulUserCreation(client);

        

        // Test Case 3: Duplicate Phone Number
        testDuplicatePhoneNumber(client);

        // Test Case 4: Duplicate Email ID
        testDuplicateEmailId(client);

        // Test Case 5: Missing Required Field in Body (firstName)
        testMissingRequiredFieldInBodyFirstName(client);

        // Test Case 6: Missing Required Field in Body (lastName)
        testMissingRequiredFieldInBodyLastName(client);

        // Test Case 7: Missing Required Field in Body (phoneNumber)
        testMissingRequiredFieldInBodyPhoneNumber(client);

        // Test Case 8: Missing Required Field in Body (emailId)
        testMissingRequiredFieldInBodyEmailId(client);

        // Test Case 9: Invalid Phone Number Format
        testInvalidPhoneNumberFormat(client);

        // Test Case 10: Invalid Email ID Format
        testInvalidEmailIdFormat(client);
    }

    private static void testSuccessfulUserCreation(HttpClient client) throws IOException, JSONException {
        HttpPost post = new HttpPost(API_ENDPOINT);
       
        post.setHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON);

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstName", "Abhay");
        requestBody.put("lastName", "Singh");
        
        requestBody.put("phoneNumber", 873780124);
        
        requestBody.put("emailId", "abhayrajsinghpawar.cdac.com");

        StringEntity entity = new StringEntity(requestBody.toString());
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Test Case 1: Successful User Creation - Expected 201, Got " + statusCode);
        assert statusCode == 201;
    }

  

    private static void testDuplicatePhoneNumber(HttpClient client) throws IOException, JSONException {
        HttpPost post = new HttpPost(API_ENDPOINT);
        
        post.setHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON);

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstName", "Abhy");
        requestBody.put("lastName", "Sigh");
        
        requestBody.put("phoneNumber", 8737805);
        requestBody.put("emailId", "abhayrajsinghpawa.cdac.com");

        StringEntity entity = new StringEntity(requestBody.toString());
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Test Case 3: Duplicate Phone Number - Expected 400, Got " + statusCode);
        assert statusCode == 400;
    }

    private static void testDuplicateEmailId(HttpClient client) throws IOException, JSONException {
        HttpPost post = new HttpPost(API_ENDPOINT);
       
        post.setHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON);

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstName", "Abhay");
        requestBody.put("lastName", "Singh");
        
        requestBody.put("phoneNumber", 873780126);
        requestBody.put("emailId", "abhayrajsinghpawar.cdac.com");

        StringEntity entity = new StringEntity(requestBody.toString());
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Test Case 4: Duplicate Email ID - Expected 400, Got " + statusCode);
        assert statusCode == 400;
    }

    private static void testMissingRequiredFieldInBodyFirstName(HttpClient client) throws IOException, JSONException {
        HttpPost post = new HttpPost(API_ENDPOINT);
        
        post.setHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON);

        JSONObject requestBody = new JSONObject();
//        requestBody.put("firstName", "Abhay");
        requestBody.put("lastName", "Singh");
        
        requestBody.put("phoneNumber", 873780127);
        requestBody.put("emailId", "abhayrajsinghpawar.cdac.com");

        StringEntity entity = new StringEntity(requestBody.toString());
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Test Case 5: Missing Required Field in Body (firstName) - Expected 400, Got " + statusCode);
        assert statusCode == 400;
    }

    private static void testMissingRequiredFieldInBodyLastName(HttpClient client) throws IOException, JSONException {
        HttpPost post = new HttpPost(API_ENDPOINT);
      
        post.setHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON);

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstName", "Abhay");
//        requestBody.put("lastName", "Singh");
        
        requestBody.put("phoneNumber", 873780128);
        requestBody.put("emailId", "abhayrajsinghpawar.cdac.com");

        StringEntity entity = new StringEntity(requestBody.toString());
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Test Case 6: Missing Required Field in Body (lastName) - Expected 400, Got " + statusCode);
        assert statusCode == 400;
    }

    private static void testMissingRequiredFieldInBodyPhoneNumber(HttpClient client) throws IOException, JSONException {
        HttpPost post = new HttpPost(API_ENDPOINT);
        
        post.setHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON);

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstName", "Abhay");
        requestBody.put("lastName", "Singh");
//        requestBody.put("phoneNumber", 873780134);
        requestBody.put("emailId", "abhayrajsinghpawar.cdac.com");

        StringEntity entity = new StringEntity(requestBody.toString());
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Test Case 7: Missing Required Field in Body (phoneNumber) - Expected 400, Got " + statusCode);
        assert statusCode == 400;
    }

    private static void testMissingRequiredFieldInBodyEmailId(HttpClient client) throws IOException, JSONException {
        HttpPost post = new HttpPost(API_ENDPOINT);
        
        post.setHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON);

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstName", "Abhay");
        requestBody.put("lastName", "Singh");
        
        requestBody.put("phoneNumber", 873780135);
//        requestBody.put("emailId", "abhayrajsinghpawar.cdac.com");

        StringEntity entity = new StringEntity(requestBody.toString());
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Test Case 8: Missing Required Field in Body (emailId) - Expected 400, Got " + statusCode);
        assert statusCode == 400;
    }

    private static void testInvalidPhoneNumberFormat(HttpClient client) throws IOException, JSONException {
        HttpPost post = new HttpPost(API_ENDPOINT);
       
        post.setHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON);

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstName", "Abhay");
        requestBody.put("lastName", "Singh");
     
        requestBody.put("phoneNumber", 873780136);
        requestBody.put("emailId", "abhayrajsinghpawar.cdac.com");

        StringEntity entity = new StringEntity(requestBody.toString());
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Test Case 9: Invalid Phone Number Format - Expected 400, Got " + statusCode);
        assert statusCode == 400;
    }

    private static void testInvalidEmailIdFormat(HttpClient client) throws IOException, JSONException {
        HttpPost post = new HttpPost(API_ENDPOINT);
      
        post.setHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON);

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstName", "Abhay");
        requestBody.put("lastName", "Singh");
        
        requestBody.put("phoneNumber", 873780137);
        requestBody.put("emailId", "abhayrajsinghpawar.cdac.com");

        StringEntity entity = new StringEntity(requestBody.toString());
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
       
                System.out.println("Test Case 10: Invalid Email ID Format - Expected 400, Got " + statusCode);
                assert statusCode == 400;
            }
        }