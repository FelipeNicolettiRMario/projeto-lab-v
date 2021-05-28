package com.fatec.sp.gov.br.teamLol.security;

public class  Login {
    private String username;

    private String password;

    private String autorizacoes;

    private String token;

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(String autorizacoes) {
        this.autorizacoes = autorizacoes;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
