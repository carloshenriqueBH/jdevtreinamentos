package cursojava.excecao;

public class ExcecaoProcessarNota extends Exception {

	public ExcecaoProcessarNota(String erro) {
		super("Existe um erro no processamento das notas do aluno: "+erro);
	}
}
