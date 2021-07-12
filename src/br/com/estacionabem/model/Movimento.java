package br.com.estacionabem.model;

public class Movimento {

	private String codigo;
	private int tempo;
	private double valorPago;
	private Veiculo veiculo;
	private String dataEntrada;
	private String dataSaida;
	private String horaEntrada;
	private String horaSaida;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}
	
	
	

	@Override
	public String toString() {
		return codigo + ";" + veiculo.getPlaca() + ";" + veiculo.getModelo() + ";" + dataEntrada + ";" + horaEntrada
				+ ";" + dataSaida + ";" + horaSaida + ";" + tempo + ";" + valorPago;
	}

	public String toStringEntrada() {
		return codigo + ";" + veiculo.getPlaca() + ";" + veiculo.getModelo() + ";" + dataEntrada + ";" + horaEntrada
				+ ";" + 0 + ";" + 0 + ";" + 0 + ";" + 0;
	}

}
