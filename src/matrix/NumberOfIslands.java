package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    bfs(grid, row, col);
                    grid[row][col] = '0';
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<int[]> land = new LinkedList<>();
        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        land.add(new int[] {row, col});

        while (!land.isEmpty()) {
            int[] current = land.poll();
            for(int[] dir: directions) {
                int r = current[0] + dir[0];
                int c = current[1] + dir[1];
                if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1') {
                    land.offer(new int[] {r, c});
                    grid[r][c] = '0';
                }
            }
        }
    }


}
