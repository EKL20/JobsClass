package com.personalSoft.tallerFullStack.dto;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class RegDTO implements Serializable {

	private static final long serialVersionUID = 1L;


	private long id;
	
	private Date daUP;
	
	private String moveUP;
	
	private Date daDown;

	private String moveDown;
	
	private Date daStart;
	
	private String Start;
	
	private Date datakeOff;
	
	private String takeOff;
	
	private Date datoLand;
		
	private String toLand;
	
	private Date daeject;

	private String Eject;

	private int distHorizon;
	
	private int distVertical;
	
	private String powerOnLight;
	
	private Date daLight;

}

	
	

