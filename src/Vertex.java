import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
    }

    public V getData() {
        return data;
    }

    public void addAdjacentVertices(Vertex<V> dest, double weight) {
        adjacentVertices.put(dest, weight);
    }

    public boolean isAdjacent(Vertex<V> dest) {
        return (adjacentVertices.get(dest) != null);
    }

    public Double getDist(Vertex<V> dest) {
        return adjacentVertices.get(dest);
    }

    public void removeVertex(Vertex<V> dest) {
        if (!isAdjacent(dest))
            return;
        adjacentVertices.remove(dest);
    }

    public List<Vertex<V>> adjacencyList() {
        Set<Vertex<V>> res = adjacentVertices.keySet();
        List<Vertex<V>> list = new ArrayList<>(res);
        return list;
    }

    public int size() {
        return adjacentVertices.size();
    }
}
