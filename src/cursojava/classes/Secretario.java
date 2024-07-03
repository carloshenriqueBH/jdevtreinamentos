package cursojava.classes;

import cursoJavaInterfaces.PermitirAcesso;

public class Secretario extends Pessoa implements PermitirAcesso {

	private String registro;
	private String nivelCargo;

	private String login;
	private String senha;

	public Secretario() {

	}

	public Secretario(String login, String senha) {
		this.login = login;
		this.senha = senha;
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

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getNivelCargo() {
		return nivelCargo;
	}

	public void setNivelCargo(String nivelCargo) {
		this.nivelCargo = nivelCargo;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	private String experiencia;

	@Override
	public double salario() {

		return 1900.00 * 1.4;
	}

	public boolean autenticar() {
		return login.equalsIgnoreCase("admin") && (senha.equalsIgnoreCase("admin"));
	}

	public boolean autenticar(String login, String senha) {
		this.login = login;
		this.senha = senha;
		// return login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin");
		return autenticar();
	}

}
