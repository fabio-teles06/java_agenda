package com.fabio.agenda;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private static final String SAVE_PATH = "contatos.txt";
    private List<Contato> contatos;

    public void init() {
        contatos = new ArrayList<>();
    }

    public void addContato(String nome, String email, String numero) {
        contatos.add(new Contato(nome, email, numero));
    }

    public void listContatos() {
        for (int i = 0; i < contatos.size(); i++) {
            Contato c = contatos.get(i);
            System.out.println(c.getNome());
        }
    }

    public boolean save() {
        try{
            FileWriter writer = new FileWriter(SAVE_PATH);

            for (int i = 0; i < contatos.size(); i++) {
                Contato c = contatos.get(i);

                String l = "";
                l += c.getNome() + ";";
                l += c.getEmail() + ";";
                l += c.getNumero() + ";";

                writer.write(l);
            }

            writer.close();
            System.out.println("Salvo");
            return true;
        } catch (IOException e) {
            System.out.println("Falha ao salvar");
            return false;
        }
    }

    public boolean load() {
        try {
            FileReader reader = new FileReader(SAVE_PATH);
            List<String> lines = reader.readAllLines();
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(";");
                Contato c = new Contato(parts[0], parts[1], parts[2]);
                contatos.add(c);
            }
            reader.close();
            return true;
        } catch (IOException e){
            System.out.println("Falha ao salvar");
            return false;
        }
    }
}
