package com.dio.eleicao.service;

import com.dio.eleicao.model.Candidate;
import com.dio.eleicao.model.Resident;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ElectionService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public List<Candidate> getCandidates() {
        return entityManager.createQuery("SELECT c FROM Candidate c", Candidate.class).getResultList();
    }

    @Transactional
    public void vote(Long residentId) {
        Resident resident = entityManager.find(Resident.class, residentId);
        if (resident != null && !resident.isHasVoted()) {
            // Lógica de votação
            resident.setHasVoted(true);
            entityManager.merge(resident);
        }
    }
}
