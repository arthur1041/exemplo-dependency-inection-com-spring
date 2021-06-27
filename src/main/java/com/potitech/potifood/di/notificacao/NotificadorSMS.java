package com.potitech.potifood.di.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.potitech.potifood.di.model.Cliente;

@Component
@TipoDoNotificador(HierarquiaEnum.SECUNDARIO)
public class NotificadorSMS implements Notificador{

	public void notificar(Cliente cliente, String mensagem) {
		System.out.println("Notificando " + cliente.getNome() + " por SMS através do telefone " + cliente.getTelefone()+": "+mensagem);
	}

}
