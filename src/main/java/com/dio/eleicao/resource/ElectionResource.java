package com.dio.eleicao.resource;

import com.dio.eleicao.model.Candidate;
import com.dio.eleicao.service.ElectionService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/election")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ElectionResource {

    @Inject
    ElectionService electionService;

    @GET
    @Path("/candidates")
    public Response getCandidates() {
        List<Candidate> candidates = electionService.getCandidates();
        return Response.ok(candidates).build();
    }

    @POST
    @Path("/vote")
    public Response vote(Long candidateId) {
        electionService.vote(candidateId);
        return Response.ok().build();
    }
}
