package com.louay.projects.util;

import java.util.ArrayList;

public  interface Sortable extends Comparable {
    static  void sort(ArrayList list) {
        for (int i=0;i<list.size();i++)
            for (int j=0;j<list.size()-1;j++)
                if ( ((Comparable) list.get(j)).compareTo(list.get(j+1)) < 1){
                    swap(j,j+1,list);
                }
    }

    static void swap(int currentMinIndex, int i, ArrayList list){
        if (currentMinIndex != i){
            Object temp = list.get(i);
            list.set(i,list.get(currentMinIndex));
            list.set(currentMinIndex,temp);
        }
    }
}
