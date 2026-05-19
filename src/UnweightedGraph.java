public class UnweightedGraph<V> extends WeightedGraph<V> {
    public UnweightedGraph() {
        this(true);
    }

    public UnweightedGraph(boolean undirected) {
        this.undirected = undirected;
        this.graph = (Vertex<V>[]) new Vertex[1];
    }

    public void addEdge(V a, V b) {
        super.addEdge(a, b, 1);
    }

    public void addEdge(V a, V b, double weight) {
        super.addEdge(a, b, 1);
    }
}
