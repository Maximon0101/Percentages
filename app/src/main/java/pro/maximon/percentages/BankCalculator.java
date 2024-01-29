package pro.maximon.percentages;

public class BankCalculator {

    double deposit;
    double percentage;

    public BankCalculator(double _deposit, double _percentage) {

        deposit =  _deposit;
        percentage = _percentage;
    }

    public double calculateAnnualProfit() {
        double current_deposit = deposit;
        double monthly_percentage = percentage / 12;

        for (int i = 1; i < 13; i++) {
            current_deposit *= monthly_percentage + 1;
        }
        return current_deposit;
    }

}
