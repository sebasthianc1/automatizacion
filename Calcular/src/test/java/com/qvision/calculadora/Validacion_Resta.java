package com.qvision.calculadora;

import static org.junit.Assert.*;  //validaciones de objetos, mensajes, boleanos, 
import org.junit.Test;

import com.qvision.calculadora.Calc.Calc;


public class Validacion_Resta {

	
	
	
	@Test
	public void test() {
		
		//intanciar la clase  resta
		Calc miResta=new Calc();
	    assertEquals(2,miResta.resta(5, 3));
	
	}

}
