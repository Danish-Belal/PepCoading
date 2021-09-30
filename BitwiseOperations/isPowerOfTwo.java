package BitwiseOperations;

import javax.imageio.plugins.tiff.TIFFImageReadParam;

public class isPowerOfTwo {
    public static boolean isPower2(int n){
        if(n <= 0) return false;
        int ands =   (n & n-1);
        return ands== 0 ? true : false;

    }
    public static void main(String[] args) {
        System.out.println(isPower2(0));

    }
}
