package sas.test;

public class DiguiTest {
    public static int f(int x){
        if(x<=0)
            return 0;
        return x+f(x-1);
    }
    public static void main(String[] args){
        System.out.println(f(100));
    }
}
