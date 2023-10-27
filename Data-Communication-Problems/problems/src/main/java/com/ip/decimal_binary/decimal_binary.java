package com.ip.decimal_binary  ;
import java.util.Scanner;

public class decimal_binary {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the IP Address and Subnet Mask (e.g., 192.168.10.10/24): ");
        String input = sc.nextLine();
        
        // Split the input into IP address and subnet mask parts
        String[] parts = input.split("/");
        if (parts.length != 2) {
            System.out.println("Invalid input format. Please use the format 'IP/SubnetMask'.");
            return;
        }
        
        String ipAddress = parts[0];
        int subnetMaskLength = Integer.parseInt(parts[1]);
        
        // Convert the IP address to binary
        String binaryIP = convertIPToBinary(ipAddress);
        
        // Calculate the subnet mask
        String binarySubnetMask = calculateSubnetMask(subnetMaskLength);
        
        // Calculate the network address and broadcast address
        String binaryNetworkAddress = calculateNetworkAddress(binaryIP, binarySubnetMask);
        String binaryBroadcastAddress = calculateBroadcastAddress(binaryIP, binarySubnetMask);
        
        // Determine the IP class
        String ipClass = determineIPClass(ipAddress);
        
        // Calculate the number of hosts
        int numHosts = calculateNumberOfHosts(subnetMaskLength);
        
        // Print the results
        System.out.println("IPv4: " + binaryIP);
        System.out.println("SM: " + binarySubnetMask);
        System.out.println("NA: " + binaryNetworkAddress);
        System.out.println("BA: " + binaryBroadcastAddress);
        System.out.println("Class: " + ipClass);
        System.out.println("Number of hosts: " + numHosts);
    }

    public static String convertIPToBinary(String ipAddress) {
        String[] octets = ipAddress.split("\\.");
        StringBuilder binaryIP = new StringBuilder();
        for (String octet : octets) {
            String binaryOctet = Integer.toBinaryString(Integer.parseInt(octet));
            binaryIP.append(String.format("%8s", binaryOctet).replace(' ', '0')).append(".");
        }
        return binaryIP.substring(0, binaryIP.length() - 1);
    }

    public static String calculateSubnetMask(int subnetMaskLength) {
        StringBuilder binarySubnetMask = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if (i < subnetMaskLength) {
                binarySubnetMask.append("1");
            } else {
                binarySubnetMask.append("0");
            }
            if (i % 8 == 7) {
                binarySubnetMask.append(".");
            }
        }
        return binarySubnetMask.substring(0, binarySubnetMask.length() - 1);
    }

    public static String calculateNetworkAddress(String binaryIP, String binarySubnetMask) {
        StringBuilder binaryNetworkAddress = new StringBuilder();
        for (int i = 0; i < binaryIP.length(); i++) {
            if (binaryIP.charAt(i) == '.' || binarySubnetMask.charAt(i) == '.') {
                binaryNetworkAddress.append(".");
            } else {
                if (binaryIP.charAt(i) == '1' && binarySubnetMask.charAt(i) == '1') {
                    binaryNetworkAddress.append("1");
                } else {
                    binaryNetworkAddress.append("0");
                }
            }
        }
        return binaryNetworkAddress.toString();
    }

    public static String calculateBroadcastAddress(String binaryIP, String binarySubnetMask) {
        StringBuilder binaryBroadcastAddress = new StringBuilder();
        for (int i = 0; i < binaryIP.length(); i++) {
            if (binaryIP.charAt(i) == '.' || binarySubnetMask.charAt(i) == '.') {
                binaryBroadcastAddress.append(".");
            } else {
                if (binarySubnetMask.charAt(i) == '1') {
                    binaryBroadcastAddress.append(binaryIP.charAt(i));
                } else {
                    binaryBroadcastAddress.append("1");
                }
            }
        }
        return binaryBroadcastAddress.toString();
    }

    public static String determineIPClass(String ipAddress) {
        String[] octets = ipAddress.split("\\.");
        int firstOctet = Integer.parseInt(octets[0]);
        if (firstOctet >= 1 && firstOctet <= 126) {
            return "A";
        } else if (firstOctet >= 128 && firstOctet <= 191) {
            return "B";
        } else if (firstOctet >= 192 && firstOctet <= 223) {
            return "C";
        } else if (firstOctet >= 224 && firstOctet <= 239) {
            return "D";
        } else if (firstOctet >= 240 && firstOctet <= 255) {
            return "E";
        } else {
            return "Invalid";
        }
    }

    public static int calculateNumberOfHosts(int subnetMaskLength) {
        return (int) Math.pow(2, 32 - subnetMaskLength) - 2;
    }
}