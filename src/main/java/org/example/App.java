package org.example;

/**
 * Hello world!
 *
 */
public class App 
{

   int square (int a, int b, int c){
        int p = (a+b+c)/2;
        int s = (int) Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return s;
    }

}
