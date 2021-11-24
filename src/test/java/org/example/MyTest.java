package org.example;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


public class MyTest {

    @Test
    @DisplayName("Тренировка")
    @RepeatedTest(2)
    public void testForTest() {
        System.out.println("Привет. Меня зовут Мария и я студент Geekbrains!");
    }

    private App app;

    // Проверка теста на валидных знаечниях, что площадь высчитывается правильно
    @ParameterizedTest
    @CsvSource({"3,4,5"})
    @DisplayName("Стороны треугольника равны 3, 4, 5")
    public void calculateSquare(int a, int b, int c) {
        App app = new App();
        if(a+b < c||a+c< b|| b+c < a){
            System.out.println( "Эти стороны не образуют треугольника");
           }
        int value = app.square(a, b, c);
        assertEquals (6, value);
    }
    // Проверка теста на валидных знаечниях, подставляем массив
    @ParameterizedTest
    @DisplayName("Значения для сторон треугольника из массива")
    @CsvSource({"3,4,5, 6", "13, 14, 15, 84", "51, 52, 53, 1170"})
    public void calculateSquareArray(int a, int b, int c, int value) {
        if(a+b < c||a+c< b|| b+c < a){
            System.out.println( "Эти стороны не образуют треугольника");
        }
        App app = new App();
        int totalSquare = app.square(a, b, c);
        assertEquals (value, totalSquare);
    }

    // Данный тест проверяет, что среди переменных нет пустого значения
    @Test
    @DisplayName("Аргументы не пустые")
    public void calculateSquareArgNotNull() {
        App app = new App();
       int value = app.square(1, 3, 8);
        assertNotNull (value);
    }

    // Данный тест проверяет, что значение площади положительное. Если хоть одна из переменных будет отрицательной или 0, то мы увидим ошибку)
    @Test
    @DisplayName("Значение площади должно быть положительным числом")
    public void calculateSquareArgNot0() {
        App app = new App();
        assumeTrue( app.square(5, 6, 6) > 0, "Значение площади должно быть положительным числом");

    }

}
