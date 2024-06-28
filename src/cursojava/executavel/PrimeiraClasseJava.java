package cursojava.executavel;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.constantes.StatusAluno;

public class PrimeiraClasseJava {
	public static void main(String[] args) {

//		Aluno aluno1 = new Aluno();

		List<Aluno> alunos = new ArrayList<Aluno>();
		List<Aluno> alunosAprovados = new ArrayList<Aluno>();
		List<Aluno> alunosReprovados = new ArrayList<Aluno>();
		List<Aluno> alunosRecuperacao = new ArrayList<Aluno>();

		for (int qtde = 1; qtde < 6; qtde++) {

			Aluno aluno1 = new Aluno();
			String nomeAluno = JOptionPane.showInputDialog("Nome do Aluno " + qtde + " ?");
			aluno1.setNome(nomeAluno);
			/*
			 * Instância do Objeto: Criação do Objeto aluno1 é uma referência para o objeto
			 * aluno
			 */

//		String nome = "Carlos Henrique";
//		String idade = "63";
//		String dataNascimento = "10/07/1960";
//		String RG = "M-1.567.940 SSPMG";
//		String CPF = "403.309.156-49";
//		String nomeMae = "Sudaria";
//		String nomePai = "Joaquim";
//		String dataMatricula = "14/02/2024";
//		String serieMatriculado = "1";
//		String nomeEscola = "JDev Treinamentos";
			/*
			 * RECEBENDO AS DISCIPLINAS DE FORMA DINÂMICA USANDO UM "FOR" - AULA 9.22 -
			 * 21/06/2024
			 */
			for (int pos = 1; pos <= 1; pos++) {
				String nomeDisciplina = JOptionPane
						.showInputDialog("Nome da disciplina " + Integer.valueOf(pos) + " ? ");
				String notaDisciplina = JOptionPane
						.showInputDialog("Qual a nota da disciplina " + Integer.valueOf(pos) + " ? ");

				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(nomeDisciplina);
				disciplina.setNota(Integer.valueOf(notaDisciplina));
				aluno1.getDisciplinas().add(disciplina);
			}

//			int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina? ");
//
//			if (escolha == 0) {
//				int continuarRemover = 0;
//				int posicao = 1;
//				while (continuarRemover == 0) {
//					String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina? 1/2/3 ou 4");
//					aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
//					posicao++;
//					continuarRemover = JOptionPane.showConfirmDialog(null, "continuar a remover? ");
//				}
//			}
			alunos.add(aluno1);
		}
		/*
		 * SEPARANDO OS ALUNOS EM TRÊS LISTAS: APROVADOS, REPROVADOS E EM RECUPERAÇÃO
		 * AULA 9.32 EM 28/06/2024
		 */
		for (Aluno aluno : alunos) {
			if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
				alunosAprovados.add(aluno);
			} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				alunosRecuperacao.add(aluno);
			} else {
				alunosReprovados.add(aluno);
			}
		}
		/*
		 * COMENTANDO ESSES DOIS BLOCOS DE CÓDIGO PARA OS TESTES DA AULA 9:29
		 * "PERCORRENDO LISTAS PELAS POSIÇÕES" - 28/06/2024 for (Aluno aluno : alunos) {
		 * 
		 * if (aluno.getNome().equalsIgnoreCase("henrique")) { alunos.remove(aluno);
		 * break; } else { System.out.println(aluno.toString());
		 * System.out.println("A média de notas do aluno 1 é " + aluno.getMediaNota());
		 * System.out.println(aluno); System.out.println("Média do aluno: " +
		 * aluno.getMediaNota()); System.out.println("Situação do aluno: " +
		 * aluno.getAlunoAprovado2()); } } for (Aluno aluno: alunos) {
		 * System.out.println("Alunos que sobraram na lista:");
		 * System.out.println(aluno.getNome());
		 * System.out.println("Suas disciplinas são: "); for (Disciplina disciplina:
		 * aluno.getDisciplinas()) { System.out.println(disciplina.getDisciplina()+
		 * " com "+disciplina.getNota()+" Pontos."); } }
		 */

		/* Percorrendo a lista pela suas posições */

