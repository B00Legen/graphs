import java.util.List;

public class WeightedGraph<V> {
    protected boolean undirected;
    protected Vertex<V>[] graph;
    protected int size = 0, cap = 1;

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        this.graph = (Vertex<V>[]) new Vertex[1];
    }

    public Vertex<V> getVertex(V a) {
        for (int i = 0; i < size; i++) if (graph[i].getData() == a) return graph[i];
        return null;
    }

    public void addVertex(Vertex<V> v) {
        if (hasVertex(v))
            return;

        if (size == cap) {
            cap *= 2;
            Vertex<V>[] temp = (Vertex<V>[]) new Vertex[cap];
            if (size >= 0) System.arraycopy(graph, 0, temp, 0, size);
            graph = temp;
        }
        graph[size++] = v;
    }

    public void addEdge(V a, V b, double weight) {
        if (a == b) return;

        Vertex<V> source = getVertex(a), dest = getVertex(b);

        if (source == null || dest == null) return;

        if (hasEdge(source, dest)) return;

        source.addAdjacentVertices(dest, weight);

        if (undirected) dest.addAdjacentVertices(source, weight);
    }

    public void removeEdge(V a, V b) {
        if (a == b) return;

        Vertex<V> source = getVertex(a), dest = getVertex(b);

        if (source == null || dest == null) return;

        if (!hasEdge(source, dest)) return;

        source.removeVertex(dest);

        if (undirected) dest.removeVertex(source);
    }

    public int getVerticesCount() {
        return size;
    }

    public int getEdgesCount() {
        int count = 0;
        for (int i = 0; i < size; i++) count += graph[i].size();

        if (undirected) count /= 2;

        return count;
    }

    public boolean hasVertex(V v) {
        return getVertex(v) != null;
    }

    public boolean hasVertex(Vertex<V> v) {
        for (int i = 0; i < size; i++) {
            if (graph[i] == v)
                return true;
        }
        return false;
    }

    public boolean hasEdge(V a, V b) {
        if (a == b)
            return false;

        Vertex<V> source = getVertex(a), dest = getVertex(b);

        if (source == null || dest == null)
            return false;

        return hasEdge(source, dest);
    }

    public boolean hasEdge(Vertex<V> source, Vertex<V> dest) {
        return source.isAdjacent(dest);
    }

    public List<Vertex<V>> adjacencyList(Vertex<V> v) {
        for (int i = 0; i < size; i++) {
            if (graph[i] == v) {
                return graph[i].adjacencyList();
            }
        }
        return null;
    }
}
