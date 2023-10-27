package com.hamming_code;

import java.util.Scanner;

public class HammingCode{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data bits: ");
        String data = sc.nextLine();
        Integer  dataLength = data.length();


         int parityBitCount = 0;
        // count the number of parity bits required
        while (dataLength + parityBitCount + 1 > Math.pow(2, parityBitCount)) {
            parityBitCount++;
        }
        System.out.println("Number of parity bits: " + parityBitCount);

        StringBuilder encodedData = new StringBuilder(data.length() + parityBitCount);
        int j = 0;

        // loop to insert parity bits at correct positions
        for (int i = 0; i < data.length() + parityBitCount; i++) {
            if (i + 1 == Math.pow(2, j)) {
                encodedData.append('0');
                j++;
            } else {
                encodedData.append(data.charAt(i - j));
            }
        }

        System.out.println("Encoded data (with parity bits): " + encodedData.toString());

        // loop to calculate parity bits
        for (int i = 0; i < parityBitCount; i++) {
            int parityBitPosition = (int) Math.pow(2, i);
            char parityBit = calculateParityBit(encodedData.toString(), parityBitPosition);
            encodedData.setCharAt(parityBitPosition - 1, parityBit);
        }

        System.out.println("Encoded data: " + encodedData.toString());


     }

     // function to calculate parity bit
    public static char calculateParityBit(String data, int parityBitPosition) {
        int dataLength = data.length();
        char parityBit = '0';
        for (int i = parityBitPosition - 1; i < dataLength; i += 2 * parityBitPosition) {
            for (int j = i; j < Math.min(i + parityBitPosition, dataLength); j++) {
                if (data.charAt(j) == '1') {
                    parityBit ^= '1';
                }
            }
        }
        return parityBit;
    }

}