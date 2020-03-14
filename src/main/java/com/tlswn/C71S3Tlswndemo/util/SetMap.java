package com.tlswn.C71S3Tlswndemo.util;

import java.util.ArrayList;
import java.util.HashMap;

public class SetMap {
	
	public static boolean put(Integer key, Integer str, HashMap<Integer, ArrayList> map){
        ArrayList<Integer> list = map.get(key);
        if(list == null)
            list = new ArrayList<Integer>();
        for(int i = 0; i < list.size(); ++i){
            if(list.get(i).equals(str))
                return false;
        }
        list.add(str);
        map.put(key, list);
        System.out.println(map.toString());
        return true;
    }

}
