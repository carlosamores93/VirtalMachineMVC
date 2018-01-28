package tp.pr5.mv;

import tp.pr5.mv.aritm.instructions.*;
import tp.pr5.mv.bools.instructions.*;
import tp.pr5.mv.comps.instructions.*;
import tp.pr5.mv.indirecto.instructions.*;
import tp.pr5.mv.jumps.instructions.*;
import tp.pr5.mv.jumps.relativos.*;
import tp.pr5.mv.others.instructions.*;

public class InstructionParser {
	
	private static Instruction [] ListaInst = {new AddInstruction(), new SubInstruction(), 
		new MulInstruction(), new DivInstruction(), new AndInstruction(), new NotInstruction(),
		new OrInstruction(), new GtInstruction(), new LtInstruction(), new EqInstruction(),
		new LeInstruction(), new FlipInstruction(), new LoadInstruction(), new NegInstruction(),
		new PushInstruction(), new StoreInstruction(), new HaltInstruction(), new OutInstruction(),
		new PopInstruction(), new DupInstruction(),  new JumpInstruction(), new BtInstruction(),  
		new BfInstruction(), new WriteInstruction(), new RbfInstruction(), new RbtInstruction(), 
		new RjumpInstruction(), new JumpindInstruction(), new LoadindInstruction(), 
		new StoreindInstruction(), new InInstruction()};
	
	private static Instruction [] PpWInstructions = {new PushInstruction(), new PopInstruction(), new WriteInstruction()};
	
	public  Instruction parse(String cadena){
		// Bucle para parsear las instrucciones
		Instruction instruccion = null;
		int i = 0;
		boolean salir = false;
		while(i < ListaInst.length && !salir){
			instruccion = ListaInst[i].parse(cadena);
			if(instruccion != null){
				salir = true;
			}else{
				i++;
			}
		}
		return instruccion;
	}
	
	public Instruction parsePushPopWrite(String cadena) throws NumberFormatException{
		Instruction instruccion = null;
		int i = 0;
		boolean salir = false;
		while(i < PpWInstructions.length && !salir){
			instruccion = PpWInstructions[i].parse(cadena);
			if(instruccion != null){
				salir = true;
			}else{
				i++;
			}
		}
		return instruccion;
	}
}


