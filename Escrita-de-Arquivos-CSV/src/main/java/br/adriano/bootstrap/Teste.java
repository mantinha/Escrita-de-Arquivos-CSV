package br.adriano.bootstrap;

import br.adriano.service.EscritaCSV;

/**
 * Teste de uso da classe EscritaCSV
 * Os parametros sao ilimitados
 * 
 * @author adriano
 *
 */
public class Teste {

	public static void main(String[] args) {		
		
		EscritaCSV escritor = new EscritaCSV("nome","idade","tel");
		escritor.prepararDados("Adriano","27","44791725");
		escritor.prepararDados("Eliana","22","43751729");
		escritor.prepararDados("Bianca","25","44551943");		
		escritor.print();
		escritor.escreverDados();

	}

}
