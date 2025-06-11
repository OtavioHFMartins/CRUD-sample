import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ContatoCRUDImpl implements ContatoCRUD {

    private final Connection connection;

    public ContatoCRUDImpl() {
        MysqlConfig mysqlConfig = new MysqlConfig();
        connection = mysqlConfig.getConnection();
    }

    @Override
    public void createContato(String nome, TipoContato tipo, String valor) {
        String sql = "INSERT INTO contatos (nome, tipo, valor) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, tipo.name());
            stmt.setString(3, valor);

            int rows = stmt.executeUpdate();
            System.out.println("Cadastro realizado - linhas afetadas:"  + rows);

        } catch (SQLException e) {
            throw  new RuntimeException("Ocorreu um erro no: createContato" + e.getMessage());
        }

    }

    @Override
    public Contato readContato(Integer id) {
        return null;
    }

    @Override
    public Contato readContato(String nome) {
        return null;
    }

    @Override
    public List<Contato> readContatos() {
        return List.of();
    }

    @Override
    public void updateContato(Contato contato) {

    }

    @Override
    public void deleteContato(Integer id) {

    }
}
