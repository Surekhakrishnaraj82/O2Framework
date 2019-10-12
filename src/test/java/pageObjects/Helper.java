package pageObjects;

import java.util.Random;

public class Helper {
    int randomNum;
    public int randomNumberGeneration(int size)
    {
        Random random=new Random();
        if(size>=0) {
            randomNum = random.nextInt(size - 1);
        }
        return randomNum;
    }
}
