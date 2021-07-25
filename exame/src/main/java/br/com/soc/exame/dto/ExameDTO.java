package br.com.soc.exame.dto;

import br.com.soc.exame.model.Exame;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ExameDTO {
    @NotBlank
    @NotNull
    private String nome;
    private String consulta;
    private String data;
    private String observacao;
    
    public Exame toExame() {
        Exame exame = new Exame();
        exame.setNome(this.nome);
        exame.setConsulta(this.consulta);
        exame.setData(this.data);
        exame.setObservacao(this.observacao);
        return exame;
    }
    
    public void setExame(Exame exame) {
    	this.nome = exame.getNome();
    	this.consulta = exame.getConsulta();
    	this.data = exame.getData();
    	this.observacao = exame.getObservacao();
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getConsulta() {
        return consulta;
    }
    
    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public String getObservacao() {
        return observacao;
    }
    
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    @Override
    public String toString() {
        return "ExameDTO{" +
                "nome='" + nome + '\'' +
                ", consulta='" + consulta + '\'' +
                ", data='" + data + '\'' +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
