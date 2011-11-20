package graphix;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;



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
public class Panel extends javax.swing.JPanel {

	private static final long serialVersionUID = -1772564531624491714L;
	private JScrollPane jScrollPane1;
	private JLabel WB3_2;
	private JLabel WB3_1;
	private JLabel Jal2;
	private JLabel M2_2;
	private JLabel M2_1;
	private JLabel WB2;
	private JLabel EX1_3;
	private JLabel Jal1;
	private JLabel Jal0;
	private JLabel EX1_2;
	private JLabel EX1_1;
	private JLabel M1;
	private JLabel WB0;
	private JLabel WB1;
	private JLabel EX0;
	private JLabel M0;
	private JLabel Constante;
	private JLabel Constante20_2;
	private JLabel Sham;
	private JLabel PC4_SL;
	private JLabel FU1;
	private JLabel FU2;
	private JLabel HDU3;
	private JLabel HDU1;
	private JLabel HDU2;
	private JLabel FFlush;
	private JLabel ADDRESS;
	private JLabel SSL1;
	private JLabel SSL2;
	private JLabel SMUX3;
	private JLabel SMUX2;
	private JLabel SMUX1;
	private JLabel SHAMT;
	private JLabel Jr;
	private JLabel Jump;
	private JLabel Direccion1;
	private JLabel Direccion0;
	private JLabel SMUX11;
	private JLabel ALU3;
	private JLabel DM2;
	private JLabel DM;
	private JLabel ALU2;
	private JLabel PC;
	private JLabel PC_4A;
	private JLabel ALU;
	private JLabel Alucontrol;
	private JLabel AluOP;
	private JLabel SMUX9;
	private JLabel SMUX10;
	private JLabel SMUX8;
	private JLabel SMUX7;
	private JLabel RegDst;
	private JLabel RD_1;
	private JLabel RT_2;
	private JLabel R2_2;
	private JLabel R1_2;
	private JLabel R22;
	private JLabel R11;
	private JLabel Constante5;
	private JLabel ReadData2_2;
	private JLabel RD;
	private JLabel ReadData1_2;
	private JLabel XOR_IG1;
	private JLabel XOR_IG0;
	private JLabel ReadData2;
	private JLabel ReadData1;
	private JLabel Constante20;
	private JLabel RT;
	private JLabel PC_4;
	private JLabel WD;
	private JLabel WR;
	private JLabel R2;
	private JLabel R1;
	private JLabel PC_43;
	private JLabel PC_42;
	private JLabel PC_41;
	private JLabel PC_40;
	private JLabel Jal3;
	private JLabel Control;
	private JLabel WBS;
	private JLabel MEMS;
	private JLabel EXS;
	private JLabel IDS;
	private JLabel Ima;
	private JPanel jPanel1;
	private JLabel IFS;

	/**********Mouse*********************/
	private int xPos, yPos;
	/************************************/
	

	
	/******************Paint XY**************************/
	private int xScroll=0, yScroll=0;
	
	
	
	int IFID_ActivateR=0;
	int IFID_ActivateW=0;
	int IDEX_ActivateR=0;
	int IDEX_ActivateW=0;
	int EXMEM_ActivateR=0;
	int EXMEM_ActivateW=0;
	int MEMWB_ActivateR=0;
	int MEMWB_ActivateW=0;
	int ALU1_Activate=0;
	int ALU2_Activate=0;
	int ALU3_Activate=0;
	int PC_Activate=0;
	int Registers_ActivateW=0;
	int Registers_ActivateR=0;
	int IMemory_ActivateW=0;
	int IMemory_ActivateR=0;
	int DMemory_ActivateW=0;
	int DMemory_ActivateR=0;
	int Control_Activate=0;
	int Shift_Activate=0;
	int Hazard_Activate=0;
	int Fowarding_Activate=0;
	int Signede_Activate=0;
	int Shift2_Activate=0;
	int Xor_Activate=0;
	int Alucontrol_Activate=0;
	int Mux1_Activate=-1;
	int Mux2_Activate=-1;
	int Mux3_Activate=-1;
	int Mux4_Activate=-1;
	int Mux5_Activate=-1;
	int Mux6_Activate=-1;
	int Mux7_Activate=-1;
	int Mux8_Activate=-1;
	int Mux9_Activate=-1;
	int Mux10_Activate=-1;
	int Mux11_Activate=-1;
	
	/**************************************************/

	Color colorb;
	Color colorf;

	/** Etiquetas **/
	public String Names []={"","IFS","IDS","EXS","MEMS","WBS","Control","WB0",
							"M0","EX0","WB1","M1","EX1_1","EX1_2","EX1_3",
							"Jal0","Jal1","WB2","M2_1","M2_2","Jal2","WB3_1",
							"WB3_2","Jal3","PC_40","PC_41","PC_42","PC_43","R1",
							"R2","WR","WD","PC_4","Constante","RD","RT","Constante20",
							"ReadData1","ReadData2","XOR_IG0","XOR_IG1","ReadData1_2",
							"ReadData2_2","Constante20_2","Constante5","R11","R22","R1_2",
							"R2_2","RT_2","RD_1","RegDst","SMUX7","SMUX8","SMUX10","SMUX9",
							"AluOP","Alucontrol","ALU","PC_4A","PC","ALU2","DM",
							"DM2","ALU3","SMUX11","Direccion0","Direccion1","Jump",
							"Jr","FFlush","HDU2","HDU1","HDU3","FU1","FU2","PC4_SL",
							"Sham", "SHAMT", "SMUX1", "SMUX2", "SMUX3", "SSL2", "SSL1", "ADDRESS"}; 
	
	
	HashMap <String,JLabel > Labels=new HashMap <String ,JLabel>();  
	
	
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	
	
