//package com.java.leetcode;
//
//import java.util.Scanner;
//
//public class FindDiagonalOrder {
//    public int[] findDiagonalOrder(int[][] mat) {
//        int m = mat.length;
//        if (m == 0) return new int[0];
//        int n = mat[0].length;
//        int[] res = new int[m * n];
//        boolean flag = true;
//        int i = 0, j = 0, k = 0;
//        while (i < m && j < n) {
//            if (flag) {
//                while (i >= 0 && j < n) {
//                    res[k++] = mat[i][j];
//                    i--;
//                    ++j;
//                }
//                i++;
//            } else {
//                while (i < m && j >= 0) {
//                    res[k++] = mat[i][j];
//                    i++;
//                    --j;
//                }
//                j++;
//            }
//            flag = !flag;
//            if (j == n && i < m) {
//                j--;
//                i++;
//            } else if (i == m && j < n) {
//                j++;
//                i--;
//            }
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
//        int n = scanner.nextInt();
//        int[][] mat = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; ++j) {
//                mat[i][j] = scanner.nextInt();
//            }
//        }
//        FindDiagonalOrder ob = new FindDiagonalOrder();
//        int[] res = ob.findDiagonalOrder(mat);
//
//    }
//}
