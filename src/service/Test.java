package service;

public class Test {
    public static void main(String[] args) {


        int[] array = {10, 20, 30, 40, 50, 60, 70}; // Пример массива
        int length = array.length;

        // Пример: итерация по массиву 10 раз
        for (int i = 0; i < 18; i++) {
            int index = i % length; // Используем остаток от деления для получения индекса

            System.out.println("Итерация " + i + ": " + array[index] + " Элемент номер: " + index);
        }
    }
}