	public Panel() {
		super();
		initGUI();
		getColorbase();
		
	}
	
	private void initGUI() {
		try {

			this.setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(1024, 768));
			//this.setPreferredSize(new java.awt.Dimension(1024,768));
			
			{
				jScrollPane1 = new JScrollPane();
				this.add(getJScrollPane1());
				jScrollPane1.setBounds(0, 0, 1106, 768);
				{
					jPanel1 = new JPanel();
					jScrollPane1.setViewportView(jPanel1);
					jPanel1.setBounds(1, 1, 1253, 804);
					jPanel1.setLayout(null);
					jPanel1.setPreferredSize(new java.awt.Dimension(1224, 812));
					{
						IFS = new JLabel();
						jPanel1.add(IFS);
						IFS.setText("IF: add $t0,$t0,$t0");
						IFS.setBounds(7, 13, 257, 14);
						Labels.put("IFS", IFS);
					}
					{
						IDS = new JLabel();
						jPanel1.add(IDS);
						IDS.setText("ID: Add $t0,$t0,$t0");
						IDS.setBounds(281, 12, 317, 14);
						Labels.put("IDS", IDS);
					}
					{
						EXS = new JLabel();
						jPanel1.add(EXS);
						EXS.setText("EX: XXXXXX");
						EXS.setBounds(610, 13, 249, 14);
						Labels.put("EXS", EXS);
					}
					{
						MEMS = new JLabel();
						jPanel1.add(MEMS);
						MEMS.setText("MEM: XXXXX");
						MEMS.setBounds(869, 12, 178, 14);
						Labels.put("MEMS", MEMS);
					}
					{
						WBS = new JLabel();
						jPanel1.add(WBS);
						WBS.setText("WB: XXXXXXX");
						WBS.setBounds(1059, 12, 165, 14);
						Labels.put("WBS", WBS);
					}
					{
						Control = new JLabel();
						jPanel1.add(Control);
						Control.setText("X1");
						Control.setBounds(320, 237, 107, 21);
						Labels.put("Control", Control);
					}
					{
						WB0 = new JLabel();
						jPanel1.add(WB0);
						WB0.setText("WB0");
						WB0.setBounds(553, 210, 48, 14);
						Labels.put("WB0", WB0);
					}
					{
						M0 = new JLabel();
						jPanel1.add(M0);
						M0.setText("M0");
						M0.setBounds(553, 246, 45, 14);
						Labels.put("M0", M0);
					}
					{
						EX0 = new JLabel();
						jPanel1.add(EX0);
						EX0.setText("EX0");
						EX0.setBounds(553, 297, 44, 14);
						Labels.put("EX0", EX0);
					}
					{
						WB1 = new JLabel();
						jPanel1.add(WB1);
						WB1.setText("WB1");
						WB1.setBounds(734, 210, 100, 14);
						Labels.put("WB1", WB1);
					}
					{
						M1 = new JLabel();
						jPanel1.add(M1);
						M1.setText("M1");
						M1.setBounds(685, 243, 135, 14);
						Labels.put("M1", M1);
					}
					{
						EX1_1 = new JLabel();
						jPanel1.add(EX1_1);
						EX1_1.setText("EX1_1");
						EX1_1.setBounds(642, 268, 106, 14);
						Labels.put("EX1_1", EX1_1);
					}
					{
						EX1_2 = new JLabel();
						jPanel1.add(EX1_2);
						EX1_2.setText("EX1_2");
						EX1_2.setBounds(642, 284, 131, 14);
						Labels.put("EX1_2", EX1_2);
					}
					{
						EX1_3 = new JLabel();
						jPanel1.add(EX1_3);
						EX1_3.setText("EX1_3");
						EX1_3.setBounds(642, 296, 118, 14);
						Labels.put("EX1_3", EX1_3);
					}
					{
						Jal0 = new JLabel();
						jPanel1.add(Jal0);
						Jal0.setText("Jal0");
						Jal0.setBounds(521, 308, 48, 14);
						Labels.put("Jal0", Jal0);
					}
					{
						Jal1 = new JLabel();
						jPanel1.add(Jal1);
						Jal1.setText("Jal1");
						Jal1.setBounds(641, 311, 80, 14);
						Labels.put("Jal1", Jal1);
					}
					{
						WB2 = new JLabel();
						jPanel1.add(WB2);
						WB2.setText("WB2");
						WB2.setBounds(905, 243, 90, 18);
						Labels.put("WB2", WB2);
					}
					{
						M2_1 = new JLabel();
						jPanel1.add(M2_1);
						M2_1.setText("M2_1");
						M2_1.setBounds(905, 281, 91, 14);
						Labels.put("M2_1", M2_1);
					}
					{
						M2_2 = new JLabel();
						jPanel1.add(M2_2);
						M2_2.setText("M2_2");
						M2_2.setBounds(905, 297, 65, 14);
						Labels.put("M2_2", M2_2);
					}
					{
						Jal2 = new JLabel();
						jPanel1.add(Jal2);
						Jal2.setText("Jal2");
						Jal2.setBounds(906, 310, 62, 14);
						Labels.put("Jal2", Jal2);
					}
					{
						WB3_1 = new JLabel();
						jPanel1.add(WB3_1);
						WB3_1.setText("WB3_1");
						WB3_1.setBounds(1073, 280, 98, 14);
						Labels.put("WB3_1", WB3_1);
					}
					{
						WB3_2 = new JLabel();
						jPanel1.add(WB3_2);
						WB3_2.setText("WB3_2");
						WB3_2.setBounds(1106, 295, 79, 14);
						Labels.put("WB3_2", WB3_2);
					}
					{
						Jal3 = new JLabel();
						jPanel1.add(Jal3);
						Jal3.setText("Jal3");
						Jal3.setBounds(1150, 310, 50, 14);
						Labels.put("Jal3", Jal3);
					}
					{
						PC_40 = new JLabel();
						jPanel1.add(PC_40);
						PC_40.setText("PC_40");
						PC_40.setBounds(521, 339, 68, 14);
						Labels.put("PC_40", PC_40);
					}
					{
						PC_41 = new JLabel();
						jPanel1.add(PC_41);
						PC_41.setText("PC_41");
						PC_41.setBounds(634, 339, 86, 12);
						Labels.put("PC_41", PC_41);
					}
					{
						PC_42 = new JLabel();
						jPanel1.add(PC_42);
						PC_42.setText("PC_42");
						PC_42.setBounds(904, 339, 57, 14);
						Labels.put("PC_42", PC_42);
					}
					{
						PC_43 = new JLabel();
						jPanel1.add(PC_43);
						PC_43.setText("PC_43");
						PC_43.setBounds(1102, 339, 66, 14);
						Labels.put("PC_43", PC_43);
					}
					{
						R1 = new JLabel();
						jPanel1.add(R1);
						R1.setText("R1");
						R1.setBounds(317, 372, 139, 14);
						Labels.put("R1", R1);
					}
					{
						R2 = new JLabel();
						jPanel1.add(R2);
						R2.setText("R2");
						R2.setBounds(342, 386, 97, 15);
						Labels.put("R2", R2);
					}
					{
						WR = new JLabel();
						jPanel1.add(WR);
						WR.setText("WR");
						WR.setBounds(353, 419, 103, 17);
						Labels.put("WR", WR);
					}
					{
						WD = new JLabel();
						jPanel1.add(WD);
						WD.setText("WD");
						WD.setBounds(364, 448, 101, 14);
						Labels.put("WD", WD);
					}
					{
						PC_4 = new JLabel();
						jPanel1.add(PC_4);
						PC_4.setText("PC_4");
						PC_4.setBounds(139, 240, 103, 14);
						Labels.put("PC_4", PC_4);
					}
					{
						Constante = new JLabel();
						jPanel1.add(Constante);
						Constante.setText("Constante");
						Constante.setBounds(320, 510, 76, 15);
						Labels.put("Constante", Constante);
					}
					{
						RD = new JLabel();
						jPanel1.add(RD);
						RD.setText("RD");
						RD.setBounds(454, 602, 76, 14);
						Labels.put("RD", RD);
					}
					{
						RT = new JLabel();
						jPanel1.add(RT);
						RT.setText("RT");
						RT.setBounds(454, 586, 78, 14);
						Labels.put("RT", RT);
					}
					{
						Constante20 = new JLabel();
						jPanel1.add(Constante20);
						Constante20.setText("Constante20");
						Constante20.setBounds(467, 510, 87, 14);
						Labels.put("Constante20", Constante20);
					}
					{
						ReadData1 = new JLabel();
						jPanel1.add(ReadData1);
						ReadData1.setText("ReadData1");
						ReadData1.setBounds(541, 351, 68, 14);
						Labels.put("ReadData1", ReadData1);
					}
					{
						ReadData2 = new JLabel();
						jPanel1.add(ReadData2);
						ReadData2.setText("ReadData2");
						ReadData2.setBounds(541, 456, 67, 14);
						Labels.put("ReadData2", ReadData2);
					}
					{
						XOR_IG0 = new JLabel();
						jPanel1.add(XOR_IG0);
						XOR_IG0.setText("XOR_IG0");
						XOR_IG0.setBounds(553, 403, 18, 14);
						Labels.put("XOR_IG0", XOR_IG0);
					}
					{
						XOR_IG1 = new JLabel();
						jPanel1.add(XOR_IG1);
						XOR_IG1.setText("XOR_IG1");
						XOR_IG1.setBounds(63, 574, 25, 15);
						Labels.put("XOR_IG1", XOR_IG1);
					}
					{
						ReadData1_2 = new JLabel();
						jPanel1.add(ReadData1_2);
						ReadData1_2.setText("ReadData1_2");
						ReadData1_2.setBounds(621, 352, 79, 17);
						Labels.put("ReadData1_2", ReadData1_2);
					}
					{
						ReadData2_2 = new JLabel();
						jPanel1.add(ReadData2_2);
						ReadData2_2.setText("ReadData2_2");
						ReadData2_2.setBounds(621, 435, 73, 14);
						Labels.put("ReadData2_2", ReadData2_2);
					}
					{
						Constante20_2 = new JLabel();
						jPanel1.add(Constante20_2);
						Constante20_2.setText("Constante20_2");
						Constante20_2.setBounds(623, 498, 74, 14);
						Labels.put("Constante20_2", Constante20_2);
					}
					{
						Constante5 = new JLabel();
						jPanel1.add(Constante5);
						Constante5.setText("Constante5");
						Constante5.setBounds(622, 514, 80, 14);
						Labels.put("Constante5", Constante5);
					}
					{
						R11 = new JLabel();
						jPanel1.add(R11);
						R11.setText("R11");
						R11.setBounds(454, 561, 79, 14);
						Labels.put("R11", R11);
					}
					{
						R22 = new JLabel();
						jPanel1.add(R22);
						R22.setText("R22");
						R22.setBounds(454, 574, 83, 14);
						Labels.put("R22", R22);
					}
					{
						R1_2 = new JLabel();
						jPanel1.add(R1_2);
						R1_2.setText("R1_2");
						R1_2.setBounds(619, 560, 49, 14);
						Labels.put("R1_2", R1_2);
					}
					{
						R2_2 = new JLabel();
						jPanel1.add(R2_2);
						R2_2.setText("R2_2");
						R2_2.setBounds(619, 575, 46, 14);
						Labels.put("R2_2", R2_2);
					}
					{
						RT_2 = new JLabel();
						jPanel1.add(RT_2);
						RT_2.setText("RT_2");
						RT_2.setBounds(619, 587, 41, 14);
						Labels.put("RT_2", RT_2);
					}
					{
						RD_1 = new JLabel();
						jPanel1.add(RD_1);
						RD_1.setText("RD_1");
						RD_1.setBounds(619, 605, 47, 14);
						Labels.put("RD_1", RD_1);
					}
					{
						RegDst = new JLabel();
						jPanel1.add(RegDst);
						RegDst.setText("RegDst");
						RegDst.setBounds(765, 569, 69, 14);
						Labels.put("RegDst", RegDst);
					}
					{
						SMUX7 = new JLabel();
						jPanel1.add(SMUX7);
						SMUX7.setText("SMUX7");
						SMUX7.setBounds(729, 372, 55, 13);
						Labels.put("SMUX7", SMUX7);
					}
					{
						SMUX8 = new JLabel();
						jPanel1.add(SMUX8);
						SMUX8.setText("SMUX8");
						SMUX8.setBounds(730, 449, 37, 18);
						Labels.put("SMUX8", SMUX8);
					}
					{
						SMUX10 = new JLabel();
						jPanel1.add(SMUX10);
						SMUX10.setText("SMUX10");
						SMUX10.setBounds(756, 591, 64, 14);
						Labels.put("SMUX10", SMUX10);
					}
					{
						SMUX9 = new JLabel();
						jPanel1.add(SMUX9);
						SMUX9.setText("SMUX9");
						SMUX9.setBounds(771, 467, 96, 11);
						Labels.put("SMUX9", SMUX9);
					}
					{
						AluOP = new JLabel();
						jPanel1.add(AluOP);
						AluOP.setText("AluOP");
						AluOP.setBounds(765, 543, 57, 14);
						Labels.put("AluOP", AluOP);
					}
					{
						Alucontrol = new JLabel();
						jPanel1.add(Alucontrol);
						Alucontrol.setText("Alucontrol");
						Alucontrol.setBounds(768, 497, 54, 17);
						Labels.put("Alucontrol", Alucontrol);
					}
					{
						ALU = new JLabel();
						jPanel1.add(ALU);
						ALU.setText("ALU");
						ALU.setBounds(812, 414, 63, 14);
						Labels.put("ALU", ALU);
					}
					{
						PC_4A = new JLabel();
						jPanel1.add(PC_4A);
						PC_4A.setText("PC_4A");
						PC_4A.setBounds(366, 308, 44, 18);
						Labels.put("PC_4A", PC_4A);
					}
					{
						PC = new JLabel();
						jPanel1.add(PC);
						PC.setText("PC");
						PC.setBounds(138, 284, 50, 12);
						Labels.put("PC", PC);
					}
					{
						ALU2 = new JLabel();
						jPanel1.add(ALU2);
						ALU2.setText("ALU2");
						ALU2.setBounds(877, 412, 87, 14);
						Labels.put("ALU2", ALU2);
					}
					{
						DM = new JLabel();
						jPanel1.add(DM);
						DM.setText("DM");
						DM.setBounds(1018, 418, 70, 10);
						Labels.put("DM", DM);
					}
					{
						DM2 = new JLabel();
						jPanel1.add(DM2);
						DM2.setText("DM2");
						DM2.setBounds(1072, 416, 87, 17);
						Labels.put("DM2", DM2);
					}
					{
						ALU3 = new JLabel();
						jPanel1.add(ALU3);
						ALU3.setText("ALU3");
						ALU3.setBounds(1076, 505, 51, 14);
						Labels.put("ALU3", ALU3);
					}
					{
						SMUX11 = new JLabel();
						jPanel1.add(SMUX11);
						SMUX11.setText("SMUX11");
						SMUX11.setBounds(1150, 435, 73, 15);
						Labels.put("SMUX11", SMUX11);
					}
					{
						Direccion0 = new JLabel();
						jPanel1.add(Direccion0);
						Direccion0.setText("Direccion0");
						Direccion0.setBounds(938, 588, 74, 14);
						Labels.put("Direccion0", Direccion0);
					}
					{
						Direccion1 = new JLabel();
						jPanel1.add(Direccion1);
						Direccion1.setText("Direccion1");
						Direccion1.setBounds(1072, 586, 49, 17);
						Labels.put("Direccion1", Direccion1);
					}
					{
						Jump = new JLabel();
						jPanel1.add(Jump);
						Jump.setText("Jump: 0");
						Jump.setBounds(67, 534, 59, 24);
						Labels.put("Jump", Jump);
					}
					{
						Jr = new JLabel();
						jPanel1.add(Jr);
						Jr.setText("Jr: 0");
						Jr.setBounds(114, 616, 45, 24);
						Labels.put("Jr", Jr);
					}
					{
						FFlush = new JLabel();
						jPanel1.add(FFlush);
						FFlush.setText("FFlush: 0");
						FFlush.setBounds(49, 141, 53, 14);
						Labels.put("FFlush", FFlush);
					}
					{
						HDU2 = new JLabel();
						jPanel1.add(HDU2);
						HDU2.setText("HDU2");
						HDU2.setBounds(100, 161, 65, 20);
						Labels.put("HDU2", HDU2);
					}
					{
						HDU1 = new JLabel();
						jPanel1.add(HDU1);
						HDU1.setText("HDU1");
						HDU1.setBounds(259, 169, 47, 19);
						Labels.put("HDU1", HDU1);
					}
					{
						HDU3 = new JLabel();
						jPanel1.add(HDU3);
						HDU3.setText("HDU3");
						HDU3.setBounds(527, 174, 45, 14);
						Labels.put("HDU3", HDU3);
					}
					{
						FU1 = new JLabel();
						jPanel1.add(FU1);
						FU1.setText("FU1");
						FU1.setBounds(694, 500, 28, 14);
						Labels.put("FU1", FU1);
					}
					{
						FU2 = new JLabel();
						jPanel1.add(FU2);
						FU2.setText("FU2");
						FU2.setBounds(695, 420, 38, 18);
						Labels.put("FU2", FU2);
					}
					{
						PC4_SL = new JLabel();
						jPanel1.add(PC4_SL);
						PC4_SL.setText("PC4_SL");
						PC4_SL.setBounds(117, 102, 147, 14);
						Labels.put("PC4_SL", PC4_SL);
					}
					{
						Sham = new JLabel();
						jPanel1.add(Sham);
						Sham.setText("Sham");
						Sham.setBounds(622, 544, 40, 14);
						Labels.put("Sham", Sham);
					}
					{
						SHAMT = new JLabel();
						jPanel1.add(SHAMT);
						SHAMT.setText("SHAMT");
						SHAMT.setBounds(323, 544, 73, 15);
						Labels.put("SHAMT", SHAMT);
					}
					{
						SMUX1 = new JLabel();
						jPanel1.add(SMUX1);
						SMUX1.setText("SMUX1");
						SMUX1.setBounds(88, 435, 33, 14);
						Labels.put("SMUX1", SMUX1);
					}
					{
						SMUX2 = new JLabel();
						jPanel1.add(SMUX2);
						SMUX2.setText("SMUX2");
						SMUX2.setBounds(127, 500, 33, 14);
						Labels.put("SMUX2", SMUX2);
					}
					{
						SMUX3 = new JLabel();
						jPanel1.add(SMUX3);
						SMUX3.setText("SMUX3");
						SMUX3.setBounds(155, 578, 33, 14);
						Labels.put("SMUX3", SMUX3);
					}
					{
						SSL2 = new JLabel();
						jPanel1.add(SSL2);
						SSL2.setText("SSL2");
						SSL2.setBounds(415, 269, 77, 14);
						Labels.put("SSL2", SSL2);
					}
					{
						SSL1 = new JLabel();
						jPanel1.add(SSL1);
						SSL1.setText("SSL1");
						SSL1.setBounds(18, 53, 97, 14);
						Labels.put("SSL1", SSL1);
					}
					{
						ADDRESS = new JLabel();
						jPanel1.add(ADDRESS);
						ADDRESS.setText("ADDRESS");
						ADDRESS.setBounds(309, 61, 49, 16);
						Labels.put("ADDRESS", ADDRESS);
					}
					{
						Ima = new JLabel();
						jPanel1.add(Ima);
						Ima.setBounds(-4, 1, 1200, 778);
						Ima.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ima.png")));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jPanel1.addMouseListener( new ManejadorClicsRaton() );
		
		/*****************Listener for jscrollPane******************/
		/***********************************************************/
		AdjustmentListener hListener = new AdjustmentListener() {
		      public void adjustmentValueChanged(AdjustmentEvent e) {
		    	  //System.out.println("Horizontal: ");
		    	  Informacion(e,1);
		    	  repaint();
		      }
		    };
		
		JScrollBar hBar = jScrollPane1.getHorizontalScrollBar();
	    hBar.addAdjustmentListener(hListener);
	    
	    AdjustmentListener vListener = new AdjustmentListener() {
	      public void adjustmentValueChanged(AdjustmentEvent e) {
	       // System.out.println("Vertical: ");
	        Informacion(e,2);
	        repaint();
	      }
	    };
	    
	    
	    JScrollBar vBar = jScrollPane1.getVerticalScrollBar();
	    vBar.addAdjustmentListener(vListener);
	    /************************************************************/
		    
	}
	
	/****************************Jscroll Methodo**********************/
	public  void Informacion(AdjustmentEvent e, int i) {
	   // System.out.println("\tValue: " + e.getValue());
	    
	    //String type = null;
	    
	    switch (e.getAdjustmentType()) {
	    case AdjustmentEvent.TRACK:
	    	if(i==1)this.xScroll=e.getValue(); //Horizontal__Scroll x
	    	if(i==2) this.yScroll=e.getValue(); //Scroll x
	      break;
	    
	    /*case AdjustmentEvent.BLOCK_DECREMENT:
	      type = "Block Decrement";
	      break;
	    case AdjustmentEvent.BLOCK_INCREMENT:
	      type = "Block Increment";
	      break;
	    case AdjustmentEvent.UNIT_DECREMENT:
	      type = "Unit Decrement";
	      break;
	    case AdjustmentEvent.UNIT_INCREMENT:
	      type = "Unit Increment";
	      break;*/
	    }

	    ////System.out.println("\tType: " + type);
	    
	  //  System.out.println("XYScroll: " + xScroll + " ::: "+yScroll);
	  }
	/****************************Jscroll Methodo**********************/
	
	
	public JScrollPane getJScrollPane1() {
		return jScrollPane1;
	}
	
	public JLabel getIma() {
		return Ima;
	}
	
	public JPanel getJPanel1() {
		return jPanel1;
	}
	
	public JLabel getImax() {
		return Ima;
	}
	
	
	
	/****Define Text for: array code *************************************/
	
	public  void setValues(String val[][]){
		String Text="";
		int id;
		for(int i=0; i< val.length; i++){
			id = Integer.parseInt(val[i][0]);
			Text=Labels.get(getName(id)).getText();
			
			Labels.get(getName(id)).setText(defText(Text,""+val[i][1]));
			Labels.get(getName(id)).setOpaque(false);
			//Labels.get(getName(id)).setBackground(new java.awt.Color(252,255,213));
			Labels.get(getName(id)).setForeground(Color.RED);
		}
	}
	/******End Text for: array code *************************************/
	
	private String defText(String Text,String Text2){
		String nx="";
	
		StringTokenizer token1 = new StringTokenizer(Text,":");
		
		if(token1.countTokens()==2) nx=token1.nextToken()+": "+Text2; 
		else nx=""+Text2;
	
		return nx;
	}

	/****Reset  *******************************************************/
	public void reset(){
		String Text="";

		for(int i=1; i<Names.length;i++){
			
			//System.out.println("["+getName(i)+"]");
			Text=Labels.get(getName(i)).getText();
			

		Labels.get(Names[i]).setForeground(colorf);
		Labels.get(Names[i]).setOpaque(false);
		Labels.get(Names[i]).setFont(new java.awt.Font("",0,10));
		Labels.get(Names[i]).setText(Text(Text,""));
		
		}
		
		IFID_ActivateW=0;
		IFID_ActivateR=0;
		IDEX_ActivateW=0;
		IDEX_ActivateR=0;
		EXMEM_ActivateW=0;
		EXMEM_ActivateR=0;
		MEMWB_ActivateW=0;
		MEMWB_ActivateR=0;
		ALU1_Activate=0;
		ALU2_Activate=0;
		ALU3_Activate=0;
		PC_Activate=0;
		Registers_ActivateW=0;
		Registers_ActivateR=0;
		IMemory_ActivateW=0;
		IMemory_ActivateR=0;
		DMemory_ActivateW=0;
		DMemory_ActivateR=0;
		Control_Activate=0;
		Shift_Activate=0;
		Hazard_Activate=0;
		Fowarding_Activate=0;
		Signede_Activate=0;
		Shift2_Activate=0;
		Xor_Activate=0;
		Alucontrol_Activate=0;
		Mux1_Activate=-1;
		Mux2_Activate=-1;
		Mux3_Activate=-1;
		Mux4_Activate=-1;
		Mux5_Activate=-1;
		Mux6_Activate=-1;
		Mux7_Activate=-1;
		Mux8_Activate=-1;
		Mux9_Activate=-1;
		Mux10_Activate=-1;
		Mux11_Activate=-1;
		repaint();
	}
	/*********End Reset***********************************************/
	
	
	
	/*********Get Name : Labels***************************************/
	public String getName(int id){		
		return Names[id];
		}
	/*********End***************************************************/
	
	
	
	
	/*********Text*************************************************/
	public String Text(String Text,String Text2){
		String nx="";
	
		StringTokenizer token1 = new StringTokenizer(Text,":");
		
		if(token1.countTokens()==2) nx=token1.nextToken()+": "+Text2; 
		else nx=""+Text2;
	
		return nx;
	}
	/*********End Text*****************************************/
	
	/*********Color Base :******************************************/
	public void getColorbase(){
		this.colorb=this.PC.getBackground();			
		this.colorf=this.PC.getForeground();
	}
	/*********End Color Base :************************************/
	
	
	
	/**********************************************************************/	
	//clase interna para manejar eventos de ratón
	private class ManejadorClicsRaton extends MouseAdapter {
		
	   // manejar evento de clic del ratón y determinar cuál botón se oprimió
	   public void mouseClicked(MouseEvent evento)
	   {  
		   xPos = evento.getX();
	       yPos = evento.getY();
	     System.out.println(xPos+","+yPos);
	   } 

	   
	}
	/**********************************************************************/
	
	
	
	
	/*********************MEMORIAS TEMPORALES*************************************************/
	public void IFID_ActivateW(int fase){   //1 Escritura, 2 Lectura
		IFID_ActivateW=fase;	
		this.repaint();
	}	
	/********************************************************************/
	public void IFID_ActivateR(int fase){   //1 Escritura, 2 Lectura
		IFID_ActivateR=fase;	
		this.repaint();
	}	
	
	/**********************************************************************/	
	public void IDEX_ActivateW(int fase){   //1 Escritura, 2 Lectura
		IDEX_ActivateW=fase;
		this.repaint();
	}	
	/********************************************************************/
	public void IDEX_ActivateR(int fase){   //1 Escritura, 2 Lectura
		IDEX_ActivateR=fase;
		this.repaint();
	}	
	/**********************************************************************/	
	public void EXMEM_ActivateW(int fase){   //1 Escritura, 2 Lectura
		EXMEM_ActivateW=fase;
		this.repaint();
	}	
	public void EXMEM_ActivateR(int fase){   //1 Escritura, 2 Lectura
		EXMEM_ActivateR=fase;
		this.repaint();
	}	
	/********************************************************************/
	
	/**********************************************************************/	
	public void MEMWB_ActivateW(int fase){   //1 Escritura, 2 Lectura
		MEMWB_ActivateW=fase;	
		this.repaint();
	}	
	/********************************************************************/
	public void MEMWB_ActivateR(int fase){   //1 Escritura, 2 Lectura
		MEMWB_ActivateR=fase;	
		this.repaint();
	}	
	
	/*******************************ALU*************************************/
	public void ALU1_Activate(int fase){
		ALU1_Activate=fase;
		this.repaint();
	}
	/********************************************************************/
	
	/********************************************************************/
	public void ALU2_Activate(int fase){
		ALU2_Activate=fase;
		this.repaint();
	}
	/********************************************************************/
	
	/********************************************************************/
	public void ALU3_Activate(int fase){
		ALU3_Activate=fase;
		this.repaint();
	}
	/********************************************************************/
	/**********************PC_ACTIVATE************************************/
	public void PC_Activate(int fase){
		PC_Activate=fase;
		this.repaint();
	}
	/********************************************************************/
	/**********************Registers_ACTIVATE************************************/
	public void Registers_ActivateW(int fase){
		Registers_ActivateW=fase;
		this.repaint();
	}

	public void Registers_ActivateR(int fase){
		Registers_ActivateR=fase;
		this.repaint();
	}
	/********************************************************************/
	
	/**********************IMemory_ACTIVATE************************************/
	public void IMemory_ActivateW(int fase){
		IMemory_ActivateW=fase;
		this.repaint();
	}

	public void IMemory_ActivateR(int fase){
		IMemory_ActivateR=fase;
		this.repaint();
	}
	/********************************************************************/
	/**********************DMemory_ACTIVATE************************************/
	public void DMemory_ActivateW(int fase){
		DMemory_ActivateW=fase;
		this.repaint();
	}

	public void DMemory_ActivateR(int fase){
		DMemory_ActivateR=fase;
		this.repaint();
	}
	/********************************************************************/
	
	/**********************Control_ACTIVATE************************************/
	public void Control_Activate(int fase){
		Control_Activate=fase;
		this.repaint();
	}
	/********************************************************************/
	
	/**********************Shift_ACTIVATE************************************/
	public void Shift_Activate(int fase){
		Shift_Activate=fase;
		this.repaint();
	}
	/********************************************************************/
	
	/**********************Hazard_ACTIVATE************************************/
	public void Hazard_Activate(int fase){
		Hazard_Activate=fase;
		this.repaint();
	}
	/********************************************************************/
	
	/**********************Fowarding_ACTIVATE************************************/
	public void Fowarding_Activate(int fase){
		Fowarding_Activate=fase;
		this.repaint();
	}
	/********************************************************************/
	
	/**********************Signede_ACTIVATE************************************/
	public void Signede_Activate(int fase){
		Signede_Activate=fase;
		this.repaint();
	}
	/********************************************************************/
	
	/**********************Shift_ACTIVATE************************************/
	public void Shift2_Activate(int fase){
		Shift2_Activate=fase;
		this.repaint();
	}
	/********************************************************************/
	/**********************XOR_ACTIVATE************************************/
	public void Xor_Activate(int fase){
		Xor_Activate=fase;
		this.repaint();
	}
	/********************************************************************/
	
	/**********************Alucontrol_ACTIVATE************************************/
	public void Alucontrol_Activate(int fase){
		Alucontrol_Activate=fase;
		this.repaint();
	}
	/********************************************************************/
	
	/**********************Mux_ACTIVATE************************************/
	public void Mux_Activate(int x1,int x2,int x3,int x4,int x5,int x6,int x7,int x8,int x9,int x10,int x11){
		
		this.Mux1_Activate=x1;
		this.Mux2_Activate=x2;
		this.Mux3_Activate=x3;
		this.Mux4_Activate=x4;
		this.Mux5_Activate=x5;
		this.Mux6_Activate=x6;
		this.Mux7_Activate=x7;
		this.Mux8_Activate=x8;
		this.Mux9_Activate=x9;
		this.Mux10_Activate=x10;
		this.Mux11_Activate=x11;
		
		this.repaint();
	}
	/********************************************************************/
	
	
	public void paint(Graphics g){
		//Mux Info
		int Alu1_x[]={185-xScroll,216-xScroll,216-xScroll,185-xScroll,185-xScroll,190-xScroll,185-xScroll};
		int Alu1_y[]={288-yScroll,315-yScroll,340-yScroll,368-yScroll,335-yScroll,328-yScroll,321-yScroll};
		int Alu2_x[]={450-xScroll,480-xScroll,480-xScroll,450-xScroll,450-xScroll,456-xScroll,452-xScroll};
		int Alu2_y[]={270-yScroll,297-yScroll,324-yScroll,350-yScroll,317-yScroll,310-yScroll,305-yScroll};
		
		int Alu3_x[]={768-xScroll,808-xScroll,808-xScroll,768-xScroll,768-xScroll,775-xScroll,770-xScroll};
		int Alu3_y[]={379-yScroll,415-yScroll,451-yScroll,488-yScroll,444-yScroll,432-yScroll,424-yScroll};
		
		
		
		
		super.paint(g);
		Insets s = getInsets();
				
		g.translate( s.left,s.top );		
		g.setColor(new java.awt.Color(255,0,0,100));
		
		if(this.IFID_ActivateW==1)g.fillRect(260-xScroll, 320-yScroll,13, 313); //Escritura
		if(this.IFID_ActivateR==1)g.fillRect(273-xScroll, 320-yScroll,13, 313); //Lectura
			
		if(this.IDEX_ActivateW==1)g.fillRect(585-xScroll, 212-yScroll,13, 419); //Escritura
		if(this.IDEX_ActivateR==1)g.fillRect(598-xScroll, 212-yScroll,13, 419); //Lectura	
		
		
		if(this.EXMEM_ActivateW==1)g.fillRect(848-xScroll, 248-yScroll,13, 382); //Escritura
		if(this.EXMEM_ActivateR==1)g.fillRect(861-xScroll, 248-yScroll,13, 382); //Lectura
		
		if(this.MEMWB_ActivateW==1)g.fillRect(1038-xScroll, 284-yScroll,13, 346); //Escritura
		if(this.MEMWB_ActivateR==1)g.fillRect(1051-xScroll, 284-yScroll,13,346); //Lectura
		
		///ALU PAint form
		
		if(ALU1_Activate==1) g.fillPolygon(Alu1_x, Alu1_y, 7); //ALU PC+4
		if(ALU2_Activate==1) g.fillPolygon(Alu2_x, Alu2_y, 7); //ALU PC+4	
		if(ALU3_Activate==1) g.fillPolygon(Alu3_x, Alu3_y, 7); //ALU PC+4
		
		


		if(PC_Activate==1) g.fillRect(101-xScroll,375-yScroll, 24, 56);
		
		if(Registers_ActivateW==1)g.fillRect(438-xScroll, 358-yScroll,47, 123); //Escritura
		if(Registers_ActivateR==1) g.fillRect(485-xScroll, 358-yScroll,47, 123); //Lectura
		
		
		
		
		if(IMemory_ActivateW==1)g.fillRect(160-xScroll, 376-yScroll,40, 124); //Escritura
		if(IMemory_ActivateR==1) g.fillRect(200-xScroll, 376-yScroll,40, 124); //Lectura
	
		
		
		if(DMemory_ActivateW==1)g.fillRect(938-xScroll, 372-yScroll,40, 125); //Escritura
		if(DMemory_ActivateR==1) g.fillRect(978-xScroll, 372-yScroll,40, 125); //Lectura
	
	
		//
		if(Control_Activate==1) g.fillOval(357-xScroll, 218-yScroll, 53, 94);
		
		if(Shift_Activate==1) g.fillOval(370-xScroll, 54-yScroll, 60, 60);

		
		if(Hazard_Activate==1) {
			g.setColor(new java.awt.Color(0,255,0,100));
			g.fillRoundRect(336-xScroll, 149-yScroll, 92, 45, 26, 26);
			g.setColor(new java.awt.Color(255,0,0,100));
		}
			
		if(Fowarding_Activate==1) {
			g.setColor(new java.awt.Color(0,255,0,100));
			g.fillRoundRect(747-xScroll, 624-yScroll, 93, 45, 26, 26);
			g.setColor(new java.awt.Color(255,0,0,100));
		}
			
		if(Signede_Activate==1) g.fillOval(390-xScroll, 490-yScroll, 47, 84);
		
		if(Shift2_Activate==1) g.fillOval(395-xScroll, 334-yScroll, 38, 54);
		
		if(Xor_Activate==1) g.fillOval(541-xScroll, 385-yScroll, 30, 58);		
	
		if(Alucontrol_Activate==1) g.fillOval(757-xScroll, 496-yScroll, 32, 50);
		
		
		
		//Mux Activate
		g.setColor(Color.GREEN);
		
		Font f = new Font ("Serif", Font.BOLD, 15);
	    g.setFont (f);
	    
		if(Mux1_Activate==0) g.drawString("0", 64-xScroll, 426-yScroll);
		else if(Mux1_Activate==1) g.drawString("1", 64-xScroll, 452-yScroll);

		if(Mux2_Activate==0) g.drawString("0", 100-xScroll, 491-yScroll);
		else if(Mux2_Activate==1) g.drawString("1", 100-xScroll, 518-yScroll);
		
		if(Mux3_Activate==0) g.drawString("0", 134-xScroll, 571-yScroll);
		else if(Mux3_Activate==1) g.drawString("1", 134-xScroll, 597-yScroll);
		
		if(Mux4_Activate==0) g.drawString("0", 358-xScroll, 725-yScroll);
		else if(Mux4_Activate==1) g.drawString("1", 385-xScroll, 722-yScroll);
		

		if(Mux5_Activate==0) g.drawString("0", 458-xScroll, 725-yScroll);
		else if(Mux5_Activate==1) g.drawString("1", 433-xScroll, 725-yScroll);
		
	
		if(Mux6_Activate==0) g.drawString("0", 541-xScroll, 254-yScroll);
		else if(Mux6_Activate==1) g.drawString("1", 541-xScroll, 279-yScroll);
		

		if(Mux7_Activate==0) g.drawString("0", 710-xScroll, 380-yScroll);
		else if(Mux7_Activate==1) g.drawString("1", 710-xScroll, 395-yScroll);
		else if(Mux7_Activate==2) g.drawString("2", 710-xScroll, 410-yScroll);
		
		if(Mux8_Activate==0) g.drawString("0", 710-xScroll, 465-yScroll);
		else if(Mux8_Activate==1) g.drawString("1", 710-xScroll, 480-yScroll);
		else if(Mux8_Activate==2) g.drawString("2", 710-xScroll, 495-yScroll);

		if(Mux9_Activate==0) g.drawString("0", 710-xScroll, 601-yScroll);
		else if(Mux9_Activate==1) g.drawString("1", 710-xScroll,627-yScroll);


		if(Mux10_Activate==0) g.drawString("0", 750-xScroll, 475-yScroll);
		else if(Mux10_Activate==1) g.drawString("1", 750-xScroll,492-yScroll);

		//en 10 se empieza a mostrar
		if(xScroll>50){
			g.setColor(Color.GREEN);
			if(Mux11_Activate==0) g.drawString("0", 1135-xScroll, 468-yScroll);
			else if(Mux11_Activate==1) g.drawString("1", 1135-xScroll,442-yScroll);
		}
	}
    /********************************************************************/
	
		
	
}
