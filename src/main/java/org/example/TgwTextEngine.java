package org.example;

public class TgwTextEngine {
    //all these methods work with raw tengwar text, not Latin alphabet
    public static String fixFinalNGs(String inputText) {
        StringBuilder outputText = new StringBuilder(); //TODO only use String[] in and out of the method, no String/StringBuilder
        String[] inputArr = inputText.split("\\s+");
        for (String word : inputArr) {
            word.replace("6x8 ","b_ "); //ngs
            word.replace("6x ","b "); //ng
        }
        return outputText.toString();
    }

    public static String fixFinalSs(String inputText) {
        StringBuilder outputText = new StringBuilder();
        String[] inputArr = inputText.split("\\s+");

        return outputText.toString();
    }

    public static String fixDoubleConsonants(String inputText) {
        StringBuilder outputText = new StringBuilder();
        String[] inputArr = inputText.split("\\s+");
        for (String word : inputArr) {
//            word.replace("ww", )
//            word.replace("cc")
//            word.replace("dd")
//            word.replace("ff")
//            word.replace("bb")
//            word.replace("bb")
//            word.replace("bb")
        }
    }

    //    public static String fixOfThes(String input) {
//        input.replaceAll(" of the", " ");
//    }
}