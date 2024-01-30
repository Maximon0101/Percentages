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

fun Double.formatTOSiString(context: Context) : String {
    if (this / 1E3 < 1) { return DecimalFormat("#.##").format(this) };
    if (this / 1E6 < 1) { return DecimalFormat("#.##").format(this / 1E3) + context.getString(R.string.kilo) };
    if (this / 1E9 < 1) { return DecimalFormat("#.##").format(this / 1E6) + context.getString(R.string.million) };
    if (this / 1E12 < 1) { return DecimalFormat("#.##").format(this / 1E9) + context.getString(R.string.billion) };
    return context.getString(R.string.tomuch);
}