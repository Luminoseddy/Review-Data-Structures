/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotatearray;


import java.util.ArrayList;

public class RotateArray {
    
    public static void main(String[] args) throws Exception{
        
        ArrayList<Integer> arrayList_Object = new ArrayList<Integer>(); /* Create the ArrayList Object*/
        int[] arrayList = {1, 3, 5, 7, 11, 13, 17, 23, 29}; /* Create the list of integest in a array */

        for(int i = 0; i< arrayList.length; i++){
            arrayList_Object.add(i); /* Use the ArrayList built in functions tp add. */
            System.out.println("Length of array" + arrayList[i]);
        }   
            
//        System.out.println(rotate(arrayList, 2));
    }
    
    public static void rotate(int[] arr, int order) {	
	if (arr == null || arr.length==0 || order < 0) { throw new IllegalArgumentException("Illegal argument!"); }
		
	if(order > arr.length){
            order = order %arr.length;
	}
 
	//length of first part
	int a = arr.length - order; 
 
	reverse(arr, 0, a-1);
	reverse(arr, a, arr.length-1);
	reverse(arr, 0, arr.length-1);
 
}
 
    public static void reverse(int[] arr, int left, int right){
	if(arr == null || arr.length == 1) 
            return;
 
	while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
	}	
    }
    
}
