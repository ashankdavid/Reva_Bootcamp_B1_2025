package Data_Structure.Graphs.Representation.AdjList;

import java.util.ArrayList;
import java.util.Scanner;

class Graph {
    ArrayList<ArrayList<Integer>> adjList;

    Graph(int n){
        adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, boolean direction){
        // direction = false -> undirected;
        // direction = true -> directed;

        adjList.get(u).add(v); // add edge from u to v

        if(!direction){
            adjList.get(v).add(u);
        }
    }

    void printAdjList(){
        for(int i=0; i<adjList.size(); i++){
            System.out.print(i + "->");
            for(int neighbour : adjList.get(i)){
                System.out.print(neighbour + ", ");
            }
            System.out.println();
        }
    }
}

class DriverCode{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the num of Node: ");
        int n = sc.nextInt();

        System.out.println("Enter the Edges: ");
        int m = sc.nextInt();

        Graph g = new Graph(n);

        System.out.println("Enter the Edges u and v: ");
        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            g.addEdge(u, v, false);
        }
        g.printAdjList();
    }
}
