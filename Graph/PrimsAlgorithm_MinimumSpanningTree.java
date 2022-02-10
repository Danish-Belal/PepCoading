package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/*
1. You are given a graph and a source vertex. The vertices represent computers and the edges

     represent length of LAN wire required to connect them.

2. You are required to find the minimum length of wire required to connect all PCs over a network.

     Print the output in terms of which all PCs need to be connected, and the length of wire between

     them.



Note -> For output, check the sample output and question video.
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
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
Sample Output
[1-0@10]
[2-1@10]
[3-2@10]
[4-3@2]
[5-4@3]
[6-5@3]


Find the small egde weight among neighbour.
 */
public class PrimsAlgorithm_MinimumSpanningTree {
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

    public static class Pair implements Comparable<Pair>{
        int vrtx ;
        int parent;
        int weight;

        public Pair(int v , int parent , int w){
            this.vrtx = v;
            this.parent = parent;
            this.weight = w;

        }

        public int compareTo(Pair o1){
            return this.weight-o1.weight;
        }
    }

    public static <PrioirtyQueue> void main(String[] args) throws Exception {
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

        int sr = 0;
        boolean[] visited = new boolean[vtces];

        PriorityQueue<Pair> Q = new PriorityQueue<>();
        Q.add(new Pair(sr , -1 , 0));

        while(Q.size() !=0){
            Pair rn = Q.remove();
            if(!visited[rn.vrtx]){
                visited[rn.vrtx] = true;
                if(rn.vrtx != 0) {
                    System.out.println("[" + rn.vrtx + " - " + rn.parent + "@" + rn.weight + "]");
                }
                for(Edge e : graph[rn.vrtx]){
                    if(!visited[e.nbr]){
                        Q.add(new Pair(e.nbr ,rn.vrtx , e.wt ));
                    }
                }





            }
        }
    }

}
