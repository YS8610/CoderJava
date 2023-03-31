package com.dxc.ys;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DxcDecode implements DecodeInterface {
  
  private static Map<String,String> eMapper (String a){
    int offset=-1;
    String[] offsetArray = new String[44];
    int counter = 0;
    String[] originalRef = new String[44];
    Map<String,String> decodeMap = new HashMap<>();

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
        decodeMap.put(offsetArray[i],originalRef[i]);
      }
      return decodeMap;

    }
    return new HashMap<>();
  }

  @Override
  public String decode(String encodedText) {

    String[] txtArray = encodedText.split("");
    Map<String,String> offsetMap = eMapper(txtArray[0]);
    
    if ( offsetMap.isEmpty() ) return "";

    return Arrays.stream(txtArray, 1, txtArray.length)
          .map(x ->{
            if (offsetMap.containsKey(x) ){
              return offsetMap.get(x);
            } 
            else{
              return x;
            }
          })
          .collect(Collectors.joining());
  }
  
}
