package stanford.algorithmsIlluminated1.minimumCut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MinCutSolved {

    public static void main(String[] args) throws FileNotFoundException {
        int n = 200;
        int trial = 1000; //(int) Math.round(n * (n - 1) / 2 * Math.log(n));
        System.out.println("Trial is " + trial);
        int kargerMinCut = 2147483647;
        for (int k = 0; k < trial; k++) {
            System.out.println("In pass " + (k + 1));
            Scanner in = new Scanner(new File("/Users/jonthomas/source/Algorithms/src/main/java/stanford/algorithmsIlluminated1/minimumCut/kargerMinCut.txt"));
            Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
            for (int i = 1; i <= n; i++) {
                String[] line = in.nextLine().split("\\s+");
                List<Integer> ls = new ArrayList<Integer>();
                for (int j = 1; j < line.length; j++)
                    ls.add(Integer.parseInt(line[j]));
                adj.put(i, ls);
            }
            in.close();
            Map<Integer, List<Integer>> testAdj = new HashMap<Integer, List<Integer>>(adj);
            List<int[]> edges = hasEdges(testAdj);
            int randResult = randMinCut(testAdj);
            if (randResult < kargerMinCut) kargerMinCut = randResult;
        }
        System.out.println(kargerMinCut);
    }

    static void mergeVertices(Map<Integer, List<Integer>> graph, int x, int y) {
        while (hasEdge(graph, x, y)) removeEdge(graph, x, y);
        List<Integer> yEdges = new ArrayList<Integer>(graph.get(y));
        Iterator<Integer> yEdgeIterator = yEdges.iterator();
        while (yEdgeIterator.hasNext()) {
            int z = yEdgeIterator.next();
            addEdge(graph, x, z);
            removeEdge(graph, y, z);
        }
        if (graph.get(y).size() == 0)
            graph.remove(y);
    }

    static boolean hasEdge(Map<Integer, List<Integer>> graph, int x, int y) {
        return graph.get(x).contains(y);
    }

    static void addEdge(Map<Integer, List<Integer>> graph, int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    static void removeEdge(Map<Integer, List<Integer>> graph, int x, int y) {
        Iterator<Integer> it = graph.get(x).iterator();
        while (it.hasNext()) {
            if (it.next() == y) {
                it.remove();
                break;
            }
        }
        it = graph.get(y).iterator();
        while (it.hasNext()) {
            if (it.next() == x) {
                it.remove();
                return;
            }
        }
    }

    static List<int[]> hasEdges(Map<Integer, List<Integer>> graph) {
        List<int[]> res = new ArrayList<int[]>();
        Set<Integer> vertices = graph.keySet();
        Iterator<Integer> startPointIterator = vertices.iterator();
        while (startPointIterator.hasNext()) {
            int startPoint = startPointIterator.next();
            List<Integer> endPoints = graph.get(startPoint);
            Iterator<Integer> endPointIterator = endPoints.iterator();
            while (endPointIterator.hasNext()) {
                int endPoint = endPointIterator.next();
                if (endPoint <= startPoint) continue;
                int[] edge = new int[2];
                edge[0] = startPoint;
                edge[1] = endPoint;
                res.add(edge);
            }
        }
        return res;
    }

    static int randMinCut(Map<Integer, List<Integer>> graph) {
        while (graph.size() > 2) {
            List<int[]> edges = hasEdges(graph);
            Random random = new Random();
            int randInd = random.nextInt(edges.size());
            int[] twoEnds = edges.get(randInd);
            mergeVertices(graph, twoEnds[0], twoEnds[1]);
        }
        Set<Integer> keys = graph.keySet();
        int key = keys.iterator().next();
        return graph.get(key).size();
    }
}
