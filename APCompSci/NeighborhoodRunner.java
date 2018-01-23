/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class NeighborhoodRunner {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Person armance = new Person("Armance",20);
        Person eugenie = new Person("Eugenie",25);
        Person veronique = new Person("Veronique",60);
        Person marc = new Person("Marc",61);
        
        Person phillip = new Person("Phillip",28);
        Person kathy = new Person("Kathy",30);
        Person wuschi = new Person("Wuschi",63);
        Person gabriel = new Person("Armance",64);
        
        Person stan = new Person("Stan", 59);
        Person katerina = new Person("Katerina", 57);
        
        Family sherman = new Family(marc, "Sherman");
        sherman.add(veronique);
        sherman.add(eugenie);
        sherman.add(armance);
        
        Family acuna = new Family(gabriel, "Acuna");
        acuna.add(wuschi);
        acuna.add(kathy);
        acuna.add(phillip);
        
        for(Person a : sherman.getAdults())
            System.out.println(a);
        System.out.println();
        
        
        System.out.println(sherman.isInFamily(katerina));
        System.out.println(sherman.isInFamily(armance));
        System.out.println();
        
        Neighborhood southbay = new Neighborhood();
        southbay.addFamily(sherman);
        southbay.addFamily(acuna);
        
        System.out.println(southbay.isInNeighborhood(stan));
        System.out.println(southbay.isInNeighborhood(phillip));

    }

}
