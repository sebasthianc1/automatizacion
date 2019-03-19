package com.qvision.calculadora;

import static org.junit.Assert.*;  //validaciones de objetos, mensajes, boleanos, 
import org.junit.Test;

import com.qvision.calculadora.Calc.Calc;


public class Validacion_Division {

	
	
	
	@Test
	public void test() {
		
		//intanciar la clase  suma
		Calc miDiv=new Calc();
	    assertEquals(5,miDiv.division(10, 2));
	
	}

}
