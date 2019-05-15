package engtelecom.std.db;

public class BancoDeDados {

    private static BancoDeDados instance;
    public CampiDAO campiDAO;

    public BancoDeDados() {
        this.campiDAO = new CampiDAO();
    }

    public static synchronized BancoDeDados getInstance() {
        if (instance == null) {
            instance = new BancoDeDados();
        }
        return instance;
    }

}
