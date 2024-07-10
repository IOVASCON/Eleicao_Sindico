package com.dio.eleicao;

// Importa a biblioteca RestAssured para realizar requisições HTTP em testes
import io.restassured.RestAssured;
// Importa a classe Response da biblioteca RestAssured para manipular respostas HTTP
import io.restassured.response.Response;
// Importa a anotação @BeforeAll para métodos que devem ser executados antes de todos os testes
import org.junit.jupiter.api.BeforeAll;
// Importa a anotação @Test para definir métodos de teste
import org.junit.jupiter.api.Test;
// Importa o método assertEquals da biblioteca JUnit para asserções em testes
import static org.junit.jupiter.api.Assertions.assertEquals;

// Define a classe de teste para ElectionResource
public class ElectionResourceTest {

    // Define o método de configuração que será executado antes de todos os testes
    @BeforeAll
    public static void setup() {
        // Configura a URI base para as requisições RestAssured
        RestAssured.baseURI = "http://localhost";
        // Configura a porta para as requisições RestAssured
        RestAssured.port = 8080;
    }

    // Define o método de teste para verificar o endpoint de candidatos
    @Test
    public void testGetCandidatesEndpoint() throws InterruptedException {
        // Espera 5 segundos para garantir que o servidor está rodando
        Thread.sleep(5000);

        // Envia uma requisição GET para o endpoint /election/candidates
        Response response = RestAssured.get("/election/candidates");

        // Verifica se o status da resposta é 200 (OK)
        assertEquals(200, response.getStatusCode());
    }
}
