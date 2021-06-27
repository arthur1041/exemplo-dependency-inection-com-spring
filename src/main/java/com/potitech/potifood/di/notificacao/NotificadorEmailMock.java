package com.potitech.potifood.di.notificacao;

import com.potitech.potifood.di.model.Cliente;


public class NotificadorEmailMock implements Notificador {
	
	private boolean caixaAlta;
	private String hostServidorSmtp;
	
	public NotificadorEmailMock(String hostServidorSmtp) {
		this.hostServidorSmtp = hostServidorSmtp;
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		if(this.caixaAlta) {
			mensagem = mensagem.toUpperCase();
		}
		
		System.out.printf("MOCK: Notificando %s através do e-mail %s usando SMTP %s: %s\n", cliente.getNome(), cliente.getEmail(), this.hostServidorSmtp,  mensagem);
	}

	public boolean isCaixaAlta() {
		return caixaAlta;
	}

	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}
	
	
	
}
