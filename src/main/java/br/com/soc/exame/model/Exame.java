package br.com.soc.exame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Exame implements Comparable<Exame> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String nome;
    private String consulta;
    private String data;
    private String observacao;
    
    public Exame() {}
    
    public Exame(String nome, String consulta, String data, String observacao) {
        this.nome = nome;
        this.consulta = consulta;
        this.data = data;
        this.observacao = observacao;
    }
    
    public Long getId() {
    	return id;
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
    
    public void setData(String data) { this.data = data; }
    
    public String getObservacao() {
        return observacao;
    }
    
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    @Override
    public String toString() {
        return "Exame{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", exame='" + consulta + '\'' +
                ", data=" + data +
                ", observacao='" + observacao + '\'' +
                '}';
    }
    
    @Override
    public int compareTo(Exame ex) {
    	return getNome().compareTo(ex.getNome());
    }
}
