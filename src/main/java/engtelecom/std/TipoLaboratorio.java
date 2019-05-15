package engtelecom.std;

public enum TipoLaboratorio {
    HARDWARE("hardware"),
    SOFTWARE("software");

    private String descricao;

    private TipoLaboratorio(String desc) {
        this.descricao = desc;
    }

    public String getDescricao() {
        return descricao;
    }
}
