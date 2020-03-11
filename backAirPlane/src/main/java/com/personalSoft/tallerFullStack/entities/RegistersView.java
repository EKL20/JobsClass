package com.personalSoft.tallerFullStack.entities;


import java.io.Serializable;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

//----------------------------------------


import lombok.Data;

@Data
@Entity
@Table(name = "REGISTERS")
public class RegistersView implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	@CreationTimestamp
	private Date daUP;
	
	@Column
	private String moveUP;
	
	@Column
	@CreationTimestamp
	private Date daDown;

	@Column
	private String moveDown;
	
	@Column
	@CreationTimestamp
	private Date daStart;
	
	@Column
	private String Start;
	
	@Column
	@CreationTimestamp
	private Date datakeOff;
	
	@Column
	private String takeOff;
	
	@Column
	@CreationTimestamp
	private Date datoLand;
	
	@Column
	private String toLand;
	
	@Column
	@CreationTimestamp
	private Date daeject;

	@Column
	private String Eject;

	@Column
	private int distHorizon;
	
	//this value is constant 
	@Column
	private int distVertical;
	
	@Column
	private String powerOnLight;
	
	@Column
	@CreationTimestamp
	private Date daLight;
	

}
