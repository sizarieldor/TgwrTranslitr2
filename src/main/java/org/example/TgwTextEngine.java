package org.example;

public class TgwTextEngine {
    //all these methods work with raw tengwar text, not Latin alphabet
    //TODO only use String[] in and out of the method, no String/StringBuilder?
    /*
    consonants:
                .replaceAll("ww", "w:") //bb, wide
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
     */

    public static String fixDoubleConsonants(String inputText) {
        return inputText.replaceAll("ww", "w:") //bb, wide
                .replaceAll("zz", "z;") //cc, narrow
                .replaceAll("22", "2:") //dd, wide
                .replaceAll("ee", "e;") //ff, narrow
                .replaceAll("xx", "x:") //gg, wide
                .replaceAll("99", "9;") //hh, narrow
                .replaceAll("ss", "s:") //jj, wide
                .replaceAll("zz", "z;") //kk, narrow
                .replaceAll("jj", "j:") //ll, wide
                .replaceAll("yy", "t") //mm, DIGRAPH?
                .replaceAll("66", "5") //nn, DIGRAPH?
                .replaceAll("qq", "q;") //pp, narrow
                .replaceAll("zz", "z;") //qq, narrow
                .replaceAll("77", "7;") //rr, narrow
                .replaceAll("88", "k") //ss, SPECIAL
                .replaceAll("11", "1;") //tt, narrow
                .replaceAll("rr", "r;") //vv, narrow
                .replaceAll("nn", "n;") //ww, narrow
                .replaceAll("AA", "A;") //xx, narrow
                .replaceAll(",,", ""); //zz, SPECIAL
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

    public static String fixNasals(String inputText) {
        /*
        tengwarNasalisable.add('w'); //b
        tengwarNasalisable.add('z'); //c/k/q
        tengwarNasalisable.add('2'); //d
        tengwarNasalisable.add('x'); //g
        tengwarNasalisable.add('s'); //j
        tengwarNasalisable.add('j'); //l
        tengwarNasalisable.add('q'); //p
        tengwarNasalisable.add('1'); //t
        tengwarNasalisable.add('a'); //ch
        //'6' = n
        //'y' = m
         */
        return inputText.replaceAll("yw", "wP") //mb
                        .replaceAll("6z", "zp") //nc/k/q
                        .replaceAll("62", "2P") //nd
                        .replaceAll("6e", "ep") //mf
                        .replaceAll("6x", "xP") //ng
                        .replaceAll("6s", "sp") //nj
                        .replaceAll("yq", "qp") //mp
                        .replaceAll("61", "1p") //nt
                        .replaceAll("6r", "rP") //nv
                        .replaceAll("6a", "aP") //nch
                ;
    }

    public static String fixDiphtongs(String inputText) {
        /*

         */
        return inputText
                .replaceAll("yw", "wP") //mb
                .replaceAll("6z", "zp") //nc/k/q
                .replaceAll("62", "2P") //nd
                .replaceAll("6e", "ep") //mf
                .replaceAll("6x", "xP") //ng
                .replaceAll("6s", "sp") //nj
                .replaceAll("yq", "qp") //mp
                .replaceAll("61", "1p") //nt
                ;
    }

    //    public static String fixOfThes(String input) {
//        input.replaceAll(" of the", " ");
//    }
}