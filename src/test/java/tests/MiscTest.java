package tests;

import org.testng.annotations.Test;


public class MiscTest extends BaseTest{



    @Test
    public void inputMinHR() {
        int minHR = 60;
        int maxHR = 70;
        int num = (int) Math.floor(Math.random()*(maxHR - minHR + 1) + minHR);
        String strNum = String.valueOf(num);
        System.out.println(strNum);
    }

    @Test
    public void inputMaxHR() {
        int minHR = 90;
        int maxHR = 100;
        int num = (int) Math.floor(Math.random()*(maxHR - minHR + 1) + minHR);
        String strNum = String.valueOf(num);
        System.out.println(strNum);
    }
}
