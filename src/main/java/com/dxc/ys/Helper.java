package com.dxc.ys;

import java.util.HashMap;
import java.util.Map;

public class Helper {


  public static int indexOffset(String a){

    String[] originalRef = new String[44];
    for (int i=0;i<26;i++){
        originalRef[i]= String.valueOf((char)(i + 65));
    }
    for (int i=26; i<36;i++){
        originalRef[i]= String.valueOf(i-26); 
    }
    for (int i=36;i<44;i++){
        originalRef[i]= String.valueOf((char)(i + 4 ));
    }
    for (int i=0;i<44;i++){
        if(originalRef[i].equals(a) ) return i;
    }
    return -1;
  }

  public static Map<String,String> eMapper (String a){
    int offset=-1;
    String[] offsetArray = new String[44];
    int counter = 0;
    String[] originalRef = new String[44];
    Map<String,String> encodeMap = new HashMap<>();

    for (int i=0;i<26;i++){
        originalRef[i]= String.valueOf((char)(i + 65));
    }
    for (int i=26; i<36;i++){
        originalRef[i]= String.valueOf(i-26); 
    }
    for (int i=36;i<44;i++){
        originalRef[i]= String.valueOf((char)(i + 4 ));
    }
    for (int i=0;i<44;i++){
        if(originalRef[i].equals(a) ){
          offset=i;
          break;
        } 
    }

    if (offset >-1){

      for (int i =offset; i<44;i++){
        offsetArray[i] = originalRef[counter];
        counter ++;
      }
      for (int i=0; i<offset; i++ ){
        offsetArray[i] = originalRef[counter];
        counter ++;
      }
      for (int i=0; i<44;i++){
        encodeMap.put(originalRef[i], offsetArray[i]);
      }
      return encodeMap;

    }
    return new HashMap<>();
  }



}
