package tp.pr5.mv.windows;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import tp.pr5.mv.AccessMemory;
import tp.pr5.mv.AccessPila;
import tp.pr5.mv.controladores.ControladorSwing;
import tp.pr5.mv.observadores.ObservadoresCPU;

@SuppressWarnings("serial")
public class PanelPrograma extends JPanel implements ObservadoresCPU{
	
	private TitledBorder tituloBorde;
	@SuppressWarnings("unused")
	private JScrollPane lugarDelTexto;
	private JTextArea areaTexto;
	private String [] instrucciones;
	private int numInstruc;
	
	public PanelPrograma(ControladorSwing controladorSwing) {
		//this.cpu3 = cpu;
		//programa = cpu3.getProgramMV();
		instrucciones = new String [100];
		tituloBorde = new TitledBorder("Programa");
		this.setBorder(tituloBorde);
		this.setLayout(new BorderLayout());
		areaTexto = new JTextArea(0, 15);
		areaTexto.setEditable(false);
		areaTexto.setFont(new Font("Verdana", 14, 14));
		JScrollPane lugaDeltexto = new JScrollPane(areaTexto); 
		this.add(lugaDeltexto);
		

	}
	
	public void mostrarPrograma(int pc){
		areaTexto.setText("");
		String aux;
		for (int i = 0; i < numInstruc; i++) {
			if(pc == i){
				aux = "*        " + i + ":  " + instrucciones[i] + "\n";
				areaTexto.setText(areaTexto.getText() + aux);
			}else{
				aux = "          " + i + ":  " + instrucciones[i] + "\n";
				areaTexto.setText(areaTexto.getText() + aux);
			}
		}
		
	}

	@Override
	public void onStart(String[] arrayInstrucciones, int numInstrucciones) {
		// TODO Auto-generated method stub
		instrucciones = arrayInstrucciones;
		numInstruc = numInstrucciones;
		mostrarPrograma(0);
	}

	@Override
	public void onHalted() {
		// TODO Auto-generated method stub
		mostrarPrograma(-1);
	}

	@Override
	public void onInstructionError(String error) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInstructionStart(String instruccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInstructionEnd(int pc, AccessMemory mem,
			AccessPila pila, int instru) {
		// TODO Auto-generated method stub
		mostrarPrograma(instru);
	}

}
