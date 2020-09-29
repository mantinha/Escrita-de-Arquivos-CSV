package br.adriano.pojo;

import com.opencsv.bean.CsvBindByName;

/**
 * A classe Pessoa representa o cabeçalho do arquivo .CSV
 * A partir desse POJO os dados serão mantidos e recuperados
 * 
 * @author adriano
 *
 */
public class Pessoa {
	/**
	 * A ordem dos dados é escrita em ordem alfabetica
	 * O controle da ordem é feita pelo cabecalho
	 * (column = "dado do cabecalho")
	 */
	@CsvBindByName(column = "nome")
	private String nome;
	@CsvBindByName(column = "sobrenome")
	private String sobrenome;
	@CsvBindByName(column = "email")
	private String email;
	
	public Pessoa(String nome, String sobrenome, String email) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
        return "\n\"" + Pessoa.class.getSimpleName() +
        	     "\": {\n\tnome=\"" + nome +
        	     "\",\n\tsobrenome=\"" + sobrenome +
        	     "\",\n\temail=\"" + email +
        	     "\"\n}\n";
    }

}
