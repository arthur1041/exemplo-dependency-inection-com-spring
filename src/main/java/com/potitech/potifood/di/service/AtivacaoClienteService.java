package com.potitech.potifood.di.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.potitech.potifood.di.event.ClienteAtivadoEvent;
import com.potitech.potifood.di.model.Cliente;
import com.potitech.potifood.di.notificacao.HierarquiaEnum;
import com.potitech.potifood.di.notificacao.Notificador;
import com.potitech.potifood.di.notificacao.TipoDoNotificador;

@Component
public class AtivacaoClienteService {

	// Pontos de injeção

//	@Autowired
//	@TipoDoNotificador(HierarquiaEnum.PRIMARIO)
//	private Notificador notificador;
//
//	@PostConstruct
//	public void init() {
//		System.out.println("INIT");
//	}
//
//	@PreDestroy
//	public void destroy() {
//		System.out.println("DESTROY");
//	}

//	@Autowired
//	public AtivacaoClienteService(Notificador notificador) {
//		this.notificador = notificador;
//	}

//	@Autowired
//	public void setNotificador(Notificador notificador) {
//		this.notificador = notificador;
//	}
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;

	public void ativar(Cliente cliente) {
		
		
		cliente.setAtivo(true);

		//Dizer para o container que o cliente está ativo neste momento
		
		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
		
//		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");

	}

}
