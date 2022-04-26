package LeetCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
https://leetcode.com/problems/min-cost-to-connect-all-points/
You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj]
        is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 */

public class MinCost_Prims {
    public int minCostConnectPoints(int[][] points) {

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[2]-b[2]));

        int cost = 0;
        Set<Integer> visited = new HashSet<>();

        pq.offer(new int[]{0,0,0});

        int num = points.length;
        while(pq.size() > 0 && visited.size()<num){
            int[] curr = pq.poll();
            int endid = curr[1];
            int currCost = curr[2];

            if(visited.contains(endid)) continue;

            cost += currCost;

            visited.add(endid);



            for(int i = 0 ; i<num; i++){
                if(!visited.contains(i)){
                    pq.offer(new int[]{endid , i ,distance(points , endid , i)});
                }
            }
        }
        return cost;
    }
    private int distance(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}
