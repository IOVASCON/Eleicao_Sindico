package com.dio.eleicao.repository;

// Importação da classe Candidate do pacote model
import com.dio.eleicao.model.Candidate;
// Importação do PanacheRepository do Quarkus, que fornece funcionalidades padrão para repositórios
import io.quarkus.hibernate.orm.panache.PanacheRepository;

// Importação da anotação ApplicationScoped, que indica que o repositório será um bean de escopo de aplicação
import javax.enterprise.context.ApplicationScoped;

// Anotação que define o escopo de aplicação para este repositório
@ApplicationScoped
// Declaração da classe CandidateRepository que implementa o PanacheRepository
// para a entidade Candidate
public class CandidateRepository implements PanacheRepository<Candidate> {
    // A implementação PanacheRepository já fornece métodos CRUD básicos, então não
    // é necessário adicionar mais nada aqui
}
