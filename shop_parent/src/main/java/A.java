import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;

public class A {
    static {
        System.out.println("Class A static");
    }
    void show() {
        System.out.println("Class A");
    }
}
class B extends A {
    static {
        System.out.println("Class B static");
    }
    void show() {
        System.out.println("Class B");
    }

    public static void main(String[] args) {
        A a=new A();
        a.show();
        A b=new B();
        b.show();
        int[] arr = {6,3,2,1,7};
        int[] array=  solution(arr);
        System.out.println(5 /3);
        System.out.println(Arrays.toString(array));
    }

    public  static int[] solution(int[] array) {
        for(int i = 0;i<array.length-1;i++){
            for(int j = 0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        return array;
    }


}