package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Secretario;

public class TestandoClassesFilhas {

	public static void main(String[] args) {
		
		Aluno aluno = new Aluno();
		aluno.setNome("Carlos Henrique");
		aluno.setIdade(13);

		Diretor diretor = new Diretor();
		diretor.setRegistroEducacao("xxxx");
		diretor.setIdade(63);
		
		Secretario secretario = new Secretario();
		secretario.setExperiencia("Administracao");
		secretario.setIdade(49);
		
		System.out.println(diretor);
		System.out.println(aluno);
		System.out.println(secretario);
		
		System.out.println("Salário do diretor: "+diretor.salario());
		System.out.println("Salário do aluno: "+aluno.salario());
		System.out.println("Salário do secretário: "+secretario.salario());
		
		System.out.println(aluno.pessoaMaiorIdade()+" - "+aluno.msgMaiorIdade());
		System.out.println(diretor.pessoaMaiorIdade());
		System.out.println(secretario.pessoaMaiorIdade());
	}

	
}
