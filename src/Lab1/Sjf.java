
package Lab1;
import java.util.Scanner;

public class Sjf {
    
     Scanner in = new Scanner(System.in);
    
    public void calShort() {

        int at;

        System.out.print("\nHow many no of Processes:- ");
        int n = in.nextInt();
        int pro[] = new int[n];    // process
        int cb[] = new int[n];     // cpu bound
        int st[] = new int[n];     //starting time
        int ft[] = new int[n];     // finishing time
        int ta[] = new int[n];     // turn around time
        int wt[] = new int[n];     // waiting time
        int rt[] = new int[n];     //response time
        int temp;
        float avgwt = 0, avgta = 0, avgrt = 0;
        
        
        System.out.println("\nPro\tCB");
        System.out.println("```\t```");
        for (int i = 0; i < n; i++) {
            System.out.print("P"+i+"\t");
            cb[i] = in.nextInt();

            pro[i] = i;
        }
        System.out.print("enter common arrival time-> ");
        at = in.nextInt();
        

        //sorting with their cpu bound 
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (cb[i] > cb[j]) {

                    temp = cb[i];
                    cb[i] = cb[j];
                    cb[j] = temp;
                    temp = pro[i];
                    pro[i] = pro[j];
                    pro[j] = temp;
                }
            }
        }

        // finding finishing * Starting times
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ft[i] = at + cb[i]; //first process finishing time
                st[i] = at; //first process starting time
            } else {

                ft[i] = ft[i - 1] + cb[i];
                st[i] = ft[i - 1];
            }
            
            wt[i] = st[i] - at;   // waiting time= turnaround time- cpu bound
            ta[i] = ft[i] - at;   // turnaround time= Finishing time- arrival time
            rt[i] = wt[i]; // wt==rt
            avgwt += wt[i];         // total waiting time
            avgta += ta[i];         // total turnaround time
            avgrt += rt[i];         // total response time
        }

         System.out.print("\n\t   Guntt Chart\n\t|");
        for(int i=0;i<n;i++){
        System.out.print(" P"+pro[i]+" |");
        }
        for(int i=0;i<n;i++){
            if(i==0){
                System.out.print("\n\t"+st[i]);
            }
        System.out.print("    "+ft[i]);
        }
        
        System.out.println("\n\nPro\tCB\tAT\tST\tFT\tWT\tTT\tRT");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + pro[i] + "\t" + cb[i] + "\t" + at + "\t" + st[i] + "\t" + ft[i] + "\t" +wt[i]   + "\t" +   ta[i]+ "\t" + rt[i]);
        }

        System.out.println("\n*Average waiting time: " + (avgwt / n));
        System.out.println("*Average turnaround time:" + (avgta / n));
        System.out.println("*Average response time:" + (avgrt / n));
    }

}
