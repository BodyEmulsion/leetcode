package org.example;

public class Problem547NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        boolean[] isChecked = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (isChecked[i]) {
                continue;
            }
            provinces++;
            isChecked[i] = true;
            checkProvinceDfs(i, isChecked, isConnected);
        }
        return provinces;
    }

    private void checkProvinceDfs(int i, boolean[] isChecked, int[][] isConnected) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 0 || isChecked[j]) {
                continue;
            }
            isChecked[j] = true;
            checkProvinceDfs(j, isChecked, isConnected);
        }
    }

}
