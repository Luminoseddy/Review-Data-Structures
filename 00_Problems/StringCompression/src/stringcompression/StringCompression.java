/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringcompression;

/**
 *
 * @author edward
 */
public class StringCompression {


    
    // Compress giving string. 
    public static void main(String[] args) {
        
        
        
        char[] arr = {'a','a','a','a','b','b','b','c','c'};
        
        stringCompress("aaaabbbcc");
        System.out.println(charCompress(arr));
        

    }
    
    
    public static void stringCompress(String str){
        
        int length = str.length();      //length of a String

        //Created an object of a StringBuilder class        
        StringBuilder sb = new StringBuilder(); 

        int count = 1;   //counter for number of occurances

        for(int i=0; i < length; i++){
            
            //if i reaches at the end then append all and break the loop
            if(i==length-1){         
                sb.append(str.charAt(i)+""+count);
                break;
            }

            //if two successive chars are equal then increase the counter
            if(str.charAt(i)==str.charAt(i+1)){   
                count++;
            }
            else{
            //else append character with its count                            
                sb.append(str.charAt(i)+""+count);
                count=1;     //reseting the counter to 1
            }
        }

        //String representation of a StringBuilder object
        System.out.println(sb.toString());   
    }
    
    
    // Compress Array of characters
    public static int charCompress(char[] chars) {
        
        int anchor = 0; // Anchor starting position of the contiguos group of characters
        int write = 0;  // Pointer, where we are writing from. 
        
        // read : from left to right of the array. 
        for (int read = 0; read < chars.length; read++){
            
            // test : ["a","a","b","b","c","c","c"]
            
            // 1. if 1 == 7 OR 0th-char != 1st-char -> false a == a
            // 2. if 2 == 7 OR 1st-char != 2nd-char -> true  a != b
            // 3. 
            if(read + 1 == chars.length || chars[read] != chars[read+1] ){
                
                // 2. char[1] = char [1]
                chars[write++] = chars[anchor];
                
                // 2. 1 > 1 -> false
                if (read > anchor){
                    for(char c: ("" + (read - anchor + 1)).toCharArray()){
                        chars[write++] = c;
                    }
                }
                
                // 1. anchor = 1 
                // 2. anchor = 2
                anchor = read + 1;
            }
        } 
      
        return write;
    }
    
}
