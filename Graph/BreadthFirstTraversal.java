package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

/*
1. You are given a graph, and a src vertex.

2. You are required to do a breadth first traversal and print which vertex is reached via which path,
         starting from the src.



Note -> for output, check the sample output and question video.
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
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2

Sample Output
2@2
1@21
3@23
0@210
4@234
5@2345
6@2346

 */
public class BreadthFirstTraversal {

    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class pair{
        int v ;
        String psf;
        pair(int src , String psf){
            this.v = src;
            this.psf = psf;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        // write your code here
        boolean[] visited = new boolean[vtces];
        bsf(graph , src);
    }
    static void bsf(ArrayList<Edge>[] graph , int src ){

        boolean[] visited = new boolean[graph.length];

        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(src, ""+src));

        while(q.size() !=0){
            pair rn = q.remove();
           if(!visited[rn.v]){
               visited[rn.v] = true;
               System.out.println(rn.v+"@"+rn.psf);
               for(Edge e : graph[rn.v]){
                   if(!visited[e.nbr]){
                       q.add(new pair(e.nbr , rn.psf+e.nbr));
                   }
               }
           }
        }


    }

}
