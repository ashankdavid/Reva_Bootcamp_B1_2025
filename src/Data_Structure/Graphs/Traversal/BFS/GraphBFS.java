package Data_Structure.Graphs.Traversal.BFS;

import java.util.*;

public class GraphBFS {
    private int V;

    public GraphBFS(int v) {
        this.V = v;
    }

    public List<Integer> bfsTraversal(List<List<Integer>> adjList) {
        boolean[] visited = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(0); // Start from vertex 0
        visited[0] = true;

        while (!q.isEmpty()) {
            int front = q.poll();
            ans.add(front);

            for (int neighbour : adjList.get(front)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }

        return ans;
    }
}

class DriverCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Vertices and Edges: ");
        int v = sc.nextInt();
        int e = sc.nextInt();

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        GraphBFS g = new GraphBFS(v);

        for (int i = 1; i <= e; i++) {
            System.out.print("Enter Edge " + i + ": ");
            int u = sc.nextInt();
            int vertex = sc.nextInt();
            adjList.get(u).add(vertex);
        }

        List<Integer> result = g.bfsTraversal(adjList);
        System.out.println("The BFS Traversal is: ");
        for (int i : result) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}


