package IntroductionToJavaProgramming.chapter28_hashing;

public class TestMyHashMap {

    public static void main(String[] args){
        Map<String, Integer> map = new HashMap<>();
        map.put("Ali", 56);
        map.put("Hoda", 50);
        map.put("Asmaa", 27);
        map.put("Ibrahim", 23);
        map.put("Hagar", 17);
        map.put("Rokya", 10);

        System.out.println("Entries in map: " + map);

        System.out.println("The age for Hagar is: " +
                map.get("Hagar"));

        System.out.println("Is Ali in the map ? " + map.containsKey("Ali"));

        System.out.println("Is age 27 in the map ? " + map.containsValue(27));

        map.remove("Hagar");
        System.out.println("Entries in map: " + map);

        map.clear();
        System.out.println("Entries in map: " + map);
    }
}
