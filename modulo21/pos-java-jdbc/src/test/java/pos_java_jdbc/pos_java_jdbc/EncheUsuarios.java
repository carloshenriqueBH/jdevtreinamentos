package pos_java_jdbc.pos_java_jdbc;

public class EncheUsuarios {

	public String retornaNome() {
		String[] primeiraLista = { "João", "Pedro", "Marina", "Clara", "Joaquim", "Enio", "Pinduca" };
		String[] segundaLista = { "da Silva", "dos Santos", "Faria Lima", "Ferreira Lopes", "Cerqueira Cezar" };
		String[] terceiraLista = { "Jorge", "e Santos", "de Lima", "Canto e Silva", "Moreira Franco", "Aguiar" };
		java.util.Random randomGenerator = new java.util.Random();
		int tamanhoPrimeira = primeiraLista.length;
		int tamanhoSegunda = segundaLista.length;
		int tamanhoTerceira = terceiraLista.length;
		int rnd1 = randomGenerator.nextInt(tamanhoPrimeira);
		int rnd2 = randomGenerator.nextInt(tamanhoSegunda);
		int rnd3 = randomGenerator.nextInt(tamanhoTerceira);
		String primeiroNome = primeiraLista[rnd1];
		String nomeDoMeio = segundaLista[rnd2];
		String sobreNome = terceiraLista[rnd3];
		String nomeCompleto = primeiroNome + 
				" "+nomeDoMeio +
				" "+sobreNome;
		
		return nomeCompleto;
	}
}