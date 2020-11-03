package graph;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class t133 {
//    private Map<Node, Node> visited = new HashMap<>();
//    public Node cloneGraph(Node node) {
//        if(node == null) return null;
//        if(visited.containsKey(node)) return visited.get(node);
//        Node cloneNode = new Node(node.val);
//        visited.put(node, cloneNode);
//        for(Node n: node.neighbors){
//            cloneNode.neighbors.add(cloneGraph(n));
//        }
//        return cloneNode;
//    }
    private int[] marked = new int[101];
    public Node cloneGraph(Node node){
        if(node == null) return null;
        Node cloneNode = new Node(node.val);
        Queue<Node> origin = new LinkedList<>();
        Queue<Node> copy = new LinkedList<>();
        for(Node n : node.neighbors){
            origin.add(n);
        }
        copy.add(cloneNode);
        Node prev;
        while(!origin.isEmpty()){
            Node old = origin.remove();
            for(Node n : old.neighbors){
                origin.add(n);
            }
            Node clone = new Node(old.val);
            prev = copy.remove();
            prev.neighbors.add(clone);
            copy.add(clone);
        }
        return cloneNode;
    }
}
