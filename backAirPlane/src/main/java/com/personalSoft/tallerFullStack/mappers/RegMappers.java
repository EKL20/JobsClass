package com.personalSoft.tallerFullStack.mappers;

import java.util.ArrayList;

import java.sql.Date;

import com.personalSoft.tallerFullStack.dto.RegDTO;
import com.personalSoft.tallerFullStack.entities.RegistersView;

import lombok.Data;



@Data
public class RegMappers {

	//private final RegMappers regMapper = new RegMappers();

	public RegDTO obtenerRegDTO(RegistersView regACastear) {

				
		RegDTO regARetornar = new RegDTO();
		regARetornar.setId(regACastear.getId());
		regARetornar.setMoveUP(regACastear.getMoveUP());
		regARetornar.setDaUP(regACastear.getDaUP());
		regARetornar.setMoveDown(regACastear.getMoveDown());
		regARetornar.setDaDown(regACastear.getDaDown());
		regARetornar.setStart(regACastear.getStart());
		regARetornar.setDaStart(regACastear.getDaStart());
		regARetornar.setTakeOff(regACastear.getTakeOff());
		regARetornar.setDatakeOff(regACastear.getDatakeOff());
		regARetornar.setToLand(regACastear.getToLand());
		regARetornar.setDatoLand(regACastear.getDatoLand());
		regARetornar.setEject(regACastear.getEject());
		regARetornar.setDistHorizon(regACastear.getDistHorizon());
		regARetornar.setDistVertical(regACastear.getDistVertical());
		regARetornar.setPowerOnLight(regACastear.getPowerOnLight());
		regARetornar.setDaLight(regACastear.getDaLight());

		
		return regARetornar;
		
	}
	
	public RegistersView obtenerReg (RegDTO regDTO) {
		
		RegistersView register = new RegistersView();
		
		register.setId(regDTO.getId());
		register.setMoveUP(regDTO.getMoveUP());
		register.setDaUP((Date) regDTO.getDaUP());
		register.setMoveDown(regDTO.getMoveDown());
		register.setDaDown((Date) regDTO.getDaDown());
		register.setStart(regDTO.getStart());
		register.setDaStart((Date) regDTO.getDaStart());
		register.setTakeOff(regDTO.getTakeOff());
		register.setDatakeOff((Date) regDTO.getDatakeOff());
		register.setToLand(regDTO.getToLand());
		register.setDatoLand((Date) regDTO.getDatoLand());
		register.setEject(regDTO.getEject());
		register.setDistHorizon(regDTO.getDistHorizon());
		register.setDistVertical(regDTO.getDistVertical());
		register.setPowerOnLight(regDTO.getPowerOnLight());
		register.setDaLight((Date) regDTO.getDaLight());
		
		
		return register;
		
	}
	

}
