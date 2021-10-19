package ru.geekbrains.lessons.jc;
//import java.lang.Exception;

public class MyArraySizeException extends Exception {
    private String message;
    MyArraySizeException() { super(); message = new String();};
    MyArraySizeException(String message) { super(); this.message = message;};
    public String getMessage() { return message; };
}
