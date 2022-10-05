package org.example;
/*
 1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо
 бросить исключение MyArraySizeException.
 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе массива
 преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException –
 с детализацией, в какой именно ячейке лежат неверные данные.
 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.
 */

public class Main {

    public static void main (String[] args) {

        String[][] arr = new String[][]{{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "a", "4", "4"}};
        try {
            try {
                int result = handlingExceptions (arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Превышен размер массива");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Не верные данные в массиве");
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);

        }

    }


    public static int handlingExceptions(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {                                              //Размер массива
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {                             //Проходимся по массиву
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {                      //Перебираем значения массива
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException (i, j);
                }
            }

        }
        return count;
    }

}