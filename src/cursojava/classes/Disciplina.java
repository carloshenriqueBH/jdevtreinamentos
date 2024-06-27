package cursojava.classes;

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
	private double nota;
	private String disciplina;

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "Disciplina [nota=" + nota + ", disciplina=" + disciplina + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(disciplina, nota);
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
		return Objects.equals(disciplina, other.disciplina)
				&& Double.doubleToLongBits(nota) == Double.doubleToLongBits(other.nota);
	}

}
