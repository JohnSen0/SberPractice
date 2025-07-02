package org.example;
import java.lang.reflect.*;

public class ClassAnalyzer {
    public static void analyzeClass(String className) {
        try {
            Class<?> clazz = Class.forName(className);

            // Получаем и выводим информацию о модификаторах класса
            System.out.println("Класс: " + clazz.getSimpleName());
            System.out.println("Модификаторы: " + Modifier.toString(clazz.getModifiers()));
            System.out.println();

            // Получаем и выводим информацию о полях
            System.out.println("Поля:");
            Field[] fields = clazz.getDeclaredFields();
            if (fields.length == 0) {
                System.out.println("У класса нет полей");
            } else {
                for (Field field : fields) {
                    System.out.println(Modifier.toString(field.getModifiers()) + " " +
                            field.getType().getSimpleName() + " " +
                            field.getName());
                }
            }
            System.out.println();

            // Получаем и выводим информацию о методах
            System.out.println("Методы:");
            Method[] methods = clazz.getDeclaredMethods();
            if (methods.length == 0) {
                System.out.println("У класса нет методов");
            } else {
                for (Method method : methods) {
                    System.out.println(Modifier.toString(method.getModifiers()) + " " +
                            method.getReturnType().getSimpleName() + " " +
                            method.getName() +
                            getParameterTypes(method));
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + className + " not found");
        }
    }

    // Вспомогательный метод для получения параметров метода
    private static String getParameterTypes(Method method) {
        StringBuilder params = new StringBuilder("(");
        Class<?>[] paramTypes = method.getParameterTypes();
        for (int i = 0; i < paramTypes.length; i++) {
            params.append(paramTypes[i].getSimpleName());
            if (i < paramTypes.length - 1) {
                params.append(", ");
            }
        }
        params.append(")");
        return params.toString();
    }
}
