package pro.maximon.percentages

import android.content.Context
import java.text.DecimalFormat

fun isNumber(string: String) : Boolean {
    var count : Int = 0;
    if (string.length == 0) { return false };
    if ((string.length == 1) && ( (string == ".") || (string == ",") )) { return false };

    for (char in string) {
        if (char !in "0123456789.,") { return false };
        if (char in ".,") { count++ }
    }
    if (count > 1) { return false };
    return true;
}

fun SI(profit : Double, context: Context) : String {
    if (profit / 1000 < 1) { return DecimalFormat("#.##").format(profit) };
    if (profit / 1000000 < 1) { return DecimalFormat("#.##").format(profit / 1000) + context.getString(R.string.kilo) };
    if (profit / 1000000000 < 1) { return DecimalFormat("#.##").format(profit / 1000000) + context.getString(R.string.million) };
    if (profit / 1000000000000 < 1) { return DecimalFormat("#.##").format(profit / 1000000000) + context.getString(R.string.billion) };
    return context.getString(R.string.tomuch);
}