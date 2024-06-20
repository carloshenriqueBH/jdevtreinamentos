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

		// A partir aula 9.14 - Entrada de dados pelo teclado - 18/06/2024

		String xxx = JOptionPane.showInputDialog("xxxx");
		String nome = JOptionPane.showInputDialog("Qual o nome do aluno? ");
		String idade = JOptionPane.showInputDialog("Qual a idade do aluno? ");
		String dataNascimento = JOptionPane.showInputDialog("Qual a data de nascimento do aluno? ");
		String RG = JOptionPane.showInputDialog("Qual o Registro Geral ? ");
		String CPF = JOptionPane.showInputDialog("Qual CPF ? ");
		String nomeMae = JOptionPane.showInputDialog("Qual o nome da Mãe ? ");
		String nomePai = JOptionPane.showInputDialog("Qual o nome do Pai ? ");
		String dataMatricula = JOptionPane.showInputDialog("Qual da data da matrícula ? ");
		String serieMatriculado = JOptionPane.showInputDialog("Série matriculado ? ");
		String nomeEscola = JOptionPane.showInputDialog("Qual o nome da escola ? ");
		/*
		 * Saiu quando começamos a usar lista de disciplinas 19/06/2024
		 * 
		 * String disciplina1 = JOptionPane.showInputDialog("Disciplina 1: "); String
		 * nota1 = JOptionPane.showInputDialog("Qual a nota da primeira prova ? ");
		 * String disciplina2 = JOptionPane.showInputDialog("Disciplina 2: "); String
		 * nota2 = JOptionPane.showInputDialog("Qual a nota da segunda prova ? ");
		 * String disciplina3 = JOptionPane.showInputDialog("Disciplina 3: "); String
		 * nota3 = JOptionPane.showInputDialog("Qual a nota da terceira prova ? ");
		 * String disciplina4 = JOptionPane.showInputDialog("Disciplina 4: "); String
		 * nota4 = JOptionPane.showInputDialog("Qual a nota da quarta prova ? ");
		 */

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
		/*
		 * recebe os dados das disciplinas - depois faremos isso dinamicamente
		 */
		
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setDisciplina("HTML");
		disciplina1.setNota(90);
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("CSS");
		disciplina2.setNota(92);
		
		Disciplina disciplina3 = new Disciplina();
		disciplina3.setDisciplina("JAVA");
		disciplina3.setNota(88);
		

		Disciplina disciplina4 = new Disciplina();
		disciplina4.setDisciplina("PHP");
		disciplina4.setNota(66);
		
		aluno1.getDisciplinas().add(disciplina1);
		aluno1.getDisciplinas().add(disciplina2);
		aluno1.getDisciplinas().add(disciplina3);
		aluno1.getDisciplinas().add(disciplina4);
		
		
		/*
		 * Esse bloco de código não funciona mais a partir da implantação 
		 * da lista de disciplinas 19/06/2024
		 * 
		 * aluno1.getDisciplina().setNota1(Integer.valueOf(nota1));
		 * aluno1.getDisciplina().setNota2(Integer.valueOf(nota2));
		 * aluno1.getDisciplina().setNota3(Integer.valueOf(nota3));
		 * aluno1.getDisciplina().setNota4(Integer.valueOf(nota4));
		 * aluno1.getDisciplina().setDisciplina1(disciplina1);
		 * aluno1.getDisciplina().setDisciplina2(disciplina2);
		 * aluno1.getDisciplina().setDisciplina3(disciplina3);
		 * aluno1.getDisciplina().setDisciplina4(disciplina4);
		 */
		/*
		 * removido para uso do toString() 19/06/2024 retornou a partir da aula 9.17
		 * 19/06/2024
		 */

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
		
		/*
		 * removido para uso do toString() 19/06/2024 retornou a partir da aula 9.17
		 * 19/06/2024
		 * System.out.println("O nome da disciplina 1 é "+aluno1.getDisciplina1() );
		 * System.out.println("A nota da primeira prova foi " + aluno1.getNota1());
		 * System.out.println("O nome da disciplina 2 é "+aluno1.getDisciplina2());
		 * System.out.println("A nota da segunda prova foi " + aluno1.getNota2());
		 * System.out.println("O nome da disciplina 3 é "+aluno1.getDisciplina3());
		 * System.out.println("A nota da terceira prova foi " + aluno1.getNota3());
		 * System.out.println("O nome da disciplina 4 é "+aluno1.getDisciplina4());
		 * System.out.println("A nota da quarta prova foi " + aluno1.getNota4());
		 */
		  System.out.println("A média de notas do aluno 1 é " + aluno1.getMediaNota());
		  System.out.println("Situação do aluno: " + (aluno1.getAlunoAprovado() ?
		  "Aprovado" : "Reprovado"));
		 
		
		  System.out.println(aluno1.toString());
		  System.out.println("A média de notas do aluno 1 é "+ aluno1.getMediaNota());
		  System.out.println("Situação do aluno: " + (aluno1.getAlunoAprovado() ?
		  "Aprovado" : "Reprovado"));
		 

		/*
		 * EQUALS E HASHCODE: Diferenciar e comparar objetos - aula 9.16 - 19/06/2024
		 * 
		 * Aluno aluno1 = new Aluno(); Aluno aluno2 = new Aluno();
		 * aluno1.setNome("Carlos"); aluno2.setNome("Carlos"); if
		 * (aluno1.equals(aluno2)) { System.out.println("Alunos são iguais."); } else {
		 * System.out.println("Alunos não são iguais."); }
		 */
	}
}