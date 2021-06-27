package com.potitech.potifood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.potitech.potifood.di.model.Cliente;
import com.potitech.potifood.di.service.AtivacaoClienteService;

@Controller 
public class MyFirstController {
	
	private AtivacaoClienteService ativacaoClienteService;
	
	public MyFirstController(AtivacaoClienteService ativacaoClienteService) {
		this.ativacaoClienteService = ativacaoClienteService;
	}

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		Cliente joao = new Cliente("João", "joao@xyz.com", "99999999", false);
	
		ativacaoClienteService.ativar(joao);
		
		return "Cliente " + joao.getNome() + " ativado!";
	}
}
