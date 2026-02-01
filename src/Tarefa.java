import java.time.LocalDate;

    public class Tarefa {

        private String titulo;
        private String descricao;
        private LocalDate data;
        private Status status;

        public Tarefa(String titulo, String descricao, LocalDate data, Status status) {
            this.titulo = titulo;
            this.descricao = descricao;
            this.data = data;
            this.status = status;
        }

        public String getTitulo() {
            return titulo;
        }
        public String getDescricao() {
            return descricao;
        }
        public LocalDate getDataLimite() {
            return data;
        }
        public Status getStatus() {
            return status;
        }
    }



