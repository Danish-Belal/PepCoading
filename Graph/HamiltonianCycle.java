package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
1. A Hamiltonian path, is a path in an undirected or directed graph that visits each vertex exactly

     once.

2. Given an undirected graph  the task is to check if a Hamiltonian path is present in it or not.
Constraints

1&lt;=N&lt;=10

1&lt;=M&lt;=15

Format
Input

First line consists of two space separated integers N and M denoting the number of vertices and number of edges.

Second line contains 2*M space separated integers denoting the edge from 2*i th element to 2*i+1 th element.
Output

Print the boolean value.
Example

Sample Input

7
9
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2 5 10
0
Sample Output

true
 */
public class HamiltonianCycle {

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

        int src = Integer.parseInt(br.readLine());

        // write all your codes here
        boolean[] visited = new boolean[vtces];
        hamiltonianPath(graph , src , visited , "" , 0 , src );

    }

    static void hamiltonianPath(ArrayList<Edge>[] graph , int src , boolean[] visited , String psf , int count, int osrc){

        if(count == graph.length-1){

            boolean neg = false;
            for(Edge e : graph[src]){
                if(e.nbr == osrc){
                    neg = true;
                    break;
                }
            }

            if(neg){
                System.out.println(psf+"*");
                return;
            }
            System.out.println(psf+".");
        }

        visited[src] = true;
        for(Edge e : graph[src]){
            if(visited[e.nbr] == false){
                hamiltonianPath(graph , e.nbr , visited , psf+e.src , count+1 , osrc );
            }
        }
        visited[src] = false;
    }


}
