import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Array a1 = new Array();
        System.out.println(a1); //[]
        Array a2 = new Array(5);
        System.out.println(a2); //[]
        String[] A = {"a", "b", "a"};
        Array a3 = new Array(A);
        System.out.println(a3); //a,b,a

        System.out.println(a1.getArray()); //[]

        a1.add("d");
        System.out.println(a1); //d

        a1.add(0,"c");
        System.out.println(a1); //c,d

        System.out.println(a1.getAnElement(0)); //c
        System.out.println(a1.getAnElement(1)); //d
        System.out.println(a1.getAnElement(5)); //out of index

        System.out.println(Arrays.toString(a3.findIndex("a"))); //0,2

        System.out.println(a3.subArray(0,1)); //a

        a3.remove("a");
        System.out.println(a3); //b

        System.out.println(a3.length()); //1

        System.out.println(a3.isEmpty()); //false

        Array a4 = new Array();
        a4.merge(a1, a3);
        System.out.println(a4); //b,c,d
    }
}
