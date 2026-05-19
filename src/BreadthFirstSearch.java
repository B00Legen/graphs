import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(UnweightedGraph<V> graph, V source) {
        super(source);

        bfs(graph, source);
    }

    private void bfs(UnweightedGraph<V> graph, V a) {
        Vertex<V> current = graph.getVertex(a);
        marked.add(a);

        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(current); //[0]

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.remove(); // []

            for (Vertex<V> vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex.getData())) {
                    marked.add(vertex.getData());
                    edgeTo.put(vertex.getData(), v.getData()); // {[1,0] [2,0] [3,0] [4 0] [5 1] [6 1] [7 2]}
                    queue.add(vertex); // [1,2,3,4]
                }
            }
        }
    }
}
