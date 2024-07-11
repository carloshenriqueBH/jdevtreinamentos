package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

public class ArrayVetor {

	public static void main(String[] args) {

		double[] notasJava = { 7.8, 8.3, 4.5, 9.6 };
		double[] notasHtml = { 8.2, 8.0, 8.5, 9.0 };
		double[] notasCSS = { 7.5, 5.9, 9.6, 10.0 };
		double[] notasLogica = { 8.9, 9.0, 9.6, 8.7 };
		Aluno aluno = new Aluno();

		aluno.setNome("Carlos Henrique");
		aluno.setNomeEscola("JDEV Treinamentos");

		Disciplina disciplina = new Disciplina();
		disciplina.setDisciplina("Java");
		disciplina.setNota(notasJava);

		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("HTML");
		disciplina2.setNota(notasHtml);

		Disciplina disciplina3 = new Disciplina();
		disciplina3.setDisciplina("CSS");
		disciplina3.setNota(notasCSS);

		Disciplina disciplina4 = new Disciplina();
		disciplina4.setDisciplina("Lógica de programação");
		disciplina4.setNota(notasLogica);
		aluno.getDisciplinas().add(disciplina);
		aluno.getDisciplinas().add(disciplina2);
		aluno.getDisciplinas().add(disciplina3);
		aluno.getDisciplinas().add(disciplina4);
		System.out.println("=====================================================================");
		System.out.println("Nome do Aluno: " + aluno.getNome() + " matriculado no curso " + aluno.getNomeEscola());
		System.out.println("=====================================================================");

		for (Disciplina d : aluno.getDisciplinas()) {
			// System.out.println(contaDisciplinas + 1 + "a" + " Disciplina: " +
			// d.getDisciplina() + " Nota: "
			// + disc.getNota()[contaDisciplinas]);
			System.out.println("Disciplina: " + d.getDisciplina());
			System.out.println("As notas da disciplina são: ");
			double notaMax = 0.0;
			double notaMin = 0.0;
			for (int pos = 0; pos < d.getNota().length; pos++) {
				System.out.println("Nota: " + (pos + 1) + " é igual a: " + d.getNota()[pos]);
				if (pos == 0) {
					notaMax = d.getNota()[pos];
				} else {
					if (d.getNota()[pos] < notaMax) { // inverte o sinal de maior que para menor que
						notaMax = d.getNota()[pos];
						
					}
				}
			}
			System.out.println("=====================================================================");
			System.out.println("A menor nota da disciplina "+d.getDisciplina()+" é: " + notaMax);
		
		}
	}
}
