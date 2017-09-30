package com.alen;

/**
 * Created by y64195 on 2017/9/30.
 */
public class ClassTest {

    public int add(int x, int y){
        if(Configuration.isEnabled()){
            return x + y;
        }
        return 0;
    }
}
