package lesson1;

import lesson1.fruits.Apple;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"abc","def","jhi"};
        ArrayList<String> al = arrayConvertsList(arr);
        System.out.println(al);

        Box<Apple> box1 = new Box<>();

    }


    // Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа).
    public static <T> void change(T[] arr, int a1, int a2) {
        T obj = arr[a1];
        arr[a1] = arr[a2];
        arr[a1] = obj;
    }

    //Написать метод, который преобразует массив в ArrayList.
    public static <T> ArrayList<T> arrayConvertsList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }


}
