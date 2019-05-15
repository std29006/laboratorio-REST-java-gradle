package engtelecom.std.entities;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class Campus {
    private String nome;
    private String sigla;
    private String telefone;
    private Map<String, Bloco> blocos;

    public Campus() {
        this.blocos = new HashMap<>();
    }

    public Campus(String nome, String sigla, String telefone) {
        super();
        this.nome = nome;
        this.sigla = sigla;
        this.telefone = telefone;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public Bloco buscaBlocoPelaSigla(String sigla) {
        return this.blocos.get(sigla);
    }

    public Map<String, Bloco> getBlocos() {
        return blocos;
    }

    public void setBlocos(Map<String, Bloco> blocos) {
        this.blocos = blocos;
    }
}
