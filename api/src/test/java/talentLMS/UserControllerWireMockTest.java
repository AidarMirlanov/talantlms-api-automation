package talentLMS;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentlms.api.controllers.UserController;
import talentlms.api.entity.User;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;


public class UserControllerWireMockTest {

    private static WireMockServer wireMockServer;
    private static UserController userController;

    @BeforeClass
    public static void setup() {

        wireMockServer = new WireMockServer(options().port(8089));
        wireMockServer.start();


        WireMock.configureFor("localhost", 8089);

        RestAssured.baseURI = "http://localhost:8089";


        userController = new UserController("http://localhost:8089");
    }

    @AfterClass
    public static void teardown() {

        wireMockServer.stop();
    }

    @Test
    public void testGetUsers() {

        stubFor(get(urlEqualTo("/api/v1/users"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("[{\"id\":\"1\",\"username\":\"john\"},{\"id\":\"2\",\"username\":\"jane\"}]")
                        .withStatus(200)));


        User[] users = userController.getUsers();



    }

    @Test
    public void testCreateUser() {

        stubFor(post(urlEqualTo("/api/v1/user_signup"))
                .withRequestBody(containing("{\"username\":\"new_user\"}"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\":\"3\",\"username\":\"new_user\"}")
                        .withStatus(200)));


        User newUser = new User();



        User createdUser = userController.createUser(newUser);



    }

    @Test
    public void testDeleteUser() {

        stubFor(post(urlPathEqualTo("/api/v1/delete_user"))
                .withRequestBody(containing("user_id=1"))
                .willReturn(aResponse()
                        .withStatus(200)));


        userController.deleteUser("1");

        verify(postRequestedFor(urlPathEqualTo("/api/v1/delete_user"))
                .withRequestBody(containing("user_id=1")));
    }
}