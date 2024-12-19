package br.com.emailproject.dto;

import br.com.emailproject.model.Email;

public class EmailLayout {

	private static final String QUEBRA_DE_LINHA_SIMPLES = "<br>";
	private static final String QUEBRA_DE_LINHA_DUPLA = "<br><br>";
	public Email montarEmailAdministrador(String destinatario, String assunto) {
		
		StringBuilder texto = new StringBuilder();
		texto.append("A/C Administrador")
		.append(QUEBRA_DE_LINHA_DUPLA)
		.append("---------------------------");
		texto.append("Solicito a troca da senha do usuário xlxks")
		.append(QUEBRA_DE_LINHA_DUPLA);
		
		gerarAssinatura(texto);
		
		retornaRodape(texto);		
		
		return new Email(destinatario, assunto, texto.toString());
	}
	private String gerarAssinatura(StringBuilder texto) {
		return texto
				.append("Att.:")
				.append(QUEBRA_DE_LINHA_SIMPLES)
				.append("Operador de caixa")
				.append(QUEBRA_DE_LINHA_DUPLA)
				.toString();
		
	}
	
	private String retornaRodape(StringBuilder texto) {
		return texto.append("Email automático - Favor não responder").toString();
	}
}