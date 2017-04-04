/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzytimeseries;

import java.util.Arrays;




/**
 *
 * @author tahajuda
 */
public class fuzzymain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] ars = {13861, 13794, 13876, 13805, 13865, 13766, 13792, 13808, 13817, 13861, 13851,
             13827, 13830, 13805, 13775, 13834, 13802, 13820, 13631, 13553, 13688, 13594, 13585, 13470, 13302, 13404, 13409,
            13266};
        double [] arh = new double[ars.length];
        int[] ars2, hi;
        int[][] flrg;
        double[] der;
        double[][] him;
        double hs;


        ars2 = proses.interval(ars);
        him = proses.himpunan(ars2,6);
        hi = proses.himint(ars2, him);
        flrg = proses.fuzlore(hi, him.length);
        
        for(int i=1;i<arh.length;i++){
        int acu = hi[i-1];
        der = proses.derkeang(flrg, acu);
        hs = proses.defuzifikasi(der, him);
        arh[i]=hs+ars[i-1];
        }
        System.out.println(Arrays.toString(arh));
        System.out.println(Arrays.toString(ars));
        
//        for (int i = 0; i < him.length; i++) {
//            System.out.println(Arrays.toString(him[i]));
//      }




    }

}

