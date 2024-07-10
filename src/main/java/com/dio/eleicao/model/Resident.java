package com.dio.eleicao.model;

// Importações necessárias para a definição da entidade JPA
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Anotação que indica que esta classe é uma entidade JPA
@Entity
public class Resident {

    // Anotação que indica que este campo é a chave primária da entidade
    @Id
    // Anotação que define a estratégia de geração de valor para a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do residente

    // Nome do residente
    private String name;

    // Indica se o residente já votou
    private boolean hasVoted;

    // Métodos getters e setters para os campos da entidade

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
}
