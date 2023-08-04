import java.util.Scanner;

public class Viewer {
    static Controller control = new Controller();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("MENU");
            System.out.println("1 - Cadastrar usuario");
            System.out.println("2 - Visualizar usuario cadastrado");
            System.out.println("3 - Atualizar cadastro de usuario");
            System.out.println("4 - Deletar usuario");
            System.out.println("5 - Encerrar");

            int opcaoMenu = scanner.nextInt();
            scanner.nextLine();

            if (opcaoMenu == 1) { control.mostrar(1); }
            if (opcaoMenu == 2) { control.mostrar(2); }
            if (opcaoMenu == 3) { control.mostrar(3); }
            if (opcaoMenu == 4) { control.mostrar(4); }
            if (opcaoMenu == 5) { break; }
        }
    }

    public void opcaoMenu1() {
        System.out.println("Cadastro de usuario");
        System.out.println("Digite o CPF do usuario a ser cadastrado:");
        String cpf = scanner.nextLine();
        System.out.println("Digite o NOME do usuario a ser cadastrado:");
        String nome = scanner.nextLine();
        System.out.println("Digite o DATA DE NASCIMENTO do usuario a ser cadastrado:");
        String dataNascimento = scanner.nextLine();
        System.out.println("Digite o TELEFONE do usuario a ser cadastrado:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o E-MAIL do usuario a ser cadastrado:");
        String email = scanner.nextLine();
        System.out.println("----------------------------------------------");

        control.criarUsuario(cpf, nome, dataNascimento, telefone, email);

        System.out.println("Usuario cadastrado com sucesso!");
    }
    public void opcaoMenu2() {
        System.out.println("Visualizacao de usuario cadastrado");
        System.out.println("Digite o CPF do usuario:");

        String cpfPesquisa = scanner.nextLine();

        for (int i = 0; i < control.listaUsuarios.size(); i++) {
            if (control.listaUsuarios.get(i).cpf.equals(cpfPesquisa)) {
                control.mostrarUsuario(i);
            }
        }
    }

    public void opcaoMenu3() {
        System.out.println("Atualizacao de cadastro de usuario");
        System.out.println("Digite o CPF do usuario:");

        String cpfPesquisa = scanner.nextLine();

        for (int i = 0; i < control.listaUsuarios.size(); i++) {
            if (control.listaUsuarios.get(i).cpf.equals(cpfPesquisa)) {

                System.out.println("O que voce deseja atualizar?");
                System.out.println("1 - Telefone");
                System.out.println("2 - E-mail");

                int opcaoSubMenu = scanner.nextInt();
                scanner.nextLine();

                if (opcaoSubMenu == 1) {
                    System.out.println("Digite o novo numero de telefone: ");
                    String novoTelefone = scanner.nextLine();
                    control.atualizarUsuario(i, 1, novoTelefone);
                    System.out.println("Telefone atualizado com sucesso.");
                }
                if (opcaoSubMenu == 2) {
                    System.out.println("Digite o novo e-mail: ");
                    String novoEmail = scanner.nextLine();
                    control.atualizarUsuario(i, 2, novoEmail);
                    System.out.println("E-mail atualizado com sucesso.");
                }
            }
        }
    }

    public void opcaoMenu4() {
        System.out.println("Deletar usuario");
        System.out.println("Digite o CPF do usuario:");

        String cpfPesquisa = scanner.nextLine();

        for (int i = 0; i < control.listaUsuarios.size(); i++) {
            if (control.listaUsuarios.get(i).cpf.equals(cpfPesquisa)) {
                control.deletarUsuario(i);
            }
        }

        System.out.println("Usuario removido.");
        System.out.println("----------------------------------------------");
        System.out.println("Lista de usuarios remanescentes:");

        for (int i = 0; i < control.listaUsuarios.size(); i++) {
            System.out.println(control.listaUsuarios.get(i).nome);
        }
    }
}
