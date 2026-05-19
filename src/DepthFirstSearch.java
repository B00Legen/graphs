public class DepthFirstSearch<V> extends Search<V> {
    public DepthFirstSearch(UnweightedGraph<V> graph, V source) {
        super(source);

        dfs(graph, source);
    }

    private void dfs(UnweightedGraph<V> graph, V a) {
        Vertex<V> current = graph.getVertex(a);
        marked.add(a);

        for (Vertex<V> v : graph.adjacencyList(current)) {
            if (!marked.contains(v.getData())) {
                edgeTo.put(v.getData(), current.getData());
                dfs(graph, v.getData());
            }
        }
    }
}
