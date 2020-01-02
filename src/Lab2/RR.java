
package Lab2;
import java.util.Scanner;

public class RR {
    
     Scanner in = new Scanner(System.in);
    
    public void calRound(){
 
        int temp=0,proFinish,i=0,t=1;
    
        float avgWt=0,avgTa=0,avgRt=0;
	int wt=0,ta=0,qt,ft=0;

	System.out.print("\nHow many no of Processes:- ");
        int n = in.nextInt();

	proFinish=n;//make them equal initially
        
        int pro[] = new int[n];    // process
	int[] at= new int[n];//arival time
	int[] cb= new int[n];//cpu bound
        int[] rt= new int[n];//response time
        
	int[] tempBound= new int[n];//temporary bound which holds value when > qt 

	System.out.println("\nEnter Cpu Bound And Arrival Time.\n!press Tab between CB and AT!");
        System.out.println("\nPro\tCB\tAT");
        System.out.println("```\t```\t```");

        for ( ; i < n; i++) {
            System.out.print("P" + i + "\t");

            cb[i] = in.nextInt();
            at[i] = in.nextInt();
		tempBound[i]=cb[i];
	}

	System.out.print("Enter Quantum Time:");
	qt = in.nextInt();
        
        
	System.out.println("\n\nPro\tCB\tAT\tWT\tTT\tRT");
        i=0;
	while(proFinish!=0)
	{   
            if(i>=0 && t!=-1){
                rt[i]=ft-at[i];
            }
                
		if(tempBound[i]<=qt && tempBound[i]>0)
		{
			ft += tempBound[i];
			tempBound[i]=0;
			temp=1;
		}
                
		else if(tempBound[i]>qt)
		{
			tempBound[i] -= qt;
			ft += qt;
                        
		}
                
		if(tempBound[i]==0 && temp==1)
		{
			proFinish--;
                        ta=ft-at[i];
                        wt=ta-cb[i];
System.out.println("P" + i + "\t" + cb[i] + "\t" + at[i]+"\t"+wt+"\t"+ta+"\t"+rt[i]);

			avgWt += ft-at[i]-cb[i];
			avgTa+= ft-at[i];
                        avgRt+=rt[i];
			temp=0;
		}
                
              
		if(i == n-1){
			i=0;
                        t=-1;
                }
		else if(at[i+1] <= ft){
			i++;
                }
                else{
			i=0;
                }
	}

	System.out.println("\n*Average waiting time: " + (avgWt / n));
        System.out.println("*Average turnaround time:" + (avgTa / n));
        System.out.println("*Average response time:" + (avgRt / n));

} 
}
