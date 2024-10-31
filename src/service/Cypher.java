package service;

public class Cypher {

    public void encoder(String line) {
        //System.out.println("Идет шифрование с ключем");
        System.out.println(line);
        int j = 0; //переключатель, если символ не нашелся в словаре пишем его без изменений
        int lengthALPH = Alphavit.ALPHABET.length;
        char[] lineChar = line.toCharArray();
        for (char charFile : lineChar) {
            j = 0;
            for (int i = 0; i < lengthALPH; i++) {
                if (charFile == Alphavit.ALPHABET[i]) {
                    int index = (i + 1) % lengthALPH; // Используем остаток от деления для получения индекса
                    System.out.print(Alphavit.ALPHABET[index]);
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
