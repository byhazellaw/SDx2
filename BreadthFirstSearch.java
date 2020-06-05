

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * SD2x Homework #6
 * This is an implementation of Breadth First Search (BFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class BreadthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;

	public BreadthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<Node>();
		graph = graphToSearch;
	}
	
	/**
	 * This method was discussed in the lesson
	 */
	public boolean bfs(Node start, String elementToFind) {
		if (!graph.containsNode(start)) {
				return false;
		}
		if (start.getElement().equals(elementToFind)) {
			return true;
		}
		Queue<Node> toExplore = new LinkedList<Node>();
		marked.add(start);
		toExplore.add(start);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					if (neighbor.getElement().equals(elementToFind)) {
						return true;
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
					
				}
			}
		}
		return false;
	}
	
	
	/*
	 * find distance between start and end node
	 */
	
	
	public int dist(Node start, String elementToFind) {
		if (!graph.containsNode(start)) {
				return -1;													//null
		}
		if (start.getElement().equals(elementToFind)) {
			return 0;
		}
		
		Map<Node, Integer> dist = new HashMap<>();		
		Queue<Node> toExplore = new LinkedList<Node>();
		
		marked.add(start);
		toExplore.add(start);
		dist.put(start, 0);													//distance between start to dest

		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					
					dist.put(neighbor, dist.get(current) + 1);				//unweighted map
					if (neighbor.getElement().equals(elementToFind)) {
						return dist.get(neighbor);
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
		return -1;															//null
	}
	

}