//		for (int pos = 0; pos < alunos.size(); pos++) {
//			Aluno aluno = alunos.get(pos);
//			System.out.println("Aluno: " + aluno.getNome());
//			System.out.println("Média de notas do aluno: " + aluno.getMediaNota());
//			System.out.println("Resultado final: " + aluno.getAlunoAprovado2());
//			System.out.println("------------------------------------------------------------------");
//			int contaDisciplinas = 1;
//			for (Disciplina disciplina : aluno.getDisciplinas()) {
//
//				System.out.println(contaDisciplinas + " Matéria: " + disciplina.getDisciplina() + " Nota: "
//						+ disciplina.getNota());
//				contaDisciplinas++;
//			}
//			System.out.println("------------------------------------------------------------------");
//		}
		System.out.println("-------------------LISTA DOS ALUNOS REPROVADOS:-------------------");
		for (Aluno aluno: alunosReprovados) {
			System.out.println("Resultado = "+ aluno.getNome()+" " +aluno.getAlunoAprovado2()+" Com a média "+aluno.getMediaNota());
		}
		System.out.println("------------------------------------------------------------------");

		System.out.println("-------------------LISTA DOS ALUNOS EM RECUPERAÇÃO:-------------------");
		for (Aluno aluno: alunosRecuperacao) {
			System.out.println("Resultado = "+ aluno.getNome()+" "+aluno.getAlunoAprovado2()+" Com a média "+aluno.getMediaNota());
		}
		System.out.println("------------------------------------------------------------------");
		System.out.println("-------------------LISTA DOS ALUNOS APROVADOS:-------------------");
		for (Aluno aluno: alunosAprovados) {
			System.out.println("Resultado = "+ aluno.getNome()+" "+aluno.getAlunoAprovado2()+" Com a média "+aluno.getMediaNota());
		}
		System.out.println("------------------------------------------------------------------");

		/*
		 * SUBSTITUINDO UM ALUNO NA LISTA - AULA 9.30 - 28/06/2024
		 * 
		 * for (int pos = 0; pos < alunos.size(); pos++) { Aluno aluno =
		 * alunos.get(pos); if (aluno.getNome().equalsIgnoreCase("carlos")) { Aluno
		 * trocar = new Aluno(); trocar.setNome("Aluno teve o nome trocado.");
		 * Disciplina disciplina = new Disciplina();
		 * disciplina.setDisciplina("Matemática"); disciplina.setNota(88);
		 * trocar.getDisciplinas().add(disciplina); alunos.set(pos, trocar); aluno =
		 * alunos.get(pos); } }
		 */
		/* Percorrendo a lista pela suas posições */

//		for (int pos = 0; pos < alunos.size(); pos++) {
//			Aluno aluno = alunos.get(pos);
//			System.out.println("Aluno: " + aluno.getNome());
//			System.out.println("Média de notas do aluno: " + aluno.getMediaNota());
//			System.out.println("Resultado final: " + aluno.getAlunoAprovado2());
//			System.out.println("------------------------------------------------------------------");
//			int contaDisciplinas = 1;
//			for (Disciplina disciplina : aluno.getDisciplinas()) {
//
//				System.out.println(contaDisciplinas + " Matéria: " + disciplina.getDisciplina() + " Nota: "
//						+ disciplina.getNota());
//				contaDisciplinas++;
//			}
//			System.out.println("------------------------------------------------------------------");
//		}

//		aluno1.setNome(nome);
//		aluno1.setIdade(Integer.valueOf(idade));
//		aluno1.setDataNascimento(dataNascimento);
//		aluno1.setRegistroGeral(RG);
//		aluno1.setNumeroCPF(CPF);
//		aluno1.setNomeMae(nomeMae);
//		aluno1.setNomePai(nomePai);
//		aluno1.setDataMatricula(dataMatricula);
//		aluno1.setSerieMatriculado(serieMatriculado);
//		aluno1.setNomeEscola(nomeEscola);

//		System.out.println("O nome do aluno 1 é " + aluno1.getNome());
//		System.out.println("A idade é " + aluno1.getIdade());
//		System.out.println("A data de nascimento é " + aluno1.getDataNascimento());
//		System.out.println("O documento de identidade é " + aluno1.getRegistroGeral());
//		System.out.println("O número do CPF é " + aluno1.getNumeroCPF());
//		System.out.println("O nome da mãe é " + aluno1.getNomeMae());
//		System.out.println("O nome do pai é " + aluno1.getNomePai());
//		System.out.println("A data de matrícula é " + aluno1.getDataMatricula());
//		System.out.println("A Série da matrícula é " + aluno1.getSerieMatriculado());
//		System.out.println("O nome da escola é " + aluno1.getNomeEscola());

	}
}