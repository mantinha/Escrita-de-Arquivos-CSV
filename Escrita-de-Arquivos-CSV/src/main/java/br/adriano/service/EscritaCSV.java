package br.adriano.service;

import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import br.adriano.pojo.Pessoa;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * A classe EscritaCSV guarda e escreve dados em um arquivo .CSV
 * O nomeDoArquivo pode ser modificado conforme necessidade
 * O POJO pode ser modificado conforme necessidade
 * 
 * @author adriano
 *
 */
public class EscritaCSV {
	
	private final String nomeDoArquivo = "teste.csv";
    private List<Pessoa> lista;
    
    private Writer writer;
    private CSVWriter csvWriter;
    
    public EscritaCSV() {    	
    	lista = new ArrayList<>();
    	
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
    
    /**
     * Atribui lista baseado nos atributos do POJO
     * @param nome
     * @param sobrenome
     * @param email
     */
    public void toList(String nome, String sobrenome, String email) {
    	lista.add(new Pessoa(nome, sobrenome, email));
    }
    
    public void print() {
    	System.out.println(lista);
    }
    
    public void write() {
		if(writer != null) {			
			csvWriter = new CSVWriter(writer);
			
			StatefulBeanToCsv<Pessoa> beanToCsv = new StatefulBeanToCsvBuilder<Pessoa>(writer)
					.withSeparator(CSVWriter.DEFAULT_SEPARATOR)
					.build();
			
			try {
				beanToCsv.write(lista.iterator());
			} catch (CsvDataTypeMismatchException exc) {
				System.out.println("ERRO! " + exc.getMessage());
				exc.printStackTrace();
			} catch (CsvRequiredFieldEmptyException exc) {
				System.out.println("ERRO! " + exc.getMessage());
				exc.printStackTrace();				
			}
	        
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
    
}
