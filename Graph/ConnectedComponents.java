package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
1. You are given a graph.

2. You are required to find and print all connected components of the graph.
Constraints

None
Format
Input

Input has been managed for you
Output
Check the sample output
Example

Sample Input

7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10

Sample Output

[[0, 1], [2, 3], [4, 5, 6]]
 */
public class ConnectedComponents {

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

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        // write your code here
        boolean[] visited = new boolean[vtces];

        for(int i = 0 ; i<visited.length ; i++){
            if(!visited[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                getComponenet(graph, i, visited, comp);
                comps.add(comp);
            }
        }

        System.out.println(comps);
    }

    static void getComponenet(ArrayList<Edge>[] graph , int src , boolean[] visited , ArrayList<Integer> comp){

        visited[src] = true;
        comp.add(src);

        for(Edge e : graph[src]){
            if(!visited[e.nbr]){
                getComponenet(graph , e.nbr , visited , comp);
            }
        }
    }

}
