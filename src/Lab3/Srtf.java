package Lab3;

import java.util.Scanner;

public class Srtf {

   Scanner in = new Scanner(System.in);
        
   public void calSrtf(){
        
        int i, j, smallest, count = 0, time;
        double avgWt = 0, avgTt = 0;
        
        System.out.print("\nHow many no of Processes:- ");
        int n = in.nextInt();
        int[] at = new int[n];
        int[] cb = new int[n+1];
        int[] tempBound = new int[n];
        int[] wt=new int[n];
        int[] tt=new int[n];
        int[] rt=new int[n];
        int[] ft=new int[n];
        int[] pro=new int[n];
        System.out.println("\nEnter Cpu Bound And Arrival Time.\n!press Tab between CB and AT!");
        System.out.println("\nPro\tCB\tAT");
        System.out.println("```\t```\t```");

        for ( i=0 ; i < n; i++) {
            System.out.print("P" + i + "\t");

            cb[i] = in.nextInt();
            tempBound[i] = cb[i];//copying each value of cb
            at[i] = in.nextInt();
	}
        
        cb[n] = 10000;
        for (time = 0; count != n; time++) {
            smallest = n;
            for (i = 0; i < n; i++) {
                if (at[i] <= time && cb[i] < cb[smallest] && cb[i] > 0) {
                    smallest = i;
                }
      
            }
            cb[smallest]--;
            if (cb[smallest] == 0) {
                count++;
                pro[smallest]=smallest;
                ft[smallest] = time + 1;
                tt[smallest] = ft[smallest] - at[smallest];
                wt[smallest] = tt[smallest]-tempBound[smallest];
                avgWt += wt[smallest]; 
                avgTt +=tt[smallest]; 
                
            }
        }
        
        System.out.println("\n\nPro\tCB\tAT\tFT\tWT\tTT\tRT");
        for (i = 0; i < n; i++) {
            System.out.println("P" + pro[i] + "\t" + tempBound[i] + "\t" + at[i] + "\t" + ft[i] + "\t" + wt[i] + "\t" + tt[i] + "\t"+rt[i]);
        }
        System.out.println("\n\nAverage waiting time =" + avgWt / n);
        System.out.println("Average Turnaround time = " + avgTt / n);
    }

}
