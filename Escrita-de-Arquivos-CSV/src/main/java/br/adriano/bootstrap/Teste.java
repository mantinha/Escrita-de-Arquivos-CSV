package br.adriano.bootstrap;

import br.adriano.service.EscritaCSV;

/**
 * Teste de uso da classe EscritaCSV
 * 
 * @author adriano
 *
 */
public class Teste {

	public static void main(String[] args) {		
		
		EscritaCSV escreve = new EscritaCSV();
		escreve.toList("Adriano","Cenoura","adriandesigner@hotmail.com");
		escreve.toList("Eliana","Beterraba","eliana@teste.com");
		escreve.toList("Bianca","Abacate","bianca123@test.com");		
		escreve.print();
		escreve.write();

	}

}
