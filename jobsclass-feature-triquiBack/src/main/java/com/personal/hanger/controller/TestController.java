package com.personal.hanger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Test")
public class TestController {
	private int actuallySum = 0;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String triquiMatrix[][] = new String[3][3];

	
	
	@GetMapping(value= "Hello", produces= MediaType.APPLICATION_JSON_VALUE)
	public String sayHello() {
		return "hola";
	}
	@GetMapping(value= "obtener_bye", produces= MediaType.APPLICATION_JSON_VALUE)
	public String saybye() {
		return "Adios";
	}
	@GetMapping(value = "sum_please", produces = MediaType.APPLICATION_JSON_VALUE)
	public String sumPlace() {
		this.actuallySum++;
		return "Vamos en: " + this.actuallySum;
	}
	
	//inicia la el algoritmo del triqui
	
	@GetMapping(value = "verify_triqui", produces = MediaType.APPLICATION_JSON_VALUE)
	public String verifyTriqui(@RequestParam int xPosition, @RequestParam int yPosition, @RequestParam boolean type) {
		logger.info(xPosition + "-");
		logger.info(yPosition + "-");
		logger.info(type + "-");
		if (type) {
			this.triquiMatrix[xPosition][yPosition] = "O";
		} else {
			this.triquiMatrix[xPosition][yPosition] = "X";
		}
		return this.hasTriqui(type);
	}
	
	@GetMapping(value = "get_last_matrix", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getLastMatrix() {
		return this.getStringMaxtrix();
	}

	@GetMapping(value = "start_triqui", produces = MediaType.APPLICATION_JSON_VALUE)
	public String startTriqui() {
		this.startMatrix();
		return getStringMaxtrix();
	}

	private String hasTriqui(boolean type) {
		if (type) {
			if (this.triquiMatrix[0][0].equals("O") 
					&& this.triquiMatrix[0][1].equals("O") 
					&& this.triquiMatrix[0][2].equals("O")) {
				return "O-TK";
			}
			if (this.triquiMatrix[1][0].equals("O") 
					&& this.triquiMatrix[1][1].equals("O") 
					&& this.triquiMatrix[1][2].equals("O")) {
				return "O-TK";
			}
			if (this.triquiMatrix[2][0].equals("O") 
					&& this.triquiMatrix[2][1].equals("O") 
					&& this.triquiMatrix[2][2].equals("O")) {
				return "O-TK";
			}
			if (this.triquiMatrix[0][0].equals("O") 
					&& this.triquiMatrix[1][0].equals("O") 
					&& this.triquiMatrix[2][0].equals("O")) {
				return "O-TK";
			}
			if (this.triquiMatrix[0][1].equals("O") 
					&& this.triquiMatrix[1][1].equals("O") 
					&& this.triquiMatrix[2][1].equals("O")) {
				return "O-TK";
			}
			if (this.triquiMatrix[0][2].equals("O") 
					&& this.triquiMatrix[1][2].equals("O") 
					&& this.triquiMatrix[2][2].equals("O")) {
				return "O-TK";
			}
			if (this.triquiMatrix[0][0].equals("O") 
					&& this.triquiMatrix[1][1].equals("O") 
					&& this.triquiMatrix[2][2].equals("O")) {
				return "O-TK";
			}
			if (this.triquiMatrix[2][0].equals("O") 
					&& this.triquiMatrix[1][1].equals("O") 
					&& this.triquiMatrix[0][2].equals("O")) {
				return "O-TK";
			}
		} else {
			if (this.triquiMatrix[0][0].equals("X") 
					&& this.triquiMatrix[0][1].equals("X") 
					&& this.triquiMatrix[0][2].equals("X")) {
				return "X-TK";
			}
			if (this.triquiMatrix[1][0].equals("X") 
					&& this.triquiMatrix[1][1].equals("X") 
					&& this.triquiMatrix[1][2].equals("X")) {
				return "X-TK";
			}
			if (this.triquiMatrix[2][0].equals("X") 
					&& this.triquiMatrix[2][1].equals("X") 
					&& this.triquiMatrix[2][2].equals("X")) {
				return "X-TK";
			}
			if (this.triquiMatrix[0][0].equals("X") 
					&& this.triquiMatrix[1][0].equals("X") 
					&& this.triquiMatrix[2][0].equals("X")) {
				return "X-TK";
			}
			if (this.triquiMatrix[0][1].equals("X") 
					&& this.triquiMatrix[1][1].equals("X") 
					&& this.triquiMatrix[2][1].equals("X")) {
				return "X-TK";
			}
			if (this.triquiMatrix[0][2].equals("X") 
					&& this.triquiMatrix[1][2].equals("X") 
					&& this.triquiMatrix[2][2].equals("X")) {
				return "X-TK";
			}
			if (this.triquiMatrix[0][0].equals("X") 
					&& this.triquiMatrix[1][1].equals("X") 
					&& this.triquiMatrix[2][2].equals("X")) {
				return "X-TK";
			}
			if (this.triquiMatrix[2][0].equals("X") 
					&& this.triquiMatrix[1][1].equals("X") 
					&& this.triquiMatrix[0][2].equals("X")) {
				return "X-TK";
			}
		}
		return getStringMaxtrix();
	}

	private String getStringMaxtrix() {
		String stringMatrix = "";
		for (int i = 0; i < this.triquiMatrix.length; i++) {
			for (int j = 0; j < this.triquiMatrix[i].length; j++) {
				stringMatrix += this.triquiMatrix[i][j] + ",";
			}
		}
		return (stringMatrix.substring(0, stringMatrix.length() - 1));
	}

	private void startMatrix() {
		this.triquiMatrix[0][0] = "-";
		this.triquiMatrix[0][1] = "-";
		this.triquiMatrix[0][2] = "-";
		this.triquiMatrix[1][0] = "-";
		this.triquiMatrix[1][1] = "-";
		this.triquiMatrix[1][2] = "-";
		this.triquiMatrix[2][0] = "-";
		this.triquiMatrix[2][1] = "-";
		this.triquiMatrix[2][2] = "-";
	}


}
