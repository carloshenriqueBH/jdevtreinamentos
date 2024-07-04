/**
 * 
 */
package cursojava.classesauxiliares;

import cursoJavaInterfaces.PermitirAcesso;

/**
 * Somente receber alguém que tem o contrato da interface
 * de permissão de acesso - aula 10-14 - 04/07/2024
 */
public class FuncaoAutenticacao {
	
	private PermitirAcesso permitirAcesso;
	
	public boolean autenticar() {
		return permitirAcesso.autenticar();
	}
	public FuncaoAutenticacao(PermitirAcesso acesso) {
		this.permitirAcesso = acesso;
		
	}
}
