package HashMap_Heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/*
1. You are required to complete the code of our Hashmap class.
 The theoretical details of required functionality is explained in detail there.
  Implement the functions to achieve what is explained in the theoretical discussion in question video.
2. Input and Output is managed for you.

Sample Input

put India 135
put Aus 5
put Canada 3
display
get China
remove Aus
get Aus
containsKey US
put US 10
put UK 20
remove US
containsKey US
put Pak 80
put China 200
display
put Utopia 0
display
put Nigeria 3
display
put India 138
display
put Sweden 1
display
put finland 20
display
quit

Sample Output

Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@3 .
Bucket3 India@135 Aus@5 .
Display Ends
null
5
null
false
10
false
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 Sweden@1 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Pak@80 finland@20 .
Bucket3 .
Bucket4 Sweden@1 .
Bucket5 .
Bucket6 Canada@3 UK@20 .
Bucket7 India@138 China@200 Nigeria@3 .
Display Ends
 */
public class Write_Hash_Map {
    public static class HashMap<K, V> {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList<HMNode>[] buckets; // N = buckets.length

        public HashMap() {
            initbuckets(4);
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList<>();
            }
        }

        public void put(K key, V value)  {
            int bi = hashFunction(key);
            int di = findInWithBucket(key , bi);
            if(di==-1){
                buckets[bi].add(new  HMNode(key,value));
                size++;

            }else{
                buckets[bi].get(di).value = value;
            }

            double lambda = (size*1.0) / (buckets.length*1.0);
            if(lambda > 2.0){
                resize();
            }
        }

        public void resize(){
            LinkedList<HMNode>[] ol = buckets;
            buckets = new LinkedList[2 * ol.length];

            for(int i = 0 ; i<buckets.length ; i++){
                buckets[i] = new LinkedList<>();
            }


            size =0;
            for(int i =0 ; i<ol.length; i++){
                LinkedList<HMNode> list = ol[i];
                for(int j = 0 ; j<list.size(); j++ ){
                    put(list.get(j).key , list.get(j).value);
                }
            }
        }

        public int hashFunction(K key){
            return Math.abs(key.hashCode())%buckets.length;
        }

        public int findInWithBucket(K key , int bi){
            for(int i =0 ; i <buckets[bi].size() ; i++){
                if(buckets[bi].get(i).key.equals(key)){
                    return i;
                }
            }
            return -1;
        }

        public V get(K key)  {
            // write your code here
            int bi = hashFunction(key);
            int di = findInWithBucket(key , bi);
            if(di==-1){
                return null;

            }else{
               return buckets[bi].get(di).value ;
            }
        }

        public boolean containsKey(K key) {
            // write your code here
            int bi = hashFunction(key);
            int di = findInWithBucket(key , bi);
            if(di==-1){
                return false;

            }else{
                return true;
            }
        }

        public V remove(K key) {
            // write your code here
            int bi = hashFunction(key);
            int di = findInWithBucket(key , bi);
            if(di==-1){
                return null;

            }else{
                size--;
                return buckets[bi].remove(di).value ;
            }
        }

        public ArrayList<K> keyset()  {
            // write your code here
            ArrayList<K> list = new ArrayList<>();

            for(int i = 0 ; i<buckets.length ; i++){
                LinkedList<HMNode> l = buckets[i];
                for(int j = 0 ; i<l.size() ; j++){
                    list.add(l.get(j).key);
                }
            }

            return list;
        }

        public int size() {
            // write your code here
            return size;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node : buckets[bi]) {
                    System.out.print( node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("put")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                Integer val = Integer.parseInt(parts[2]);
                map.put(key, val);
            } else if (str.startsWith("get")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
            } else if (str.startsWith("containsKey")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
            } else if (str.startsWith("remove")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
            } else if (str.startsWith("size")) {
                System.out.println(map.size());
            } else if (str.startsWith("keyset")) {
                System.out.println(map.keyset());
            } else if (str.startsWith("display")) {
                map.display();
            }
            str = br.readLine();
        }
    }
}
