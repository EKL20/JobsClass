package com.personalSoft.tallerFullStack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.personalSoft.tallerFullStack.constants.ConstApis;
import com.personalSoft.tallerFullStack.dto.RegDTO;
import com.personalSoft.tallerFullStack.response.RespuestaGenerica;
import com.personalSoft.tallerFullStack.services.RegService;

@RestController
@RequestMapping(value = ConstApis.REG_API)
public class ControllersReg {
	
	@Autowired
	private RegService regService;
	
	@GetMapping(value = ConstApis.REG_API_OBTENER)
	public @ResponseBody ResponseEntity<RespuestaGenerica> obtenerReg(@RequestParam long id) {
		return this.regService.obtenerReg(id);
	}
	
	@PostMapping(value = ConstApis.REG_API_GUARDAR)
	public @ResponseBody ResponseEntity<RespuestaGenerica> guardarReg(@RequestBody RegDTO regDtoAGuardar) {
		return this.regService.guardarReg(regDtoAGuardar);
	}
	
	

}
