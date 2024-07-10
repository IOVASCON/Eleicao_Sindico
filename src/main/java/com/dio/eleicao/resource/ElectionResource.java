package com.dio.eleicao.resource;

// Importação da classe Candidate do pacote model
import com.dio.eleicao.model.Candidate;
// Importação do serviço ElectionService
import com.dio.eleicao.service.ElectionService;

// Importação da anotação Inject para injeção de dependência
import javax.inject.Inject;
// Importação da anotação GET para mapear requisições HTTP GET
import javax.ws.rs.GET;
// Importação da anotação POST para mapear requisições HTTP POST
import javax.ws.rs.POST;
// Importação da anotação Path para definir o caminho do recurso
import javax.ws.rs.Path;
// Importação da anotação Produces para definir o tipo de mídia que o recurso produz
import javax.ws.rs.Produces;
// Importação da anotação Consumes para definir o tipo de mídia que o recurso consome
import javax.ws.rs.Consumes;
// Importação da classe MediaType para tipos de mídia
import javax.ws.rs.core.MediaType;
// Importação da classe Response para construção de respostas HTTP
import javax.ws.rs.core.Response;
// Importação da classe List para manipulação de listas
import java.util.List;

// Define o caminho base para este recurso REST
@Path("/election")
// Define que este recurso produz respostas no formato JSON
@Produces(MediaType.APPLICATION_JSON)
// Define que este recurso consome dados no formato JSON
@Consumes(MediaType.APPLICATION_JSON)
public class ElectionResource {

    // Injeção do serviço ElectionService
    @Inject
    ElectionService electionService;

    // Mapeia requisições GET para o caminho "/candidates"
    @GET
    @Path("/candidates")
    public Response getCandidates() {
        // Obtém a lista de candidatos do serviço
        List<Candidate> candidates = electionService.getCandidates();
        // Retorna a lista de candidatos em uma resposta HTTP 200 (OK)
        return Response.ok(candidates).build();
    }

    // Mapeia requisições POST para o caminho "/vote"
    @POST
    @Path("/vote")
    public Response vote(Long candidateId) {
        // Chama o serviço para registrar o voto no candidato especificado
        electionService.vote(candidateId);
        // Retorna uma resposta HTTP 200 (OK)
        return Response.ok().build();
    }
}
