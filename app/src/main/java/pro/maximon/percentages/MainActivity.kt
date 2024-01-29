package pro.maximon.percentages

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        val main_layout : LinearLayout = findViewById(R.id.main_layout);
        val children : Array<View> = main_layout.children.toArray(2);
    }
}

fun Sequence<View>.toArray(size: Int): Array<View> {
    val iter = iterator()
    return Array<View>(size) { iter.next() }
}

