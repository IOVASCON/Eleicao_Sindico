package com.dio.eleicao;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectionResourceTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void testGetCandidatesEndpoint() throws InterruptedException {
        // Espera 5 segundos para garantir que o servidor está rodando
        Thread.sleep(5000);

        Response response = RestAssured.get("/election/candidates");

        assertEquals(200, response.getStatusCode());
    }
}
