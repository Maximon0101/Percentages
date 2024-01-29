package pro.maximon.percentages

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    lateinit var Bank_1: BankCard;
    lateinit var Bank_2: BankCard;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        val main_layout: LinearLayout = findViewById(R.id.main_layout);
        val children: Array<View> = main_layout.children.toArray(2);
        Bank_1 = BankCard(children.get(0), this);
        Bank_2 = BankCard(children.get(1), this);

    }
}

fun Sequence<View>.toArray(size: Int): Array<View> {
    val iter = iterator()
    return Array<View>(size) { iter.next() }
}

