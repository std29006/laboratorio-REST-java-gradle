package engtelecom.std.entities;

import engtelecom.std.TipoLaboratorio;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Laboratorio {
    private String nome;
    private String sigla;
    private int totalDeLugares;
    private TipoLaboratorio tipo;

    public Laboratorio() {
    }

    public Laboratorio(String nome, String sigla, int totalDeLugares, TipoLaboratorio tipo) {
        this.nome = nome;
        this.sigla = sigla;
        this.totalDeLugares = totalDeLugares;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getTotalDeLugares() {
        return totalDeLugares;
    }

    public void setTotalDeLugares(int totalDeLugares) {
        this.totalDeLugares = totalDeLugares;
    }

    public TipoLaboratorio getTipo() {
        return tipo;
    }

    public void setTipo(TipoLaboratorio tipo) {
        this.tipo = tipo;
    }
}
