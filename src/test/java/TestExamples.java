
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class TestExamples {

    @Test
    public void test_1(){

        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println("Response: "+response.asString());
        System.out.println("Status Code: "+response.getStatusCode());
        System.out.println("Body: "+response.getBody().asString());
        System.out.println("Time Taken: "+response.getTime());
        System.out.println("Response: "+response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test
    public void test_2()
    {
        baseURI = "https://resreq.in/api";

        given().
           get("/users?page=2").
                then().statusCode(200).
         body("data[1].id",equalTo(8));
    }
}
