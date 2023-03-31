package com.dxc.ys;

public class DxcCoder extends Coder {

  public DxcCoder(){
    encodeInterface = new DxcEncode();
    decodeInterface = new DxcDecode();
  }

  public static String[] getOriginalRef(){
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
    return originalRef;
  }

}
