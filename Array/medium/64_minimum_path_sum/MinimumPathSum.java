//
// Created by Joshua.cao, 2018/09/20
//
// https://leetcode.com/problems/minimum-path-sum/description/
// 
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Queue;

public class MinimumPathSum {
	class Node {
		int x;
		int y;
		int cost;
		int heuristic;
		int total;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			
		}
		
		public void addCost(int cost, int heuristic) {
			this.cost = cost;
			this.heuristic = heuristic;
			total = this.cost + this.heuristic;
		}
	}

	Comparator<Node> nodeComparator = new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
			return o1.total - o2.total;
		}
	};
	
	public int calculateHeuristicValue(Node current, Node target) {
		return target.x - current.x + target.y - current.y;
	}
	
	public boolean isTarget(Node target, Node node) {
		return target.x == node.x && target.y == node.y;
	}

  // A-star: Time Limit Exceeded
	public int minPathSum(int[][] grid) {
		int rows = grid.length;
		if (rows <= 0) return 0;
		int columns = grid[0].length;
		if (columns <= 0) return 0;
		Node target = new Node(rows - 1, columns - 1);
		
		PriorityQueue<Node> queue = new PriorityQueue<>(nodeComparator);
		Node start = new Node(0, 0);
		start.addCost(
			grid[start.x][start.y],
			calculateHeuristicValue(start, target)
		);
		queue.offer(start);
		int result = 0;
		
		while (queue.peek() != null) {
			Node current = queue.poll();
			if (isTarget(target, current)) {
				result = current.cost;
				break;
			}
			if (current.x + 1 < rows) {
				Node bottom = new Node(current.x + 1, current.y);
				bottom.addCost(
					current.cost + grid[bottom.x][bottom.y],
					calculateHeuristicValue(bottom, target)
				);
				queue.offer(bottom);
			}
			if (current.y + 1 < columns) {
				Node right = new Node(current.x, current.y + 1);
				right.addCost(
					current.cost + grid[right.x][right.y],
					calculateHeuristicValue(right, target)
				);
				queue.offer(right);
			}
		}
		
		return result;
	}
  
  public int minPathSum_2(int[][] grid) {
		int rows = grid.length;
		if (rows <= 0) return 0;
		int columns = grid[0].length;
		if (columns <= 0) return 0;

		int[][] costMap = new int[rows][columns];
		costMap[0][0] = grid[0][0];
		for (int i = 1; i < rows; i++) {
			costMap[i][0] = costMap[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < columns; i++) {
			costMap[0][i] = costMap[0][i - 1] + grid[0][i];
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				if (costMap[i - 1][j] < costMap[i][j - 1]) {
					costMap[i][j] = grid[i][j] + costMap[i - 1][j];
				} else {
					costMap[i][j] = grid[i][j] + costMap[i][j - 1];
				}
			}
		}

    return costMap[rows - 1][columns - 1];
  }

	public static void main(String[] args) {
		MinimumPathSum obj = new MinimumPathSum();
		int[][] input = { {1,3,1}, {1,5,1}, {4,2,1} };
		System.out.println("result_1: " + obj.minPathSum(input));
		System.out.println("result_2_1: " + obj.minPathSum_2(input));

		int[][] input_2 = {{0}};
		System.out.println("result_2_2: " + obj.minPathSum_2(input_2));
		int[][] input_3 = {{1}, {1}};
		System.out.println("result_2_3: " + obj.minPathSum_2(input_3));
	}
}