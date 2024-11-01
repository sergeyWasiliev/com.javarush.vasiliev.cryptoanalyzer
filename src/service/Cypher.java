package service;

public class Cypher {

    public void encoder(String lineRead) {
        //System.out.println("Идет шифрование с ключем");
        System.out.println(lineRead);
        int v = 0; //переключатель, если символ не нашелся в словаре пишем его без изменений
        int lengthALPH = Alphavit.ALPHABET.length;
        char[] lineReadChar = lineRead.toCharArray();
        for (int i = 0; i < lineReadChar.length; i++) {
             v = 0;
            for (int j = 0; j < lengthALPH; j++) {
                if (lineReadChar[i] == Alphavit.ALPHABET[j]) {
                    int index = (j + 1) % lengthALPH; // Используем остаток от деления для получения индекса
                    System.out.print(Alphavit.ALPHABET[index]);
                    v = 1;
                }
            }
            if (v == 0) {
                System.out.print(lineReadChar[i]);
            }

        }
        System.out.println();
    }
}
