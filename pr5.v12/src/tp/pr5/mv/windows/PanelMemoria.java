package tp.pr5.mv.windows;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import tp.pr5.mv.controladores.ControladorSwing;
import tp.pr5.mv.observadores.ObservadorMemoria;



@SuppressWarnings("serial")
public class PanelMemoria extends JPanel implements ActionListener, ObservadorMemoria{
	
	private int pos, val;
	private TitledBorder tituloBorde;
	private JLabel posicion, valor;
	private JTextField textoPos, textoVal;
	private JButton botonWrite;
	private JPanel panelAbajo, panel1 , panel2;
	private MemoryModel modelMemory;
	private ControladorSwing controlador;
	
	public PanelMemoria(ControladorSwing controladorSwing) {
		// TODO Auto-generated constructor stub
		// Ponemos el borde y el titulo del panel
		controlador = controladorSwing;
		
		tituloBorde = new TitledBorder("Memoria de la máquina");
		this.setBorder(tituloBorde);
		this.setLayout(new BorderLayout());
		
		// Falta crear un panelArriba, para colocar la tabla de MEmoria
		modelMemory = new MemoryModel();
		JTable tableMemory = new JTable(modelMemory);
		tableMemory.setFillsViewportHeight(true);
		tableMemory.setPreferredScrollableViewportSize(new Dimension(300, 150));
		JScrollPane scrollPaneMemory = new JScrollPane(tableMemory);
		this.add(scrollPaneMemory, BorderLayout.CENTER);
		
		
		
		
		// Ponemos en el panel de abajo, parte superior  ----- Pos: [__] Valor: [__]
		panelAbajo = new JPanel();
		panelAbajo.setLayout(new GridLayout(2, 1));
		
		panel1 = new JPanel();
		
		posicion = new JLabel("Pos:");
		panel1.add(posicion);
		textoPos = new JTextField(5);
		panel1.add(textoPos);
		valor = new JLabel("Val:");
		panel1.add(valor);
		textoVal = new JTextField(5);
		panel1.add(textoVal);
		
		panelAbajo.add(panel1);
		
		// Ponemos en la parte inferior del panel de abajo el boton Write -- [Write]
		panel2 = new JPanel();
		botonWrite = new JButton("Write");
		botonWrite.addActionListener(this);
		panel2.add(botonWrite);
		panelAbajo.add(panel2);
		
		// Añadimos al panel de memoria el panel de abajo
		this.add(panelAbajo, BorderLayout.SOUTH);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e);
		//System.out.println("Boton WRITE pulsado");
		String cadena1, cadena2;
		cadena1 = textoPos.getText();
		cadena2 = textoVal.getText();
		try {
			pos = Integer.parseInt(cadena1);
			if(pos < 0){
				JOptionPane.showMessageDialog(this, "Error, la posicion: " + pos + " no está en memoria.", 
						"Error, acceso a parte negativa de memoria", JOptionPane.ERROR_MESSAGE);
			}
			try {
				val = Integer.parseInt(cadena2);
				controlador.write(pos, val);
				
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Error: '" + cadena2 + "' no es un número.", 
						"Error en el parseo", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Error: '" + cadena1 + "' no es un número.", 
					"Error en el parseo", JOptionPane.ERROR_MESSAGE);
		}
		
	}

/*
	public void write(int pos, int valor) {
		// TODO Auto-generated method stub
		int dir = modelMemory.existeDir(pos);
		if(dir == -1){
			CeldaMemoria nuevaCelda = new CeldaMemoria(pos, valor);
			this.modelMemory.add(nuevaCelda);
		}else{
			CeldaMemoria nuevaCelda = new CeldaMemoria(pos, valor);
			modelMemory.addEnPosI(nuevaCelda, dir);
		}
		
	}*/


	@Override
	public void onWrite(int pos, int valor) {
		// TODO Auto-generated method stub
		int dir = modelMemory.existeDir(pos);
		if(dir == -1){
			CeldaMemoria nuevaCelda = new CeldaMemoria(pos, valor);
			this.modelMemory.add(nuevaCelda);
		}else{
			CeldaMemoria nuevaCelda = new CeldaMemoria(pos, valor);
			modelMemory.addEnPosI(nuevaCelda, dir);
		}
	}
	
}
