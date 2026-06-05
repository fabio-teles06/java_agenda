package com.fabio.agenda;

public class Contato {

    private final String nome;
    private final String email;
    private final String numero;

    public Contato (String nome, String numero, String email) {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNumero() {
        return this.numero;
    }
}
