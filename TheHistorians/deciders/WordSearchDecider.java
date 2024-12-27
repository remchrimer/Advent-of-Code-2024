package TheHistorians.deciders;

public class WordSearchDecider {
    private static final char startChar = 'M';
    private static final char endChar = 'S';
    private static final char startCharX = 'X';
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    private static final String MAS = "MAS";
    private static final String XMAS = "XMAS";
    private static final String SAM = "SAM";

    public long calculateWordCount(char[][] data) {
        long count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                char ch = data[i][j];
                if (ch == startCharX || ch == endChar) {
                    for(int[] direction : directions) {
                        if(searchDFS(data, i, j, XMAS, 0, direction)){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public long calculateXwordCount(char[][] data) {
        long count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 2; j < data[i].length; j++) {
                char ch1 = data[i][j - 2];
                char ch2 = data[i][j];
                if ((ch1 == startChar || ch1 == endChar) && (ch2 == startChar || ch2 == endChar)) {
                    if(checkAndCount(data, i, j, MAS, SAM)){
                        count++;
                    }
                    else if(checkAndCount(data, i, j, SAM, MAS)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean checkAndCount(char[][] data, int i, int j, String word, String oppositeWord) {
        boolean valid = false;
        if (searchDFS(data, i, j - 2, word, 0, directions[7])) {
            if (searchDFS(data, i, j, word, 0, directions[6])) {
                valid = true;
            }
            else if (searchDFS(data, i, j, oppositeWord, 0, directions[6])) {
                valid = true;
            }
        }
        return valid;
    }

    private boolean searchDFS(char[][] data, int row, int col, String word, int index, int[] direction) {
        if (index == word.length()) {
            return true;
        }
        if(row < 0 || col < 0 || row >= data.length || col >= data[row].length || data[row][col] != word.charAt(index)) {
            return false;
        }
        char temp = data[row][col];
        data[row][col] = '#';

        boolean found = searchDFS(data, row + direction[0], col + direction[1], word, index + 1, direction);
        data[row][col] = temp;
        return found;
    }
}
