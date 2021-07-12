package br.com.estacionabem;

import java.util.UUID;

public class LerEscrever {
	
public static void main(String[] args) {
		
		String codigo = UUID.randomUUID().toString();
		System.out.println(codigo);
		
		String novoCodigo2 = codigo.substring(0, 8);
		System.out.println(novoCodigo2.toUpperCase());
		
	}

}
