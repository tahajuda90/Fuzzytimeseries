/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzytimeseries;

/**
 *
 * @author tahajuda
 */
public class proses {
    
    public static double defuzifikasi(double[] der, double[][] him) {
        double hs;
        int st = 0, en = 0, m1 = 0, m2 = 0, idx = 0;
        for (int i = 0; i < der.length; i++) {
            if (der[i] == 1) {
                m1 = m1 + 1;
                idx = i;
            } else if (der[i] == 0.5) {
                m2 = m2 + 1;
                idx = i;
            }
        }

        for (int j = 0; j < der.length; j++) {
            if (der[j] == 1) {
                st = st + 1;
                en = j;
                if (j == der.length - 1) {
                    break;
                } else if (der[j + 1] != 1) {
                    break;
                }
            }
        }

        if (st > 1) {
            hs = (him[(en + 1) - st][0] + him[en][1]) / 2;

        } else if (m2 == 1 && m1 == 1) {
            hs = (((him[idx][0] + him[idx][1]) / 2) * der[idx]);

        } else if (m2 == 0 && m1 == 0) {
            hs = (((him[idx][0] + him[idx][1]) / 2) * der[idx]);

        } else {
            double adh1 = 0, adh2 = 0;
            for (int i = 0; i < der.length; i++) {
                adh1 = adh1 + (((him[i][0] + him[i][1]) / 2) * der[i]);
                adh2 = adh2 + der[i];
            }
            hs = adh1 / adh2;

        }
        return hs;
    }

    public static double[] derkeang(int[][] flrg, int acu) {

        double[][] der;
        der = new double[flrg.length][flrg.length];

        for (int i = 0; i < der.length; i++) {
            for (int j = 0; j < der[0].length; j++) {
                if (i == j) {
                    der[i][j] = 1;
                } else if (i - j == 1) {
                    der[i][j] = 0.5;
                } else if (j - i == 1) {
                    der[i][j] = 0.5;
                }
            }
        }
        double[] temp = new double[der[0].length];
        for (int i = 0; i < flrg[0].length; i++) {
            if (flrg[acu][i] != 0) {
                for (int j = 0; j < der[0].length; j++) {
                    temp[j] = Math.max(der[i][j], temp[j]);

                }
            }
        }
        return temp;
    }

    public static int[][] fuzlore(int[] hi, int rng) {
        int[][] flr, flrg;
        flr = new int[hi.length - 1][2];
        flrg = new int[rng][rng];
        for (int i = 0; i < hi.length - 1; i++) {
            flr[i][0] = hi[i];
            flr[i][1] = hi[i + 1];
        }
        for (int i = 0; i < flr.length; i++) {
            int x = flr[i][0];
            int y = flr[i][1];
            flrg[x][y] = flr[i][1] + 1;
        }
        return flrg;
    }

    public static int[] himint(int[] ars2, double[][] him) {
        int[] ats, bwh, hi;
        ats = new int[him.length];
        bwh = new int[him.length];
        hi = new int[ars2.length];
        for (int j = 0; j < him.length; j++) {
            bwh[j] = (int) him[j][0];
            ats[j] = (int) him[j][1];
        }

        for (int i = 0; i < ars2.length; i++) {
            for (int j = 0; j < him.length; j++) {
                if (ars2[i] > bwh[j] && ars2[i] < ats[j]) {
                    hi[i] = j;
                }
            }
        }

        return hi;
    }
    
    public static double[][] himpunan(int[] ars2,int jh) {

        

        double rag = Math.abs(((Math.floorDiv(getMax(ars2), 10) + 5) * 10) + (Math.abs((Math.floorDiv(getMin(ars2), 10)-5) * 10)));
        rag=rag/jh;
       
        
        double temp2 = (Math.floorDiv(getMin(ars2), 10)-5) * 10;
        double[][] him = new double[jh][2];
        for (int i = 0; i < him.length; i++) {
            him[i][0] = temp2;
            temp2 = temp2 + rag;
            him[i][1] = temp2;
        }
        return him;
    }

    public static int[] interval(int[] ars) {
        int[] ars2 = new int[ars.length - 1];
        for (int i = 0; i < ars2.length; i++) {
            ars2[i] = ars[i+1] - ars[i];
        }
        return ars2;
    }

    
    
    

    // Method for getting the maximum value
    public static int getMax(int[] inputArray) {
        int maxValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maxValue) {
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }
// 
//  // Method for getting the minimum value

    public static int getMin(int[] inputArray) {
        int minValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] < minValue) {
                minValue = inputArray[i];
            }
        }
        return minValue;
    }
}
