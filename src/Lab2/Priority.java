
package Lab2;
import java.util.Scanner;
    

public class Priority {

    Scanner in = new Scanner(System.in);

    public void calPriority() {
        Scanner s = new Scanner(System.in);

        float avgwt = 0, avgta = 0, avgrt = 0;
        int temp, at = 0;

        System.out.print("\nHow many no of Processes:- ");
        int n = in.nextInt();

        int pro[] = new int[n];    // process
        int cb[] = new int[n];     // cpu bound
        int priority[] = new int[n]; // process priority
        int st[] = new int[n];     //starting time
        int ft[] = new int[n];     // finishing time
        int ta[] = new int[n];     // turn around time
        int wt[] = new int[n];     // waiting time
        int rt[] = new int[n];     //response time
        System.out.println("\nEnter Cpu Bound And Arrival Time.\n!press Tab between CB and AT!");
        System.out.println("\nPro\tCB\tPriority");
        System.out.println("```\t```\t```");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + i + "\t");
            cb[i] = s.nextInt();
            priority[i] = s.nextInt();
            pro[i] = i;
        }
        System.out.print("enter common arrival time-> ");
        at = in.nextInt();
//sorting on the basis of priority
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (priority[i] > priority[j]) {
                    temp = priority[i];
                    priority[i] = priority[j];
                    priority[j] = temp;
                    temp = cb[i];
                    cb[i] = cb[j];
                    cb[j] = temp;
                    temp = pro[i];
                    pro[i] = pro[j];
                    pro[j] = temp;
                }
            }
        }

        // finding finishing & starting times
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ft[i] = at + cb[i]; //first process finishing time
                st[i] = at; //first process starting time
            } else {/* we have two conditions 1,arrival time is greater than 
                the previous one 2,if they are equal or less than*/
                if (at > ft[i - 1]) {
                    ft[i] = at + cb[i];
                    st[i] = at;
                } else {
                    ft[i] = ft[i - 1] + cb[i];
                    st[i] = ft[i - 1];
                }
            }
            wt[i] = st[i] - at;   // waiting time= turnaround time- cpu bound
            ta[i] = ft[i] - at;   // turnaround time= Finishing time- arrival time
            rt[i] = st[i] - at;  // wt==rt
            avgwt += wt[i];         // total waiting time
            avgta += ta[i];         // total turnaround time
            avgrt += rt[i];         // total response time
        }
        System.out.print("\n\t   Guntt Chart\n\t|");
        for (int i = 0; i < n; i++) {
            System.out.print(" P" + pro[i] + " |");
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.print("\n\t" + st[i]);
            }
            System.out.print("    " + ft[i]);
        }

        System.out.println("\n\nPro\tCB\tPri\tAT\tST\tFT\tWT\tTT\tRT");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + pro[i] + "\t" + cb[i] + "\t" + priority[i] + "\t" + at + "\t" + st[i] + "\t" + ft[i] + "\t" + wt[i] + "\t" + ta[i] + "\t" + rt[i]);
        }

        System.out.println("\n*Average waiting time: " + (avgwt / n));
        System.out.println("*Average turnaround time:" + (avgta / n));
        System.out.println("*Average response time:" + (avgrt / n));
    }
}


