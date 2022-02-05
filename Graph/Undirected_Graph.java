package Graph;

// Undirected Graph without Weigth.
// Undirected graph have both side traversal power.

import java.util.ArrayList;

public class Undirected_Graph {
    public static void main(String[] args){
        int n =3 ,m = 3;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i = 0 ;i<=n ; i++){
            adj.add(new ArrayList<>());
        }

        // edge 1-->2.
        adj.get(1).add(2);
        adj.get(2).add(1);

        // edge 2-->3.
        adj.get(2).add(3);
        adj.get(3).add(2);

        // edge 1-->3.
        adj.get(1).add(3);
        adj.get(3).add(1);


        /*
        adj.add(u).add(v);
        adj.add(v).add(u);

         */

        for(int i = 1 ; i<n ; i++){
            for(int j = 0 ; j <adj.get(i).size() ; j++){
                System.out.println(adj.get(i).get(j)+ " ");
            }
            System.out.println();
        }

    }
}
