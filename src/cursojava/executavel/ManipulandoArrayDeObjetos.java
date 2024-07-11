package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

public class ManipulandoArrayDeObjetos {

	public static void main(String[] args) {
		double[] notasJava = { 7.8, 8.3, 4.5, 9.6 };
		double[] notasHtml = { 8.2, 8.0, 8.5, 9.0 };

		Aluno aluno = new Aluno();

		aluno.setNome("Carlos Henrique");
		aluno.setNomeEscola("JDEV Treinamentos");

		Disciplina disciplina = new Disciplina();
		disciplina.setDisciplina("Java");
		disciplina.setNota(notasJava);

		aluno.getDisciplinas().add(disciplina);

		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("HTML");
		disciplina2.setNota(notasHtml);

		aluno.getDisciplinas().add(disciplina2);

		// --------------------------------

		Aluno arrayAlunos[] = new Aluno[1];
		arrayAlunos[0] = aluno;

		for (int pos = 0; pos < arrayAlunos.length; pos++) {
			System.out.println("Nome do aluno: " + arrayAlunos[pos].getNome());
			for (Disciplina d : arrayAlunos[pos].getDisciplinas()) {
				System.out.println("Disciplinas do aluno: " + d.getDisciplina());
				for (int posNota = 0; posNota < d.getNota().length; posNota++) {
					System.out.println("Notas da disciplina : " + (posNota + 1) + " é : " + d.getNota()[posNota]);
				}
			}
		}

	}

}
