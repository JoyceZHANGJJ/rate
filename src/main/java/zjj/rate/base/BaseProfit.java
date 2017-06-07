package zjj.rate.base;

/**
 * Created by zhangjingjing9 on 2017/6/7.
 *
 * @author zhangjingjing
 * @version 1.0.0
 * @see BaseProfit
 */
public class BaseProfit {
    private double rate;
    private double initPrincipal;//本金
    private double rollPrincipal;//变化的本金
    private double profit;//利润

    public BaseProfit() {
    }

    /**
     * @param princp initPrincipal 本金
     * @param rt     rate 利率
     */
    public BaseProfit(double princp, double rt) {
        initPrincipal = rollPrincipal = princp;
        rate = rt;
        initProfit();
    }

    public void initProfit() {
        profit = rate * initPrincipal;
    }

    /**
     * show initProfit 计算利润
     *
     * @param princp Principal 本金
     * @param rt     rate 利率
     * @return (double) profit 利润
     */
    public double calculateProfit(double princp, double rt) {
        return princp * rt;
    }

    /**
     * @param princp Principal 本金
     * @param pf     profit 利润
     * @param rt     rate 利率
     * @return (double) 下一次利润
     */
    public double nextTimeProfit(double princp, double pf, double rt) {
        return calculateProfit(princp + pf, rt);
    }

    /**
     *
     * @param times 次数
     */
    public void timesProfit(int times) {
        double tempProfit = 0;
        double tempPrincp = initPrincipal;
        for (int i = 0; i < times; i++) {
            tempProfit = calculateProfit(tempPrincp + tempProfit, rate);
            tempPrincp = initPrincipal + tempPrincp + tempProfit;
        }
        profit = tempPrincp - initPrincipal*times;
    }

    public double timesProfit(double princp, double rt, int times) {
        double profit = 0;
        double tempPrincp = princp;
        for (int i = 0; i < times; i++) {
            profit = calculateProfit(tempPrincp + profit, rt);
            tempPrincp = princp + tempPrincp + profit;
        }
        return tempPrincp - princp * times;
    }

    public double profitToProfit(double princp, double rt, int times) {
        double profit = 0;
        double tempPrincp = princp;
        for (int i = 0; i < times; i++) {
            profit = calculateProfit(tempPrincp + profit, rt);
            tempPrincp = tempPrincp + profit;
        }
        return tempPrincp - princp;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getInitPrincipal() {
        return initPrincipal;
    }

    public void setInitPrincipal(double initPrincipal) {
        this.initPrincipal = initPrincipal;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "BaseProfit{" +
                "rate=" + rate +
                ", initPrincipal=" + initPrincipal +
                ", profit=" + profit +
                '}';
    }
}
