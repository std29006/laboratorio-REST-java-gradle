package engtelecom.std.entities;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class Bloco {
    private String sigla;
    private String descricao;
    private Map<String, Laboratorio> laboratorios;

    public Bloco() {
        this.laboratorios = new HashMap<>();
    }

    public Bloco(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Laboratorio buscaLabPelaSigla(String lab) {
        return this.laboratorios.get(lab);
    }

    public Map<String, Laboratorio> getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(Map<String, Laboratorio> laboratorios) {
        this.laboratorios = laboratorios;
    }
}
