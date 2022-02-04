package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;

        Queue<int[]> rottenOrangesPositions = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) freshOranges++;
                if (grid[i][j] == 2) rottenOrangesPositions.add(new int[]{i,j});
            }
        }

        if (freshOranges == 0) return 0;
        if (rottenOrangesPositions.size() == 0) return -1;

        return bfs(grid, rottenOrangesPositions, freshOranges);
    }

    private int bfs(int[][] grid, Queue<int[]> rottenOrangesPositions, int freshOranges) {
        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        int minutes = 0;

        while (!rottenOrangesPositions.isEmpty()) {
            int levelSize = rottenOrangesPositions.size();
            int stepCounter = 0;

            while (levelSize > stepCounter) {
                int[] current = rottenOrangesPositions.poll();
                for(int[] dir: directions) {
                    int r = current[0] + dir[0];
                    int c = current[1] + dir[1];
                    if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
                        rottenOrangesPositions.offer(new int[] {r, c});
                        freshOranges--;
                        grid[r][c] = 2;
                    }
                }
                stepCounter++;
            }
            minutes++;
        }

        if (freshOranges > 0) return -1;
        return minutes;
    }

}
