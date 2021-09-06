package com.abo.security.adminsecurity;

import java.util.ArrayList;
import java.util.List;

public   class TestUtil {



    private  List<Integer> list =new ArrayList<>();



    public List<Integer> getList() {
        return list;
    }


    public void printf(){
        System.out.println(getList().toString());
        System.out.println(list.toString());
    }


}
