package cursojava.classes;

import java.util.Arrays;
import java.util.Objects;

/* 
 * A classe Disciplina servirá para todos os objetos e instâncias tanto de notas quanto de matérias.
 */
public class Disciplina {
	/*
	 * Movendo os atributos disciplinas e notas da clsse Aluno para essa nova classe
	 * aula 9.18 - 19/06/2024
	 */

	/*
	 * 
	 * Passando a usar listas - 19/06/2024: aula 9.20 Todo o código anterior será
	 * apagado (vou comentar e salvar no final da classe
	 */
	private double[] nota = new double[4];
	private String disciplina;


	public String getDisciplina() {
		return disciplina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + Arrays.hashCode(nota);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (!Arrays.equals(nota, other.nota))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina [nota=" + Arrays.toString(nota) + ", disciplina=" + disciplina + "]";
	}
	
	public double getMediaNotas() {
		double somaNotas = 0;
		for (int i=0; i < nota.length; i++) {
			somaNotas += nota[i];
		}
		return somaNotas/nota.length;
	}

	public double[] getNota() {
		return nota;
	}

	public void setNota(double[] nota) {
		this.nota = nota;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}	
}
