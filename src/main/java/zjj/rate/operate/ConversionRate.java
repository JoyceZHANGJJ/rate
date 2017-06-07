package zjj.rate.operate;

import zjj.rate.base.DayProfit;
import zjj.rate.base.MonthProfit;
import zjj.rate.base.YearProfit;

/**
 * Created by zhangjingjing9 on 2017/6/7.
 */
public class ConversionRate {
    private DayProfit dayProfit=null;
    private MonthProfit monthProfit=null;
    private YearProfit yearProfit=null;

    public ConversionRate(DayProfit dProfit){
        dayProfit=dProfit;
        yearProfit=new YearProfit(dayProfit.getInitPrincipal(),dayProfit.getRate()*365);
        monthProfit=new MonthProfit(dayProfit.getInitPrincipal(),yearProfit.getRate()/12);
    }

    public ConversionRate(MonthProfit mProfit){
        monthProfit=mProfit;
        yearProfit=new YearProfit(monthProfit.getInitPrincipal(),dayProfit.getRate()*12);
        dayProfit=new DayProfit(monthProfit.getInitPrincipal(),yearProfit.getRate()/365);
    }

    public ConversionRate(YearProfit yProfit){
        yearProfit=yProfit;
        dayProfit=new DayProfit(yearProfit.getInitPrincipal(),yearProfit.getRate()/365);
        monthProfit=new MonthProfit(yearProfit.getInitPrincipal(),yearProfit.getRate()/12);
    }

}
