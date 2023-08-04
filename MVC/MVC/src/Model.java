import java.util.ArrayList;

public class Model extends Usuario {
    public void create(String cpf, String nome, String dataNascimento, String telefone, String email, ArrayList listaUsuarios ) {
        Usuario usuario = new Usuario();

        usuario.setCpf(cpf);
        usuario.setNome(nome);
        usuario.setDataNascimento(dataNascimento);
        usuario.setTelefone(telefone);
        usuario.setEmail(email);

        listaUsuarios.add(usuario);
    }

    public void read(Usuario usuario) {
        System.out.println("CPF: " + usuario.getCpf());
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Data de nascimento: " + usuario.getDataNascimento());
        System.out.println("Telefone: " + usuario.getTelefone());
        System.out.println("E-mail: " + usuario.getEmail());
    }

    public void update(Usuario usuario, int opcao, String novoDado) {
        if (opcao == 1) {
            usuario.setTelefone(novoDado);
        } if (opcao == 2) {
            usuario.setEmail(novoDado);
        }
    }
    public void delete(ArrayList listaUsuarios, Usuario usuario) {
        listaUsuarios.remove(usuario);
    }
}
