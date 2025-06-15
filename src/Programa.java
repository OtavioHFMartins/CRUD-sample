public class Programa {
    public static void main(String[] args) {


        ContatoCRUD contatoCRUD = new ContatoCRUDImpl();
       //  testCriacaoContato(contatoCRUD);
       // testObterContatos(contatoCRUD);
        // testObterContatoByid(contatoCRUD, 1);
        testObterContatoByNome(contatoCRUD, "Otavio");


    }

    private static void testCriacaoContato(ContatoCRUD crud){
        var nome = "mikasa";
        var tipo = TipoContato.EMAIL;
        var valor = "mikasa@mail.com";
        crud.createContato(nome,tipo,valor);
        System.out.println("contato criado com sucesso");
    }

    private static void testObterContatos(ContatoCRUD crud) {
        var contatos = crud.readContatos();
        contatos.forEach(System.out::println);
    }
    private static void testObterContatoByid(ContatoCRUD crud, Integer id) {
        var contato = crud.readContato(id);
        System.out.println(contato);
    }

    private static void testObterContatoByNome(ContatoCRUD crud, String nome) {
        var contato = crud.readContato(nome);
        System.out.println(contato);
    }

    private static void testUpdateContato(ContatoCRUD crud) {
        var contatoAtualizar = crud.readContato(1);
        contatoAtualizar.setNome("nome atualizado");
        crud.updateContato(contatoAtualizar);
        System.out.println("contato atualizado");
    }

    private static void testDelete(ContatoCRUD crud, Integer id) {
       crud.deleteContato(id);
        System.out.println("contato foi deletado");
    }
}
