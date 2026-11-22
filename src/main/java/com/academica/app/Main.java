package com.academica.app;

import com.academica.model.AgendaAcademica;
import com.academica.model.Atividade;
import com.academica.model.Disciplina;
import com.academica.model.Estudante;
import com.academica.model.Prova;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== Estudante =====
        System.out.println("=== Dados do estudante ===");

        String nomeEstudante = "";
        while (nomeEstudante.isEmpty()) {
            System.out.print("Nome do estudante: ");
            nomeEstudante = sc.nextLine().trim();
            if (nomeEstudante.isEmpty()) {
                System.out.println("  Nome não pode ser vazio.");
            }
        }

        String periodo = "";
        while (periodo.isEmpty()) {
            System.out.print("Período (ex: 3º semestre): ");
            periodo = sc.nextLine().trim();
            if (periodo.isEmpty()) {
                System.out.println("  Período não pode ser vazio.");
            }
        }

        Estudante estudante = new Estudante(nomeEstudante, periodo);
        AgendaAcademica agenda = new AgendaAcademica(estudante);

        // ===== Disciplina 1 =====
        System.out.println("\n=== Disciplina 1 ===");

        String nomeD1 = "";
        while (nomeD1.isEmpty()) {
            System.out.print("Nome: ");
            nomeD1 = sc.nextLine().trim();
            if (nomeD1.isEmpty()) {
                System.out.println("  Nome não pode ser vazio.");
            }
        }

        String codigoD1 = "";
        while (codigoD1.isEmpty()) {
            System.out.print("Código: ");
            codigoD1 = sc.nextLine().trim();
            if (codigoD1.isEmpty()) {
                System.out.println("  Código não pode ser vazio.");
            }
        }

        String professorD1 = "";
        while (professorD1.isEmpty()) {
            System.out.print("Professor: ");
            professorD1 = sc.nextLine().trim();
            if (professorD1.isEmpty()) {
                System.out.println("  Professor não pode ser vazio.");
            }
        }

        Disciplina poo = new Disciplina(nomeD1, codigoD1, professorD1);
        estudante.adicionarDisciplina(poo);

        // Atividades da disciplina 1 (repete enquanto o usuário quiser)
        boolean maisAtividades = true;
        int numAtividade = 1;
        while (maisAtividades) {
            System.out.println("-- Atividade " + numAtividade + " --");

            String titulo = "";
            while (titulo.isEmpty()) {
                System.out.print("Título: ");
                titulo = sc.nextLine().trim();
                if (titulo.isEmpty()) {
                    System.out.println("  Título não pode ser vazio.");
                }
            }

            LocalDate prazo = null;
            while (prazo == null) {
                System.out.print("Prazo (AAAA-MM-DD): ");
                String textoPrazo = sc.nextLine().trim();
                try {
                    prazo = LocalDate.parse(textoPrazo);
                } catch (DateTimeParseException e) {
                    System.out.println("  Data inválida. Use o formato AAAA-MM-DD.");
                }
            }

            String descricao = "";
            while (descricao.isEmpty()) {
                System.out.print("Descrição: ");
                descricao = sc.nextLine().trim();
                if (descricao.isEmpty()) {
                    System.out.println("  Descrição não pode ser vazia.");
                }
            }

            String textoPrioridade = "";
            while (!textoPrioridade.matches("[1-5]")) {
                System.out.print("Prioridade (1 a 5): ");
                textoPrioridade = sc.nextLine().trim();
                if (!textoPrioridade.matches("[1-5]")) {
                    System.out.println("  Prioridade deve ser um número de 1 a 5.");
                }
            }
            int prioridade = Integer.parseInt(textoPrioridade);

            Atividade atividade = new Atividade(titulo, prazo, descricao, prioridade);
            poo.adicionarTarefa(atividade);
            agenda.adicionarTarefa(atividade);
            numAtividade++;

            String resposta = "";
            while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n")) {
                System.out.print("Quer adicionar mais alguma atividade? [s/n]: ");
                resposta = sc.nextLine().trim();
                if (resposta.equalsIgnoreCase("s")) {
                    maisAtividades = true;
                } else if (resposta.equalsIgnoreCase("n")) {
                    maisAtividades = false;
                } else {
                    System.out.println("  Valor inválido, digite s ou n.");
                }
            }
        }

        // Prova da disciplina 1 (só uma)
        System.out.println("-- Prova --");

        String tituloProva = "";
        while (tituloProva.isEmpty()) {
            System.out.print("Título: ");
            tituloProva = sc.nextLine().trim();
            if (tituloProva.isEmpty()) {
                System.out.println("  Título não pode ser vazio.");
            }
        }

        LocalDate prazoProva = null;
        while (prazoProva == null) {
            System.out.print("Prazo (AAAA-MM-DD): ");
            String textoPrazo = sc.nextLine().trim();
            try {
                prazoProva = LocalDate.parse(textoPrazo);
            } catch (DateTimeParseException e) {
                System.out.println("  Data inválida. Use o formato AAAA-MM-DD.");
            }
        }

        String descricaoProva = "";
        while (descricaoProva.isEmpty()) {
            System.out.print("Descrição: ");
            descricaoProva = sc.nextLine().trim();
            if (descricaoProva.isEmpty()) {
                System.out.println("  Descrição não pode ser vazia.");
            }
        }

        String textoPrioridadeProva = "";
        while (!textoPrioridadeProva.matches("[1-5]")) {
            System.out.print("Prioridade (1 a 5): ");
            textoPrioridadeProva = sc.nextLine().trim();
            if (!textoPrioridadeProva.matches("[1-5]")) {
                System.out.println("  Prioridade deve ser um número de 1 a 5.");
            }
        }
        int prioridadeProva = Integer.parseInt(textoPrioridadeProva);

        String conteudoProva = "";
        while (conteudoProva.isEmpty()) {
            System.out.print("Conteúdo: ");
            conteudoProva = sc.nextLine().trim();
            if (conteudoProva.isEmpty()) {
                System.out.println("  Conteúdo não pode ser vazio.");
            }
        }

        Prova prova1 = new Prova(tituloProva, prazoProva, descricaoProva, prioridadeProva, conteudoProva);
        poo.adicionarTarefa(prova1);
        agenda.adicionarTarefa(prova1);

        // ===== Disciplina 2 =====
        System.out.println("\n=== Disciplina 2 ===");

        String nomeD2 = "";
        while (nomeD2.isEmpty()) {
            System.out.print("Nome: ");
            nomeD2 = sc.nextLine().trim();
            if (nomeD2.isEmpty()) {
                System.out.println("  Nome não pode ser vazio.");
            }
        }

        String codigoD2 = "";
        while (codigoD2.isEmpty()) {
            System.out.print("Código: ");
            codigoD2 = sc.nextLine().trim();
            if (codigoD2.isEmpty()) {
                System.out.println("  Código não pode ser vazio.");
            }
        }

        String professorD2 = "";
        while (professorD2.isEmpty()) {
            System.out.print("Professor: ");
            professorD2 = sc.nextLine().trim();
            if (professorD2.isEmpty()) {
                System.out.println("  Professor não pode ser vazio.");
            }
        }

        Disciplina bd = new Disciplina(nomeD2, codigoD2, professorD2);
        estudante.adicionarDisciplina(bd);

        // Atividades da disciplina 2 (repete enquanto o usuário quiser)
        maisAtividades = true;
        numAtividade = 1;
        while (maisAtividades) {
            System.out.println("-- Atividade " + numAtividade + " --");

            String titulo = "";
            while (titulo.isEmpty()) {
                System.out.print("Título: ");
                titulo = sc.nextLine().trim();
                if (titulo.isEmpty()) {
                    System.out.println("  Título não pode ser vazio.");
                }
            }

            LocalDate prazo = null;
            while (prazo == null) {
                System.out.print("Prazo (AAAA-MM-DD): ");
                String textoPrazo = sc.nextLine().trim();
                try {
                    prazo = LocalDate.parse(textoPrazo);
                } catch (DateTimeParseException e) {
                    System.out.println("  Data inválida. Use o formato AAAA-MM-DD.");
                }
            }

            String descricao = "";
            while (descricao.isEmpty()) {
                System.out.print("Descrição: ");
                descricao = sc.nextLine().trim();
                if (descricao.isEmpty()) {
                    System.out.println("  Descrição não pode ser vazia.");
                }
            }

            String textoPrioridade = "";
            while (!textoPrioridade.matches("[1-5]")) {
                System.out.print("Prioridade (1 a 5): ");
                textoPrioridade = sc.nextLine().trim();
                if (!textoPrioridade.matches("[1-5]")) {
                    System.out.println("  Prioridade deve ser um número de 1 a 5.");
                }
            }
            int prioridade = Integer.parseInt(textoPrioridade);

            Atividade atividade = new Atividade(titulo, prazo, descricao, prioridade);
            bd.adicionarTarefa(atividade);
            agenda.adicionarTarefa(atividade);
            numAtividade++;

            String resposta = "";
            while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n")) {
                System.out.print("Quer adicionar mais alguma atividade? [s/n]: ");
                resposta = sc.nextLine().trim();
                if (resposta.equalsIgnoreCase("s")) {
                    maisAtividades = true;
                } else if (resposta.equalsIgnoreCase("n")) {
                    maisAtividades = false;
                } else {
                    System.out.println("  Valor inválido, digite s ou n.");
                }
            }
        }

        // Prova da disciplina 2 (só uma)
        System.out.println("-- Prova --");

        String tituloProva2 = "";
        while (tituloProva2.isEmpty()) {
            System.out.print("Título: ");
            tituloProva2 = sc.nextLine().trim();
            if (tituloProva2.isEmpty()) {
                System.out.println("  Título não pode ser vazio.");
            }
        }

        LocalDate prazoProva2 = null;
        while (prazoProva2 == null) {
            System.out.print("Prazo (AAAA-MM-DD): ");
            String textoPrazo = sc.nextLine().trim();
            try {
                prazoProva2 = LocalDate.parse(textoPrazo);
            } catch (DateTimeParseException e) {
                System.out.println("  Data inválida. Use o formato AAAA-MM-DD.");
            }
        }

        String descricaoProva2 = "";
        while (descricaoProva2.isEmpty()) {
            System.out.print("Descrição: ");
            descricaoProva2 = sc.nextLine().trim();
            if (descricaoProva2.isEmpty()) {
                System.out.println("  Descrição não pode ser vazia.");
            }
        }

        String textoPrioridadeProva2 = "";
        while (!textoPrioridadeProva2.matches("[1-5]")) {
            System.out.print("Prioridade (1 a 5): ");
            textoPrioridadeProva2 = sc.nextLine().trim();
            if (!textoPrioridadeProva2.matches("[1-5]")) {
                System.out.println("  Prioridade deve ser um número de 1 a 5.");
            }
        }
        int prioridadeProva2 = Integer.parseInt(textoPrioridadeProva2);

        String conteudoProva2 = "";
        while (conteudoProva2.isEmpty()) {
            System.out.print("Conteúdo: ");
            conteudoProva2 = sc.nextLine().trim();
            if (conteudoProva2.isEmpty()) {
                System.out.println("  Conteúdo não pode ser vazio.");
            }
        }

        Prova prova2 = new Prova(tituloProva2, prazoProva2, descricaoProva2, prioridadeProva2, conteudoProva2);
        bd.adicionarTarefa(prova2);
        agenda.adicionarTarefa(prova2);

        // ===== Relatório =====
        System.out.println("\n=== Organização Acadêmica ===\n");
        System.out.println("Disciplinas matriculadas:");
        for (Disciplina disciplina : estudante.getDisciplinas()) {
            System.out.println("- " + disciplina.getNome() + " (" + disciplina.getCodigo() + ")");
        }

        System.out.println();
        agenda.listarResumo();

        System.out.println();
        System.out.println("Próximas tarefas:");
        agenda.listarProximas(3);

        System.out.println();
        System.out.println(agenda.relatorioResumo());

        sc.close();
    }
}
