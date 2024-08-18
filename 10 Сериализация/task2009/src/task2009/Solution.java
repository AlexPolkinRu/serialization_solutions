package task2009;

import java.io.*;

/* 
Как сериализовать static?
Сделай так, чтобы сериализация класса ClassWithStatic была возможной.


Requirements:
1. Класс ClassWithStatic должен существовать внутри класса Solution.
2. Класс ClassWithStatic должен быть статическим.
3. Класс ClassWithStatic должен быть публичным.
4. Класс ClassWithStatic должен поддерживать интерфейс Serializable.*/

public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "static.ser";
        ClassWithStatic objectClassWithStatic = new ClassWithStatic();
        objectClassWithStatic.i = 10;
        objectClassWithStatic.j = 20;

        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName));

        writer.writeObject(objectClassWithStatic);

        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fileName));
        ClassWithStatic anotherObject = (ClassWithStatic) reader.readObject();

        System.out.println(
                "i = " + anotherObject.i + "\n" +
                "j = " + anotherObject.j + "\n" +
                "staticString = " + anotherObject.staticString);
    }
}
