package pro.maximon.percentages;

public class BankCalculator {

    double deposit;
    double percentage;

    public BankCalculator(double _deposit, double _percentage) {

        deposit =  _deposit;
        percentage = _percentage;
    }

    public double calculateAnnualProfit() {
        deposit *= percentage;
        return deposit;
    }

}
