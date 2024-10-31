package service;

public class Cypher {

    public void encoder(String line) {
        System.out.println("Идет шифрование с ключем");
        //System.out.println(line);
        int j = 0;
        char[] lineChar = line.toCharArray();
        for (char charFile : lineChar) {
            j = 0;
            for (char charAlph : Alphavit.ALPHABET) {
                if (charFile == charAlph) {
                    System.out.print((char) (charAlph + 5));
                    j = 1;
                }
            }
            if (j == 0) {
                System.out.print(charFile);
            }
        }
        System.out.println();
    }
}
