package com.potitech.potifood.di.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.potitech.potifood.di.event.ClienteAtivadoEvent;
import com.potitech.potifood.di.notificacao.HierarquiaEnum;
import com.potitech.potifood.di.notificacao.Notificador;
import com.potitech.potifood.di.notificacao.TipoDoNotificador;

@Component
public class NotificacaoListener {
	
	@Autowired
	@TipoDoNotificador(HierarquiaEnum.PRIMARIO)
	private Notificador notificador;
	
	@EventListener
	public void clienteAtivadoListener(ClienteAtivadoEvent event) {
		System.out.println("Cliente " + event.getCliente().getNome() + " agora está ativo.");
		notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo!");
	}
	
}
