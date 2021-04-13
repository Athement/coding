package unionFind;

import java.util.HashMap;

public class _130 {
    int[] parent;

    public void init(int n) {
        parent = new int[n + 1];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }
    }

    /**
     * 较大的成为新root
     *
     * @param a
     * @param b
     */
    public void union(int a, int b) {
        int ap = find(a);
        int bp = find(b);
        if (ap != bp) {
            if (ap > bp) {
                parent[bp] = ap;
            } else {
                parent[ap] = bp;
            }
        }
    }

    public int find(int a) {
        int root = a;
        while (parent[root] != root) {
            root = parent[root];
        }
        //压缩并查树
        while (parent[a] != a) {
            int tmp = a;
            parent[a] = root;
            a = parent[tmp];
        }
        return root;
    }

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int row=board.length;
        int col=board[0].length;
        int dummy=row*col;
        init(dummy+1);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    if(i==0||i==row-1||j==0||j==col-1){
                        union(i*col+j,dummy);
                    }
                    if (i > 0 && board[i - 1][j] == 'O') {
                        union(i * col + j, (i - 1) * col + j);
                    }
                    if (j > 0 && board[i][j - 1] == 'O') {
                        union(i * col + j, i * col + j - 1);
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && find(i * col + j) != dummy) {
                    board[i][j] = 'X';
                }
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        char[][] board = {{'O', 'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O'}, {'X', 'O', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'}};
        _130 test = new _130();
        test.solve(board);
    }
}
