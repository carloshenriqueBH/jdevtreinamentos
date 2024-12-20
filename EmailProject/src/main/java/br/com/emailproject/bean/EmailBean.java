package br.com.emailproject.bean;

import java.io.Serializable;

import br.com.emailproject.dto.EmailLayout;
import br.com.emailproject.model.Email;
import br.com.emailproject.service.EmailService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class EmailBean implements Serializable {

		private static final long serialVersionUID = 4538755582654584073L;

		private static final String DESTINATARIO = "carlhenrique@gmail.com";
		private static final String ASSUNTO = "trocar Senha";
		@Inject
		private EmailService emailService;
		
		public String enviarEmail() {
			emailService.enviar(montarEmail()); 
			return null;				
		}
		private Email montarEmail() {
			EmailLayout layout = new EmailLayout();
			return layout.montarEmailAdministrador(DESTINATARIO,ASSUNTO);
		}
	
	
}
