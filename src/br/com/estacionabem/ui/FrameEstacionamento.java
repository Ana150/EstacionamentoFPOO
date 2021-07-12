package br.com.estacionabem.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.estacionabem.dao.EstacionamentoDao;
import br.com.estacionabem.model.Movimento;
import br.com.estacionabem.model.Veiculo;
import br.com.estacionabem.util.Util;

public class FrameEstacionamento {
	
	private JLabel labelEntrada;
	private JLabel labelPlaca;
	private JTextField textPlaca;
	private JLabel labelModelo;
	private JTextField textModelo;
	private JButton buttonEntrar;
	private JLabel labelSaida;
	private JLabel labelPlaca2;
	private JTextField textPlaca2;
	private JButton buttonBuscar;
	private JLabel labelModelo2;
	private JTextField textModelo2;
	private JLabel labelDataEntrada;
	private JTextField textDataEntrada;
	private JLabel labelHoraEntrada;
	private JTextField textHoraEntrada;
	private JLabel labelDataSaida;
	private JTextField textDataSaida;
	private JLabel labelHoraSaida;
	private JTextField textHoraSaida;
	private JLabel labelTempo;
	private JTextField textTempo;
	private JLabel labelValor;
	private JTextField textValor;
	private JButton buttonSaida;
	private JButton buttonFechar;
	
	private JTable tabelaMovimento;
	private DefaultTableModel tabelaMovimentoModel;
	private JScrollPane scrollTabelaMovimento;
	
