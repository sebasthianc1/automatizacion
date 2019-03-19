package com.qvision.calculadora;

//validaciones de objetos, mensajes, boleanos, 
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qvision.calculadora.Calc.Calc;

public class Validacion_Suma {

	
	
	@Test
	public void test() {
		
		//intanciar la clase  suma
		Calc miSuma=new Calc();
	    assertEquals(8,miSuma.sumar(5, 3));
	
	}

}
