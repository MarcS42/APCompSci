import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CodingBat {
    public static int stringMatch(String a, String b)
    {
        int count = 0, index1;
        String findMe = "";
        for (int i = 0; i < a.length() - 1; i++)
        {
            findMe = a.substring(i, i + 2);
            if (b.contains(findMe))
            {
                index1 = a.indexOf(findMe);
                if (b.indexOf(findMe, i) == index1)
                {
                    count++;
                }
            }
        }
        return count;
    }

    public static String wordAppend(String[] strings)
    {
        Map<String, Integer> map = new HashMap<>();
        String result = "";
        for (String s : strings)
        {
            Integer count = 1;
            if (!map.containsKey(s))
            {
                map.put(s, count);
            } else
            {
                count = map.get(s);
                map.put(s, count + 1);
            }
            if (map.get(s) % 2 == 0)
            {
                result += s;
            }
        }
        System.out.println("Result=: " + result);
        return result;
    }

    /**
     * We'll say that 2 strings "match" if they are non-empty and their first chars
     * are the same. Loop over and then return the given array of non-empty strings
     * as follows: if a string matches an earlier string in the array, swap the 2
     * strings in the array. When a position in the array has been swapped, it no
     * longer matches anything. Using a map, this can be solved making just one pass
     * over the array. More difficult than it looks.
     * 
     * allSwap(["ab", "ac"]) → ["ac", "ab"] allSwap(["ax", "bx", "cx", "cy", "by",
     * "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"]
     * allSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by",
     * "ax", "bx", "aj", "ai", "by", "bx"]
     * 
     * @param strings
     * @return
     */
    public String[] allSwap(String[] strings)
    {
        long startTime = System.nanoTime();
        Map<String, Integer> map = new HashMap<>();
        String temp, maxSwapKey = "";
        int maxSwapPosit = 0, i2, matches = 0, passes = 0;
        // Build HashMap #1.
        for (int i = 0; i < strings.length; i++)
        {
            if (strings[i].length() != 0 && !map.containsKey(strings[i].substring(0, 1)))
            {
                map.put(strings[i].substring(0, 1), i);
            }
        }
        for (i2 = 0; i2 < strings.length; i2++)
        {
            // Count how many times map has been rebuilt
            passes++;

            if (map.size() == 0 || i2 > maxSwapPosit)
            {
                // if you have been through rebuild and no matches,
                // due to calling rebuild becuz i2>maxMatchPosit
                // becuz you have no matches in strings.
                if (passes == strings.length - 1 && matches == 0)
                {
                    // end time
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime;
                    System.out.println("allSwap: " + duration + " nanoseconds(10^9)");
                    return strings;
                }
                map.clear();
                // Re-build HashMap
                for (int k = maxSwapPosit + 1; k < strings.length; k++)
                {
                    if (strings[k].length() != 0 && !map.containsKey(strings[k].substring(0, 1)))
                    {
                        map.put(strings[k].substring(0, 1), k);
                    }
                }
                i2 = maxSwapPosit + 1;
            }
            for (int j = i2 + 1; j < strings.length; j++)
            {
                int passCount;
                passCount = 0;
                if ((strings[j].substring(0, 1)).equals(strings[i2].substring(0, 1)))
                {
                    if (i2 <= maxSwapPosit && strings[i2].substring(0, 1).equals(maxSwapKey)
                            || !map.containsKey(strings[i2].substring(0, 1)))
                    {
                        continue;
                    }
                    temp = strings[map.get(strings[i2].substring(0, 1))];
                    strings[i2] = strings[j];
                    strings[j] = temp;
                    if (maxSwapPosit < j)
                    {
                        maxSwapPosit = j;
                        maxSwapKey = strings[j].substring(0, 1);
                    }
                    passCount++;
                }
                if (passCount > 0)
                {
                    matches++;
                    map.remove(strings[i2].substring(0, 1));
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

    public String[] allSwap2(String[] strings)
    {// Solution code
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < strings.length; i++)
        {
            String key = strings[i].substring(0, 1);
            if (map.containsKey(key))
            {
                int match = map.get(key);
                String temp = strings[match]; // swap strings at match/i
                strings[match] = strings[i];// swaps second occurrence
                // of string, while first occurrence gets put as key
                strings[i] = temp;
                map.remove(key); // so this old one won't match anything
            } else
            {
                map.put(key, i);
            }
        }
        return strings;
    }

    /**
     * We'll say that 2 strings "match" if they are non-empty and their first chars
     * are the same. Loop over and then return the given array of non-empty strings
     * as follows: if a string matches an earlier string in the array, swap the 2
     * strings in the array. A particular first char can only cause 1 swap, so once
     * a char has caused a swap, its later swaps are disabled. Using a map, this can
     * be solved making just one pass over the array. More difficult than it looks.
     * 
     * firstSwap(["ab", "ac"]) → ["ac", "ab"] firstSwap(["ax", "bx", "cx", "cy",
     * "by", "ay", "aaa", "azz"]) → → ["ay", "by", "cy", "cx", "bx", "ax", "aaa",
     * "azz"] firstSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → → ["ay",
     * "by", "ax", "bx", "ai", "aj", "bx", "by"]
     * 
     * @param strings
     * @return String Array with keys only swapped once;
     */
    public String[] firstSwap(String[] strings)
    {
        long startTime = System.nanoTime();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> swapped = new HashMap<>();
        for (int i = 0; i < strings.length; i++)
        {
            String key = strings[i].substring(0, 1);
            if (map.containsKey(key))
            {
                if (swapped.containsKey(key))
                {
                    continue;
                }
                Integer match = map.get(key);
                String temp = strings[match];
                strings[match] = strings[i];
                strings[i] = temp;
                swapped.put(key, i);
                map.remove(key);
            } else
            {
                map.put(key, i);
            }
        }
        // end time
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("firstSwap: " + duration + " nanoseconds(10^9)");
        return strings;
    }

    /**
     * Recursion: count the number of X's in string str; Hard One. Need to remember
     * recursive call is: count '+='countX(str); Also, shortening str each round
     * leads to: n=str.length()-1 == -1, so use 'end=Math.max(0,n)'.
     * 
     * @param str
     * @return
     */
    public static int countX(String str)
    {
        int count = 0, n = str.length() - 1;
        int end = Math.max(0, n);

        if (str.isEmpty())
        {
            return 0;
        } else
        {
            if (str.substring(end).equals("x"))
                count++;

            str = str.substring(0, end);
            count += countX(str);
        }
        return count;
    }

    public static int countHi(String str)
    {
        int count = 0;
        if (str.equals("") || str.lastIndexOf("hi") < 0)
        {
            return 0;
        } else
        {
            count++;
            str = str.substring(0, str.lastIndexOf("hi"));
            count += countHi(str);
        }
        return count;
    }

    public int array11(int[] nums, int index)
    {
        int count = 0;
        if (nums.length == 0)
            return 0;
        if (index == nums.length - 1)
        {
            if (nums[nums.length - 1] == 11)
            {
                return count + 1;
            } else
            {
                return count;
            }
        }
        if (nums[index] == 11)
        {
            count++;
        }
        index = index + 1;
        count += array11(nums, index);
        return count;
    }

    public String allStar(String str)
    {
        String str2 = "";
        String insert = "*";
        if (str.length() == 0 || str == "")
            return str;

        if (str.length() == 1)
        {
            str2 = str.substring(str.length() - 1);
            return str2;
        }
        str2 = str.substring(0, 1) + insert;
        str = str.substring(1);
        str2 += allStar(str);
        return str2;
    }

    /**
     * Key to solution was: 1) return str at the base case; 2) have two helper
     * strings: 1 for when and "x" was found, and 1 for when a non-"x" was found;
     * and 3) return the recursive call in the right order Non-"x"+ + endX(str) +
     * str2 with "x's".
     * 
     * @param str
     * @return
     */
    public String endX(String str)
    {
        String str2 = "";
        String str3 = "";
        if (str.equals(null) || str.equals(""))
            return str;

        if (str.length() == 1 || str.indexOf("x") < 0)
        {
            if (str.equals("x"))
                str2 = "x";
            return str;
        }

        if (str.substring(0, 1).equals("x"))
        {
            str2 = "x";
        } else
        {
            str3 = str.substring(0, 1);
        }
        str = str.substring(1);
        return str3 + endX(str) + str2;
    }

    /**
     * We'll say that a "pair" in a string is two instances of a char separated by a
     * char. So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains 3
     * pairs -- 2 for A and 1 for x. Recursively compute the number of pairs in the
     * given string.
     * 
     * countPairs("axa") → 1 countPairs("axax") → 2 countPairs("axbx") → 1
     * 
     * @param str
     * @return
     */
    public int countPairs(String str)
    {
        String matchMe = "";
        int count = 0;
        if (str.length() < 2)
            return count;
        if (str.length() == 2)
        {
            // if(str.substring(1).equals(matchMe)) count++;
            return count;
        }
        matchMe = str.substring(0, 1);
        str = str.substring(1);
        if (matchMe.equals(str.substring(1, 2)))
            count++;
        count += countPairs(str);
        return count;
    }

    public int count11(String str)
    {
        int count = 0;
        String matchMe = "11";
        if (str.length() < 2)
            return count;
        if (str.length() == 2)
        {
            if (str.equals(matchMe))
            {
                count++;
                return count;
            }
            return count;
        }
        if (str.substring(0, 2).equals("11"))
        {
            count++;
            str = str.substring(2);
        } else
        {
            str = str.substring(1);
        }
        count += count11(str);
        return count;
    }

    /**
     * Given a string, return recursively a "cleaned" string where adjacent chars
     * that are the same have been reduced to a single char. So "yyzzza" yields
     * "yza".
     * 
     * stringClean("yyzzza") → "yza" stringClean("abbbcdd") → "abcd"
     * stringClean("Hello") → "Helo"
     * 
     * @param str:"yyzzza"
     * @return str:"yza"
     */
    public String stringClean(String str)
    {
        String str2 = "";
        if (str.length() < 2)
            return str;
        if (str.length() == 2)
        {
            if (str.substring(0, 1).equals(str.substring(1)))
            {
                str2 = str.substring(0, 1);
                return str2;
            }
            str2 = str.substring(0);
            return str2;
        }
        if (str.substring(0, 1).equals(str.substring(1, 2)))
        {
            if (str.indexOf(str.substring(1, 2), 2) < 0 || str.indexOf(str.substring(1, 2), 2) > 2)
            {
                str2 = str.substring(0, 1);
                str = str.substring(2);
            } else
            {
                str2 = str.substring(0, 1);
                str = str.substring(3);
            }
        } else
        {
            str2 = str.substring(0, 1);
            str = str.substring(1);
        }
        str2 += stringClean(str);
        return str2;
    }

    /**
     * count "hi" only if not preceeded by "x".
     * 
     * @param str
     * @return
     */
    public int countHi2(String str)
    {
        int count = 0;
        String findMe1 = "hi";
        String findMe2 = "xhi";
        if (str.length() < 2)
            return count;
        if ((str.indexOf(findMe2) >= 0 && str.indexOf(findMe1) < 0) || str.indexOf(findMe1) < 0)
            return count;
        if (str.length() == 3)
        {
            if (str.substring(0, 1).equals("x") || str.indexOf(findMe1) < 0)
            {
                return count;
            } else if (str.indexOf(findMe1) >= 0)
                count++;
            return count;
        }
        if (str.indexOf(findMe2) >= 0 && str.indexOf(findMe1) >= 0)
        {
            if (str.indexOf(findMe1) < str.indexOf(findMe2))
            {
                count++;
                str = str.substring(str.indexOf(findMe2) + 3);
            } else
            {
                str = str.substring(str.indexOf(findMe2) + 3);
            }
        } else if (str.indexOf(findMe1) >= 0)
        {
            count++;
            str = str.substring(str.indexOf(findMe1) + 2);
        }
        count += countHi2(str);
        return count;
    }

    /**
     * Given a string, return true if it is a nesting of zero or more pairs of
     * parenthesis, like "(())" or "((()))". Suggestion: check the first and last
     * chars, and then recur on what's inside them.
     * 
     * nestParen("(())") → true nestParen("((()))") → true nestParen("(((x))") →
     * false
     * 
     * @param str
     * @return
     */
    public boolean nestParen(String str)
    {
        if (str.equals(""))
            return true;
        if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')')
            return nestParen(str.substring(1, str.length() - 1));
        else
            return false;
    }

    public boolean strCopies(String str, String sub, int n)
    {
        if (countSub(str, sub) == n)
            return true;
        else
            return false;
    }

    /**
     * Very interesting boolean String recursion problem. had to create a recusive
     * method just to count the occurrences of str, and then call it from the
     * strCopies(String str,String sub,int n) method to do the comparison of sub
     * count vs n.
     * 
     * @param str
     * @param sub
     * @return
     */
    private int countSub(String str, String sub)
    {
        String findMe = sub;
        int lengthFindMe = sub.length();

        if (str.length() < lengthFindMe)
            return 0;
        if (str.substring(0, lengthFindMe).equals(findMe))
        {
            str = str.substring(1);
            return 1 + countSub(str, sub);
        } else
        {
            str = str.substring(1);
            return countSub(str, sub);
        }
    }

    public int strDist(String str, String sub)
    {
        String findMe = sub;
        int findMeLength = sub.length(), n2 = 0, n2a = 0, n2b = 0;

        if (str.indexOf(findMe) < 0)
            return 0;
        if (str.indexOf(findMe) == str.lastIndexOf(findMe))
            return findMeLength;
        n2a = str.lastIndexOf(findMe) + findMeLength;
        n2b = str.indexOf(findMe);
        n2 = n2a - n2b;
        if (n2 == str.length())
            return n2;
        str = str.substring(str.indexOf(findMe) + 1);
        strDist(str, sub);

        return n2;
    }

    public int matchUp(String[] a, String[] b)
    {
        int count = 0;
        for (int i = 0; i < a.length; i++)
        {
            if (a[i].length() != 0 && b[i].length() != 0)
            {
                if (a[i].substring(0, 1).equals(b[i].substring(0, 1)))
                {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean dividesSelf(int n)
    {

        String nS = String.valueOf(n);
        int nLength = nS.length();
        ArrayList<Integer> digits = new ArrayList<>();
        for (int i = 0; i <= nLength - 1; i++)
        {

            digits.add(Integer.valueOf(nS.substring(i, i + 1)));
        }
        for (int i = 0; i < digits.size(); i++)
        {
            if (digits.get(i) != 0 && Integer.valueOf(nS) % digits.get(i) == 0)
            {
                continue;
            } else
            {
                return false;
            }
        }
        return true;
    }

    public boolean dividesSelfWrong(int n)
    {
        int tmp = n;
        if (n % 10 == 0)
            return false;
        while (n != 0)
        {
            if (tmp % (n % 10) != 0)
                return false;
            n /= 10;
        }
        return true;
    }

    public int userCompare(String aName, int aId, String bName, int bId)
    {
        if (aName.compareTo(bName) < 0)
        {
            return -1;
        } else if (aName.compareTo(bName) == 0)
        {
            if (aId < bId)
            {
                return -1;
            } else if (aId == bId)
            {
                return 0;
            } else
                return +1;
        } else
            return 1;
    }

    public String[] mergeTwo(String[] a, String[] b, int n)
    {
        String out[] = new String[n];
        int aindex = 0, bindex = 0;
        for (int i = 0; i < n; i++)
        {
            int cmp = a[aindex].compareTo(b[bindex]);
            if (cmp <= 0)
            {
                out[i] = a[aindex++];
                if (cmp == 0)
                    bindex++;
            } else
            {
                out[i] = b[bindex++];
            }
        }
        return out;
    }

    public int commonTwo(String[] a, String[] b)
    {
        int count = 0;
        String str = "";
        for (int i = 0; i < b.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                if (a[j].equals(b[i]) && !str.contains(a[j]))
                {
                    str += a[j];
                    count++;
                }
            }
        }
        return count;
    }

    public int noTeenSum(int a, int b, int c)
    {
        return fixTeen(a) + fixTeen(b) + fixTeen(c);
    }

    public int fixTeen(int teen)
    {
        if (13 <= teen && teen <= 19)
        {
            if (!(teen == 15) && !(teen == 16))
            {
                return 0;
            } else
                return teen;
        }
        return teen;
    }

    public int makeChocolate(int small, int big, int goal)
    {
        int remainder = 0;
        if ((big * 5 + small) < goal)
            return -1;
        while (goal / (big * 5) < 1)
        {
            big--;
            if (big == 0)
                break;
        }
        if (big == 0)
            remainder = goal;
        if (big * 5 < goal)
            remainder = goal - big * 5;
        if (remainder == 0)
            return 0;
        if (remainder / small > 1)
            return -1;
        if (remainder / small == 1)
            return small;
        while ((remainder / small) < 1)
        {
            small--;
            if (remainder / small == 1)
                return small;
        }
        return small;
    }

    public boolean makeBricks(int small, int big, int goal)
    {
        int remainder;
        int bigNeeded;
        if ((small * 1 + big * 5) < goal)
            return false;
        if (big == 0 && small < goal)
        {
            return false;
        } else if (big == 0 && small > goal)
        {
            return true;
        }
        if (goal / (big * 5) == 1)
            return true;
        if (goal / (big * 5) > 1)
        {
            remainder = goal - big * 5;
            if (remainder <= small)
            {
                return true;
            } else
            {
                return false;
            }
        } // At this point big can only be > than goal
        bigNeeded = goal / 5;
        if (small >= (goal - bigNeeded * 5) || small == 0)
            return true;
        return false;
    }

    public String startWord(String str, String word)
    {
        int wordLength = word.length();
        if (str.length() >= wordLength)
        {
            if (str.substring(1, wordLength).equals(word.substring(1)))
            {
                return str.substring(0, wordLength);
            }
        }
        return "";
    }

    public String doubleChar(String str)
    {// Hi-There
        String ans = "";
        int strLength = 2 * str.length();// 18
        int i = 0;
        if (str.length() == 0)
            return str;
        if (strLength > 2)
        {
            while (strLength > 0)
            {// 16
                ans += str.substring(i, i + 1) + str.substring(i, i + 1);
                strLength -= 2;
                i++;
            }
        } else
        {
            ans = str.substring(0, 1) + str.substring(0, 1) + str.substring(1) + str.substring(1);
        }
        return ans;
    }

    public boolean xyzThere(String str)
    {
        if (str.length() < 3)
            return false;
        for (int i = 0; i < str.length() - 2; i++)
        {
            if (str.indexOf("xyz") == 0)
                return true;
            if (str.substring(i, i + 3).equals("xyz") && !str.substring(i - 1, i).equals("."))
            {
                return true;
            }
        }
        return false;
    }

    /**Misson is to eliminate stars plus one character on 
     * either side other then a "*": 
     * so smi**ley ==>smey, but smi*ley==>smey.
     * first eliminate odd cases:str too short, * at 1st or 
     * last character.
     * non-recursive may have taken less code, 
     * but less interesting.
     * @param str
     * @return
     */
    public String starOut(String str)
    {
        if (!str.contains("*"))
            return str;
        if (str.length() < 3)
            return "";
        if (str.indexOf("*") == 0)
            str = str.substring(2);
        if (str.lastIndexOf("*") == str.length() - 1)
            str = str.substring(0, str.lastIndexOf("*") - 1);
        if (str.contains("*") && str.substring(str.indexOf("*"), str.indexOf("*") + 1)
                .equals(str.substring(str.indexOf("*") + 1, str.indexOf("*") + 2)))
        {
            int sequentialStars = countSequentialStars(str, str.indexOf("*"));
            str = str.substring(0, str.indexOf("*") - 1)
                    + str.substring(str.indexOf("*") + sequentialStars+1);
        } else if (str.contains("*"))
        {
            str = str.substring(0, str.indexOf("*") - 1)
                    + str.substring(Math.min(str.length(), str.indexOf("*") + 2));
        }
        str = starOut(str);
        return str;
    }

    private int countSequentialStars(String str, int indxStr1)
    {
        int seqStars = 0;
        int i = indxStr1;
        while (str.substring(i, i + 1).equals("*"))
        {
            seqStars++;
            i++;
        }
        return seqStars;
    }

    public static void main(String[] args)
    {
        // String [] s1 = {"a", "a", "b", "b", "c"};
        // String tgt = "b";
        // String [] s2 = {"b", "b", "b", "x"};
        // int n=3;
        // String [] s3 = {"ax", "bx", "ay", "by", "ai", "aj", "bx", "by"};
        CodingBat cb = new CodingBat();
        // String [] result = cb.firstSwap(s3);
        // System.out.println("Result=: " + Arrays.toString(result));
        // String str1 = "xxHixx";
        // String str2 = "xhixhix";
        // String str3 = "xxxx";
        // String str4 = "hixhhi";
        // String str5 = "((()))";
        // String str6 = "(((x)))";
        // String str7 = "hiHellohihihi";
        // String sub7 = "hih";
        // int n7 = 2;
        // String str8 = "catcowcat";
        // String sub8 ="cow";
        // int n8 = 1;
        // String str9= "iiijjj";
        // String sub9 = "ii";
        // int n9=2;
        // int n10=105;
        // System.out.println("'hi'" + "count "+str3+ " =: " +cb.countHi(str3));
        // int[] nums1 = {11, 2, 3, 4, 11, 5};
        // int index=0;
        System.out.println("starOut(sm***eil*ly) =: " + cb.starOut("sm***eil*ly"));

    }

}
