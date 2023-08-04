import java.util.ArrayList;

public class Controller {
        Model model = new Model();
        Viewer view = new Viewer();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        public void mostrar(int opcao) {
                if (opcao == 1) {
                        view.opcaoMenu1();
                }  if (opcao == 2) {
                        view.opcaoMenu2();
                }  if (opcao == 3) {
                        view.opcaoMenu3();
                }  if (opcao == 4) {
                        view.opcaoMenu4();
                }
        }

        public void criarUsuario(String cpf, String nome, String dataNascimento, String telefone, String email) {
                model.create(cpf, nome, dataNascimento, telefone, email, listaUsuarios);
        }

        public void mostrarUsuario(int i) {
                model.read(listaUsuarios.get(i));
        }

        public void atualizarUsuario(int i, int opcao, String novoDado) {
                model.update(listaUsuarios.get(i), opcao, novoDado);
        }

        public void deletarUsuario(int i) {
                model.delete(listaUsuarios, listaUsuarios.get(i));
        }
}
