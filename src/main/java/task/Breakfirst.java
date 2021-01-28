package task;

import java.util.Scanner;

public class Breakfirst {
    public float mainFood[]=new float[100];
    public float dringks[]=new float[100];
    public float money;
    public void init(){
        Scanner scanner=new Scanner(System.in);
        String foods[]=scanner.nextLine().split(" ");
        int len=foods.length;
        //mainFood=new float[len];
        for(int i=0;i<len;i++)
            mainFood[i]=Float.parseFloat(foods[i]);
        String drink[]=scanner.nextLine().split(" ");
        len=drink.length;
        //dringks=new float[len];
        for(int i=0;i<len;i++)
            dringks[i]=Float.parseFloat(drink[i]);
        money=Float.parseFloat(scanner.next());
    }

    public void getMoney(){

    }
    public static void main(String[] argv){
        Breakfirst breakfirst=new Breakfirst();
        breakfirst.init();
        System.out.println(breakfirst.dringks[0]);
    }
}
