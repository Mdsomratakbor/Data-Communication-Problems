package com.parity_bit;

import java.util.Scanner;

public class parity_bit_from_name_id {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input name and ID from the user
        System.out.print("Enter your full name: ");
        String fullName = sc.nextLine();
        System.out.print("Enter your ID: ");
        String id = sc.nextLine();

        sc.close();
        // Convert the name and ID to binary using ASCII values
        String binaryFullName = convertToBinary(fullName);
        String binaryID = convertToBinary(id);

        String data = binaryFullName + binaryID;
        StringBuilder result = new StringBuilder(data);
        System.out.println("Sample Output:\n\n");

        System.out.println("Converted Binary Data : " + result.toString());

        Integer oneCount = 0;
        Integer zeroCount = 0;
        
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '1')
                oneCount++;
            else
                zeroCount++;
        }

        System.out.println("Even Parity : " + EventParity(oneCount, result));
        System.out.println("Odd Parity : " + OddParity(oneCount, result));

    }

    public static String EventParity(Integer oneCount, StringBuilder result) {

        if (oneCount % 2 == 0) {
            result.append('0');
        } else {
            result.append('1');
        }
        return result.toString();
    }

    public static String OddParity(Integer oneCount, StringBuilder result) {
        if (oneCount % 2 != 0) {
            result.append('0');
        } else {
            result.append('1');
        }
        return result.toString();
    }

    // Convert a string to binary using ASCII values
    public static String convertToBinary(String input) {
        StringBuilder binary = new StringBuilder();
        for (char c : input.toCharArray()) {
            int asciiValue = (int) c;
            String binaryValue = Integer.toBinaryString(asciiValue);
            binary.append(String.format("%8s", binaryValue).replace(' ', '0'));
        }
        return binary.toString();
    }
}
