package ru.geekbrains.lessons.jc;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
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
        }
        catch(Exception e) {
           System.out.println("General exception occurs");
        }
    }

    /* 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого
    размера необходимо бросить исключение MyArraySizeException.
    */
    public static void checkArray(String[][] array) throws MyArraySizeException {
        if ((array.length == 4) && (array[0].length == 4))
            return;

        throw new MyArraySizeException("It is not array 4x4: " + Arrays.deepToString(array));
    }
}
