package pro.maximon.percentages

fun isNumber(string: String) : Boolean {
    var count : Int = 0;
    if (string.length == 0) { return false };

    for (char in string) {
        if (char !in "0123456789.,") { return false };
        if (char in ".,") { count++ }
    }
    if (count > 1) { return false };
    return true;
}