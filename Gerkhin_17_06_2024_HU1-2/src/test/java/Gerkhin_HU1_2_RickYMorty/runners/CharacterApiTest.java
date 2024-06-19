package Gerkhin_HU1_2_RickYMorty.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = {"src/test/resources/features"},
//        glue = {"com.vimalselvam.cucumber.stepdefinitions"},
//)//

public class CharacterApiTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://rickandmortyapi.com/api";
    }

    // GET request to search for characters by name
    @Test
    public void testSearchCharactersByName() {
        given().
                queryParam("name", "Rick Sanchez").
                when().
                get("/character").
                then().
                statusCode(200).
                body("results[0].name", equalTo("Rick Sanchez"));
    }

    // GET request to search for characters by partial name
    @Test
    public void testSearchCharactersByPartialName() {
        given().
                queryParam("name", "Rick").
                when().
                get("/character").
                then().
                statusCode(200).
                body("results", not(empty())).
                body("results.name", hasItem("Rick Sanchez"));
    }

    // GET request for character details by ID
    @Test
    public void testGetCharacterDetailsById() {
        given().
                when().
                get("/character/1").
                then().
                statusCode(200).
                body("id", equalTo(1)).
                body("name", equalTo("Rick Sanchez")).
                body("status", notNullValue()).
                body("species", notNullValue()).
                body("gender", notNullValue()).
                body("origin.name", notNullValue()).
                body("location.name", notNullValue()).
                body("episode", not(empty()));
    }

    // GET request with invalid ID
    @Test
    public void testGetCharacterDetailsWithInvalidId() {
        given().
                when().
                get("/character/9999").
                then().
                statusCode(404).
                body("error", equalTo("Character not found"));
    }

    // Performance test: Search characters by name
    @Test
    public void testSearchPerformance() {
        long responseTime = given().
                queryParam("name", "Rick").
                when().
                get("/character").
                then().
                statusCode(200).
                extract().time();

        assert(responseTime < 2000);
    }

    // Performance test: Get character details by ID
    @Test
    public void testDetailPerformance() {
        long responseTime = given().
                when().
                get("/character/1").
                then().
                statusCode(200).
                extract().time();

        assert(responseTime < 2000);
    }

    // POST, PUT, DELETE requests are not supported by the Rick and Morty API
    // @Test
    // public void testCreateCharacter() {
    //     given().
    //         contentType(ContentType.JSON).
    //         body("{ \"name\": \"New Character\", \"status\": \"unknown\", \"species\": \"Alien\", \"gender\": \"unknown\", \"origin\": { \"name\": \"unknown\" }, \"location\": { \"name\": \"unknown\" } }").
    //     when().
    //         post("/character").
    //     then().
    //         statusCode(201).
    //         body("name", equalTo("New Character"));
    // }

    // @Test
    // public void testUpdateCharacter() {
    //     given().
    //         contentType(ContentType.JSON).
    //         body("{ \"name\": \"Updated Character\" }").
    //     when().
    //         put("/character/1").
    //     then().
    //         statusCode(200).
    //         body("name", equalTo("Updated Character"));
    // }

    // @Test
    // public void testDeleteCharacter() {
    //     given().
    //     when().
    //         delete("/character/1").
    //     then().
    //         statusCode(204);
    // }
}


