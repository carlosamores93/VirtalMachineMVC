package tp.pr5.mv.windows;


import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelSalida extends JPanel {

	private TitledBorder tituloBorde;
	private JTextArea areaTexto;
	private JScrollPane lugaDeltexto;
	private String cadena;
	
	public PanelSalida() {

		// TODO Auto-generated constructor stub
		this.tituloBorde = new TitledBorder("Salida del programa-p");
		this.areaTexto = new JTextArea(5, 50);
		areaTexto.setEditable(false);
		areaTexto.setFont(new Font("Verdana", 14, 14));
		this.lugaDeltexto = new JScrollPane(areaTexto);
		
		this.cadena = "";
		
		this.setLayout(new BorderLayout());
		this.setBorder(tituloBorde);
		this.add(lugaDeltexto);
		
	}
	
	public void write(char c){
		this.cadena += c;
		this.areaTexto.setText(cadena);		
	}
}
