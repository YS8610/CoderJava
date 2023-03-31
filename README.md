# Encoder/Decoder written in Java
A simple encoder that takes in plain text and then encode it to another obfuscated string.

## How it works
For encoding, there are 2 inputs. The 1st input determines the offset.   
1st input should be a single character of A-Z, 0 - 9, ()*+,-./   
2nd input is the text to be encoded. For example, HELLO WORLD   
The first character in the output is the offset, the rest are the encoded word   
Example: 1st input = B, 2nd Input = HELLO WORLD, Output = BGDKKN VNQKC
   
For decoding, the 1st input must be decode   
2nd input is the encoded text   
Example: 1st input = decode, 2nd input = BGDKKN VNQKC, Output = HELLO WORLD

## How to Compile
Maven is used for compiling the file   
`mvn clean compile` to compile the class files   
`mvn clean package` to create the jar file   

## How to Run
For powershell user,   
Maven Command if you are running from compiled file   
Encoding: `java -cp "target\classes" "com.dxc.ys.App" 'B' 'HELLO WORLD'`   
Decoding: `java -cp "target\classes" "com.dxc.ys.App" 'decode' 'BGDKKN VNQKC'`   
Maven Command if you are running from jar file   
Encoding: `java -cp ".\target\encoder-1.0.jar" "com.dxc.ys.App" "B" "HELLO WORLD"`   
Decoding: `java -cp ".\target\encoder-1.0.jar" "com.dxc.ys.App" "decode" "BGDKKN VNQKC"`   
   
For command prompt user,   
Maven Command if you are running from compiled file   
Encoding: `java -cp target\classes com.dxc.ys.App "B" "HELLO WORLD"`   
Decoding: `java -cp target\classes com.dxc.ys.App "decode" "BGDKKN VNQKC"`   
Maven Command if you are running from jar file   
Encoding: `java -cp .\target\encoder-1.0.jar com.dxc.ys.App "B" "HELLO WORLD"`   
Decoding: `java -cp .\target\encoder-1.0.jar com.dxc.ys.App "decode" "BGDKKN VNQKC"`   
