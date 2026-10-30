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
        CadastroSenha(senha);
        this.perfil = nome;
    }

    public void MudarPerfil(String perfil){
        setPerfil(perfil);
    }

    public void CadastroSenha(String senha){
        if (senha == null || senha.length() < 7) {
            throw new IllegalArgumentException(
                    "A senha deve conter no mínimo 5 caracteres"
            );
        }
        else
            this.senha = senha;
    }

    public void MudarSenha(String senha1, String senha2){
        if (!senha1.equals(senha2) || senha1 == null){
            throw new IllegalArgumentException(
                    "As senhas inseridas são diferentes"
            );
        }else
            CadastroSenha(senha1);
    }


    public String getNome() { return nome; }

    public String getEmail() { return email; }

    public String getSenha() { return senha; }

    public String getPerfil() { return perfil; }

    public void setPerfil(String perfil) { this.perfil = perfil; }
}
