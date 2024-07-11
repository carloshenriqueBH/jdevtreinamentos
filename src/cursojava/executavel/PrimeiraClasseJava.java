package cursojava.executavel;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Disciplina;
import cursojava.classes.Secretario;
import cursojava.classesauxiliares.FuncaoAutenticacao;
import cursojava.constantes.StatusAluno;
import cursojava.excecao.ExcecaoProcessarNota;
import cursoJavaInterfaces.PermitirAcesso;

public class PrimeiraClasseJava {

	public static void main(String[] args) {

		try {

		//	lerArquivo();

			String login = JOptionPane.showInputDialog("Informe o Login: ");
			String senha = JOptionPane.showInputDialog("Informe a Senha: ");

			if (new FuncaoAutenticacao(new Diretor(login, senha)).autenticar()) {

				List<Aluno> alunos = new ArrayList<Aluno>();
				// List<Aluno> alunos = null;

				HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

				for (int qtde = 1; qtde < 4; qtde++) {

					Aluno aluno1 = new Aluno();
					String nomeAluno = JOptionPane.showInputDialog("Nome do Aluno? " + qtde + " ?");
					String idadeAluno = JOptionPane.showInputDialog("Qual a idade do Aluno? " + qtde + " ?");
					aluno1.setNome(nomeAluno);
					aluno1.setIdade(Integer.valueOf(idadeAluno));
					/*
					 * Instância do Objeto: Criação do Objeto aluno1 é uma referência para o objeto
					 * aluno
					 */

					/*
					 * RECEBENDO AS DISCIPLINAS DE FORMA DINÂMICA USANDO UM "FOR" - AULA 9.22 -
					 * 21/06/2024
					 */
					for (int pos = 1; pos <= 1; pos++) {
						String nomeDisciplina = JOptionPane
								.showInputDialog("Nome da disciplina " + Integer.valueOf(pos) + " ? ");
					//	String notaDisciplina = JOptionPane.showInputDialog("Qual a nota da disciplina " + Integer.valueOf(pos) + " ? ");

						Disciplina disciplina = new Disciplina();
						disciplina.setDisciplina(nomeDisciplina);
				//		disciplina.setNota(Integer.valueOf(notaDisciplina));
						aluno1.getDisciplinas().add(disciplina);
					}

					alunos.add(aluno1);
				}
				maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
				maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
				maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
				/*
				 * SEPARANDO OS ALUNOS EM TRÊS LISTAS: APROVADOS, REPROVADOS E EM RECUPERAÇÃO
				 * AULA 9.32 EM 28/06/2024
				 */
				for (Aluno aluno : alunos) {
					if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
						maps.get(StatusAluno.APROVADO).add(aluno);
						// alunosAprovados.add(aluno);
					} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
						// alunosRecuperacao.add(aluno);
						maps.get(StatusAluno.RECUPERACAO).add(aluno);
					} else {
						maps.get(StatusAluno.REPROVADO).add(aluno);
						// alunosReprovados.add(aluno);
					}
				}

				System.out.println("-------------------LISTA DOS ALUNOS REPROVADOS:-------------------");
				// for (Aluno aluno: alunosReprovados) {
				for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
					System.out.println("Resultado = " + aluno.getNome() + " " + aluno.getAlunoAprovado2()
							+ " Com a média " + aluno.getMediaNota());
				}
				System.out.println("------------------------------------------------------------------");

				System.out.println("-------------------LISTA DOS ALUNOS EM RECUPERAÇÃO:-------------------");
				// for (Aluno aluno: alunosRecuperacao) {
				for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
					System.out.println("Resultado = " + aluno.getNome() + " " + aluno.getAlunoAprovado2()
							+ " Com a média " + aluno.getMediaNota());
				}
				System.out.println("------------------------------------------------------------------");
				System.out.println("-------------------LISTA DOS ALUNOS APROVADOS:-------------------");
				for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
					System.out.println("Resultado = " + aluno.getNome() + " " + aluno.getAlunoAprovado2()
							+ " Com a média " + aluno.getMediaNota());
				}
				System.out.println("------------------------------------------------------------------");
			} else {
				System.out.println("Você não forneceu um login ou senha válidos!");
			}

		} catch (NumberFormatException e) {
			StringBuilder saida = new StringBuilder();
			// e.printStackTrace();
			System.out.println("Mensagem: " + e.getMessage());

			for (int pos = 0; pos < e.getStackTrace().length; pos++) {
				saida.append("\nClasse onde ocorreu o erro  : " + e.getStackTrace()[pos].getClassName());
				saida.append("\nMétodo onde ocorreu o erro  : " + e.getStackTrace()[pos].getMethodName());
				saida.append("\nLinha onde ocorreu o erro   : " + e.getStackTrace()[pos].getLineNumber());
				saida.append("\nClass                       : " + e.getClass().getName());
			}
			JOptionPane.showMessageDialog(null, "Erro na conversão de número! " + saida.toString());
		} catch (Exception e) {
			StringBuilder saida = new StringBuilder();
			// e.printStackTrace();
			System.out.println("Mensagem: " + e.getMessage());

			for (int pos = 0; pos < e.getStackTrace().length; pos++) {
				saida.append("\nClasse onde ocorreu o erro  : " + e.getStackTrace()[pos].getClassName());
				saida.append("\nMétodo onde ocorreu o erro  : " + e.getStackTrace()[pos].getMethodName());
				saida.append("\nLinha onde ocorreu o erro   : " + e.getStackTrace()[pos].getLineNumber());
				saida.append("\nClass                       : " + e.getClass().getName());
			}
			JOptionPane.showMessageDialog(null, "Ocorreu um erro! " + saida.toString());
		} finally {
			JOptionPane.showMessageDialog(null, "Processamento concluído!");
		}
	}

	public static void lerArquivo() throws FileNotFoundException {

		File fil = new File("C://lines.txt");
		Scanner scan = new Scanner(fil);
		scan.close();

	}
}