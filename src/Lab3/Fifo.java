package Lab3;

import java.util.Scanner;

public class Fifo {

    Scanner in = new Scanner(System.in);

    String frame[];//store different page strings interms of the size of the frame
    String pageString[];//to store array of page string
    String dispaly[][];//final output
    int framesLen, pageLen;//frame number,page lenght
    int memoAdd = 0, pageFault = 0;//memory address,page fault

    public void calFifo() {

        System.out.print("\nHow many no of Page Strings: ");
        pageLen = in.nextInt();//accepting page string size

        pageString = new String[pageLen];//takes the pageLen as array size for the page string
        in.nextLine();//to ignore string jumping problem
        System.out.println("List Page Strings: ");
        //accepting page Strings
        for (int i = 0; i < pageLen; i++) {
            pageString[i] = in.nextLine();
        }

        System.out.print("Enter the number of Frames: ");
        framesLen = in.nextInt();//accepting frame Length

        frame = new String[framesLen];//takes the framelen as array size for frameNo
        dispaly = new String[pageLen][framesLen];//to dimentional array to display the output as a table

        for (int j = 0; j < framesLen; j++) {
            frame[j] = " ";
        }

        System.out.println();
        for (int i = 0; i < pageLen; i++) {
            String find = " ";

            for (int j = 0; j < framesLen; j++) {
                if (frame[j].equals(pageString[i])) {
                    find = "yes";
                    break;
                }
            }
            if (find.equals(" ")) {
                frame[memoAdd] = pageString[i];
                pageFault++;//page fault increases by one everytime any strings replaced by another 
                memoAdd++;
                if (memoAdd == framesLen) {//when the frame becomes full it start from the begining 
                    memoAdd = 0;
                }
            }
            for (int j = 0; j < framesLen; j++) {
                dispaly[i][j] = frame[j];
            }
        }

        for (int i = 0; i < pageLen; i++) {
            System.out.print(pageString[i] + "  ");//listing the page String listes at the top
        }
        System.out.println();
        for (int i = 0; i < pageLen; i++) {
            System.out.print("``" + " ");
        }
        System.out.println();
        for (int i = framesLen - 1; i >= 0; i--)//i=frameLen to start from the back of the frame
        {
            for (int j = 0; j < pageLen; j++) {
                System.out.print(dispaly[j][i] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < pageLen; i++) {
            System.out.print("``" + " ");
        }
        System.out.println("\nPage Fault: " + pageFault);
        System.out.println("Page Fault Rate: " + (float)pageFault/pageLen);
        
    }

}
