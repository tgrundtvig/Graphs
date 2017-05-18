/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.Comparator;

/**
 *
 * @author emilgras
 */
public class EdgeComparator implements Comparator<Edge> {

    public int compare(Edge edge1, Edge edge2) {
        if (edge1.getWeight() <= edge2.getWeight()) {
            return -1;
        } else {
            return 1;
        }
    }
}
