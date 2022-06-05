package com.letscode.turmasapiigor.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashSet;
import java.util.Set;

//fica no lugar do entity do JPA
// p Mongo é um banco baseado em coleções,seria análogo às tabelas
@Document(collection = "turma")
public class Turma {

    @Id
    private String Id;
    private String nome;

    // Apenas o mapeamento do atributo para o Mongo
    @Field
    private Set<Long> listaDeAlunos = new HashSet<>();

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Long> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(Set<Long> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }
}
