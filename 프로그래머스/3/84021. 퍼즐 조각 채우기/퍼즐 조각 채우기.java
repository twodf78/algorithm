import java.util.*;

class Solution {
    int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int N, M;
    int answer = 0;
    boolean[][] visit_table;
    boolean[][] visit_board;
    int[][] board;
    
    public int solution(int[][] game_board, int[][] table) {
        board = game_board;

        N = board.length;
        M = board[0].length;
        
        visit_table = new boolean[N][M];
        visit_board = new boolean[N][M];
        
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (!visit_table[i][j] && table[i][j] == 1) bfs(table, i, j);
            }
        }
        
        return answer;
    }
    
    void bfs(int[][] table, int r, int c) {
        ArrayList<int[]> list = new ArrayList<>();
        
        list.add(new int[] {r, c});
        visit_table[r][c] = true;
        
        int maxR = r;
        int minR = r;
        int maxC = c;
        int minC = c;
        
        int idx = 0;
        while (idx < list.size()) {
            int[] now = list.get(idx++);
            
            for (int i=0;i<4;i++) {
                int nextR = now[0] + move[i][0];
                int nextC = now[1] + move[i][1];
            
                if (!check(nextR, nextC) || visit_table[nextR][nextC] || table[nextR][nextC] == 0) continue;
                
                visit_table[nextR][nextC] = true;
                list.add(new int[] {nextR, nextC});
                    
                maxR = Math.max(maxR, nextR);
                minR = Math.min(minR, nextR);
                maxC = Math.max(maxC, nextC);
                minC = Math.min(minC, nextC);
            }
        }
        
        int[][] arr = makeArr(list, minR, minC, maxR, maxC);
        for (int i=0;i<4;i++) {
            if (puzzle(arr, arr.length, arr[0].length)) {
                answer += list.size();
                break;
            }
            if (i != 3) arr = rotate(arr);
        }
        
    }
    
    int[][] makeArr(ArrayList<int[]> list, int minR, int minC, int maxR, int maxC) {
        int n = maxR - minR + 1;
        int m = maxC - minC + 1;
        int[][] ret = new int[n][m];
        
        for (int[] loc : list) {
            ret[loc[0] - minR][loc[1] - minC] = 1;
        }
        
        return ret;
    }
    
    boolean check(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= M) return false;
        return true;
    }
        
    boolean puzzle(int[][] arr, int n, int m) {
        for (int i=0;i<N-n+1;i++) {
            Loop: for (int j=0;j<M-m+1;j++) {
                for (int k=0;k<n;k++) {
                    for (int l=0;l<m;l++) {
                        if (arr[k][l] == 1 && (board[i + k][j + l] == 1 || visit_board[i + k][j + l])) continue Loop;
                    }
                }
                if (checkPuzzle(i, j, arr, n, m)) return true;
            }
        }
        
        return false;
    }
    
    boolean checkPuzzle(int startR, int startC, int[][] arr, int n, int m) {
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (arr[i][j] == 1) {
                    board[startR + i][startC + j] = 1;
                    visit_board[startR + i][startC + j] = true;
                }
            }
        }
        
        boolean flag = false;
        Loop: for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (arr[i][j] == 1) {
                    for (int k=0;k<4;k++) {
                        int r = startR + i + move[k][0];
                        int c = startC + j + move[k][1];
                        
                        if (!check(r, c)) continue;
                        if (board[r][c] == 0) {
                            flag = true;
                            break Loop;
                        }
                    }
                }
            }
        }
        
        if (flag) {
            for (int i=0;i<n;i++) {
                for (int j=0;j<m;j++) {
                    if (arr[i][j] == 1) {
                        board[startR + i][startC + j] = 0;
                        visit_board[startR + i][startC + j] = false;
                    }
                }
            }
            return false;
        }
        
        return true;
    }
    
    int[][] rotate(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        
        int[][] ret = new int[m][n];
        
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                ret[j][n - i - 1] = a[i][j]; 
            }
        }
        
        return ret;
    }
}