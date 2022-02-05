package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
1. You are given a graph, a src vertex and a destination vertex.
2. You are required to find if a path exists between src and dest. If it does, print true
     otherwise print false.
 Inputs
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
0
6

Output
true
 */
public class HasPath {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static boolean isPathExist(ArrayList<Edge>[] graph , int src , int dest , boolean[] visited){
        if(src == dest){
            return true;
        }
        visited[src] = true;
        for(Edge e : graph[src]){
            if(visited[e.nbr] == false)
                return isPathExist(graph , e.nbr , dest , visited);
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0; i < vtces; i++){
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for(int i = 0; i < edges; i++){
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        // write your code here
        boolean[] ispath = new boolean[vtces];
        boolean ans = isPathExist(graph , src , dest , ispath);
        System.out.println(ans);
    }
}
