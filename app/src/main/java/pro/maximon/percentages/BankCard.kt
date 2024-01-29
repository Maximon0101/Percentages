package pro.maximon.percentages

import android.content.Context
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class BankCard(_view: View, _context: Context) {
    private val view : View = _view;
    private val context : Context = _context;
    private val deposit_text_input : TextInputEditText = view.findViewById(R.id.bank_card_deposit_text);
    private val percentage_text_input : TextInputEditText = view.findViewById(R.id.bank_card_percentage_text);
    private val deposit_layout : TextInputLayout = view.findViewById(R.id.bank_card_deposit);
    private val percetage_layout : TextInputLayout = view.findViewById(R.id.bank_card_percentage);

    init {
        deposit_text_input.addTextChangedListener {
            val str : String = deposit_text_input.text.toString();
            if (!isNumber(str)) {
                deposit_layout.error = context.getString(R.string.input_error)
            } else {
                deposit_layout.error = null;
            }
        }
        percentage_text_input.addTextChangedListener {
            val str : String = percentage_text_input.text.toString();
            if (!isNumber(str)) {
                percetage_layout.error = context.getString(R.string.input_error)
            } else {
                percetage_layout.error = null;
            }
        }
    }

    public fun validate() : Boolean {
        if (!isNumber(deposit_text_input.text.toString())) {
            deposit_layout.error = context.getString(R.string.input_error)
        }

        if (!isNumber(percentage_text_input.text.toString())) {
            percetage_layout.error = context.getString(R.string.input_error)
        }
        return isNumber(deposit_text_input.text.toString()) && isNumber(percentage_text_input.text.toString())
    }

    public  fun getDeposit() : Double {
        return deposit_text_input.text
            .toString()
            .replace(',', '.')
            .toDouble();
    }

    public fun getPercentage() : Double {
        return percentage_text_input.text
            .toString()
            .replace(',', '.')
            .toDouble() / 100;
    }
}