package com.dio.eleicao.service;

// Importação da classe Candidate do pacote model
import com.dio.eleicao.model.Candidate;
// Importação da classe Resident do pacote model
import com.dio.eleicao.model.Resident;

// Importação da anotação ApplicationScoped para definir o escopo do serviço
import javax.enterprise.context.ApplicationScoped;
// Importação da anotação Inject para injeção de dependência
import javax.inject.Inject;
// Importação da classe EntityManager para gerenciar entidades
import javax.persistence.EntityManager;
// Importação da anotação Transactional para definir que métodos são transacionais
import javax.transaction.Transactional;
// Importação da classe List para manipulação de listas
import java.util.List;

// Define que esta classe é um bean de aplicação
@ApplicationScoped
public class ElectionService {

    // Injeção do gerenciador de entidades
    @Inject
    EntityManager entityManager;

    // Método transacional para obter a lista de candidatos
    @Transactional
    public List<Candidate> getCandidates() {
        // Executa uma consulta JPQL para selecionar todos os candidatos
        return entityManager.createQuery("SELECT c FROM Candidate c", Candidate.class).getResultList();
    }

    // Método transacional para registrar o voto de um residente
    @Transactional
    public void vote(Long residentId) {
        // Encontra o residente pelo ID
        Resident resident = entityManager.find(Resident.class, residentId);
        // Verifica se o residente existe e se ainda não votou
        if (resident != null && !resident.isHasVoted()) {
            // Lógica de votação
            resident.setHasVoted(true);
            // Atualiza o estado do residente no banco de dados
            entityManager.merge(resident);
        }
    }
}
