package Data_Structure.Graphs.Representation.AdjMatrix;

class Graph {
    int V; // No of Vertices
    int[][] adjMatrix; // Adacency Matrix

    Graph(int vertices){
        this.V = vertices;
        adjMatrix = new int[V][V];
    }

    void addEdge(int u, int v){
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    void printAdjMatrix(){
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class DriverCode{
    public static void main(String[] args) {
        Graph graph = new Graph(3);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,0);

        graph.printAdjMatrix();
    }
}
