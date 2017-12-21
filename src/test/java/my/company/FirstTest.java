package my.company;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;


public class FirstTest {



    @Story("Тест на рест запрос")
    @Test
    public void shouldGetLuke() {
        RestAssured.filters(new AllureRestAssured());
        step();
    }

    @Step("Проверка name")
    public void step(){

        get("http://swapi.co/api/people/1/")
                .then().statusCode(200)
                .and()
                .assertThat()
                .body("name", equalTo("Luke Skywalker"));
    }

}
