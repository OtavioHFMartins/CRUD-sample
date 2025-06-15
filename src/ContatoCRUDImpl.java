import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        var sql = "SELECT * FROM contatos c WHERE c.id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
              return getContato(rs);
            }

        } catch (SQLException e) {
            throw  new RuntimeException("Ocorreu um erro no: ReadContato por id - erro: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Contato readContato(String nome) {
        var sql = "SELECT * FROM contatos c WHERE c.nome = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
              return getContato(rs);
            }

        } catch (SQLException e) {
            throw  new RuntimeException("Ocorreu um erro no: ReadContato por id - erro: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Contato> readContatos() {
        var sql = "SELECT * FROM contatos";
        List<Contato> contatos = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                var contato = getContato(rs);
                contatos.add(contato);
            }

        } catch (SQLException e) {
            throw  new RuntimeException("Ocorreu um erro no: ReadContatos" + e.getMessage());
        }
            return contatos;
    }



    @Override
    public void updateContato(Contato contato) {

    }

    @Override
    public void deleteContato(Integer id) {

    }
    private  Contato getContato(ResultSet rs) throws SQLException {
        var id = rs.getInt("id");
        var name = rs.getString("nome");
        var type = rs.getString("tipo");
        var value = rs.getString("valor");
        return new Contato(id, name, TipoContato.valueOf(type), value);
    }

}
