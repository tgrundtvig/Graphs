package findcycle;

import findcycle.Graph.Edge;
import findcycle.Graph.Vertex;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Yoana Krassimirova
 */
public class FindCycle {

    // Set<Vertex<Integer>> whiteSet = new HashSet<>();
    //
    Set<Vertex> whiteSet = new HashSet<>();
    Set<Vertex> graySet = new HashSet<>();
    Set<Vertex> blackSet = new HashSet<>();
    List<Vertex> cycle = new ArrayList<>();
    
         PriorityQueue<Edge> pq = new PriorityQueue<>((Object o1, Object o2) -> {
            Edge first = (Edge)o1;
            Edge second = (Edge)o2;
            
            if(first.getWeight()<second.getWeight())return -1;
            else if(first.getWeight()>second.getWeight())return 1;
            else return 0;
        });
        

    public List<Vertex> getCycle() {
        return cycle;
    }

    public void setCycle(List<Vertex> cycle) {
        this.cycle = cycle;
    }
            

    public Set<Vertex> getGraySet() {
        return graySet;
    }

    public void setGraySet(Set<Vertex> graySet) {
        this.graySet = graySet;
    }

    // Vertex<Integer>> whiteSet = new Vertex<>();
    public boolean hasCycle(Graph<Integer> graph) {
        //Map<Integer,List<Vert

        for (Vertex vertex : graph.getAllVertex()) {
            whiteSet.add(vertex);
        }

        while (whiteSet.size() > 0) {
            Vertex current = whiteSet.iterator().next();
            if (dfs(current, whiteSet, graySet, blackSet)) {
                return true;
            }
        }
        return false;
    }
    
        public Deque<Vertex> topSort(Graph<Integer> graph) {
        Deque<Vertex> stack = new ArrayDeque<>();
        Set<Vertex> visited = new HashSet<>();
        for (Vertex vertex : graph.getAllVertex()) {
            if (visited.contains(vertex)) {
                continue;
            }
            topSortUtil(vertex,stack,visited);
        }
        return stack;
    }
     // to be continued kruskalAlgorithm
     public void primsAlgorithm(Graph<Integer> graph, int s)  
     {
          Set<Vertex> visited = new HashSet<>();
         
           for (Edge edge : graph.getAllEdges()) 
           {
            pq.add(edge);
            }
            //topSortUtil(vertex,stack,visited);
        }
    // }
        
        
    private void topSortUtil(Vertex vertex, Deque<Vertex> stack,
            Set<Vertex> visited) {
        visited.add(vertex);
        for(Vertex childVertex : (List<Vertex>)vertex.getAdjacentVertex()){
            if(visited.contains(childVertex)){
                continue;
            }
            topSortUtil(childVertex,stack,visited);
        }
        stack.offerFirst(vertex);
    }
    
    
    
    
    //APPROACH WITH ARRAY
//       public Deque<Vertex<T>> topSort(Graph<T> graph) {
//        Deque<Vertex<T>> stack = new ArrayDeque<>();
//        Set<Vertex<T>> visited = new HashSet<>();
//        for (Vertex<T> vertex : graph.getAllVertex()) {
//            if (visited.contains(vertex)) {
//                continue;
//            }
//            topSortUtil(vertex,stack,visited);
//        }
//        return stack;
//    }

//    public int[] dfsTopSort(Graph<Integer> graph)
//    {
//        boolean[] visited = new boolean[graph.getAllVertex().size()];
//        int[] topnum = new int[graph.getAllVertex().size()];
//        int n = graph.getAllVertex().size() - 1;
//        for(int v = 0;v<visited.length;v++)
//        {
//            if(!visited[v])
//            {
//                dfsTopSort(v,visited,topnum,n, graph);
//            }
//        }
//        return topnum;
//    } 
//    
//    private int dfsTopSort(int v, boolean[] visited , int[] topnum, int n , Graph<Integer> graph)
//    {
//        visited[v] = true;
//        for(Vertex ver = (ArrayList)graph.getAllVertex().)
//    }
//    
    
    
    
    private boolean dfs(Vertex current, Set<Vertex> whiteSet, Set<Vertex> graySet,
            Set<Vertex> blackSet) {
        //move current to gray set from white set and then explore it.
        moveVertex(current, whiteSet, graySet);
    
        for (Vertex neighbor : (List<Vertex>) current.getAdjacentVertex()) {
            cycle.add(current);
            if (blackSet.contains(neighbor)) {
                cycle.remove(current);
                continue;
            }
            //we found cycle
            if (graySet.contains(neighbor)) {
              
                return true;
            }

            if (dfs(neighbor, whiteSet, graySet, blackSet)) 
            {
                return true;
            }
        }

        //remove here
        cycle.remove(current);
        moveVertex(current, graySet, blackSet);
        return false;

    }

    private void moveVertex(Vertex vertex, Set<Vertex> sourceSet,
            Set<Vertex> destinationSet) {
        sourceSet.remove(vertex);
        destinationSet.add(vertex);
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(2, 3);
//        graph.addEdge(4, 1);
//        graph.addEdge(4, 5);
//        graph.addEdge(5, 6);
//        graph.addEdge(6, 4);

//               FOR TOPOLOGICAL SORT
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);
        //888888888888888888888888888
//        FindCycle fc = new FindCycle();        
//        System.out.println("Is there any cycle " +fc.hasCycle(graph));
//        System.out.println("The grey area is ");
//          fc.getCycle().forEach((s)->{
//              System.out.print("  Vertex id is "+s);
//          });
//          System.out.println("");
          //88888888888888888888888888888888888
             FindCycle sort = new FindCycle();
        Deque<Vertex> result = sort.topSort(graph);
        while(!result.isEmpty()){
            System.out.println(result.poll());
        }
    }

}
