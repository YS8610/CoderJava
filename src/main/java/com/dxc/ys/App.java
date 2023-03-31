package com.dxc.ys;

import java.util.Arrays;

public class App 
{
  public static void main( String[] args )
  {
    Coder dxcCoder = new DxcCoder();
    
    if (args.length==2 ){
      if( args[0].length()==1){
        if ( !Arrays.asList( DxcCoder.getOriginalRef() ).contains(args[0]) ){
          System.out.println("offset character is wrong");
          System.exit(1);
        }
        String encodedStr = args[0] + dxcCoder.encode(args[0],args[1]);
        System.out.println(encodedStr);
      }
      else if ( args[0].equals("decode")){
        System.out.println(dxcCoder.decode(args[1]));
      }
    }
    else{
      System.out.println("Please input only 2 command line inputs");
    }
  }
}
