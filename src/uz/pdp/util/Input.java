package uz.pdp.util;

import java.util.Scanner;

public interface Input {

    static int input_Int(String msg){
        System.out.print(msg);
        return new Scanner(System.in).nextInt();
    }
    static String input_Str(String msg){
        System.out.print(msg);
        return new Scanner(System.in).nextLine();
    }
}
