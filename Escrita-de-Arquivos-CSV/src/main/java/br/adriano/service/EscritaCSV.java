package br.adriano.service;

import java.util.List;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * A classe EscritaCSV faz guarda e escreve dados em um arquivo .CSV
 * O nomeDoArquivo pode ser modificado conforme necessidade
 * @param cabecalho sao ilimitados
 * @param campos sao ilimitados
 * 
 * @author adriano
 *
 */
public class EscritaCSV {
	
	private final String nomeDoArquivo = "teste.csv";
	private List<String[]> cabecalho;
    private List<String[]> linhas;
    private Writer writer;
    private CSVWriter csvWriter;
    
    public EscritaCSV(String... cabecalho) {  	
    	this.cabecalho = new ArrayList<>();    	
		this.cabecalho.add(cabecalho);
    	
    	linhas = new ArrayList<>();
    	
    	try {
			writer = Files.newBufferedWriter(Paths.get("src"
					+File.separator
					+"main"
					+File.separator
					+"resources"
					+File.separator
					+ nomeDoArquivo));
		} catch (IOException exc) {
			System.err.println("ERRO! caminho se corrompeu. " + exc.getMessage());
			exc.printStackTrace();
		}
    	
    }
    
    public void prepararDados(String... campos) {
    	linhas.add(campos);
    }
    
    public void escreverDados() {
		if(writer != null) {			
			csvWriter = new CSVWriter(writer);
			
			csvWriter.writeAll(cabecalho);
	        csvWriter.writeAll(linhas);	        
	        
	        System.out.println(nomeDoArquivo + " criado!");
	        liberaBuffer();
		}
    }
    
    private void liberaBuffer() {
    	try {
			csvWriter.flush();
			writer.close();
		} catch (IOException exc) {
			System.err.println("ERRO! buffer parado em memoria. " + exc.getMessage());
			exc.printStackTrace();
		}        
    }
    
    public void print() {    	
    	for(int i = 0; i < linhas.size(); i++) {
    		
    		for(int j = 0; j < linhas.get(i).length; j++) {
    			if(j > 0 && i < 1)
					System.out.print(", ");
    			if(i < 1)
	    			System.out.print(cabecalho.get(i)[j]);    			
    		}
    		
			for(int j = 0; j < linhas.get(i).length; j++) {
				
				if(j > 0)
					System.out.print(", ");
				System.out.print(linhas.get(i)[j]);
			}
			
			System.out.println();
		}
    }
    
}
