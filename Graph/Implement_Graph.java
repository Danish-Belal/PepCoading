package Graph;

import java.util.ArrayList;

public class Implement_Graph {
    public static class pair{
        int src;
        int nbr;
        int wt;
        public pair(int src , int nbr , int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void print(ArrayList<pair>[] graph){

        for(int i = 0 ; i<graph.length ; i++){
            ArrayList<pair> l = graph[i];
            for(int j = 0 ; j<l.size() ; j++){
                pair p = l.get(j);
                System.out.println(p.src+" -> "+p.nbr+" "+ p.wt);
            }
            System.out.println();
        }

    }
    public static void main(String[] args){
        ArrayList<pair>[] graph = new ArrayList[7];

        for(int i = 0 ; i<graph.length ; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new pair( 0 , 1,10));
        graph[0].add(new pair( 0 , 3,40));

        graph[1].add(new pair( 1 , 0,10));
        graph[1].add(new pair( 1 , 2,10));

        graph[2].add(new pair( 2 , 1,10));
        graph[2].add(new pair( 2 , 3,10));

        graph[3].add(new pair( 3 , 0,40));
        graph[3].add(new pair( 3 , 2,10));
        graph[3].add(new pair( 3 , 4,3));

        graph[4].add(new pair( 4 , 3,3));
        graph[4].add(new pair( 4 , 5,2));
        graph[4].add(new pair( 4 , 6,7));

        graph[5].add(new pair( 5 , 4,2));
        graph[5].add(new pair( 5 , 6,3));

        graph[6].add(new pair( 6 , 4,7));
        graph[6].add(new pair( 6 , 5,3));

        print(graph);
    }
}
