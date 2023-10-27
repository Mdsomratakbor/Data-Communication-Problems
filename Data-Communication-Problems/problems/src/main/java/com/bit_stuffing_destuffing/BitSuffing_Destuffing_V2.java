package com.bit_stuffing_destuffing;

import java.util.Scanner;


public class BitSuffing_Destuffing_V2 {

    public static String bitStuff(String input, String flagBits) {
        StringBuilder stuffedData = new StringBuilder();
        stuffedData.append(flagBits); // Start with the flag bits

        int flagCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentBit = input.charAt(i);
            stuffedData.append(currentBit);

            if (currentBit == '1') {
                flagCount++;
            } else {
                flagCount = 0;
            }

            if (flagCount == flagBits.length()) {
                stuffedData.append('0'); // Stuff a '0' after flagBits
                flagCount = 0;
            }
        }

        stuffedData.append(flagBits); // End with the flag bits

        return stuffedData.toString();
    }

    public static String bitDeStuff(String input, String flagBits) {
        StringBuilder deStuffedData = new StringBuilder();

        int flagCount = 0;

        for (int i = flagBits.length(); i < input.length() - flagBits.length(); i++) {
            char currentBit = input.charAt(i);
            deStuffedData.append(currentBit);

            if (currentBit == '1') {
                flagCount++;
            } else {
                flagCount = 0;
            }

            if (flagCount == flagBits.length() && i + 1 < input.length() && input.charAt(i + 1) == '0') {
                i++; // Skip the stuffed '0'
                flagCount = 0;
            }
        }

        return deStuffedData.toString();
    }

    public static void main(String[] args) {
        String input = "101011111101011111";
        String flagBits = "1111";

        String stuffedData = bitStuff(input, flagBits);
        String deStuffedData = bitDeStuff(stuffedData, flagBits);

        System.out.println("Input: " + input);
        System.out.println("Flag bit: " + flagBits);
        System.out.println("Mod Data: " + stuffedData);
    }
}