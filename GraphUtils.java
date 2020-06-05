
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	/*
	 * this method returns the shortest distance (in terms of number of edges) from
	 * the node labeled src to the node labeled dest.
	 */

	public static int minDistance(Graph graph, String src, String dest) {

		if (graph == null || src == null || dest == null || !graph.containsNode(graph.getNode(src))
				|| !graph.containsNode(graph.getNode(dest))) {
			return -1;
		}
		return new BreadthFirstSearch(graph).dist(graph.getNode(src), dest);

	}

	/*
	 * this method returns a Set of the values of all nodes within the specified
	 * distance (in terms of number of edges) of the node labeled src, i.e. for
	 * which the minimum number of edges from src to that node is less than or equal
	 * to the specified distance. The value of the node itself should not be in the
	 * Set, even if there is an edge from the node to itself.
	 */

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {

		if (graph == null || !graph.containsElement(src) || src == null || distance < 1) {
			return null;
		}

		Set<String> result = new HashSet<>();
		Map<Node, Integer> dis = new HashMap<>();

		for (Node nd : graph.getAllNodes()) {
			dis.put(nd, minDistance(graph, src, nd.getElement()));
		}
		for (Map.Entry<Node, Integer> entry : dis.entrySet()) {
			if (entry.getValue() <= distance && entry.getValue() > 0) {
				result.add(entry.getKey().getElement());
			}
		}

		return result;
	}

	/*
	 * A Hamiltonian Path is a valid path through the graph in which every node in
	 * the graph is visited exactly once, except for the start and end nodes, which
	 * are the same, so that it is a cycle.
	 * 
	 */

	public static boolean isHamiltonianPath(Graph g, List<String> values) {

		if (g == null || values == null || values.isEmpty()) {
			return false;
		}

		Set<String> visited = new HashSet<>();
		int allN = g.getNumNodes();

		visited.add(values.get(0));

		/*
		 * If an unexplored edge/neighbor of the node leads to a node visited before,
		 * then the graph contains a cycle.
		 */

		if (values.get(0) != values.get(values.size() - 1)) {
			return false;														//start and end the same
		}

		for (int i = 1; i < values.size(); i++) {

			if (visited.contains(values.get(i)) && i != (values.size() - 1)) { // visited nodes, end node already in visited
				return false;
			}
			if (!g.getNodeNeighbors(g.getNode(values.get(i - 1))).contains(g.getNode(values.get(i)))) { // not connected
				return false;

			}
			visited.add(values.get(i));										//track nodes

		}
		return visited.size() == allN; // see if all nodes in graph are visited
	}
}
