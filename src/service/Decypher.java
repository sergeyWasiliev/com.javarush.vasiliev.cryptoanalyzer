package service;

public class Decypher {
    public char[] decoder(String lineRead, int key) {
        //System.out.println("Идет шифрование с ключем");
        System.out.println(lineRead);
        int v = 0; //переключатель, если символ не нашелся в словаре пишем его без изменений
        int lengthALPH = Alphavit.ALPHABET.length;
        char[] readChar = lineRead.toCharArray(); //Массив char из переданной строки
        char[] decoderChar = new char[readChar.length]; //Массив char зашифрованной строки

        for (int i = 0; i < readChar.length; i++) {
            v = 0;
            for (int j = 0; j < lengthALPH; j++) {
                if (readChar[i] == Alphavit.ALPHABET[j]) {
                    int index = (j + lengthALPH - key) % lengthALPH; // Используем остаток от деления для получения индекса
                    System.out.print(Alphavit.ALPHABET[index]);
                    decoderChar[i] = Alphavit.ALPHABET[index]; //записываем символ со смещением
                    v = 1;
                }
            }
            if (v == 0) {
                System.out.print(readChar[i]);
                decoderChar[i] = readChar[i]; //записываем символ без изменения, т.к. его нет в словаре
            }

        }
        System.out.println();
        return decoderChar;
    }
}
