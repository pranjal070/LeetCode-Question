
import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        // Step 2: Direction arrays
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx >= 0 && ny >= 0 &&
                        nx < m && ny < n &&
                        grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        fresh--;
                        q.add(new int[]{nx, ny});
                    }
                }
            }

            minutes++;
        }

        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }
}
