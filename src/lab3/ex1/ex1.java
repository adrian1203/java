package lab3.ex1;

import java.util.LinkedList;

public class ex1 {
   public static void foo(final double var){
      // var=var+1; //final oznacza że dane są stałe
   }
   public static void foo2(final LinkedList<Double> list){
       //list.add(3.14);
       //list.remove(0);
       //list.add(59.45);
       list.set(1,36.45);
      list.set(1,36.4);
     // list =new LinkedList<Double>();
   }
   public static void main(String [] args){
       LinkedList<Double>list=new LinkedList<Double>();
       foo2(list);
       foo(136);
   }
}