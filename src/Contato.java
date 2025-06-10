import java.util.Objects;

public class Contato {

    private Integer id;
    private String nome;
    private TipoContato tipo;
    private String valor;

    public Contato() {
    }

    public Contato(Integer id, String nome, TipoContato tipo, String valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoContato getTipo() {
        return tipo;
    }

    public void setTipo(TipoContato tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id) && Objects.equals(nome, contato.nome) && tipo == contato.tipo && Objects.equals(valor, contato.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, tipo, valor);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo=" + tipo +
                ", valor='" + valor + '\'' +
                '}';
    }
}
