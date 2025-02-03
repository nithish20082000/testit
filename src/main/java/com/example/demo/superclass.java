package com.example.demo;


import java.util.ArrayList;
import java.util.Collections;

public class superclass {
static class data{

    int start;
    int end;
    public data(int start, int end){
        this.start=start;
        this.end=end;
    }
}

    public static void main(String[] args){

    ArrayList<data> arr=new ArrayList<>();
    arr.add(new data(4,6));
    arr.add(new data(5,8));
    arr.add(new data(6,7));

    Collections.sort(arr,(a,b)->{
        if(a.start<=b.start)
               return b.start-a.start;
        return a.start-b.start;
    }
    );

    System.out.println(arr.get(0).start);


        

    }
}

