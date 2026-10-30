package org.example.model;

public abstract class Usuario {

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
        this.perfil = perfil;
    }

    public void CadastroSenha(String senha){
        if (senha == null || senha.length() < 7) {
            throw new IllegalArgumentException(
                    "A senha deve conter no mínimo 7 caracteres"
            );
        }
        else
            this.senha = senha;
    }

    public void MudarSenha(String senha1, String senha2){
        if (senha1 == null || !senha1.equals(senha2)){
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
}
