import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Operacoes {
    private List<Tarefa> tarefas = new ArrayList<>();

    public boolean cadastrar(String titulo, String descricao, LocalDate data, Status status) {

        if (titulo.length() < 5) {
            System.out.println("Título deve ter no mínimo 5 caracteres.");
            return false;
        }

        if (data.isBefore(LocalDate.now())) {
            System.out.println("Data limite não pode ser no passado.");
            return false;
        }

        if (status == Status.CONCLUIDO) {
            System.out.println("Não é permitido cadastrar tarefa como o status: CONCLUÍDO.");
            return false;
        }
        tarefas.add(new Tarefa(titulo, descricao, data, status));
        System.out.println("Tarefa cadastrada com sucesso!");
        return true;
    }

    public void listarTodas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.\n\n");
            return;
        }else {
        tarefas.forEach(this::imprimir);}
    }

    public void filtrarPorStatus(Status status) {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.\n\n");
            return;
        }else {
                Predicate<Tarefa> filtro = t -> t.getStatus() == status;
                 tarefas.stream()
                .filter(filtro)
                .forEach(this::imprimir);}
    }

    public void listarOrdenadasPorData() {
            if (tarefas.isEmpty()) {
                System.out.println("Nenhuma tarefa cadastrada.\n\n");
                return;
        } else {
        tarefas.stream()
                .sorted((a, b) -> a.getDataLimite().compareTo(b.getDataLimite()))
                .forEach(this::imprimir);}
    }
    private void imprimir(Tarefa t) {
        System.out.println("-----");
        System.out.println("Título: " + t.getTitulo());
        System.out.println("Descrição: " + t.getDescricao());
        System.out.println("Data Limite: " + t.getDataLimite());
        System.out.println("Status: " + t.getStatus());
    }

















}
