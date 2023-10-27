package com.bit_stuffing_destuffing;

import java.util.Scanner;

public class BitStuffingDestuffing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the input message from the user
        System.out.print("Enter the message: ");
        String inputMessage = sc.nextLine();

        // Get the flag data from the user
        System.out.print("Enter the flag data: ");
        String flagData = sc.nextLine();

        String remaining = new String();
        String output = new String();
        int counter = 0;

        for (int i = 0; i < inputMessage.length(); i++) {
            if (inputMessage.charAt(i) != '1' && inputMessage.charAt(i) != '0') {
                System.out.println("Enter valid Binary values");
                return;
            }
            if (inputMessage.charAt(i) == '1') {
                counter++;
                remaining = remaining + inputMessage.charAt(i);
            } else {
                remaining = remaining + inputMessage.charAt(i);
                counter = 0;
            }
            if (counter == 3) {
                remaining = remaining + '0';
                counter = 0;
            }
        }

        System.out.println("Flag--> " + flagData);

        // Insert '0' before the flag data
        String stuffedData = flagData +  remaining + flagData;

        System.out.println("Stuffed data at intermediate site is:");
        for (int k = 0; k <= (remaining.length() * 2); k++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println(" " + stuffedData);
        for (int k = 0; k <= (remaining.length() * 2); k++) {
            System.out.print("-");
        }
        System.out.println();
        counter = 0;


        //    // Remove the extra flag data at the end of destuffed message
        // if (stuffedData.endsWith(flagData)) {
        //     stuffedData = stuffedData.substring(0, stuffedData.length() - flagData.length());
        // }
        //  // Remove the extra flag data at the start of destuffed message
        //  if (stuffedData.startsWith(flagData)) {
        //     stuffedData = stuffedData.substring(flagData.length());
        // }

        int i = 0;
        while (i < stuffedData.length()) {
            if (stuffedData.charAt(i) == '1') {
                counter++;
                output = output + stuffedData.charAt(i);
            } else {
                output = output + stuffedData.charAt(i);
                counter = 0;
            }
            if (counter == 3) {
                if (i + 1 < stuffedData.length()) {
                    if (stuffedData.charAt(i+ 1)=='0') {
                        i += 1; // Skip the stuffed '0' and flag bit
                    }
                }
                counter = 0;
            }
            i++;
        }


        System.out.println("Destuffed BIT is: " + output);
    }
}