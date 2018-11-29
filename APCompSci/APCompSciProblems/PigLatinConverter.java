package APCompSciProblems;

import java.util.ArrayList;
import java.util.List;

public class PigLatinConverter{

  private String line;
  
  public PigLatinConverter(String line) {
    this.line=line;
  }
  
  public String toPig(String word)
  {
     if(isVowel(word.charAt(0)))
     {
            word=word.substring(0) +"yay";
     }else
         word=word.substring(1) +word.substring(0,1)+"ay";
  return word;
  }

  private boolean isVowel(char ch)
  {
     String VOWELS = "aeiouAEIOU";
     if(VOWELS.indexOf(ch)>=0)
     {
       return true;
     }else
       
    return false;
  }

  private List<String> getLineWords()
  {
     String word;
     List<String> words = new ArrayList<String>();
   if(!line.contains(" "))
     {
     words.add(line);
     return words; 
     }
     int i=0;
     while(i<line.length())
    {
       if(line.indexOf(" ",i) >0)
       {
         word=line.substring(i,line.indexOf(" ",i));
         i=line.indexOf(" ",i)+1;
        } else {
           word=line.substring(line.lastIndexOf(" ")+1);
           i=line.length();
        }
    words.add(word);
    }
  return words;
  }

  public String pigLatin()
  {
    String linePig="";
    List<String> words=getLineWords();
    for(int i =0; i < words.size(); i++)
    {
       linePig+=toPig(words.get(i))+" ";
    }
  line=linePig;
  return line;
  }

  public static void main(String[] args)
  {
    String line = "The quick brown fox jumps over the lazy dog";
    PigLatinConverter pLat = new PigLatinConverter(line);
//    String word= "elephant";
    
    System.out.println(line  +" to PigLatin:= \n" + pLat.pigLatin());

  }

}
