package graphix;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import exceptions.BinaryLengthException;
import processor.ControlUnit;
import processor.Processor;
import simulator.Parser;
import simulator.Simulator;




/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Arquitectura extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private static final long serialVersionUID = -8186786303013549434L;
	private final Panel Fondo = new Panel();
	private static String VERSION = "0.1";
	public String Id[][];
	private JButton Next;
	private JButton Restart;
	private JTable Registros;
	private JTable MemoriaD;
	private JScrollPane Memoria;
	private JTextArea Entrada;
	private JScrollPane jScrollPane2;
	private JLabel MemoriaData;
	private JScrollPane TablaR;
	private JLabel jLabel1;
	private JLabel Inst;

	Highlighter hilit;
    Highlighter.HighlightPainter painter;
    
    
    //Added
    Simulator sim;
    Parser parser;
    
	String lblInst31_26;
	String lblInst25_21;
	String lblInst25_0; 
	String lblInst20_16;
	String lblInst15_11;
	String lblInst15_0;
	String lblInst10_6;
	String lblInst5_0;
    //End Added
    
	/************End Examples ::  **************/
	static Arquitectura inst;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				inst = new Arquitectura();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private void init(){
		sim = new Simulator();
		initGUI();		
		/****New iNFO****/
		hilit = new DefaultHighlighter();
        painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
        Entrada.setHighlighter(hilit);    
        Entrada.setFont(new Font("",Font.BOLD,10));
	}
	
	private void reset(){
		inst.dispose();
		inst = new Arquitectura();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	
	public Arquitectura(){
		super("Simulador MIPS Segmentado(Pipelined) v" + VERSION);
		init();
    }
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setContentPane(Fondo);
			//this.setResizable(true);
			this.setResizable(false);
			
			
			Fondo.setPreferredSize(new java.awt.Dimension(1280, 780));
			//Fondo.setPreferredSize(new java.awt.Dimension(1024, 768));
			
			getContentPane().setLayout(null);
			{
				Next = new JButton();
				Fondo.add(Next);
				Next.setText("Start");
				Next.setBounds(1111, 194, 81, 27);
				Next.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						NextActionPerformed(evt);
					}
				});
			}
			{
				Restart = new JButton();
				Fondo.add(Restart);
				Restart.setEnabled(false);
				Restart.setText("Restart");
				Restart.setBounds(1190, 194, 86, 27);
				Restart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						reset();
					}
				});
			}
			{
				Inst = new JLabel();
				Fondo.add(Inst);
				Inst.setText("Instrucciones");
				Inst.setBounds(1158, 4, 184, 14);
			}
			{
				jLabel1 = new JLabel();
				Fondo.add(jLabel1);
				jLabel1.setText("Tabla de Registros");
				jLabel1.setBounds(1147, 227, 110, 16);
			}
			{
				jScrollPane2 = new JScrollPane();
				Fondo.add(jScrollPane2);
				jScrollPane2.setBounds(1108, 24, 171, 168);
				{
					Entrada = new JTextArea();
					jScrollPane2.setViewportView(Entrada);
					Entrada.setText("ADDI $1, $0, 0\n" + "ADDI $1, $1, 1\n" + "ANDI $4, $10, 15\n"+ "ORI $4, $4, 15\n"+ "SLTI $4, $10, 11\n"+ "ADD $2, $2, $1\n"+ "SW  $9, 10($2)\n"+ "SUB $7, $7, $2\n"+ "AND $4, $1, $15\n"+ "OR  $5, $4, $10\n"+ "LW  $9, 100($5)\n"+ "ADD $9, $9, $9\n"+ "SLL $6, $9, 2\n"+ "SRL $7, $12, 1\n"+ "SLT $8, $4, $5\n"+ "BEQ $1, $3, 1\n"+ "J 1\n"+ "JAL 19\n"+ "BNE $0, $1, 12\n"+ "ADDI $1, $1, 100\n"+ "ADD $2, $2, $1\n"+ "SW  $9, 10($2)\n"+ "SUB $3, $7, $2\n"+ "AND $4, $1, $15\n"+ "OR  $5, $4, $10\n"+ "LW  $9, 100($5)\n"+ "ADD $9, $9, $9\n"+ "SLL $6, $9, 2\n"+ "SRL $7, $12, 1\n"+ "SLT $8, $4, $5\n"+ "JR $31\n"+ "SW $1, 1023($0)");
					Entrada.setBounds(852, 21, 172, 169);
					Entrada.setName("Entrada");
					Entrada.setFont(new Font("",Font.BOLD,10));
					Entrada.setHighlighter(hilit);
					fillTextArea(Entrada);
				}
			}
			{
				TablaR = new JScrollPane();
				Fondo.add(TablaR);
				TablaR.setBounds(1108, 249, 175, 226);
				{
					TableModel RegistrosModel = 
						new DefaultTableModel(
								new String[][] {},
								new String[] { "Registro ", "Valor " });
					Registros = new JTable();
					TablaR.setViewportView(Registros);
					Registros.setModel(RegistrosModel);
				}
			}
			{
				MemoriaData = new JLabel();
				Fondo.add(MemoriaData);
				MemoriaData.setText("Memoria de Datos");
				MemoriaData.setBounds(1144, 487, 109, 11);
			}
			{
				Memoria = new JScrollPane();
				Fondo.add(Memoria);
				Memoria.setBounds(1110, 504, 173, 264);
				{
					TableModel MemoriaDModel = 
						new DefaultTableModel(
								new String[][] {},
								new String[] { "Direccion", "Valor" });
					MemoriaD = new JTable();
					Memoria.setViewportView(MemoriaD);
					MemoriaD.setModel(MemoriaDModel);
				}
			}
			pack();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	private void fillTextArea(JTextArea textA) {
		textA.setText(
					"ADDI $1, $0, 0\n" +
					"ADDI $1, $1, 1\n"+
					"ANDI $4, $10, 15\n"+
					"ORI $4, $4, 15\n"+
					"SLTI $4, $10, 11\n"+
					"ADD $2, $2, $1\n"+
					"SW  $9, 10($2)\n"+
					"SUB $7, $7, $2\n"+
					"AND $4, $1, $15\n"+
					"OR  $5, $4, $10\n"+
					"LW  $9, 100($5)\n"+
					"ADD $9, $9, $9\n"+
					"SLL $6, $9, 2\n"+
					"SRL $7, $12, 1\n"+
					"SLT $8, $4, $5\n"+
					"BEQ $1, $3, 1\n"+
					"J 1\n"+
					"JAL 19\n"+
					"BNE $0, $1, 12\n"+
					"ADDI $1, $1, 100\n"+
					"ADD $2, $2, $1\n"+
					"SW  $9, 10($2)\n"+
					"SUB $3, $7, $2\n"+
					"AND $4, $1, $15\n"+
					"OR  $5, $4, $10\n"+
					"LW  $9, 100($5)\n"+
					"ADD $9, $9, $9\n"+
					"SLL $6, $9, 2\n"+
					"SRL $7, $12, 1\n"+
					"SLT $8, $4, $5\n"+
					"JR $31\n"+
					"SW $1, 1023($0)");		
	}

	public void fillRegisterTable(Object[] array){
		String regTable[][] = new String[array.length][2];
		
		for (int i=0; i<array.length; i++){
			regTable[i][0] = "$" + String.valueOf(i);
			regTable[i][1] = String.valueOf(array[i]);	
		}
		
		TableModel RegistrosModel = 
			new DefaultTableModel(
					regTable,
					new String[] { "Registro ", "Valor " });
		Registros = new JTable();
		Registros.setEnabled(false);
		TablaR.setViewportView(Registros);
		Registros.setModel(RegistrosModel);
	}
	
	public void fillMemoryTable(Object array[]){
		String memTable[][] = new String[array.length][2];
		
		for (int i=0; i<array.length; i++){
			memTable[i][0] = String.valueOf(i);
			memTable[i][1] = String.valueOf(array[i]);	
		}

		TableModel MemoriaDModel = 
			new DefaultTableModel(
					memTable,
					new String[] { "Direccion", "Valor" });
		MemoriaD = new JTable();
		MemoriaD.setEnabled(false);
		Memoria.setViewportView(MemoriaD);
		MemoriaD.setModel(MemoriaDModel);
	}
	/***************************************************************************************/
	private void NextActionPerformed(ActionEvent evt) {
		
		if(sim.getStarted() == false){
			GetTextLine_Lines();
			try {
				sim.standBy(parser);
				Next.setText("Next");
				Restart.setEnabled(true);
				Entrada.setEditable(false);
			} catch (BinaryLengthException e) {
				e.printStackTrace();
			}
		}
		
		Processor MIPS = sim.getMIPS();
		
		paintLine(MIPS.getPC().getPC()/4);
		sim.nextStep();
		
		fillRegisterTable(MIPS.getRegFile().toArray());
		fillMemoryTable(MIPS.getDM().toArray());		

		MIPS.getCU();
		Id = new String[][]{
				//IF STAGE LABEL
				{"1", MIPS.getInstruction().getLabel()},
				//ID STAGE LABEL
				{"2", MIPS.getIf_id().getLabel()},
				//EX STAGE LABEL
				{"3", MIPS.getId_ex().getLabel()},
				//MEM STAGE LABEL
				{"4", MIPS.getEx_mem().getLabel()},
				//WB STAGE LABEL
				{"5", MIPS.getMem_wb().getLabel()},
				//CONTROL INPUT at ID STAGE
				{"6", String.valueOf(MIPS.getIf_id().getOpCode())},
				//WB at ID STAGE
				{"7", MIPS.getCU().getWB()},
				//M at ID STAGE
				{"8", MIPS.getCU().getM()},
				//EX at ID STAGE
				{"9", MIPS.getCU().getEX()},
				//WB at EX STAGE
				{"10", MIPS.getId_ex().getWB()},
				//M at EX STAGE
				{"11", MIPS.getId_ex().getM()},
				//EX0 at EX STAGE
				{"12", MIPS.getId_ex().getEX_0()},
				//EX1 at EX STAGE
				{"13", MIPS.getId_ex().getEX_1()},
				//EX2 at EX STAGE
				{"14", MIPS.getId_ex().getEX_2()},
				//JAL at ID STAGE
				{"15", String.valueOf(MIPS.getCU().getJumpAndLink())},
				//JAL at EX STAGE
				{"16", Integer.toBinaryString(MIPS.getId_ex().getJal())},
				//WB at MEM STAGE
				{"17", MIPS.getEx_mem().getWB()},
				//M0 at MEM STAGE
				{"18", MIPS.getEx_mem().getM0()},
				//M1 at MEM STAGE
				{"19", MIPS.getEx_mem().getM1()},
				//JAL at MEM STAGE
				{"20", String.valueOf(MIPS.getEx_mem().getJal())},
				//WB0 at WB STAGE
				{"21", MIPS.getMem_wb().getWB0()},
				//WB1 at WB STAGE
				{"22", MIPS.getMem_wb().getWB1()},
				//JAL at WB STAGE
				{"23", String.valueOf(MIPS.getMem_wb().getJal())},
				//PC + 4 at ID STAGE
				{"24", String.valueOf(MIPS.getIf_id().getPc4())},
				//PC + 4 at EX STAGE
				{"25", String.valueOf(MIPS.getId_ex().getPc4())},
				//PC + 4 at MEM STAGE
				{"26", String.valueOf(MIPS.getEx_mem().getPc4())},
				//PC + 4 at WB STAGE
				{"27", String.valueOf(MIPS.getMem_wb().getPc4())},
				//RS at ID STAGE
				{"28", String.valueOf(MIPS.getIf_id().getRs())},
				//RT at ID STAGE
				{"29", String.valueOf(MIPS.getIf_id().getRt())},
				//WR at ID STAGE
				{"30", String.valueOf(MIPS.getMuxWRJal().getOutput())},
				//WD at ID STAGE
				{"31", String.valueOf(MIPS.getMuxWDJal().getOutput())},
				//PC + 4 at IF STAGE
				{"32", String.valueOf(MIPS.getSmallALU1().getResult())},
				//IMM at ID STAGE
				{"33", String.valueOf(MIPS.getIf_id().getImm())},
				//RD at ID STAGE
				{"34", String.valueOf(MIPS.getIf_id().getRd())},
				//RT at ID STAGE
				{"35", String.valueOf(MIPS.getIf_id().getRt())},
				//IMM 32 bits at ID STAGE
				{"36", String.valueOf(MIPS.getIf_id().getImm())},
				//READ DATA 1 at ID STAGE
				{"37", String.valueOf(MIPS.getRegFile().getRd1())},
				//READ DATA 2 at ID STAGE
				{"38", String.valueOf(MIPS.getRegFile().getRd2())},
				//EQUALITY COMPARATOR at ID STAGE
				{"39", String.valueOf(MIPS.getMuxInvZero().getOutput())},
				//EQUALITY COMPARATOR at ID STAGE
				{"40", String.valueOf(MIPS.getMuxInvZero().getOutput())},
				//READ DATA 1 at EX STAGE
				{"41", String.valueOf(MIPS.getId_ex().getRd1())},
				//READ DATA 2 at EX STAGE
				{"42", String.valueOf(MIPS.getId_ex().getRd2())},
				//SIGN EXT at EX STAGE
				{"43", String.valueOf(MIPS.getId_ex().getSe())},
				//FUNCT at EX STAGE
				{"44", String.valueOf(MIPS.getId_ex().getFunct())},
				//RS at ID STAGE
				{"45", String.valueOf(MIPS.getIf_id().getRs())},
				//RT at ID STAGE
				{"46", String.valueOf(MIPS.getIf_id().getRt())},
				//RS at EX STAGE
				{"47", String.valueOf(MIPS.getId_ex().getRs())},
				//RT at EX STAGE
				{"48", String.valueOf(MIPS.getId_ex().getRt())},
				//RT at EX STAGE
				{"49", String.valueOf(MIPS.getId_ex().getRt())},
				//RD at EX STAGE
				{"50", String.valueOf(MIPS.getId_ex().getRd())},
				//REGDEST at EX STAGE
				{"51", String.valueOf(MIPS.getId_ex().getRegDest())},
				//MUXA OUTPUT at EX STAGE
				{"52", String.valueOf(MIPS.getMuxA().getOutput())},
				//MUXB OUTPUT at EX STAGE
				{"53", String.valueOf(MIPS.getMuxB().getOutput())},				
				//MUX REGDEST at EX STAGE
				{"54", String.valueOf(MIPS.getMuxRegDest().getOutput())},
				//MUX ALU SRC at EX STAGE
				{"55", String.valueOf(MIPS.getMuxALUSrc().getOutput())},
				//ALUOP at EX STAGE
				{"56", String.valueOf(MIPS.getId_ex().getAluOp())},
				//ALUCTRL at EX STAGE
				{"57", String.valueOf(ControlUnit.getAluCtrl(MIPS.getId_ex().getAluOp(), MIPS.getId_ex().getFunct()))},
				//ALU RESULT at EX STAGE
				{"58", String.valueOf(MIPS.getBigALU().getResult())},
				//PC + 4 at ID STAGE
				{"59", String.valueOf(MIPS.getIf_id().getPc4())},
				//PC + 4 at IF STAGE
				{"60", String.valueOf(MIPS.getPC().getPC())},
				//ALU RESULT at MEM STAGE
				{"61", String.valueOf(MIPS.getEx_mem().getAluResult())},
				//DATA FROM DM at  MEM STAGE
				{"62", String.valueOf(MIPS.getDM().read(MIPS.getEx_mem().getMemRead()))},
				//DATA FROM DM at WB STAGE
				{"63", String.valueOf(MIPS.getMem_wb().getDataMem())},
				//ALU RESULT at WB STAGE
				{"64", String.valueOf(MIPS.getMem_wb().getAluResult())},
				//MUX MEMTOREG at WB STAGE
				{"65", String.valueOf(MIPS.getMuxMemToReg().getOutput())},
				//RD at MEM STAGE
				{"66", String.valueOf(MIPS.getEx_mem().getRd())},
				//RD at WB STAGE
				{"67", String.valueOf(MIPS.getMem_wb().getRd())},
				//JAL at ID STAGE
				{"68", String.valueOf(MIPS.getCU().getJumpAndLink())},
				//JR at ID STAGE
				{"69", String.valueOf(MIPS.getCU().getJumpR())},
				//ID.FLUSH
				{"70", String.valueOf(MIPS.getIf_id().isFlushed())},
				//PC WRITE
				{"71", String.valueOf(MIPS.getPC().isWritable())},
				//IF/ID WRITE
				{"72", String.valueOf(MIPS.getIf_id().isWritable())},
				//MUX BUBBLE CTRL
				{"73", String.valueOf(MIPS.getHDUnit().getCtrlMuxBubble())},
				//MUX B CTRL
				{"74", String.valueOf(MIPS.getMuxB().getCtrl())},
				//MUX A CTRL
				{"75", String.valueOf(MIPS.getMuxA().getCtrl())},
				//BRANCH DIR at ID STAGE
				{"76", String.valueOf(MIPS.getSmallALU2().getResult())},
				//SHAMT at EX STAGE
				{"77", String.valueOf(MIPS.getId_ex().getShamt())},
				//SHAMT at ID STAGE
				{"78", String.valueOf(MIPS.getIf_id().getShamt())},
				//MUX PCSRC OUTPUT
				{"79", String.valueOf(MIPS.getMuxPCSrc().getOutput())},
				//MUX JUMP OUTPUT
				{"80", String.valueOf(MIPS.getMuxJump().getOutput())},
				//MUX JR OUTPUT
				{"81", String.valueOf(MIPS.getMuxJr().getOutput())},
				//SHIFT LEFT OUTPUT 2
				{"82", String.valueOf(MIPS.getShiftUnit2().getOut())},
				//SHIFT LEFT OUTPUT 1
				{"83", String.valueOf(MIPS.getShiftUnit1().getOut())},
				//JUMP ADDRESS
				{"84", String.valueOf(MIPS.getIf_id().getAddress())}
		};
		
		MIPS.getCU().printFlags();

		/*Funcion del boton siguiente.*/
		Fondo.reset(); //Reinicia los valores de las etiquetas
		Fondo.setValues(Id);

		//Hazard Detection Unit
		Fondo.Hazard_Activate(MIPS.getHDUnit().getActive());
		//Forwarding Unit
		Fondo.Fowarding_Activate(MIPS.getFUnit().getActive());
		
		//Stage 1
		{
			if(MIPS.validPC()){
				Fondo.PC_Activate(MIPS.getHDUnit().getPcWrite());
				Fondo.IMemory_ActivateR(1);
				Fondo.IFID_ActivateW(MIPS.getHDUnit().getIF_ID_Write());
				Fondo.ALU1_Activate(1);
			}
		}
		
		//Stage 2
		if(!MIPS.getIf_id().getLabel().equals("Bubble(Nop)")){
			Fondo.Control_Activate(1);
			Fondo.IFID_ActivateR(1);
			Fondo.IDEX_ActivateW(1);
			
			int opCode = MIPS.getIf_id().getOpCode();
			int funct = MIPS.getIf_id().getFunct();

			switch(opCode){
			//R-Type [JR,ADD, SUB, AND, OR, SLT, SLL, SRL]
			case 0:
				//FUNCT
				switch(funct){
					//SLL, SRL, ADD, SUB, AND, OR, XOR, SLT, JR 
					case 0: case 2: case 32: case 34: case 36: 
					case 37: case 38: case 42: case 8:
						Fondo.Registers_ActivateR(1);
						break;
				}
				break;
			//J,JAL
			case 2: case 3:
				Fondo.Shift_Activate(1);
				break;
			//LW, SW, ADDI, ANDI, ORI, SLTI
			case 35: case 43: case 8: case 12: case 13: case 10:
				Fondo.Signede_Activate(1);
				Fondo.Registers_ActivateR(1);
				break;
			//BEQ, BNE
			case 4: case 5:
				Fondo.Shift2_Activate(1);
				Fondo.Signede_Activate(1);
				Fondo.ALU2_Activate(1);
				Fondo.Registers_ActivateR(1);
				Fondo.Xor_Activate(1);
				break;			
			}
		}
		
		//Stage 3
		if(!MIPS.getId_ex().getLabel().equals("Bubble(Nop)")){
			Fondo.IDEX_ActivateR(1);
			Fondo.EXMEM_ActivateW(1);
			
			if(MIPS.getId_ex().getRegWrite() == 1 || 
			   MIPS.getId_ex().getMemRead() == 1  ||
			   MIPS.getId_ex().getMemWrite() == 1){
				Fondo.Alucontrol_Activate(1);
				Fondo.ALU3_Activate(1);
			}
		}
		
		//Stage 4
		if(!MIPS.getEx_mem().getLabel().equals("Bubble(Nop)")){
			Fondo.EXMEM_ActivateR(1);
			Fondo.MEMWB_ActivateW(1);
						
			if(MIPS.getEx_mem().getMemRead() == 1)
				Fondo.DMemory_ActivateR(1);
			if(MIPS.getEx_mem().getMemWrite() == 1)
				Fondo.DMemory_ActivateW(1);
		}
		
		//Stage 5
		if(!MIPS.getMem_wb().getLabel().equals("Bubble(Nop)")){
			Fondo.MEMWB_ActivateR(1);
			if(MIPS.getMem_wb().getRegWrite() == 1)
				Fondo.Registers_ActivateW(1);
		}

		//Muxes
		Fondo.Mux_Activate(MIPS.getMuxPCSrc().getCtrl(), 
						   MIPS.getMuxJump().getCtrl(), 
						   MIPS.getMuxJr().getCtrl(), 
						   MIPS.getMuxWRJal().getCtrl(), 
						   MIPS.getMuxWDJal().getCtrl(), 
						   MIPS.getHDUnit().getCtrlMuxBubble(), 
						   MIPS.getMuxA().getCtrl(), 
						   MIPS.getMuxB().getCtrl(), 
						   MIPS.getMuxRegDest().getCtrl(), 
						   MIPS.getMuxALUSrc().getCtrl(), 
						   MIPS.getMuxMemToReg().getCtrl());
		
		
		/*
		if(count_clicks%2==0){						
			Fondo.IFID_Activate(1);
			Fondo.IDEX_Activate(1);
			Fondo.EXMEM_Activate(1);
			Fondo.MEMWB_Activate(1);
			Fondo.ALU1_Activate(1);
			Fondo.ALU2_Activate(1);
			Fondo.ALU3_Activate(1);
			Fondo.PC_Activate(1);
			Fondo.Registers_Activate(1);
			Fondo.IMemory_Activate(1);
			Fondo.DMemory_Activate(1);
			Fondo.Control_Activate(1);
			Fondo.Shift_Activate(1);
			Fondo.Hazard_Activate(1);
			Fondo.Fowarding_Activate(1);
			Fondo.Signede_Activate(1);
			Fondo.Shift2_Activate(1);
			Fondo.Xor_Activate(1);
			Fondo.Alucontrol_Activate(1);
			Fondo.Mux_Activate(1,1,1,1,1,1,1,1,1,1,1);
			//paintLine(3,4);
			
		} else {
			
			Fondo.IFID_Activate(2);
			Fondo.IDEX_Activate(2);
			Fondo.EXMEM_Activate(2);
			Fondo.MEMWB_Activate(2);
			Fondo.ALU1_Activate(0);
			Fondo.ALU2_Activate(0);
			Fondo.ALU3_Activate(0);
			Fondo.PC_Activate(0);
			Fondo.Registers_Activate(2);
			Fondo.IMemory_Activate(2);
			Fondo.DMemory_Activate(2);
			Fondo.Control_Activate(0);
			Fondo.Shift_Activate(0);
			Fondo.Hazard_Activate(0);
			Fondo.Fowarding_Activate(0);
			Fondo.Signede_Activate(0);
			Fondo.Shift2_Activate(0);
			Fondo.Xor_Activate(0);
			Fondo.Alucontrol_Activate(0);
			Fondo.Mux_Activate(0,0,0,0,0,0,0,0,0,0,0);
			
			//paintLine(5,6);
		}
		*/
		MIPS.nextClockEgde();
		
	}
	/***************************************************************************************/

	public void GetTextLine_Lines(){
		
		int inicio=0;
		int numl=Entrada.getLineCount();
		int a=0,b=0;
		String inst="";
		parser = new Parser();
		for(;inicio<numl;inicio++){			
			/*Exception necesary***/
			try {
				a=Entrada.getLineStartOffset(inicio);
				b=Entrada.getLineEndOffset(inicio);
				inst=Entrada.getText(a, b-a);
				System.out.print(inst);
				///Here agrega la instruccion a Instruction Memory
				try {
					if(inst.length() > 0)
						parser.parse(inst);
				} catch (BinaryLengthException e) {
					e.printStackTrace();
				}				
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
			/*End Exception necesary***/			
		}		
	}
	
	public void paintLine(int numLine){
		hilit.removeAllHighlights();
		try {
			int a=Entrada.getLineStartOffset(numLine);
			int b=Entrada.getLineEndOffset(numLine);
			hilit.addHighlight(a,b, painter);
			Entrada.select(a, b);
			Entrada.requestFocus();
		} catch (BadLocationException e) {
			System.out.println("\n\n ***** Instruccion invalida/Fin del programa ***** \n\n");
		}	
	}
}
