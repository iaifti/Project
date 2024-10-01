//Tashnim Khan Ishika


import java.io.*;
import java.net.URL;
import java.util.*;

class ShortPathFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the URL: ");
        String fileName = scanner.nextLine();
        Graph graph = readGraphFromFile(fileName);

        if (graph == null) {
            System.out.println("Invalid file or file format.");
            return;
        }

        System.out.println("Enter the number of vertices: " + graph.vertices);

        System.out.println("Enter the Vertices:");
        for (int i = 0; i < graph.vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Graph.Edge edge : graph.adjacencyList.get(i)) {
                System.out.print("(" + i + "," + edge.destination + "," + edge.weight + ") ");
            }
            System.out.println();
        }

        System.out.print("Enter the start vertex: ");
        int startVertex = scanner.nextInt();
        System.out.print("Enter the end vertex: ");
        int endVertex = scanner.nextInt();

        List<Integer> shortestPath = graph.dijkstra(startVertex, endVertex);
        if (shortestPath.isEmpty()) {
            System.out.println("No path found.");
        } else {
            System.out.print("Shortest path from " + startVertex + " to " + endVertex + ": ");
            for (int vertex : shortestPath) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }

    private static Graph readGraphFromFile(String fileUrl) {
        try (Scanner scanner = new Scanner(new URL(fileUrl).openStream())) {
            int vertices = Integer.parseInt(scanner.nextLine().trim());
            Graph graph = new Graph(vertices);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] edges = line.split("\\|");
                for (String edge : edges) {
                    String[] parts = edge.trim().split("\\s*,\\s*");
                    int u = Integer.parseInt(parts[0]);
                    int v = Integer.parseInt(parts[1]);
                    int weight = Integer.parseInt(parts[2]);
                    graph.addEdge(u, v, weight);
                }
            }

            return graph;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Graph {
    public final int vertices;
    public final Map<Integer, List<Edge>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjacencyList.get(u).add(new Edge(v, weight));
        adjacencyList.get(v).add(new Edge(u, weight));
    }

    public List<Integer> dijkstra(int start, int end) {
        int[] prev = new int[vertices];
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(v -> distances[v]));
        pq.offer(start);

        while (!pq.isEmpty()) {
            int currVertex = pq.poll();

            for (Edge neighbor : adjacencyList.get(currVertex)) {
                int nextVertex = neighbor.destination;
                int newDistance = distances[currVertex] + neighbor.weight;

                if (newDistance < distances[nextVertex]) {
                    distances[nextVertex] = newDistance;
                    prev[nextVertex] = currVertex;
                    pq.offer(nextVertex);
                }
            }
        }

        List<Integer> shortestPath = new ArrayList<>();
        for (int at = end; at != start; at = prev[at]) {
            shortestPath.add(at);
        }
        shortestPath.add(start);
        Collections.reverse(shortestPath);
        return shortestPath;
    }

    public static class Edge {
        public int destination;
        public int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
