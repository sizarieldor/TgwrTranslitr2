package org.example;

import org.apache.commons.lang3.StringUtils;

public class TgwTextMethods {
    //all these methods work with raw tengwar text, not Latin alphabet
    //TODO only use String[] in and out of the method, no String/StringBuilder?
    /*
    consonants:
                ("ww", "w:") //bb, wide
                ("zz", "z;") //cc, narrow
                ("22", "2:") //dd, wide
                ("ee", "e;") //ff, narrow
                ("xx", "x:") //gg, wide
                ("99", "9;") //hh, narrow
                ("ss", "s:") //jj, wide
                ("zz", "z;") //kk, narrow
                ("jj", "j:") //ll, wide
                ("yy", "t") //mm, DIGRAPH?
                ("66", "5") //nn, DIGRAPH?
                ("qq", "q;") //pp, narrow
                ("zz", "z;") //qq, narrow
                ("77", "7;") //rr, narrow
                ("88", "k") //ss, SPECIAL
                ("11", "1;") //tt, narrow
                ("rr", "r;") //vv, narrow
                ("nn", "n;") //ww, narrow
                ("AA", "A;") //xx, narrow
                (",,", ""); //zz, SPECIAL
     */

    public static String fixDoubleConsonants(String inputText) {
       /* return inputText.replaceAll(
                "ww", "w:") //bb, wide
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
                .replaceAll(",,", ""); //zz, SPECIAL */
        String[] rawChars = new String[]{"ww","zz", "22", "ee", "xx", "99", "ss", "zz", "jj", "yy", "66", "qq", "zz", "77", "88", "11", "rr", "nn", "AA", ",,"};
        String[] fixedChars = new String[]{"w:", "z;", "2:", "e;", "x:", "9;", "s:", "z;", "j:", "t", "5", "q;", "z;", "7;", "k", "1;", "r;", "n;", "A;", ""};

        return StringUtils.replaceEach(inputText, rawChars, fixedChars);
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
        String[] rawChars = new String[]{"yw", "6z","62","6e","6x","6s","yq","61","6r","6a"};
        String[] fixedChars = new String[]{"wP", "zp", "2P", "ep", "xP", "sp", "qp", "1p", "rP", "aP"};
/*        return inputText
                .replaceAll("yw", "wP") //mb
                .replaceAll("6z", "zp") //nc/k/q
                .replaceAll("62", "2P") //nd
                .replaceAll("6e", "ep") //mf
                .replaceAll("6x", "xP") //ng
                .replaceAll("6s", "sp") //nj
                .replaceAll("yq", "qp") //mp
                .replaceAll("61", "1p") //nt
                .replaceAll("6r", "rP") //nv
                .replaceAll("6a", "aP") //nch
                ;*/
        return StringUtils.replaceEach(inputText, rawChars, fixedChars);

    }

    public static String putDotsForFullMode(String inputText) {
        String[] rawChars = new String[]{"]","`"};
        String[] fixedChars = new String[]{"]G","`B"};

        return StringUtils.replaceEach(inputText, rawChars, fixedChars);

/*        return inputText
                .replaceAll("]","]G")
                .replaceAll("`","`B")
                ;*/
    }


        public static String fixOfThes(String inputText ) {
//            String[] rawChars = new String[]{" ]62 "," 3l "," he "," he 3l "};
//            String[] fixedChars = new String[]{" 2P "," @ "," W "," W: "};
//            return StringUtils.replaceEach(inputText, rawChars, fixedChars);

            return inputText
                    .replaceAll(" he 3l ", " W: ")
                    .replaceAll(" ]62 ", " 2P ") //and
                    .replaceAll(" 3l ", " @ ") //the
                    .replaceAll(" he ", " W ") //of
                    ; //of the
    }
}