package APCompSciProblems;


/**
 * @author MarcSherman
 *
 */
public class Coin {
    private String country;
    private int year;
    private int type;
    
    public Coin(String cCountry, int cYear, int cType) {
        country= cCountry;
        year = cYear;
        type = cType;
    }
    
    public static Coin[] createCoinArrayUS() {
        Coin us1 = new Coin("US", 1936, 3);
        Coin us2 = new Coin("US", 1939, 2);
        Coin us3 = new Coin("US", 1940, 1);
        Coin us4 = new Coin("US", 1940, 1);
        Coin us5 = new Coin("US", 1941, 4);
        Coin us6 = new Coin("US", 1942, 5);
        Coin us7 = new Coin("US", 1942, 6);
        Coin us8 = new Coin("US", 1945, 3);
        Coin us9 = new Coin("US", 1947, 4);
        Coin[] US = {us1,us2, us3, us4, us5, us6, us7, us8, us9};
        return US;
    }
    
    public static Coin[] createCoinArrayFR() {
        Coin fr1 = new Coin("FR", 1935, 4);
        Coin fr2 = new Coin("FR", 1938, 3);
        Coin fr3 = new Coin("FR", 1939, 6);
        Coin fr4 = new Coin("FR", 1939, 6);
        Coin fr5 = new Coin("FR", 1940, 5);
        Coin fr6 = new Coin("FR", 1941, 1);
        Coin fr7 = new Coin("FR", 1942, 2);
        Coin fr8 = new Coin("FR", 1942, 3);
        Coin fr9 = new Coin("FR", 1947, 4);
        Coin fr10 = new Coin("FR", 1948, 3);
        Coin fr11 = new Coin("FR", 1949, 1);
        Coin[] FR = {fr1,fr2, fr3, fr4, fr5, 
                fr6, fr7, fr8, fr9, fr10, fr11};
        return FR;
    }

    /**
     * @return the String coin country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return the integer coin year
     */
    public int getYear() {
        return year;
    }

    /**
     * @return the integer coin type
     */
    public int getCoinType() {
        return type;
    }
    
    public String toString() {
        return "Country: " + getCountry() + " Year: " + getYear() + " CoinType: " + getCoinType();
    }
    
}//End Coin class
