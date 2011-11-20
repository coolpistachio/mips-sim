package simulator;

import exceptions.BinaryLengthException;

public class Test {
	public static void main (String[] args){
		Parser p = new Parser();
		String inst;
		Simulator sim = new Simulator();
		
		try{
		/*	
		inst = "SUB $1, $2, $3\n";
		p.parse(inst);
		inst = "ADDI $1, $1, 1\n";
		p.parse(inst);
		inst = "ANDI $4, $10, 15\n";
		p.parse(inst);
		inst = "ORI $4, $1, 15\n";
		p.parse(inst);
		inst = "SLTI $4, $10, 11\n";
		p.parse(inst);
		inst = "ADD $2, $2, $1\n";
		p.parse(inst);
		inst = "SUB $4, $7, $8\n";
		p.parse(inst);
		inst = "AND $4, $1, $15\n";
		p.parse(inst);
		inst = "OR  $5, $5, $10\n";
		p.parse(inst);
		inst = "SLL $6, $5, 2\n";
		p.parse(inst);
		inst = "SRL $7, $12, 1\n";
		p.parse(inst);
		inst = "SLT $8, $4, $5\n";
		p.parse(inst);
		inst = "LW  $9, 100($1)\n";
		p.parse(inst);
		inst = "SW  $9, 10($1)\n";
		p.parse(inst);
		*/
		inst = "BEQ  $1, $1, 3\n";
		p.parse(inst);
		inst = "SUB $2, $1, $3\n";
		p.parse(inst);
		inst = "AND $12, $2, $5\n";
		p.parse(inst);
		inst = "OR $13, $6, $2\n";
		p.parse(inst);
		inst = "ADD $14, $2, $2\n";
		p.parse(inst);
/*
		inst = "ORI $4, $1, 15\n";
		p.parse(inst);
		inst = "SLTI $4, $10, 11\n";
		p.parse(inst);
		inst = "ADD $2, $2, $1\n";
		p.parse(inst);
		inst = "SUB $4, $7, $8\n";
		p.parse(inst);
		inst = "AND $4, $1, $15\n";
		p.parse(inst);
*/		
		sim.standBy(p);
		sim.nextStep();
		sim.nextStep();
		sim.nextStep();
		sim.nextStep();
		sim.nextStep();
		sim.nextStep();
		sim.nextStep();
		sim.nextStep();
		sim.nextStep();
		sim.nextStep();
		sim.nextStep();
		sim.nextStep();
		
		}catch(BinaryLengthException e){
			e.printStackTrace();
		}
	
	}
}
