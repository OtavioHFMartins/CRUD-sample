import java.sql.Connection;
import java.util.List;

public interface ContatoCRUD {

    void createContato(String nome, TipoContato tipo,String valor);

    Contato readContato(Integer id);

    Contato readContato(String nome);

    List<Contato> readContatos();

    void updateContato(Contato contato);

    void deleteContato(Integer id);


}
