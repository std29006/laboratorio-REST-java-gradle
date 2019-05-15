package engtelecom.std.db;

import engtelecom.std.entities.Campus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class CampiDAO {
    @XmlElement(name = "campi")
    public Map<String, Campus> listaDosCampi;


    public CampiDAO() {
        this.listaDosCampi = new HashMap<>();
    }

    public Campus buscaCampusPelaSigla(String sigla) {
        return listaDosCampi.get(sigla);
    }

}
