package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.*;

public class Exercise32 {

    public static void main(String[] args) {
        printToFile(generateStringToSave(null));
    }

    public static String generateStringToSave(String string) {
        String input = string;
        while (input == null){
            input = generateUserInputToSave();
        }

        System.out.println("input to return: " + input);
        return input;
    }

    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while(!(string = Utils.string()).isEmpty()){
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        try{
            PrintWriter out
                    = new PrintWriter(new BufferedWriter
                        ( new FileWriter
                            ("src/main/resources/data.txt")
                        )
                    );
            out.write(string);
            out.close();
            // Source: https://docs.oracle.com/javase/8/docs/api/java/io/BufferedWriter.html
        } catch (Exception e) {
            System.out.println("Exception has occurred: " + e);
        }
    }


}
