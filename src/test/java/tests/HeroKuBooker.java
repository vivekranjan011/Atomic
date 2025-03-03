//package tests;
//
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.specification.RequestSpecification;
//import net.serenitybdd.rest.SerenityRest;
//import org.junit.jupiter.api.Test;
//
//import static org.hamcrest.Matchers.equalTo;
//
//public class HeroKuBooker {
//
//    public static String BASE_URL= "https://restful-booker.herokuapp.com";
//    public static RequestSpecification requestSpecification = new RequestSpecBuilder()
//            .setBaseUri(BASE_URL).setContentType("application/json").build();
//
//    @Test
//    public void createAuth(){
//                SerenityRest.given(requestSpecification)
//                        .when().post("/auth")
//                        .then().log().all().statusCode(200);
//    }
//
//
//    @Test
//    public void getBooking(){
//        SerenityRest.given(requestSpecification)
//                .when().get("/booking")
//                .then().log().all().statusCode(200);
//    }
//
//    @Test
//    public void getBookingById(){
//        SerenityRest.given(requestSpecification).pathParam("book_id",459)
//                .when().get("/booking/{book_id}")
//                .then().log().all().statusCode(200);
//    }
//
//    @Test
//    public void createBooking(){
//        SerenityRest.given(requestSpecification)
//                .when().get("/booking")
//                .then().log().all().statusCode(200);
//    }
//
//    @Test
//    public void updateBooking(){
//        SerenityRest.given(requestSpecification)
//                .when().get("/booking")
//                .then().log().all().statusCode(200);
//    }
//
//
//    @Test
//    public void deleteBooking(){
//        SerenityRest.given(requestSpecification)
//                .when().get("/booking")
//                .then().log().all().statusCode(200);
//    }
//
//    @Test
//    public void healthCheck(){
//        SerenityRest.given(requestSpecification)
//                .when().get("/ping")
//                .then().log().all()
//                .statusCode(200)
//                .body("message", equalTo("HTTP/1.1 201 Created"));
//    }
//
//
//}
