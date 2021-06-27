package com.potitech.potifood.di.notificacao;

import com.potitech.potifood.di.model.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);

}