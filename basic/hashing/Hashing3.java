package hashing;

//character hashing
public class Hashing3 {
    public static void main(String[] args) {
        String str = "zaszsazdszxdsAABBDDCC";
        function(str);
    }

    private static void function(String str) {
        //precompute
        int[] hashCount = new int[256];
        for(int i = 0; i < str.length(); i++) {
            hashCount[str.charAt(i)] += 1;
        }

        //fetch
        for(int i = 0; i < str.length(); i++) {
            System.out.println(" "+str.charAt(i)+" occurence in str is "+hashCount[str.charAt(i)]);
        }
    }
}
