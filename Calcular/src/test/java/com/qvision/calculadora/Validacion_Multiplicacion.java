package com.qvision.calculadora;

import static org.junit.Assert.*;  //validaciones de objetos, mensajes, boleanos, 
import org.junit.Test;

import com.qvision.calculadora.Calc.Calc;


public class Validacion_Multiplicacion {

	
	
	
	@Test
	public void test() {
		
		//intanciar la clase  multiplicacion
		
		Calc miMulti=new Calc();
	    assertEquals(15,miMulti.multiplicacion(5, 3));
	
	}

}
