package com.potitech.potifood;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.potitech.potifood.di.notificacao.HierarquiaEnum;
import com.potitech.potifood.di.notificacao.Notificador;
import com.potitech.potifood.di.notificacao.NotificadorEmail;
import com.potitech.potifood.di.notificacao.NotificadorEmailMock;
import com.potitech.potifood.di.notificacao.TipoDoNotificador;
import com.potitech.potifood.di.service.AtivacaoClienteService;

@Configuration
public class PotiConfig {

	@Bean
	@TipoDoNotificador(HierarquiaEnum.PRIMARIO)
	@Profile("prod")
	public NotificadorEmail notificadorEmail(){
		NotificadorEmail notificador = new NotificadorEmail("smtp.potimail.com.br");
		notificador.setCaixaAlta(false);
		
		return notificador;
	}
	
	@Bean
	@TipoDoNotificador(HierarquiaEnum.PRIMARIO)
	@Profile("dev")
	public NotificadorEmailMock notificadorEmailMock(){
		NotificadorEmailMock notificador = new NotificadorEmailMock("smtp.potimail.com.br");
		notificador.setCaixaAlta(false);
		
		return notificador;
	}
	
//	@Bean
//	public AtivacaoClienteService ativacaoClienteService(Notificador notificador) {
//		return new AtivacaoClienteService(notificador);
//	}
	
}
