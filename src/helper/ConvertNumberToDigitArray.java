package helper;

import java.util.ArrayList;

public class ConvertNumberToDigitArray {
    public int[] getNumberArray(long number){
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        while(number>0){
            int rem = (int) (number % 10);
             number = number / 10;
        }
        return null;
    }
}
