import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        HashMap<String,Integer> map=new HashMap<>();
        Scanner in = new Scanner(System.in);
        int numberOfDays = in.nextInt();
        for (int i = 0; i < numberOfDays; i++) {
            Boolean cooking=false;
            String ingredient = in.next();
            
            if(ingredient.contains("FAT")){
                if(map.containsKey("FAT")){
                    map.put("FAT",1+map.get("FAT"));
                }else{
                    map.put("FAT", 1);
                }
                if(!cooking && map.containsKey("FAT") && map.get("FAT")>=2){
                   cooking=true;
                   
                   map=new HashMap<>();
                }
            }else if(ingredient.contains("FIBER")){
                if(map.containsKey("FIBER")){
                    map.put("FIBER",1+map.get("FIBER"));
                }else{
                    map.put("FIBER", 1);
                }
                if(!cooking && map.containsKey("FIBER") && map.get("FIBER")>=2){
                   cooking=true;
                
                  map=new HashMap<>();
                }
            }else if(ingredient.contains("CARB")){
                if(map.containsKey("CARB")){
                    map.put("CARB",1+map.get("CARB"));
                }else{
                    map.put("CARB", 1);
                }
                if(!cooking && map.containsKey("CARB") && map.get("CARB")>=2){
                   cooking=true;
                 
                 map=new HashMap<>();
                }
            }
            if(cooking){ System.out.print(1);}
            else{
                System.out.print(0);
            }
            cooking=false;
        }
    }
}