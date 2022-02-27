import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.awt.*;

public class Table {
LinkedList<Point> p=new LinkedList<>();
Point p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17, p18,p19;
LinkedList<Point> knn=new LinkedList<>();
LinkedList<Point> weightedcoordinates=new LinkedList<>();
LinkedList<Integer>RowNum=new LinkedList<>();
LinkedList<String>GeneID=new LinkedList<>();
LinkedList<String>Essential=new LinkedList<>();
LinkedList<String>Class=new LinkedList<>();
LinkedList<String>Complex=new LinkedList<>();
LinkedList<String>Phenotype=new LinkedList<>();
LinkedList<String>Motif=new LinkedList<>();
LinkedList<String>Chromosome=new LinkedList<>();
LinkedList<String>Function=new LinkedList<>();
LinkedList<Object>Localization=new LinkedList<>();
LinkedList<String>keys=new LinkedList<>();
LinkedList<String>PredictableValues=new LinkedList<>();
LinkedList<String>KeyGeneID=new LinkedList<>();
Scanner fr=new Scanner(new FileInputStream(new File("./src/Genes_relation.test")));
Scanner ns=new Scanner(new FileInputStream(new File("./src/keys.txt")));
String fullTable="";
String fullK="";
Table() throws FileNotFoundException{
	
	
}
public void getKey() {
	
	while(ns.hasNextLine()) {
		
		String temp;
		fullK=ns.nextLine();
		KeyGeneID.add(fullK.substring(0,fullK.indexOf(",")));
		temp=fullK.substring(fullK.indexOf(",")+1);
		keys.add(temp);
		
		
	}
	//System.out.println(c);
}
public void successrate() {
	int score=0;
	for(int i=0; i<GeneID.size();i++) {
		for(int x=0; x<KeyGeneID.size();x++) {
			if(GeneID.get(i).equals(KeyGeneID.get(x)) && Localization.get(i).equals(keys.get(x))) {
				score++;
			}
			
		}	
	}
	
    System.out.println(score+"/"+Localization.size());
    double percant=((double)score/(double)Localization.size())*100.0;
    System.out.println(percant+"%");
    
    
}
public void printKey() {
	for(int i=0; i<keys.size();i++) {
		System.out.println(KeyGeneID.get(i)+" "+keys.get(i));
		
	}
}
public  void getGeneID() {
	int x=1;
while(fr.hasNextLine()) {
    //int i=0;
	String temp;
	fullTable=fr.nextLine();
    GeneID.add(fullTable.substring(0,fullTable.indexOf(",")));
    //System.out.println(GeneID.get(i));
	temp=fullTable.substring(fullTable.indexOf(",")+1);
	Essential.add(temp.substring(0,temp.indexOf(",")));
	temp=temp.substring(temp.indexOf(",")+1); 
	Class.add(temp.substring(0,temp.indexOf(",")));
	temp=temp.substring(temp.indexOf(",")+1);
	Complex.add(temp.substring(0,temp.indexOf(",")));
	temp=temp.substring(temp.indexOf(",")+1);
	Phenotype.add(temp.substring(0,temp.indexOf(",")));
	temp=temp.substring(temp.indexOf(",")+1);
	Motif.add(temp.substring(0,temp.indexOf(",")));
	temp=temp.substring(temp.indexOf(",")+1);
	Chromosome.add(temp.substring(0,temp.indexOf(",")));
	temp=temp.substring(temp.indexOf(",")+1);
	Function.add(temp.substring(0,temp.indexOf(",")));
	RowNum.add(x);
	x++;
	temp=temp.substring(temp.indexOf(",")+1);
	if(temp.contains(",")) {
	Localization.add(temp.substring(0,temp.indexOf(",")));
	}
	else {
		Localization.add(temp);
	}
	//i++;
}


//System.out.println(fullTable);
//for(int i=0; i<Class.size();i++) {
//	System.out.println(GeneID.size());
//	}
   
}

public String[][] Matrix(){
	String[][] Matrix=new String[Localization.size()][9];
	for( int i=0;i<Matrix.length;i++) {
		 for (int j=0; j<Matrix[i].length;j++) {
			                       
			 Matrix[i][0]=GeneID.get(i);
			 Matrix[i][1]=Essential.get(i);
			 Matrix[i][2]=Class.get(i);
			 Matrix[i][3]=Complex.get(i);           
			 Matrix[i][4]=Phenotype.get(i);
			 Matrix[i][5]=Motif.get(i);
			 Matrix[i][6]=Chromosome.get(i);
			 Matrix[i][7]=Function.get(i);
			 Matrix[i][8]=(String) Localization.get(i);
			 
		 }
		 
}
	return Matrix;
}
public void buildClassifier() {
	int pcord1=5+(int)Math.random()*10,  pcord2=5+(int)Math.random()*10;           //Proteasome
	int TCTcord1=11+(int)Math.random()*15, TCTcord2=11+(int)Math.random()*15;      //Transcription complexes/Transcriptosome
	int Hpluscord1=16+(int)Math.random()*20, Hpluscord2=16+(int)Math.random()*20;  //H+-transporting ATPase, vacuolar
	int CCcord1=21+(int)Math.random()*25, CCcord2=21+(int)Math.random()*25;        //Cyclin-CDK (Cyclin-dependent kinases) complexes
	int RCcord1=26+(int)Math.random()*30, RCcord2=26+(int)Math.random()*30;        //Replication complexes
	int RNAcord1=31+(int)Math.random()*35, RNAcord2=31+(int)Math.random()*35;      //RNA processing complexes
	int pmcord1=36+(int)Math.random()*40, pmcord2=36+(int)Math.random()*40;           //Proteases, mitochondrial
	int trscord1=41+(int)Math.random()*45, trscord2=41+(int)Math.random()*45;         //Translocon
	int isocord1=46+(int)Math.random()*50, isocord2=46+(int)Math.random()*50;         //Isocitrate lyase
	int itccord1=51+(int)Math.random()*55, itccord2=55+(int)Math.random()*55;         //Intracellular transport complexes
	int ccccord1=56+(int)Math.random()*60, ccccord2=56+(int)Math.random()*60;         //Chaperonine containing T-complex TRiC (TCP RING Complex)
	int kpccord1=61+(int)Math.random()*65, kpccord2=61+(int)Math.random()*65;         //Kinetochore protein complexes
	int scfcord1=66+(int)Math.random()*70, scfcord2=66+(int)Math.random()*70;         //SCF (Skp1-Cdc53-F-box protein) complexes
	int hdccord1=71+(int)Math.random()*75, hdccord2=71+(int)Math.random()*75;         // Histone deacetylase complexes
	int ckcord1=76+(int)Math.random()*80, ckcord2=76+(int)Math.random()*80;           //Casein kinase
	int thirteencord1=81+(int)Math.random()*85, thirteencord2=81+(int)Math.random()*85;     //motif pk0013
	int npccords1=86+(int)Math.random()*90, npccords2=86+(int)Math.random()*90;
	int mtccord1=91+(int)Math.random()*95, mtccord2=91+(int)Math.random()*95;
	int tttcord1=96+(int)Math.random()*100, tttcord2=96+(int)Math.random()*100;
	Point p1=new Point(pcord1, pcord2);
	Point p2=new Point(TCTcord1, TCTcord2);
	Point p3=new Point(Hpluscord1, Hpluscord2);
	Point p4=new Point(CCcord1, CCcord2);
	Point p5=new Point(RCcord1, RCcord2);
	Point p6=new Point(RNAcord1, RNAcord2);
	Point p7=new Point(pmcord1, pmcord2);
	Point p8=new Point(trscord1, trscord2);
	Point p9=new Point(isocord1, isocord2);
	Point p10=new Point(itccord1, itccord2);
	Point p11=new Point(ccccord1,ccccord2);
	Point p12=new Point(kpccord1, kpccord2);
	Point p13=new Point(scfcord1, scfcord2);
	Point p14=new Point(hdccord1, hdccord2);
	Point p15=new Point(ckcord1, ckcord2);
	Point p16=new Point(thirteencord1, thirteencord2);
	Point p17=new Point(npccords1, npccords2);
	Point p18=new Point(mtccord1, mtccord2);
	Point p19=new Point(tttcord1, tttcord2);
	p.add(p1);
	p.add(p2);
	p.add(p3);
	p.add(p4);
	p.add(p5);
	p.add(p6);
	p.add(p7);
	p.add(p8);
	p.add(p9);
	p.add(p10);
	p.add(p11);
	p.add(p12);
	p.add(p13);
	p.add(p14);
	p.add(p17);
	for(int i=0; i<Complex.size();i++) {  
		if(Motif.get(i).equals("PS00013")) {			
			this.Localization.set(i, "ER");
			       //training data adds clusters. 
			weightedcoordinates.add(p1);
		}
		else if(Complex.get(i).equals("Transcription complexes/Transcriptosome")) {
			this.Localization.set(i, "nucleus");
			
			weightedcoordinates.add(p2);
		}
		else if(Complex.get(i).equals("Chaperonine containing T-complex TRiC (TCP RING Complex)")) {
			this.Localization.set(i, "Cytoplasm");
			
			weightedcoordinates.add(p3); 
		}
		else if(Complex.get(i).equals("Respiration chain complexes")) {
			this.Localization.set(i, "mitochondria");
			
			weightedcoordinates.add(p4);
			
		}
		else if(Class.get(i).equals("Ubiquitin-system proteins")) {
			this.Localization.set(i, "plasma membrane");
			
			weightedcoordinates.add(p5);
		}
		else if(Complex.get(i).equals("Translocon")) {
			this.Localization.set(i, "ER");
			
			weightedcoordinates.add(p6);
		}
		else if(Class.get(i).equals("Protein Kinases") && Complex.get(i).equals("?")) {
			this.Localization.set(i, "nucleus");
			
			weightedcoordinates.add(p7);
		}
		else if(Complex.get(i).equals("Cytoskeleton")) {
			this.Localization.set(i, "cytoskeleton");
			
			weightedcoordinates.add(p8);
		}
		else if(Complex.get(i).equals("Intracellular transport complexes") && Essential.get(i).equals("Non-Essential")) {
			this.Localization.set(i, "golgi");
			
			weightedcoordinates.add(p9);
		}
		else if(Complex.get(i).equals("Intracellular transport complexes") && Essential.get(i).equals("Essential")) {
			this.Localization.set(i, "transport vesicles");
			
			weightedcoordinates.add(p10);
		}
		else if(Complex.get(i).equals("Proteasome")) {
			this.Localization.set(i,"nucleus");
			
			weightedcoordinates.add(p11);
		}
		else if(Class.get(i).equals("Major facilitator superfamily proteins (MFS)") && Complex.get(i).equals("?")) {
			this.Localization.set(i, "plasma membrane");
			
			weightedcoordinates.add(p12);
		}
		else if(Complex.get(i).equals("Respiration chain complexes")) {
			this.Localization.set(i, "mitochondria");
			
			weightedcoordinates.add(p13);
		}
		else if(Complex.get(i).equals("Intracellular transport complexes")) {
			
			this.Localization.set(i, "cytoplasm");
			
			weightedcoordinates.add(p14);
					
		}
		else if(Complex.get(i).equals("Proteases, mitochondrial")) {
			this.Localization.set(i, "mitochondria");
			
			weightedcoordinates.add(p15);
		}
		else if(Complex.get(i).equals("Nucleosomal protein complex")) {
			this.Localization.set(i,"nucleus");
			
			weightedcoordinates.add(p16);
		}
		else if(Complex.get(i).equals("Nuclear pore complex (NPC)")) {
			this.Localization.set(i, "nucleus");
			
			weightedcoordinates.add(p17);
			
		}
		else if(Complex.get(i).equals("Mitochondrial translocase complex")) {
			this.Localization.set(i, "mitochondria");
			weightedcoordinates.add(p18);
		}
		else if(Class.get(i).equals("Transcription factors") && Complex.get(i).equals("?")) {
			this.Localization.set(i, "nucleus");
			weightedcoordinates.add(p19);
		}
		
}
}		
public double EUdis(Point one, Point two) {
	double x3= two.getX()-one.getX();
	double y3= two.getY()-one.getY();
	return Math.sqrt(x3*x3+y3*y3); 
}
public void knn(int k, int i) {
	    
	   
		do {
			int n=0;
			
			if(Localization.get(i).equals("?")) {
			Localization.set(i, weightedcoordinates.get((int)(0+Math.random()*weightedcoordinates.size())));
			
		  
		                                                  
			   
			   do {
			 
			   int x=(int)(0+Math.random()*weightedcoordinates.size());
			   EUdis((Point)Localization.get(i), weightedcoordinates.get(x));         //calculate euclidean distance 
			   if(knn.isEmpty()) {                                                   //add smallest to linkedlist
				   knn.add(weightedcoordinates.get(x));                              //smallest will be the shortest distance and nearest neighbor
			   }                                                                    //put smallest as first element of linkedlist
			   if(EUdis((Point)Localization.get(i), knn.getFirst())>EUdis((Point)Localization.get(i), weightedcoordinates.get(x))) {
				   
				   
				   knn.addFirst(weightedcoordinates.get(x));
				   
			   }
			   if(knn.size()>=k) {
				   knn.removeLast();
				                                                               
			   }			   
			    n++;
			   }while(n<weightedcoordinates.size());
			     
			  
		   if(knn.getFirst().x<10 && knn.getFirst().y<10) {
			   Localization.set(i, "ER");
		   }
		   else if(knn.getFirst().x<15 && knn.getFirst().x>=11) {
			   Localization.set(i, "nucleus");
		   }
		   else if(knn.getFirst().x<20 && knn.getFirst().x>=16) {
			   Localization.set(i, "Cytoplasm");
		   }
		   else if(knn.getFirst().x<25 && knn.getFirst().x>=21) {
			   Localization.set(i,"mitochondria");
		   }
		   else if(knn.getFirst().x<30 && knn.getFirst().x>=26) {
			   Localization.set(i, "plasma membrane");
		   }
		   else if(knn.getFirst().x<35 && knn.getFirst().x>=31) {
			   Localization.set(i, "ER");
		   }
		   else if(knn.getFirst().x<40 && knn.getFirst().x>=36) {
			   Localization.set(i,"nucleus");
		   }
		   else if(knn.getFirst().x<45 && knn.getFirst().x>=41){
			   Localization.set(i, "cytoskeleton");
		   }
		   else if(knn.getFirst().x<50 && knn.getFirst().x>=46){
			   Localization.set(i,"golgi");
		   }
		   else if(knn.getFirst().x<55 && knn.getFirst().x>=51) {
			   Localization.set(i, "transport vesicles");
		   }
		   else if(knn.getFirst().x<60 && knn.getFirst().x>=56) {
			   Localization.set(i, "nucleus");
		   }
		   else if(knn.getFirst().x<65 && knn.getFirst().x>=61) {
			   Localization.set(i, "plasma membrane");
		   }
		   else if(knn.getFirst().x<70 && knn.getFirst().x>=66) {
			   Localization.set(i,"mitochondria");
		   }
		   else if(knn.getFirst().x<75 && knn.getFirst().x>=71) {
			   Localization.set(i,"cytoplasm");
		   }
		   else if(knn.getFirst().x<80 && knn.getFirst().x>=76) {
			   Localization.set(i, "mitochondria");
		   }
		   else if(knn.getFirst().x<85 && knn.getFirst().x>=81) {
			   Localization.set(i, "nucleus");			   
		   }
		   else if(knn.getFirst().x<90 && knn.getFirst().x>=86) {
			   Localization.set(i,"nucleus");		
		   }
		   else if(knn.getFirst().x<95 && knn.getFirst().x>=91) {
			   Localization.set(i, "mitochondria");
		   }
		   else if(knn.getFirst().x<100 && knn.getFirst().x>95) {
			   Localization.set(i, "nucleus");
		   }
		   
		   //System.out.println(i);
		   //i++;
			}
		   }while(Localization.get(i).equals("?"));
		   
		   }
		   
		
		


public void printTargetColumn() {
	
	for(int i=0; i<GeneID.size();i++) {
		System.out.println(GeneID.get(i)+" | "+Localization.get(i));
	}
	
}                                      
public int getLocsize() {
	return Localization.size();
}
public void print2d(String[][] Twod) {
	for(int i=0; i<Twod.length;i++) {
		for(int j=0; j<Twod[i].length;j++) {
			System.out.print(Twod[i][j]+" ");
	        
		}
		System.out.println();
	}
}
}