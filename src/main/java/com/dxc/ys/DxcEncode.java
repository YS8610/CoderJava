package com.dxc.ys;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DxcEncode implements EncodeInterface{

  private static Map<String,String> eMapper (String a){
    int offset=-1;
    String[] offsetArray = new String[44];
    int counter = 0;
    String[] originalRef = DxcCoder.getOriginalRef();
    Map<String,String> encodeMap = new HashMap<>();

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
        encodeMap.put(originalRef[i],offsetArray[i]);
      }
      return encodeMap;
    }
    return new HashMap<>();
  }


  @Override
  public String encode(String offsetType, String plainText) {
    
    Map<String,String> enCodeMap = eMapper(offsetType);
    
    if (enCodeMap.isEmpty()){
      return "";
    }
    return Arrays.asList( plainText.split("") )
                        .stream()
                        .map(x->{
                          if (enCodeMap.containsKey(x) ){
                            return enCodeMap.get(x);
                          } 
                          else{
                            return x;
                          }
                        })
                        .collect(Collectors.joining());
    
  }







  
}
