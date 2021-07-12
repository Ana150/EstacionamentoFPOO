package br.com.estacionabem.dao;

import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import br.com.estacionabem.model.Movimento;

public class ValoresDao {
	
	private static final String NOVO_LOCAL_ARQUIVO = "C:/Users/21192991/valores.ds1";
	
	private Movimento movimento;
	
	public void salvar() {
		Path path = Paths.get(NOVO_LOCAL_ARQUIVO);

		try {
			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("ISO-8859-1"),
					StandardOpenOption.WRITE, StandardOpenOption.APPEND);

			writer.write(movimento.toString());
			writer.newLine();
			writer.close();

		} catch (Exception e) {
			
		}
	}
	
	

}
