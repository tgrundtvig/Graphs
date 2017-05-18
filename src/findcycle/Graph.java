
package findcycle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@param T The expected class of the value.
 * @author Yoana Krassimirova
 */
public class Graph<T>
{
    
    private List<Edge<T>> allEdges;
    private Map<Integer,Vertex<T>> allVertex;
    boolean isDirected = false;

    public List<Edge<T>> getAllEdges() {
        return allEdges;
    }

    public void setAllEdges(List<Edge<T>> allEdges) {
        this.allEdges = allEdges;
    }
    
    
    
    public Graph(boolean isDirected)
    {
        allEdges = new ArrayList<Edge<T>>();
        allVertex = new HashMap<Integer,Vertex<T>>();
        this.isDirected = isDirected;
    }
    
    /**
         *@param T The expected class of the value.
         * @author Yoana Krassimirova
    */
    public void addEdge(int id1,int id2, int weight)
    {
       // if()
             Vertex<T> vertex1 = null;
        if(allVertex.containsKey(id1)){
            vertex1 = allVertex.get(id1);
        }else{
            vertex1 = new Vertex<T>(id1);
            allVertex.put(id1, vertex1);
        }
        Vertex<T> vertex2 = null;
        if(allVertex.containsKey(id2)){
            vertex2 = allVertex.get(id2);
        }else{
            vertex2 = new Vertex<T>(id2);
            allVertex.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<T>(vertex1,vertex2,isDirected,weight);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected){
            vertex2.addAdjacentVertex(edge, vertex1);
        }
    }
     public Collection<Vertex<T>> getAllVertex()
     {
        return allVertex.values();
    }

    public Map<Integer, Vertex<T>> getAllVertexs() {
        return allVertex;
    }

    public void setAllVertex(Map<Integer, Vertex<T>> allVertex) {
        this.allVertex = allVertex;
    }
     
     
    
    public void addVertex(Vertex<T> vertex)
    {
      if(allVertex.containsKey(vertex.getId()))
      {
          return;
      }
      allVertex.put(vertex.getId(), vertex);
      //add this particular vertex's edgs to the the total edgees
      for(Edge<T> edge: vertex.getEdges())
      {
          allEdges.add(edge);
      }
    }
    //add single Vertex
    public Vertex<T> addSingleVertex(int id)//we can do it just by having the id
    {
        if(allVertex.containsKey(id))
        {
            return allVertex.get(id);
        }
        Vertex<T> v = new Vertex<T>(id);
        allVertex.put(id, v);
        return v;
    }
    
    public Vertex<T> getVertex(int id)
    {
        return allVertex.get(id);
    }
    public void addEdge(int id1, int id2)
    {
        Vertex<T> vertex1 = null;
        if(allVertex.containsKey(id1))
        {
            vertex1 = allVertex.get(id1);
        }else
        {
            vertex1 = new Vertex<T>(id1);
            allVertex.put(id1,vertex1);
        }
        Vertex<T> vertex2 = null;
        if(allVertex.containsKey(id2))
        {
            vertex2 = allVertex.get(id2);
        }else
        {
            vertex2 = new Vertex<T>(id2);
            allVertex.put(id2,vertex2);
        }
        
        Edge<T> edge = new Edge<T>(vertex1,vertex2,isDirected);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected)
        {
            vertex2.addAdjacentVertex(edge, vertex1);
        }
        
       
        
    }
    
    
    
    
    class Vertex<T>
    {
        int id;
        private T data;
        private List<Edge<T>> edges = new ArrayList<>();
        private List<Vertex<T>> adjacentVertex = new ArrayList<>();
        
         Vertex(int id)
         {
             this.id = id;
         }

        public int getId()
        {
            return id;
        }

        public void setId(int id) 
        {
            this.id = id;
        }

        public T getData()
        {
            return data;
        }

        public void setData(T data) 
        {
            this.data = data;
        }
         public void addAdjacentVertex(Edge<T> e, Vertex<T> v)
         {
             edges.add(e);
             adjacentVertex.add(v);
         }

        public List<Edge<T>> getEdges() 
        {
            return edges;
        }

        public List<Vertex<T>> getAdjacentVertex() 
        {
            return adjacentVertex;
        }
         public int getDegree()
         {
             return edges.size();
         }
         public String toString()
         {
             return String.valueOf(id);
         }
         
    }
    
    class Edge<T>
    {
        private boolean isDirected = false;
        private Vertex<T> vertex1;
        private Vertex<T> vertex2;
        private int weight;//if we have weight

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public boolean isIsDirected() 
        {
            return isDirected;
        }
        
           Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected,int weight)
           {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.isDirected = isDirected;
           }

            Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected)
        {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.isDirected = isDirected;
        }
        
        public void setIsDirected(boolean isDirected) 
        {
            this.isDirected = isDirected;
        }
       
        public Edge(Vertex<T> vertex1, Vertex<T> vertex2) 
        {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }
        

        public Vertex<T> getVertex1() 
        {
            return vertex1;
        }

        public void setVertex1(Vertex<T> vertex1) 
        {
            this.vertex1 = vertex1;
        }

        public Vertex<T> getVertex2() 
        {
            return vertex2;
        }

        public void setVertex2(Vertex<T> vertex2)
        {
            this.vertex2 = vertex2;
        }
        
        
        
        
        
    }
}
