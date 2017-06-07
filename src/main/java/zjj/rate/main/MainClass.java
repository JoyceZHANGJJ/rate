package zjj.rate.main;

import zjj.rate.base.YearProfit;

/**
 * Created by zhangjingjing9 on 2017/6/7.
 */
public class MainClass {
    public static void main(String[] args) {
        YearProfit yearProfit=new YearProfit(50000,0.05);
        double profit=yearProfit.profitToProfit(yearProfit.timesProfit(50000,0.04,10)+50000*10,0.05,8)+yearProfit.timesProfit(50000,0.04,10);
        System.out.printf(""+profit);
    }
}
