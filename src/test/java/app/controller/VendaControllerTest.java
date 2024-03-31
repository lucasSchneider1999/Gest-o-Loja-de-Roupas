package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import app.repository.VendaRepository;

public class VendaControllerTest {

		@Autowired
		VendaController vendacontroller;
		
		@MockBean
		VendaRepository vendaRepository;
}
