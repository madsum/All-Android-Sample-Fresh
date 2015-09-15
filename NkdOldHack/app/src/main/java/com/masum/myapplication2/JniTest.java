package com.masum.myapplication2;

/**
 * Created by masum on 10/09/15.
 */
public class JniTest {

    public static int sum(int a, int b){
     return a+b;
    }
    public static int mul(int a, int b){
        return a*b;
    }

    public native static int sum_JNI(int a, int b );
    public native static int mul_JNI(int a, int b );
    public native static String get_string();
    public native static void print_string(String str);

    static{
        System.loadLibrary("testme");
    }
}
