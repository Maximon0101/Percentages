package pro.maximon.percentages

import android.graphics.drawable.Icon
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.core.view.children
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    lateinit var bankCard_1: BankCard;
    lateinit var bankCard_2: BankCard;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        val main_layout: LinearLayout = findViewById(R.id.main_layout);
        val children: Array<View> = main_layout.children.toArray(2);
        bankCard_1 = BankCard(children.get(0), this);
        bankCard_2 = BankCard(children.get(1), this);


        findViewById<Button>(R.id.calculate_button).setOnClickListener {
            if (!(bankCard_1.validate() && bankCard_2.validate())) {
                val builder = AlertDialog.Builder(this);
                builder.setTitle(getString(R.string.error));
                builder.setMessage(getString(R.string.validation_error_message));
                builder.setNeutralButton("Ok") {dialogInterface, i ->};
                builder.show();
            }

            val deposit_1 : Double = bankCard_1.getDeposit();
            val percentage_1 : Double = bankCard_1.getPercentage();
            val deposit_2 : Double = bankCard_2.getDeposit();
            val percentage_2 : Double = bankCard_2.getPercentage();

            val profit_1 : Double = BankCalculator(deposit_1, percentage_1).calculateAnnualProfit();
            val profit_2 : Double = BankCalculator(deposit_2, percentage_2).calculateAnnualProfit();
            val profit = profit_1 + profit_2;
            val percentage = (profit / (deposit_1 + deposit_2)) - 1;

            val profit_out_text = DecimalFormat("#.##").format(profit) + "₽";
            val percentage_out_text = DecimalFormat("#.##").format(percentage * 100) + "%";

            findViewById<TextView>(R.id.profit_value_text).text = profit_out_text;
            findViewById<TextView>(R.id.percentage_value_text).text = percentage_out_text;
        }
    }
}

fun Sequence<View>.toArray(size: Int): Array<View> {
    val iter = iterator()
    return Array<View>(size) { iter.next() }
}

