package cursojava.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cursojava.constantes.StatusAluno;

/* Essa é a classe que representa o objeto Aluno 13/06/2024 
 * 
*/
public class Aluno extends Pessoa {

	
	String dataMatricula;
	String nomeEscola;
	String serieMatriculado;
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	/*
	 * Sem USO após a implantação das listas.
	 * public void setDisciplina(Disciplina disciplina) { this.disciplina =
	 * disciplina; }
	 */
	/*
	 * public Disciplina getDisciplina() { return disciplina; }
	 */	

	public Aluno() {
		
	}
	/* 
	 * GET = resgatar ou obter valor do atributo
	 * SET = adicionar ou receber dados para os atributos
	 * */

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRegistroGeral() {
		return registroGeral;
	}

	public void setRegistroGeral(String registroGeral) {
		this.registroGeral = registroGeral;
	}

	public String getNumeroCPF() {
		return numeroCPF;
	}

	public void setNumeroCPF(String numeroCPF) {
		this.numeroCPF = numeroCPF;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public String getSerieMatriculado() {
		return serieMatriculado;
	}

	public void setSerieMatriculado(String serieMatriculado) {
		this.serieMatriculado = serieMatriculado;
	}
	
	public double getMediaNota() {
		/*
		 * vamos remover esse return para implantar o cálculo usando listas 19/06/2024
		 *		return (disciplina.getNota1() +disciplina.getNota2() + disciplina.getNota3() + disciplina.getNota4() )/4;
		 */
		double somaNota = 0.0;
		for (Disciplina disciplina: disciplinas) {
			somaNota += disciplina.getMediaNotas();
		}
		return somaNota / disciplinas.size();
	}
	public boolean getAlunoAprovado() {
		double media = this.getMediaNota();
		if (media >=70) {
			return true;
		}else {
			return false;
		}
	}
	public String getAlunoAprovado2() {
		double media = this.getMediaNota();
		if (media >= 50) {
			if (media >=70) {
				return StatusAluno.APROVADO;
			}
			else {
				return StatusAluno.RECUPERACAO;
			}				
		}
		else {
			return StatusAluno.REPROVADO;
		}
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(dataMatricula, dataNascimento, idade, nome, nomeEscola, nomeMae, nomePai, numeroCPF,
				registroGeral, serieMatriculado);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(dataMatricula, other.dataMatricula)
				&& Objects.equals(dataNascimento, other.dataNascimento) && idade == other.idade
				&& Objects.equals(nome, other.nome) && Objects.equals(nomeEscola, other.nomeEscola)
				&& Objects.equals(nomeMae, other.nomeMae) && Objects.equals(nomePai, other.nomePai)
				&& Objects.equals(numeroCPF, other.numeroCPF) && Objects.equals(registroGeral, other.registroGeral)
				&& Objects.equals(serieMatriculado, other.serieMatriculado);
	}
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", registroGeral="
				+ registroGeral + ", numeroCPF=" + numeroCPF + ", nomeMae=" + nomeMae + ", nomePai=" + nomePai
				+ ", dataMatricula=" + dataMatricula + ", nomeEscola=" + nomeEscola + ", serieMatriculado="
				+ serieMatriculado + "]";
	}
	
	@Override
	public boolean pessoaMaiorIdade() {
	    return idade >=13;
	//	return super.pessoaMaiorIdade();
	}
	public String msgMaiorIdade() {
		return this.pessoaMaiorIdade() ? "Sim, é maior de idade!" : "Não, não é maior de idade!";
	}
	/*
	 * Método abstrato declarado na classe PESSOA e foi implementado
	 * automaticamente na classe filha ALUNO
	 * 02/07/2024 - aula 10.7
	 */
	@Override
	public double salario() {
	
		return 1230.00;
	}
	
	
}