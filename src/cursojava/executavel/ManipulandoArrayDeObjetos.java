package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

public class ManipulandoArrayDeObjetos {

	public static void main(String[] args) {
		double[] notasJava = { 7.8, 8.3, 4.5, 9.6 };
		double[] notasHtml = { 8.2, 8.0, 8.5, 9.0 };
		double[] notasCSS = { 6.2, 8.5, 4.5, 6.3 };
		double[] notasJavaScript = { 5.6, 5.9, 9.5, 9.8 };
		
		Aluno aluno = new Aluno();
		Aluno aluno2 = new Aluno();
		Aluno aluno3 = new Aluno();

		aluno.setNome("Carlos Henrique");
		aluno.setNomeEscola("JDEV Treinamentos");
				
		aluno2.setNome("João da Silva");
		aluno2.setNomeEscola("Champangnat");
		
		aluno3.setNome("Maria das Graças");
		aluno3.setNomeEscola("Chrome");

		Disciplina disciplina = new Disciplina();
		disciplina.setDisciplina("Java");
		disciplina.setNota(notasJava);		

		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("CSS");
		disciplina2.setNota(notasCSS);
		
		Disciplina disciplina3 = new Disciplina();
		disciplina3.setDisciplina("JavaScript");
		disciplina3.setNota(notasHtml);
		
		Disciplina disciplina4 = new Disciplina();
		disciplina4.setDisciplina("HTML");
		disciplina4.setNota(notasHtml);

		aluno.getDisciplinas().add(disciplina);
		aluno.getDisciplinas().add(disciplina2);
		aluno.getDisciplinas().add(disciplina3);
		aluno.getDisciplinas().add(disciplina4);
	
		
		aluno2.getDisciplinas().add(disciplina2);
		aluno2.getDisciplinas().add(disciplina2);
		aluno2.getDisciplinas().add(disciplina3);
		aluno2.getDisciplinas().add(disciplina4);
		
		aluno3.getDisciplinas().add(disciplina2);
		aluno3.getDisciplinas().add(disciplina2);
		aluno3.getDisciplinas().add(disciplina3);
		aluno3.getDisciplinas().add(disciplina4);

		

		// --------------------------------

		Aluno arrayAlunos[] = new Aluno[3];
		arrayAlunos[0] = aluno;
		arrayAlunos[1] = aluno2;
		arrayAlunos[2] = aluno3;
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
