package ru.geekbrains.lessons.jc;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /* 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
            MyArrayDataException и вывести результат расчета.
         */
        try {
            String [][] testArray0 = new String[][]{{"1","2","3","4"},{"5","6","7","8"},
                    {"1","2","3","4"},{"9","10","11","12"}};
            System.out.println("sum = " + checkArray(testArray0));

            String [][] testArray1 = new String[][]{{"1","2","3","4"},{"a","b","c","d"},
                    {"1","2","3","4"},{"a","b","c","d"}};
            checkArray(testArray1);
            System.out.println("MyArraySizeException NOT occurs for testArray1");
            String [][] testArray2 = new String[][]{{"1","2","3"},{"a","b","c"}};
            checkArray(testArray2);
            System.out.println("MyArraySizeException NOT occurs for testArray2");
            // ...
        }catch (MyArraySizeException myException){
            //my error;
            System.out.println("MyArraySizeException occurs");
            System.out.println(myException.getMessage());
        }catch (MyArrayDataException myException){
            //my error;
            System.out.println("MyArrayDataException occurs");
            System.out.println(myException.getMessage());
        }
        catch(Exception e) {
           System.out.println("General exception occurs");
        }
    }

    /* 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого
    размера необходимо бросить исключение MyArraySizeException.
    */
    /*
    2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
     должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
     */
    public static int checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if ((array.length != 4) || (array[0].length != 4))
            throw new MyArraySizeException("It is not array 4x4: " + Arrays.deepToString(array));

        int sum = 0;
        for(int i = 0; i < array.length; i++){ //i - строчка
            for(int j =0; j < array[i].length; j++) {//j - столбец
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException nfe) {
                    throw new MyArrayDataException(nfe.getMessage());
                }
            }
        }
        return sum;
    }
}
