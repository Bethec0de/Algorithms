package stanford.algorithmsIlluminated1.minimumCut;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


/**
 * The file contains the adjacency list representation of a simple undirected graph.
 * There are 200 vertices labeled 1 to 200. The first column in the file represents the vertex label,
 * and the particular row (other entries except the first column) tells all the vertices that the vertex is adjacent to.
 * So for example, the  row looks like : "6 155 56 52 120 ......".
 * This just means that the vertex with label 6 is adjacent to (i.e., shares an edge with) the vertices with labels 155,56,52,120,......,etc
 *
 * Your task is to code up and run the randomized contraction algorithm for the min cut problem and use it on the above graph
 * to compute the min cut. (HINT: Note that you'll have to figure out an implementation of edge contractions.
 * Initially, you might want to do this naively, creating a new graph from the old every time there's an edge contraction.
 * But you should also think about more efficient implementations.)
 * (WARNING: As per the video lectures, please make sure to run the algorithm many times with different random seeds,
 * and remember the smallest cut that you ever find.) Write your numeric answer in the space provided.
 * So e.g., if your answer is 5, just type 5 in the space provided.
 */
public class MinimunCut {


    private int getRandomVertex(HashMap adjacencyList){
        Random generator = new Random();
        generator.setSeed(0);
        int randomIndex = Integer.MIN_VALUE;
        randomIndex = generator.nextInt(adjacencyList.size());
        return randomIndex;
    }

    public int determineMinimumCut(HashMap adjacencyList){
        int finalMinimunCut = Integer.MIN_VALUE;
        int vertexCount = adjacencyList.size();
        int currentEdge = 0;
        // Run a large numberof times
        for(int i = 0; i < 10000; i++){
            //  while there are more than 2 vertices:
            while(vertexCount >= 2){
                //      pick a remaining edge (random)
                currentEdge  = getRandomVertex(adjacencyList);
                Map<Integer, List<Integer>> testAdj = new HashMap<Integer, List<Integer>>(adjacencyList);
                List<int[]> edges = hasEdges(testAdj);
                int randResult = randMinCut(testAdj);
                if (randResult < finalMinimunCut){
                    finalMinimunCut = randResult;
                }
                return finalMinimunCut;

                //      merge (or "contract") u and v int a single vertex
                //      remove self loops
                //  return cut represented by the 2 final vertices.
            }

        }

        // Across all the runs return the smallest min cut
        return finalMinimunCut;
    }

    /**
     * Read in the data file as a hashmap of integers
     * @return a hashmap of all the adjacency data
     * @throws Exception
     */
    HashMap readInFile() throws Exception{
        HashMap result = new HashMap();
        String currentRow;
        String[] splitRow = new String[199];
        Integer currentKey;
        ArrayList currentValue;
        FileInputStream fstream = new FileInputStream("/Users/jonthomas/source/Algorithms/src/main/java/stanford/algorithmsIlluminated1/minimumCut/kargerMinCut.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        while ((strLine = br.readLine()) != null) {
            // Print the content on the console
            splitRow = strLine.split("\\t+");
            currentKey = Integer.valueOf(splitRow[0]);
            currentValue = new ArrayList();
            for (int i = 0; i < splitRow.length; i++) {
                if (i != 0){
                    currentValue.add(Integer.valueOf(splitRow[i]));
                }
            }
            result.put(currentKey, currentValue);
        }
        fstream.close();
        return result;
    }

    private void mergeVertices(Map<Integer, List<Integer>> graph, int x, int y) {
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

    private boolean hasEdge(Map<Integer, List<Integer>> graph, int x, int y) {
        return graph.get(x).contains(y);
    }

    private void addEdge(Map<Integer, List<Integer>> graph, int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    private void removeEdge(Map<Integer, List<Integer>> graph, int x, int y) {
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

    private List<int[]> hasEdges(Map<Integer, List<Integer>> graph) {
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

    private int randMinCut(Map<Integer, List<Integer>> graph) {
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
