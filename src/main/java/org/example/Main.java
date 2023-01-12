package org.example;

import org.example.gui.MainFrame;

import java.util.Scanner;

//1. how to avoid losing digraphs - wrap in symbols
//cincinnatti -- cinci[nn]a[tt]i
//others = o[th]ers
//2. remap the rest into runes
//3. adjust nasals, double consonants, tehtar,
public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
//        ConsoleTest();
    }



    private static void ConsoleTest() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            String output = EngTextMethods.translWordDigraphsSimple(input);
            output = EngTextMethods.translWordCharsSimple(output);
            System.out.println(output);
        }
    }
}