
package os_lab;

import java.util.Scanner;
import Lab1.*;
import Lab2.*;
import Lab3.*;
/**
 *
 * @author 
 */
public class OS_Lab {

    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int choice;

        //Object creation for all classes
        Fcfs alg1 = new Fcfs();
        Sjf alg2 = new Sjf();
        RR alg3 = new RR();
        Priority alg4 = new Priority();
        Srtf alg5 = new Srtf();
        Fifo alg6 = new Fifo();

        do {
            System.out.println("->Which Cpu Scheduling Algorithm or Paging Scheduling You Want to Calculate?");
            System.out.println("    1,First Come First Serve(FCFS)");
            System.out.println("    2,Shortest Job First(SJF)");
            System.out.println("    3,Round Robin(RR)");
            System.out.println("    4,Priority");
            System.out.println("    5,Shortest Remaining Time First(SRTF)");
            System.out.println("    6,First in First out(FIFO");
            System.out.println("    0,Exit");

            System.out.print("Select->");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    alg1.calFirst();
                    break;
                case 2:
                    alg2.calShort();
                    break;
                case 3:
                    alg3.calRound();
                    break;
                case 4:
                    alg4.calPriority();
                    break;
                case 5:
                    alg5.calSrtf();
                    break;
                case 6:
                    alg6.calFifo();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }

            System.out.println("\n->press Any Integer to return, 0 to Exit!");
            choice = input.nextInt();

        } while (choice != 0);
        input.close();
    }
    
}
