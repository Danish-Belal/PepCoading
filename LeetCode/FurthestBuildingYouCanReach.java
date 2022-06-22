package LeetCode;

public class FurthestBuildingYouCanReach {
    public static void main(String[] args){
        int[] h = {4,12,2,7,3,18,20,3,19};
        System.out.println(furthestBuilding(h , 10,2));

    }
    public static int furthestBuilding(int[] h, int bricks, int ladders) {

        for(int i =0 ; i<h.length-1 ; i++){
            if(h[i] < h[i+1]){
                if( bricks >= h[i+1]-h[i]){
                    bricks -= (h[i+1]-h[i]);
                }else if(ladders > 0){
                    ladders--;
                }else {
                    return i;
                }
            }
        }
        return h.length-1;
    }
}
