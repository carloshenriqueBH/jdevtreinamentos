package cursoJavaInterfaces;

/* 
 * Essa interface vai funcionar como um "contrato de autenticação" - aula 10.11 03/07/2024
 */
public interface PermitirAcesso {
	
	public boolean autenticar(String login, String senha);
	public boolean autenticar();
	

}
