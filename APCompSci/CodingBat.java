import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CodingBat {
    public static int stringMatch(String a, String b) {
        int count=0,index1;
        String findMe = "";
        for(int i = 0; i < a.length()-1;i++){
          findMe=a.substring(i,i+2);
          if(b.contains(findMe)){
            index1 = a.indexOf(findMe);
            if(b.indexOf(findMe,i) == index1){
              count++;
            }
          }
        }
        return count;
      }
    
    public static String wordAppend(String[] strings) {
        Map<String,Integer> map = new HashMap<>();
        String result= "";
        for(String s:strings){
          Integer count = 1;
          if(!map.containsKey(s)){
              map.put(s,count);
          }else{
            count = map.get(s);
            map.put(s, count + 1);
          }
          if(map.get(s)%2==0){
            result+=s;
          }
        }
        System.out.println("Result=: " + result);
        return result;
      }

    /**We'll say that 2 strings "match" if they are non-empty and their 
     * first chars are the same. Loop over and then return the given array 
     * of non-empty strings as follows: if a string matches an earlier string 
     * in the array, swap the 2 strings in the array. When a position in the 
     * array has been swapped, it no longer matches anything. Using a map, this 
     * can be solved making just one pass over the array. More difficult than it 
     * looks.

     * allSwap(["ab", "ac"]) → ["ac", "ab"]
     * allSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → 
     * ["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"]
     * allSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → 
     * ["ay", "by", "ax", "bx", "aj", "ai", "by", "bx"]
     * @param strings
     * @return
     */
    public String[] allSwap(String[] strings) {
        long startTime = System.nanoTime();
        Map<String,Integer> map = new HashMap<>();
               String temp, maxSwapKey="";
               int maxSwapPosit=0,i2,matches = 0, passes=0;
//               Build HashMap #1.
               for(int i =0;i<strings.length; i++){
                 if(strings[i].length()!=0 && 
                 !map.containsKey(strings[i].substring(0,1))){
                   map.put(strings[i].substring(0,1),i);
                 }
               }
               for(i2 = 0; i2<strings.length;i2++) {
                 //Count how many times map has been rebuilt  
                   passes++;
                   
                   if(map.size()==0 || i2 > maxSwapPosit) {
                //if you have been through rebuild and no matches, 
                     //due to calling rebuild becuz i2>maxMatchPosit
                     //becuz you have no matches in strings.
                       if(passes==strings.length-1 && matches==0) {
                        // end time
                           long endTime = System.nanoTime();
                           long duration = endTime - startTime;
                           System.out.println("allSwap: " + duration + " nanoseconds(10^9)");
                           return strings;
                       }
                       map.clear();
//                   Re-build HashMap                       
                       for(int k=maxSwapPosit+1;k<strings.length;k++) {
                           if(strings[k].length()!=0 && 
                                   !map.containsKey(strings[k].substring(0,1))){
                             map.put(strings[k].substring(0,1), k);
                           }
                       }
                   i2=maxSwapPosit+1;
                   }
                   for(int j=i2+1; j<strings.length;j++){
                     int passCount;
                     passCount=0;
                       if((strings[j].substring(0,1)).
                               equals(strings[i2].substring(0,1))){
                       if(i2<= maxSwapPosit && 
                               strings[i2].substring(0, 1).
                               equals(maxSwapKey) || 
                               !map.containsKey(strings[i2].substring(0, 1))) {
                          continue; 
                       }
                       temp=strings[map.get(strings[i2].substring(0,1))];
                       strings[i2]=strings[j];
                       strings[j]=temp;
                           if(maxSwapPosit <j) {
                               maxSwapPosit = j;
                               maxSwapKey = strings[j].substring(0,1);
                           }
                       passCount++;
                     }
                     if(passCount>0) {
                         matches++;
                     map.remove(strings[i2].substring(0,1));
                     break;
                     }
                   }
               }
            // end time
               long endTime = System.nanoTime();
               long duration = endTime - startTime;
               System.out.println("allSwap: " + duration + " nanoseconds(10^9)");
               return strings;
             }
    
    public String[] allSwap2(String[] strings) {//Solution code
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<strings.length; i++) {
          String key = strings[i].substring(0, 1);
          if (map.containsKey(key)) {
            int match = map.get(key);
            String temp = strings[match];  // swap strings at match/i
            strings[match] = strings[i];// swaps second occurrence 
             //of string, while first occurrence gets put as key
            strings[i] = temp;
            map.remove(key);  // so this old one won't match anything
          }
          else {
            map.put(key, i);
          }
        }
        return strings;
      }
    
    /**We'll say that 2 strings "match" if they are non-empty and their 
     * first chars are the same. Loop over and then return the given array
     * of non-empty strings as follows: if a string matches an earlier string
     * in the array, swap the 2 strings in the array. A particular first char 
     * can only cause 1 swap, so once a char has caused a swap, its later swaps 
     * are disabled. Using a map, this can be solved making just one pass over 
     * the array. More difficult than it looks.

     * firstSwap(["ab", "ac"]) → ["ac", "ab"]
     * firstSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → 
     * → ["ay", "by", "cy", "cx", "bx", "ax", "aaa", "azz"]
     * firstSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → 
     * → ["ay", "by", "ax", "bx", "ai", "aj", "bx", "by"]
     * @param strings
     * @return String Array with keys only swapped once;
     */
    public String[] firstSwap(String[] strings) {
        long startTime = System.nanoTime();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> swapped = new HashMap<>();
        for(int i=0; i <strings.length;i++){
        String key = strings[i].substring(0,1);
          if(map.containsKey(key)){
            if(swapped.containsKey(key)){
              continue;
            }
          Integer match = map.get(key);
          String temp = strings[match];
          strings[match]= strings[i];
          strings[i]= temp;
          swapped.put(key,i);
          map.remove(key);
          }else{
            map.put(key,i);
           }
        }
     // end time
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("firstSwap: " + duration + " nanoseconds(10^9)");
        return strings;
      }
    
    /**Recursion: count the number of X's in string str;
     * Hard One. Need to remember recursive call is: 
     *             count '+='countX(str);
     * Also, shortening str each round leads to: 
     *        n=str.length()-1 == -1, so use 'end=Math.max(0,n)'.
     * @param str
     * @return 
     */
    public static int countX(String str) {
        int count = 0, n=str.length()-1;
        int end = Math.max(0,n);
        
        if(str.isEmpty()){ 
            return 0;
                       }else {
        if(str.substring(end).equals("x"))  
            count++;
        
        str = str.substring(0,end); 
        count += countX(str);
    }
        return count;
       }
    
    public static void main(String[] args) {
//        String [] s1 = {"a", "b", "c", "xx", "yy", "zz"};
//        String [] s2 = {"ax", "bx", "cx", "ay", "cy", "aaa", "abb"};
//        String [] s3 = {"ax", "bx", "ay", "by", "ai", "aj", "bx", "by"};
        CodingBat cb = new CodingBat();
//        String [] result = cb.firstSwap(s3);
//        System.out.println("Result=: " + Arrays.toString(result));
        String str1 = "xxHixx";
        String str2 = "xhixhix";
        System.out.println("'x'" + "count=: " +cb.countX(str2));
        
        
        
        

    }

}
