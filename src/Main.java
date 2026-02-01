import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Operacoes operacoes = new Operacoes();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int opcao;

        do {
            System.out.println("Escolha uma opção");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar Nova Tarefa");
            System.out.println("2 - Listar todas Tarefas");
            System.out.println("3 - Listar Tarefas por Status");
            System.out.println("4 - Listar Tarefas por Data Limite");

            System.out.println("Digite a opção desejada:");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Digite um número: ");
                scanner.nextLine();
                opcao = -1;
                continue;
            }


            switch (opcao) {
                case 0 -> System.out.println("Fechando o programa....");
                case 1 -> {
                    try {
                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Descrição: ");
                        String descricao = scanner.nextLine();
                        System.out.print("Data (dd/MM/yyyy): ");
                        LocalDate data = LocalDate.parse(scanner.nextLine(), formatter);
                        System.out.print("Status (PENDENTE / EM_ANDAMENTO): ");
                        Status status = Status.valueOf(scanner.nextLine().toUpperCase());
                        operacoes.cadastrar(titulo, descricao, data, status);
                    } catch (DateTimeParseException e) {
                        System.out.println("Data Inválida!");
                        break;
                    }catch (IllegalArgumentException r) {
                        System.out.println("Valor Inválido!");
                        break;
                    }
                }
                case 2 -> operacoes.listarTodas();
                case 3 -> {
                          System.out.print("Digite o Status desejado:(PENDENTE, CONCLUIDO ou EM_ANDAMENTO) ");
                          String entrada = scanner.nextLine().trim().toUpperCase();
                         Status status;
                    try {
                          status = Status.valueOf(entrada);
                      } catch (IllegalArgumentException e) {
                        System.out.println("Status Inválido!");
                        break;
                    }
                          operacoes.filtrarPorStatus(status);
                }
                case 4 -> operacoes.listarOrdenadasPorData();
                default -> System.out.println("Opção Inválida. Tente novamente");
            }
        } while (opcao != 0);

        scanner.close();

    }
}