import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester {
      
	    public static void main(String[] args) throws FileNotFoundException {
	    Scanner kb=new Scanner(System.in);	    
		Table myTable=new Table();
		myTable.getKey();
		myTable.getGeneID();
		
		myTable.buildClassifier();
		int i=0;
		while(i<myTable.getLocsize()) {
		myTable.knn(4,i);
		i++;
		}
		int choice=0;
		
		while(choice !=5) {
		System.out.println("1: Print target results <Gene ID> <localization> \n 2: Print as 2D Matrix \n 3: print success rate \n 4: Show keys \n 5: end");	
		choice=kb.nextInt();
		
		if(choice==1) {
		
		myTable.printTargetColumn();
		  
		}
		
		else if(choice==2) {
	    String[][] m=myTable.Matrix();
	    myTable.print2d(m);
	    }
		else if(choice==3) {
	    
	    myTable.successrate();
	    }
		else if(choice==4) {
	    myTable.printKey();
	    }
		}
	}

}
