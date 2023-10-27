package com.parity_bit;

import java.util.Scanner;

public class parity_bit {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your student Id: ");
        String inputStudentId =  sc.nextLine();
        Integer studentId = Integer.parseInt(inputStudentId);
        Boolean isEvenParity = false;
        if(studentId % 2 == 0)
            {
                isEvenParity = true;
                System.err.println("Your student Id is even number");
            }
            else {
                System.err.println("Your student Id is ood number");
            }

        System.out.println("Enter the input data in '0' or '1': ");
        String data = sc.nextLine();
        StringBuilder result = new StringBuilder(data);
        Integer oneCount = 0;
        Integer zeroCount = 0;
        for(int i=0; i<data.length(); i++){
            if(data.charAt(i) == '1')
             oneCount++;
            else
             zeroCount++;
        }
        if(isEvenParity){

            if(oneCount%2==0){
                result.append('0');
            }
            else{
                result.append('1');
            }
        }
        else{
            if(oneCount%2 !=0){
                 result.append('0');
            }
            else{
                 result.append('1');
            }
        }
        System.out.println("Output : "+result.toString());
        
     }


 
     
}
