package com.personalSoft.tallerFullStack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personalSoft.tallerFullStack.constants.ConstRespon;
import com.personalSoft.tallerFullStack.dto.RegDTO;
import com.personalSoft.tallerFullStack.entities.RegistersView;
import com.personalSoft.tallerFullStack.mappers.RegMappers;
import com.personalSoft.tallerFullStack.repositories.RegDAO;
import com.personalSoft.tallerFullStack.response.RespuestaGenerica;

@Service
public class RegService {

	private final RegMappers regMapper = new RegMappers();
	
	
	@Autowired 
	private RegDAO regDao;
	
	
	public @ResponseBody ResponseEntity<RespuestaGenerica> obtenerReg(Long id) {
		RespuestaGenerica respuestaGenerica;
		
		try {
			if (regDao.existsById(id)) {
				 RegistersView reg = regDao.findById(id).get();
				RegDTO regDTO = this.regMapper.obtenerRegDTO(reg);
				
				respuestaGenerica = new RespuestaGenerica(regDTO, ConstRespon.EXITO, "Exito");
			} else {
				respuestaGenerica = new RespuestaGenerica(ConstRespon.ERRROR, "No hay registros");
			}
			return new ResponseEntity<RespuestaGenerica>(respuestaGenerica, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<RespuestaGenerica>(new RespuestaGenerica(ConstRespon.ERRROR, "No hay registros"),
					HttpStatus.BAD_REQUEST);
		}
	}

	public @ResponseBody ResponseEntity<RespuestaGenerica> guardarReg(RegDTO regDTO) {
		try {
			RespuestaGenerica respuestaGenerica;
			RegistersView reg = this.regMapper.obtenerReg(regDTO);
			this.regDao.save(reg);
			respuestaGenerica = new RespuestaGenerica(ConstRespon.EXITO, "Exito");
			return new ResponseEntity<RespuestaGenerica>(respuestaGenerica, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<RespuestaGenerica>(new RespuestaGenerica(ConstRespon.ERRROR, "No hay registros"),
					HttpStatus.BAD_REQUEST);
		}
	}
}