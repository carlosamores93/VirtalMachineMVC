package tp.pr5.mv.windows;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class MemoryModel extends AbstractTableModel {

	private Vector<CeldaMemoria> listaMemoria;
	private String[] columnas = {"DIRECCIÓN","VALOR"};
	
	public MemoryModel(){
		listaMemoria =  new Vector<>();
	}
	
	public String getColumnName(int column){
		return columnas[column];
	}
	
	
	@Override
	public int getRowCount() {
		return listaMemoria.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	// Este es el metodo que actualiza la tabla de memoria mostrada por la ventana
		if(rowIndex >= listaMemoria.size()){
			return null;
		}else{
			CeldaMemoria i = listaMemoria.get(rowIndex);
			if(columnIndex == 0){
				return i.getDireccion();
			}else if(columnIndex == 1){
				return i.getValor();
			}
		}
		return null;
	}

	public void add(CeldaMemoria celdaNueva){
		listaMemoria.add(celdaNueva);
		ordenarMemoria();
		this.fireTableDataChanged();
	}
	
	public void addEnPosI(CeldaMemoria celdaModificada, int dir){
		listaMemoria.add(dir, celdaModificada);
		listaMemoria.remove(dir + 1);
		ordenarMemoria();
		this.fireTableDataChanged();
	}
	
	private void ordenarMemoria() {
		// TODO Auto-generated method stub
		boolean inter = true;
		int i = 0;
		while((i< listaMemoria.size() - 1)&& inter){
			inter = false;
			for (int j = listaMemoria.size() - 1; j > i; j--) {
				if(listaMemoria.elementAt(j).getDireccion() < listaMemoria.elementAt(j-1).getDireccion()){
					CeldaMemoria aux;
					aux = listaMemoria.elementAt(j);
					listaMemoria.setElementAt(listaMemoria.elementAt(j-1), j);
					listaMemoria.setElementAt(aux, j-1);
					inter = true;
				}
			}
			if(inter){
				i++;
			}
		}
	}

	public int existeDir(int dir){
		boolean encontrado = false;
		int i=0, pos = -1;
		while((i<listaMemoria.size()) && (!encontrado)){
			if(dir == (int)getValueAt(i, 0)){
				encontrado = true;
				pos = i;
			}
			if(!encontrado)
				i++;
		}
		return pos;
	}
}
