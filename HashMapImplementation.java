import java.util.*;
public class HashMapImplementation {
    static class HashMap<K,V>{
        private class Node{
            K key;
            V value;
            public Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }
        private int n;
        private int N;
        private LinkedList<Node> buckets[];
        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N=4;
            this.buckets=new LinkedList[4];
            for(int i=0;i<4;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }
        private int hashFunction(K key){
            int hc=key.hashCode();
            return Math.abs(hc)%N;
        }
        private int searchInLL(K key,int Bi){
            LinkedList<Node> ll=buckets[Bi];
            int di=0;
            for(int i=0;i<ll.size();i++){
                Node node=ll.get(i);
                if(node.key==key){
                    return di;
                }
                di++;
            }
            return -1;
        }
        @SuppressWarnings("unchecked")
        public void rehash(){
            LinkedList<Node> oldBuck[]=buckets;
            buckets=new LinkedList[N*2];
            N=2*N;
            for(int i=0;i<buckets.length;i++){
                buckets[i]=new LinkedList<>();
            }
            //nodes-> adds in bucket
            for(int i=0;i<oldBuck.length;i++){
                LinkedList<Node> ll=oldBuck[i];
                for(int j=0;j<ll.size();j++){
                    Node node=ll.get(j);
                    put(node.key,node.value);
                } 
            }
        }
        public void put(K key,V value){
            int Bi=hashFunction(key);
            int di=searchInLL(key,Bi);
            if(di!=-1){
                Node node=buckets[Bi].get(di);
                node.value=value;
            }else{
                buckets[Bi].add(new Node(key,value));
                n++;
            }
            double lambda=(double)n/N;
            if(lambda>2.0){
                rehash();
            }
        }
        public boolean containsKey(K key){
            int Bi=hashFunction(key);
            int di=searchInLL(key,Bi);
            if(di!=-1){
                return true;
            }else{
                return false;
            }
        }
        public V remove(K key){
            int Bi=hashFunction(key);
            int di=searchInLL(key,Bi);
            if(di!=-1){
                Node node=buckets[Bi].remove(di);
                return node.value;
            }else{
                return null;
            }
        }
        public V get(K key){
            int Bi=hashFunction(key);
            int di=searchInLL(key,Bi);
            if(di!=-1){
                Node node=buckets[Bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys=new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll=buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n==0;
        }
    }
    public static void main(String[] args) {
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("India",100);
        hm.put("US",50);
        hm.put("Russia",150);
        hm.put("Nepal",30);
        ArrayList<String> keys=hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println(hm.get("India"));
    }
}
