package cursojava.executavel;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

public class PrimeiraClasseJava {
	public static void main(String[] args) {

		Aluno aluno1 = new Aluno();
		/*
		 * Instância do Objeto: Criação do Objeto aluno1 é uma referência para o objeto
		 * aluno
		 */

		String nome = "Carlos Henrique";
		String idade = "63";
		String dataNascimento = "10/07/1960";
		String RG = "M-1.567.940 SSPMG";
		String CPF = "403.309.156-49";
		String nomeMae = "Sudaria";
		String nomePai = "Joaquim";
		String dataMatricula = "14/02/2024";
		String serieMatriculado = "1";
		String nomeEscola = "JDev Treinamentos";
		/*
		 * RECEBENDO AS DISCIPLINAS DE FORMA DINÂMICA USANDO UM "FOR" - AULA 9.22 -
		 * 21/06/2024
		 */
		for (int pos = 1; pos <= 4; pos++) {
			String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + Integer.valueOf(pos) + " ? ");
			String notaDisciplina = JOptionPane
					.showInputDialog("Qual a nota da disciplina " + Integer.valueOf(pos) + " ? ");

			Disciplina disciplina = new Disciplina();
			disciplina.setDisciplina(nomeDisciplina);
			disciplina.setNota(Integer.valueOf(notaDisciplina));

			aluno1.getDisciplinas().add(disciplina);
		} 

		int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina? ");
		if (escolha == 0) {
			String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina? 1/2/3 ou 4" );
			aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue());
		}
		
		System.out.println(aluno1);
		System.out.println("Média do aluno: " + aluno1.getMediaNota());
		System.out.println("Situação do aluno: " + aluno1.getAlunoAprovado());

		aluno1.setNome(nome);
		aluno1.setIdade(Integer.valueOf(idade));
		aluno1.setDataNascimento(dataNascimento);
		aluno1.setRegistroGeral(RG);
		aluno1.setNumeroCPF(CPF);
		aluno1.setNomeMae(nomeMae);
		aluno1.setNomePai(nomePai);
		aluno1.setDataMatricula(dataMatricula);
		aluno1.setSerieMatriculado(serieMatriculado);
		aluno1.setNomeEscola(nomeEscola);

		System.out.println("O nome do aluno 1 é " + aluno1.getNome());
		System.out.println("A idade é " + aluno1.getIdade());
		System.out.println("A data de nascimento é " + aluno1.getDataNascimento());
		System.out.println("O documento de identidade é " + aluno1.getRegistroGeral());
		System.out.println("O número do CPF é " + aluno1.getNumeroCPF());
		System.out.println("O nome da mãe é " + aluno1.getNomeMae());
		System.out.println("O nome do pai é " + aluno1.getNomePai());
		System.out.println("A data de matrícula é " + aluno1.getDataMatricula());
		System.out.println("A Série da matrícula é " + aluno1.getSerieMatriculado());
		System.out.println("O nome da escola é " + aluno1.getNomeEscola());

		System.out.println("A média de notas do aluno 1 é " + aluno1.getMediaNota());
		System.out.println("Situação do aluno: " + (aluno1.getAlunoAprovado() ? "Aprovado" : "Reprovado"));

		System.out.println(aluno1.toString());
		System.out.println("A média de notas do aluno 1 é " + aluno1.getMediaNota());
		System.out.println("Situação do aluno: " + (aluno1.getAlunoAprovado() ? "Aprovado" : "Reprovado"));

	}
}