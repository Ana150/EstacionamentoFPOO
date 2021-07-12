package br.com.estacionabem.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import br.com.estacionabem.model.Movimento;
import br.com.estacionabem.model.Veiculo;

public class EstacionamentoDao {
//		private Veiculo veiculo;
		private Movimento movimento;
		
		private static final String LOCAL_ARQUIVO = "C:/Users/21192991/movimentacao.ds1";
		
		public EstacionamentoDao() {
			
		}
		
		public EstacionamentoDao(Movimento movimento) {
			this.movimento = movimento;
		}
		

		public void setEstacionamentoDao(Movimento movimento) {
			this.movimento = movimento;
		}
		
		public void salvar() {
			Path path = Paths.get(LOCAL_ARQUIVO);

			try {
				BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("ISO-8859-1"),
						StandardOpenOption.WRITE, StandardOpenOption.APPEND);

				writer.write(movimento.toString());
				writer.newLine();
				writer.close();

			} catch (Exception e) {
				
			}
		}
		
		public ArrayList<Movimento> listarMovimento() {
			Path path = Paths.get(LOCAL_ARQUIVO); 
			
			try {
				BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1")); //pega informação no HD e manda para a memória RAM-- dados armazenados temporariamente
				
				String linha = reader.readLine();
				
				ArrayList<Movimento> movimentos = new ArrayList<Movimento>();
				
				while (linha != null) {
					String[] vetorMovimento = linha.split(";");
					
					Movimento movimento = new Movimento();
					Veiculo v = new Veiculo();
					
					movimento.setVeiculo(v);
					
					movimento.setCodigo(vetorMovimento[0]);
					movimento.getVeiculo().setPlaca(vetorMovimento[1]);
					movimento.getVeiculo().setModelo(vetorMovimento[2]);
					movimento.setDataEntrada(vetorMovimento[3]);
					movimento.setHoraEntrada(vetorMovimento[4]);
					movimento.setDataSaida(vetorMovimento[5]);
					movimento.setHoraSaida(vetorMovimento[6]);
					
					movimentos.add(movimento);
					
					linha = reader.readLine();
				}
				
				reader.close();
				
				return movimentos;
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Tente novamente!!!!");
				return null;
			}
		
		}
		
		public Movimento buscarMovimento(String placa) {
			Path path = Paths.get(LOCAL_ARQUIVO); 
			
			try {
				BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1")); //pega informação no HD e manda para a memória RAM-- dados armazenados temporariamente
				
				String linha = reader.readLine();
				
				Movimento movimento = new Movimento();
				
				while (linha != null) {
					String[] vetorMovimento = linha.split(";");
					
                    Veiculo v = new Veiculo();
					
					movimento.setVeiculo(v);
					
					if (vetorMovimento[1].equals(placa)) {
						movimento.setCodigo(vetorMovimento[0]);
						movimento.getVeiculo().setPlaca(vetorMovimento[1]);
						movimento.getVeiculo().setModelo(vetorMovimento[2]);
						movimento.setDataEntrada(vetorMovimento[3]);
						movimento.setHoraEntrada(vetorMovimento[4]);
						movimento.setDataSaida(vetorMovimento[3]);
						movimento.setHoraSaida(vetorMovimento[6]);
					
						return movimento;
						
					}
					
					linha = reader.readLine();
				}
				
				reader.close();
				
				
				
			} catch (Exception e) {
				System.out.println("Tente novamente!!!!");
				return null;
				
			}
			return movimento;
	}
	
}