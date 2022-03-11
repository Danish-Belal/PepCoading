package Graph;
import java.util.*;
import java.lang.*;
import java.io.*;
//public class M_Coloring {
//
//    }

    // { Driver Code Starts

    class M_Coloring {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int tc = scan.nextInt();

            while (tc-- > 0) {
                int V = scan.nextInt();
                int C = scan.nextInt();
                int E = scan.nextInt();

                List<Integer>[] G = new ArrayList[V];
                for (int i = 0; i < V; i++) {
                    G[i] = new ArrayList<>();
                }

                for (int i = 0; i < E; i++) {
                    int u = scan.nextInt() - 1;
                    int v = scan.nextInt() - 1;
                    G[u].add(v);
                    G[v].add(u);
                }
                int[] color = new int[V];

                System.out.println(new solve().graphColoring(G, color, 0, C) ? 1 : 0);
            }
        }
    }
// } Driver Code Ends


    class solve
    {
        //Function to determine if graph can be coloured with at most M colours such
        //that no two adjacent vertices of graph are coloured with same colour.
        static boolean isSafe(int node ,List<Integer>[] G, int[] color, int n , int col){
            for(int ct : G[node]){
                if(color[ct] == col)return false;
            }
            return true;

        }
        static boolean solve(int node ,List<Integer>[] G, int[] color,  int n , int m ){
            if(node == n) return true;

            for(int i=1 ; i<=m ; i++){
                if(isSafe(node , G, color ,n , i)){
                    color[node] = i;
                    if(solve(node + 1, G, color, n, m)) return true;
                    color[node] =  0;
                }
            }
            return false;

        }
        public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m)
        {
            // Your code here
            int n = G.length;
            if(solve(0, G, color, n, m)) return true;
            return false;
        }
    }

