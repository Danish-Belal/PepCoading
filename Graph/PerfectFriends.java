package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
1. You are given a number n (representing the number of students). Each student will have an id
    from 0 to n - 1.

2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space. The numbers are ids of
     students belonging to same club.

4. You have to find in how many ways can we select a pair of students such that both students are
     from different clubs.

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
0 1
2 3
4 5
5 6
4 6

Sample Output
16

 */
public class PerfectFriends {
    public static class Edge{
        int src , nbr;
        Edge(int src , int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // write your code here
        ArrayList<Edge>[] adj = new ArrayList[n];

        for(int i = 0 ;i<n ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0 ; i<k ; i++){
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);

            adj[v1].add(new Edge(v1 , v2));
            adj[v2].add(new Edge(v2 , v1));
        }

        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> friend = new ArrayList<>();

        for(int i = 0 ; i<n ; i++){
            if(visited[i] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                Components(adj , visited ,  i , comp);
                friend.add(comp);
            }
        }
        System.out.println(friend);

        int fsize = 0 ;
        for(int i = 0 ; i<friend.size() ; i++){
            for(int j = i+1 ; j<friend.size() ; j++){
                fsize +=  friend.get(i).size()*friend.get(j).size();
            }

        }

        System.out.println(fsize);


    }
   public static void Components(ArrayList<Edge>[] graph , boolean[] visited , int src , ArrayList<Integer> cpmps){

        visited[src]= true;
        cpmps.add(src);

        for(Edge e : graph[src]){
            if(visited[e.nbr] == false){
                Components(graph , visited , e.nbr , cpmps);
            }
        }

   }

}
