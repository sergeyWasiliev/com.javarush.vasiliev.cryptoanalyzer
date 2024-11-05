package service;

import app.Application;
import resources.Alphavit;

public class CypherDecypher {

    public char[] encryptDecrypt(String lineRead, int key) {
        int v = 0; //переключатель, если символ не нашелся в словаре пишем его без изменений
        int lengthALPH = Alphavit.ALPHABET.length;
        char[] readChar = lineRead.toCharArray(); //Массив char из переданной строки
        char[] encoderChar = new char[readChar.length]; //Массив char зашифрованной строки

        if (Application.numMenu >= 2) {
            key = -1 * key;
        }
        for (int i = 0; i < readChar.length; i++) { //Цикл по строке из файла
            v = 0;
            for (int j = 0; j < lengthALPH; j++) { //Цикл по алфавиту
                if (readChar[i] == Alphavit.ALPHABET[j]) {
                    // % lengthALPH - получаем значение индекса от 0 до lengthALPH исключая полные обороты
                    // + lengthALPH - исключаем отрицательные значения index
                    int index = (j + (key % lengthALPH) + lengthALPH) % lengthALPH;
                    encoderChar[i] = Alphavit.ALPHABET[index]; //записываем символ со смещением
                    v = 1;
                }
            }
            if (v == 0) {
                encoderChar[i] = readChar[i]; //записываем символ без изменения, т.к. его нет в словаре
            }
        }
        return encoderChar;
    }
}
