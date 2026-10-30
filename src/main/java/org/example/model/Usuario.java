package org.example.model;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private String perfil;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = nome;
    }

    public void MudarPerfil(String perfil){
        setPerfil(perfil);
    }


    public String getNome() { return nome; }

    public String getEmail() { return email; }

    public String getSenha() { return senha; }

    public String getPerfil() { return perfil; }

    public void setPerfil(String perfil) { this.perfil = perfil; }
}
