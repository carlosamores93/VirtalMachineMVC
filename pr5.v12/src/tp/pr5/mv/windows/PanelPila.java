package tp.pr5.mv.windows;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import tp.pr5.mv.controladores.ControladorSwing;
import tp.pr5.mv.observadores.ObservadoresPila;

@SuppressWarnings("serial")
public class PanelPila extends JPanel implements ActionListener, ObservadoresPila{
	
	private JLabel valor;
	private JButton botonPop, botonPush;
	private TitledBorder tituloBorde;
	private JTextField textoVal;
	private JPanel panelAbajo, panel1 , panel2;
	@SuppressWarnings("unused")
	private JScrollPane lugaDeltexto;
	private JList<Object> areaTexto;
	private StackModel stackModel;
	private ControladorSwing controlador;
	
	public PanelPila(ControladorSwing controladorSwing) {
		
		this.controlador = controladorSwing;
		
		// Ponemosel borde del panel y configuramos el Layout
		tituloBorde = new TitledBorder("Pila de operandos");
		this.setLayout(new BorderLayout());
		this.setBorder(tituloBorde);
		
		// Configuramos la parte de la pila (Arriba)
		
		stackModel = new StackModel();
		areaTexto = new JList<Object>(stackModel);
		JScrollPane lugaDeltexto = new JScrollPane(areaTexto); 
		this.add(lugaDeltexto);
		
		
		// Configuramos la parte de abajo 
		panelAbajo = new JPanel();
		panelAbajo.setLayout(new GridLayout(2, 1));
		
		// Ponemos ---> Valor:    [Push]
		valor = new JLabel("Valor:");
		textoVal = new JTextField(5);
		botonPush = new JButton("Push");
		panel1 = new JPanel();
		panel1.add(valor);
		panel1.add(textoVal);
		panel1.add(botonPush);
		panelAbajo.add(panel1);
		botonPush.addActionListener(this);
		
		// Ponemos [Pop]
		panel2 = new JPanel();
		botonPop = new JButton("Pop");
		panel2.add(botonPop);
		panelAbajo.add(panel2);
		botonPop.addActionListener(this);
		
		this.add(panelAbajo, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//System.out.println(e);
		JButton boton = (JButton) e.getSource();
		if(boton.equals(botonPush)){
			// Añadimos numero a la pila de operandos(Apilar)
			String cadena = textoVal.getText();
			//System.out.println("botonPUSH pulsado");
			try {
				int val = Integer.parseInt(cadena);
				controlador.push(val);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(this, "Error: '" + cadena + "' no es un número.", 
						"Error en el parseo", JOptionPane.ERROR_MESSAGE);
			}catch(Exception e4){
				JOptionPane.showMessageDialog(this, "OJO!!, la pila de operandos está llena.", 
						"No se puede apilar", JOptionPane.INFORMATION_MESSAGE);
			}
			
			// Apilamos "valorApilar" en la cima de la pila
		}
		if(boton.equals(botonPop)){
			// Desapilamos
			//System.out.println("botonPOP pulsado");
			try{
				controlador.pop();
			}catch(Exception e3){
				JOptionPane.showMessageDialog(this, "Cuidado, la pila de operandos está vacia.", 
						"No se puede desapilar", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	/*public void push(int valor) {
		stackModel.apila(valor);
	}*/
/*
	public void pop() {
		stackModel.desapila();
	}*/

	
	@Override
	public void onPush(int cima) {
		// TODO Auto-generated method stub
		stackModel.apila(cima);
	}

	@Override
	public void onPop() {
		// TODO Auto-generated method stub
		stackModel.desapila();
	}
	
	
	
	
}
