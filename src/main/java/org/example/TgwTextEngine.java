package org.example;

public class TgwTextEngine {
    //all these methods work with raw tengwar text, not Latin alphabet
    //TODO only use String[] in and out of the method, no String/StringBuilder?

    public static String fixDoubleConsonants(String inputText) {
        return inputText.replaceAll("ww", "w:") //bb, wide
                .replace("zz", "z;") //cc, narrow
                .replace("22", "2:") //dd, wide
                .replace("ee", "e;") //ff, narrow
                .replace("xx", "x:") //gg, wide
                .replace("99", "9;") //hh, narrow
                .replace("ss", "s:") //jj, wide
                .replace("zz", "z;") //kk, narrow
                .replace("jj", "j:") //ll, wide
                .replace("yy", "t") //mm, DIGRAPH?
                .replace("66", "5") //nn, DIGRAPH?
                .replace("qq", "q;") //pp, narrow
                .replace("zz", "z;") //qq, narrow
                .replace("77", "7;") //rr, narrow
                .replace("88", "k") //ss, SPECIAL
                .replace("11", "1;") //tt, narrow
                .replace("rr", "r;") //vv, narrow
                .replace("nn", "n;") //ww, narrow
                .replace("AA", "A;") //xx, narrow
                .replace(",,", ""); //zz, SPECIAL
    }


    public static String fixFinalNGs(String inputText) { //TODO this is complicated, need a regex to find "ng"/"ngs" at end of words; "ng's" != "ngs"
//        StringBuilder outputText = new StringBuilder();
//        String[] inputArr = inputText.split("\\s+");
//        for (String word : inputArr) {
//            word = word.replace("6x8 ","b_ ") //ngs
//            .replace("6x ","b "); //ng
//            outputText.append(" " + word);
//        }
        return inputText.replace("6x8 ", "b_ ") //ngs
                .replace("6x ", "b ");
    }

    public static String fixFinalSs(String inputText) {
        StringBuilder outputText = new StringBuilder();
        String[] inputArr = inputText.split("\\s+");
        return outputText.toString();
    }

    //    public static String fixOfThes(String input) {
//        input.replaceAll(" of the", " ");
//    }
}