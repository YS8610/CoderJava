package com.dxc.ys;

public abstract class Coder {

  EncodeInterface encodeInterface;
  DecodeInterface decodeInterface;

  public Coder(){

  }

  public String encode(String offsetType, String txt){
    return encodeInterface.encode(offsetType, txt);
  }

  public String decode( String txt){
    return decodeInterface.decode(txt);
  }
  
}
