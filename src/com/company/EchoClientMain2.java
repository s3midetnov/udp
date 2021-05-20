package com.company;

import java.util.Scanner;

public class EchoClientMain2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        EchoClient client = new EchoClient();
        while(true){
            String k = s.nextLine();
            String echo = client.sendEcho(k);
            System.out.println(echo);
        }
    }
}
