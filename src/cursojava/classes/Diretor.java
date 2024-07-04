package cursojava.classes;

import cursoJavaInterfaces.PermitirAcesso;

public class Diretor extends Pessoa implements PermitirAcesso {
	
	private String registroEducacao;
	private int tempoDirecao;
	private String titulacao;
	private String login;
	private String senha;
	
	public Diretor(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	public Diretor() {
		
	}
	
	public String getRegistroEducacao() {
		return registroEducacao;
	}
	public void setRegistroEducacao(String registroEducacao) {
		this.registroEducacao = registroEducacao;
	}
	public int getTempoDirecao() {
		return tempoDirecao;
	}
	public void setTempoDirecao(int tempoDirecao) {
		this.tempoDirecao = tempoDirecao;
	}
	public String getTitulacao() {
		return titulacao;
	}
	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	@Override
	public String toString() {
		return "Diretor [registroEducacao=" + registroEducacao + ", tempoDirecao=" + tempoDirecao + ", titulacao="
				+ titulacao + ", login=" + login + ", senha=" + senha + ", nome=" + nome + ", idade=" + idade
				+ ", dataNascimento=" + dataNascimento + ", registroGeral=" + registroGeral + ", numeroCPF=" + numeroCPF
				+ ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + "]";
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public double salario() {
		// TODO Auto-generated method stub
		return 3400.00;
	}
	
	public boolean autenticar() {
		return login.equalsIgnoreCase("carlim") && (senha.equalsIgnoreCase("1645"));
	}

	public boolean autenticar(String login, String senha) {
		this.login = login;
		this.senha = senha;
		return autenticar();
	}
	
	
}