	public void criarTela() {
	
		Color cinza = new Color(222, 223, 237);
		Color azul = new Color(84, 158, 233);
		Font novaFonte = new Font("Cambria Math", Font.BOLD, 20);
		Font novaFonte1 = new Font("Cambria Math", Font.BOLD, 12);
		
		JFrame tela = new JFrame();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.getContentPane().setBackground(cinza);
		tela.setTitle("Movimentação do estacionamento");
		tela.setSize(600, 500);
		tela.setLayout(null);
		
		labelEntrada = new JLabel("ENTRADA");
		labelEntrada.setForeground(Color.black);
		labelEntrada.setBounds(20, 10, 130, 30);
		labelEntrada.setFont(novaFonte);
		
		labelPlaca = new JLabel("PLACA:");
		labelPlaca.setFont(novaFonte1);
		labelPlaca.setBounds(20, 50, 90, 30);
		textPlaca = new JTextField();
		textPlaca.setBounds(20, 80, 200, 30);
		
		labelModelo = new JLabel("MODELO:");
		labelModelo.setFont(novaFonte1);
		labelModelo.setBounds(230, 50, 90, 30);
		textModelo = new JTextField();
		textModelo.setBounds(230, 80, 200, 30);
		
		buttonEntrar = new JButton("ENTRAR");
		buttonEntrar.setBounds(440, 80, 100, 30); //x y widht height
		buttonEntrar.setForeground(Color.white);
		buttonEntrar.setBackground(azul);
		
		tabelaMovimentoModel = new DefaultTableModel();
		tabelaMovimentoModel.addColumn("CÓDIGO");
		tabelaMovimentoModel.addColumn("PLACA");
		tabelaMovimentoModel.addColumn("MODELO");
		tabelaMovimentoModel.addColumn("DATA DE ENTRADA");
		
		labelSaida = new JLabel("SAIDA");
		labelSaida.setForeground(Color.black);
		labelSaida.setBounds(20, 210, 130, 30);
		labelSaida.setFont(novaFonte);
		
		labelPlaca2 = new JLabel("PLACA:");
		labelPlaca2.setFont(novaFonte1);
		labelPlaca2.setBounds(20, 240, 90, 30);
		textPlaca2 = new JTextField();
		textPlaca2.setBounds(20, 270, 100, 30);
		
		buttonBuscar = new JButton("BUSCAR");
		buttonBuscar.setBounds(135, 270, 100, 30); 
		buttonBuscar.setForeground(Color.white);
		buttonBuscar.setBackground(azul);
		
		EstacionamentoDao estacionamentoDao = new EstacionamentoDao();
		ArrayList<Movimento> movimentos = estacionamentoDao.listarMovimento();
		
		for (Movimento movimento : movimentos) {
			String [] vetorMovimento = {movimento.getCodigo(), movimento.getVeiculo().getPlaca(), movimento.getVeiculo().getModelo(), movimento.getDataEntrada()};
			
			tabelaMovimentoModel.addRow(vetorMovimento);
		}
		
		tabelaMovimento = new JTable(tabelaMovimentoModel);
		
		tabelaMovimento.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabelaMovimento.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabelaMovimento.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabelaMovimento.getColumnModel().getColumn(3).setPreferredWidth(100);
		
		tabelaMovimento.getTableHeader().setReorderingAllowed(false);
		
		scrollTabelaMovimento = new JScrollPane(tabelaMovimento);
		scrollTabelaMovimento.setBounds(20, 110, 530, 100);
		
		
		labelModelo2 = new JLabel("MODELO:");
		labelModelo2.setFont(novaFonte1);
		labelModelo2.setBounds(20, 300, 90, 30);
		textModelo2 = new JTextField();
		textModelo2.setBounds(20, 330, 90, 30);
		
		labelDataEntrada = new JLabel("DATA ENTRADA:");
		labelDataEntrada.setFont(novaFonte1);
		labelDataEntrada.setBounds(115, 300, 90, 30);
		textDataEntrada = new JTextField();
		textDataEntrada.setBounds(115, 330, 90, 30);
		
		labelHoraEntrada = new JLabel("HORA ENTRADA:");
		labelHoraEntrada.setFont(novaFonte1);
		labelHoraEntrada.setBounds(210, 300, 90, 30);
		textHoraEntrada = new JTextField();
		textHoraEntrada.setBounds(210, 330, 90, 30);
		
		labelDataSaida = new JLabel("DATA SAIDA:");
		labelDataSaida.setFont(novaFonte1);
		labelDataSaida.setBounds(305, 300, 90, 30);
		textDataSaida = new JTextField();
		textDataSaida.setBounds(305, 330, 90, 30);
		
		labelHoraSaida = new JLabel("HORA SAIDA:");
		labelHoraSaida.setFont(novaFonte1);
		labelHoraSaida.setBounds(400, 300, 90, 30);
		textHoraSaida = new JTextField();
		textHoraSaida.setBounds(400, 330, 90, 30);
		
		labelTempo = new JLabel("TEMPO:");
		labelTempo.setFont(novaFonte1);
		labelTempo.setBounds(495, 300, 90, 30);
		textTempo = new JTextField();
		textTempo.setBounds(495, 330, 50, 30);
		
		labelValor = new JLabel("VALOR A PAGAR:");
		labelValor.setFont(novaFonte1);
		labelValor.setBounds(20, 390, 90, 30);
		textValor = new JTextField();
		textValor.setBounds(120, 380, 130, 50);
		
		buttonSaida = new JButton("EFETUAR SAIDA");
		buttonSaida.setBounds(270, 380, 130, 50); 
		buttonSaida.setForeground(Color.white);
		buttonSaida.setBackground(azul);
		
		buttonFechar = new JButton("FECHAR SISTEMA");
		buttonFechar.setBounds(410, 380, 130, 50);
		buttonFechar.setForeground(Color.white);
		buttonFechar.setBackground(Color.red);
		
		tela.getContentPane().add(labelEntrada);
		tela.getContentPane().add(labelPlaca);
		tela.getContentPane().add(textPlaca);
		tela.getContentPane().add(labelModelo);
		tela.getContentPane().add(textModelo);
		tela.getContentPane().add(buttonEntrar);
		tela.getContentPane().add(scrollTabelaMovimento);
		tela.getContentPane().add(labelSaida);
		tela.getContentPane().add(labelPlaca2);
		tela.getContentPane().add(textPlaca2);
		tela.getContentPane().add(buttonBuscar);
		tela.getContentPane().add(labelModelo2);
		tela.getContentPane().add(textModelo2);
		tela.getContentPane().add(labelDataEntrada);
		tela.getContentPane().add(textDataEntrada);
		tela.getContentPane().add(labelHoraEntrada);
		tela.getContentPane().add(textHoraEntrada);
		tela.getContentPane().add(labelDataSaida);
		tela.getContentPane().add(textDataSaida);
		tela.getContentPane().add(labelHoraSaida);
		tela.getContentPane().add(textHoraSaida);
		tela.getContentPane().add(labelTempo);
		tela.getContentPane().add(textTempo);
		tela.getContentPane().add(labelValor);
		tela.getContentPane().add(textValor);
		tela.getContentPane().add(buttonSaida);
		tela.getContentPane().add(buttonFechar);
		
		tela.setVisible(true);
	
	buttonEntrar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (validarFormulario()) {
				Veiculo veiculo = new Veiculo();
				veiculo.setPlaca(textPlaca.getText().toUpperCase());
				veiculo.setModelo(textModelo.getText().toUpperCase());
				
				Movimento movimento = new Movimento();
				movimento.setCodigo(Util.gerarCodigo());
				movimento.setVeiculo(veiculo);
				movimento.setDataEntrada(Util.converterDataParaString(LocalDate.now()));;
				movimento.setHoraEntrada(Util.converterHoraParaString(LocalTime.now()));
				movimento.setCodigo(Util.gerarCodigo());
				
				EstacionamentoDao dao = new EstacionamentoDao(movimento);
				dao.salvar();
				
				JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!!!");

				textPlaca.setText("");
				textModelo.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Voce deve preencher todos os campos!", "Atenção",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	});
	
	buttonBuscar.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
           
            String placa;
            placa = textPlaca2.getText().toUpperCase();
           
            EstacionamentoDao dao = new EstacionamentoDao();
            Movimento movimento = dao.buscarMovimento(placa);
            
            textModelo2.setText(movimento.getVeiculo().getModelo());
            textDataEntrada.setText(movimento.getDataEntrada());
            textHoraEntrada.setText(movimento.getHoraEntrada());
            textDataSaida.setText(movimento.getDataSaida());
            textHoraSaida.setText(movimento.getHoraSaida());
            textTempo.setText(String.valueOf(movimento.getTempo()));
           
        }
    });
	
	buttonFechar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		System.exit(0);
		}
	});
	
	tabelaMovimento.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			int linha = tabelaMovimento.getSelectedRow();
			String codigo = tabelaMovimento.getValueAt(linha, 0).toString();
			
			EstacionamentoDao dao = new EstacionamentoDao();
			Movimento movimento = dao.buscarMovimento(codigo);
			
			textPlaca.setText(movimento.getVeiculo().getPlaca());
			textModelo.setText(movimento.getVeiculo().getModelo());
		}
	});
 }
	
	
	private boolean validarFormulario() {

		boolean valido = true;

		if (textPlaca.getText().trim().length() == 0) {
			labelPlaca.setForeground(Color.RED);
			valido = false;
		} else if (textModelo.getText().trim().length() == 0) {
			labelModelo.setForeground(Color.RED);
			valido = false;
		} 

		return valido;
	}
}