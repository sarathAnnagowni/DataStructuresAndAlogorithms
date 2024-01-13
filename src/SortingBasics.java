import java.util.Arrays;

public class SortingBasics {

    public static void main(String[] args) {
        int[] a={-4,7,5,3,5,-4,2,-1,-9,-8,-3,0,9,-7,-4,-10,-4,2,6,1,-2,-3,-1,-8,0,-8,-7,-3,5,-1,-8,-8,8,-1,-3,3,6,1,-8,-1,3,-9,9,-6,7,8,-6,5,0,
                3,-4,1,-10,6,3,-8,0,6,-9,-5,-5,-6,-3,6,-5,-4,-1,3,7,-6,5,-8,-5,4,-3,4,-6,-7,0,-3,-2,6,8,-2,-6,-7,1,4,9,2,-10,6,-2,9,2,-4,-4,4,9,
                5,0,4,8,-3,-9,7,-8,7,2,2,6,-9,-10,-4,-9,-5,-1,-6,9,-10,-1,1,7,7,1,-9,5,-1,-3,-3,6,7,3,-4,-5,-4,-7,9,-6,-2,1,2,-1,-7,9,0,-2,-2,5,-10,-1,
                6,-7,8,-5,-4,1,-9,5,9,-2,-6,-2,-9,0,3,-10,4,-6,-6,4,-3,6,-7,1,-3,-5,9,6,2,1,7,-2,5};
        System.out.println(nobleElementWithSorting(a));
       /* int[] a={2255,6353,7832,9990,516,9853,7018,3337,3008,6158,679,2954,2024,2807,1944,6596,7992,2942,9355,788,65,2966,9276,1064,1112,6197,4615,8140,30,478,5360,7585,8853,9481,1099,8781,9514,4603,8209,7455,5225,6740,4734,4942,4475,4995,4086,6448,1408,2446,4675,92,4942,7421,6302,8226,431,2463,5762,2681,1877,2121,3450,5930,9743,5045,9977,906,9293,5441,6825,3244,7021,3910,7866,1013,8227,7926,9226,8710,7088,7761,3413,4200,1671,4526,9890,9594,257,3212,8341,9641,2060,5072,2776,4084,4988,501,4304,3685,5424,5713,7920,3115,187,3915,3971,7755,8802,4439,8104,5610,5007,1348,4449,9993,17,6395,5539,3415,6500,9899,9049,8197,1419,7112,5823,4739,7975,6915,5852,4072,1694,4353,8867,7362,3410,8415,4060,1353,2342,1712,9038,5421,5772,9291,1611,2822,7927,9644,9236,6052,9592,2206,28,3772,1694,2085,6137,4683,655,4604,4979,1948,661,9333,6319,257,8146,5744,3533,6508,6792,338,5507,4191,7116,8174,1577,1045,3337,86,5667,9341,1606,558,7382,8198,7954,225,7154,7780,1290,1269,9782,5909,6713,3605,5672,8661,6988,4669,1954,7852,5580,5893,6242,9970,2892,4471,4272,3072,8475,9925,8930,442,5873,1128,2204,2384,3532,970,3543,448,4699,2630,7742,1563,1626,3552,3030,3124,4535,650,5330,3862,3799,3011,7809,9538,4567,6431,5775,6903,6675,7459,5750,4193,9102,3352,4107,1483,7454,8293,5044,9638,4995,5558,9882,2316,2614,9934,9669,1486,762,4598,883,3279,6893,1958,9703,7636,5217,8460,3711,2173,1677,9273,1191,7967,6001,9935,7241,2552,4373,8518,2801,3310,839,3715,7410,2663,2894,1335,8993,4987,6888,4139,4324,4024};
        System.out.println(minSwaps(a,1732));*/
/*
        for (int i = 0; i < a.length-54; i++) {
            int count=0;
            for(int j=i;j<i+54;j++){
                if(a[j]<=1732){
                    count++;
                }
            }
            System.out.println(count +"   "+i+ " ");

        }
*/


        //int[] a={5,17,100,11};
      /*  int[] b=new int[55];
        int j=0;
        int l=136+54;
        for(int i=136;i<l;i++,j++){
            b[j]=a[i];
        }
        int count=0;
        for (int i = 0; i < b.length; i++) {
            if(b[i]>1732){
                count++;
            }
        }


        System.out.println(count);*/
    }

    public static int minSwaps(int[] A, int B) {
        int b=0;
        for (int j : A) {
            if (j <= B) {
                b++;
            }
        }
        int goodElementCount=0;
        int maxGoodElementCount=goodElementCount;
        for(int i=0;i<b;i++){
           if(A[i]<=B) goodElementCount++;
        }
        for(int i=1;i<A.length-b;i++){
            boolean goneElementisGood=A[i-1] <= B;
            boolean cameElementisGood=A[i+b-1] <= B;
            if(goneElementisGood && !cameElementisGood){
                goodElementCount--;
            }
            if(!goneElementisGood && cameElementisGood){
                goodElementCount++;
            }
            maxGoodElementCount= Math.max(goodElementCount,maxGoodElementCount);
        }

          return Math.min(b-maxGoodElementCount,A.length-b);
    }
    public static int nobleElementWithSorting(int[] a) {
        Arrays.sort(a);
        int count=0;
        int n=a.length;
      //  int greater=0;
        if(a[n-1]==0){
            count++;
        }
        for (int i = n-2; i >=0 ; i--) {
            if(a[i] != a[i+1]){
                if((n-i-1) == a[i]){//n-i-1 is nothing but the count of greater elements
                    //so just compare the count with A[i] element
                    count++;
                }
            }
        }
        return count == 0 ? -1:count;

    }



    public static int nobleElementBruteforce(int[] A) {
       // Arrays.sort(A);
        int n=0;
        for(int i=A.length-1;i>=0;i--){
            int c=0;
            for(int j=0;j<A.length;j++){
                if(A[j] > A[i])
                {
                    c++;
                }
            }
            if(A[i]==c){
                n++;
            }
        }
        if(n==0){
            return -1;
        }
        else{
            return n;
        }
    }
}
