package com.gowthamalwan.algorithms.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href = "https://leetcode.com/problems/number-of-islands/">
 *   200. Number of Islands
 * </a>
 */
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    int numIslands = 0;
    int m = grid.length, n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    Queue<int[]> queue = new LinkedList<>();
    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          visited[i][j] = true;
          queue.offer(new int[]{i, j});

          while (!queue.isEmpty()) {
            int[] l = queue.poll();
            for (int [] dir : dirs) {
              int x = l[0] + dir[0];
              int y = l[1] + dir[1];

              if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] == '0')
                continue;

              visited[x][y] = true;
              queue.offer(new int[]{x, y});
            }
          }
          numIslands++;
        }
      }
    }
    return numIslands;
  }
}
