package graphs.simpleimpl;

/**
 *
 * @author Luke
 */
public class EdgeComparator {

    public int compare(Edge edge1, Edge edge2) {
        if (edge1.getWeight() <= edge2.getWeight()) {
            return -1;
        } else {
            return 1;
        }
    }
}
