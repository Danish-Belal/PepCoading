package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

/*
1. You are given a graph.

2. You are required to find and print if the graph is bipartite



Note -> A graph is called bipartite if it is possible to split it's vertices in two sets of mutually

               exclusive and exhaustive vertices such that all edges are across sets.
Constraints

None
Format
Input

Input has been managed for you
Output

true if the graph is bipartite, false otherwise
Example

Sample Input

7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10

Sample Output
false


 */
public class IsGraphBipartite {

    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair{
        int vertx;
        int level;

        Pair(int src , int l){
            this.vertx = src;
            this.level = l;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        // write your code here
        HashMap<Integer , Integer> visited = new HashMap<>();

        for(int i = 0 ;i<vtces ; i++){
            if(visited.containsKey(i) == false){
                boolean ans = isBia(graph , i , visited);
                if(!ans){
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(true);
    }

    static boolean isBia(ArrayList<Edge>[] graph , int src , HashMap<Integer , Integer> visited){

        Queue<Pair> Q = new ArrayDeque<>();
        Q.add(new Pair(src , 0));

        while(Q.size() !=0){
            Pair rn = Q.remove();
            if(visited.containsKey(rn.vertx)){
                if(visited.get(rn.vertx) != rn.level) return false;

            }else{
                visited.put(rn.vertx , rn.level);
                for(Edge e : graph[rn.vertx]){
                    if(!visited.containsKey(e.nbr))
                        Q.add(new Pair(e.nbr , rn.level+1));
                }
            }

        }
        return true;
    }
}
