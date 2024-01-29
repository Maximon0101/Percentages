package pro.maximon.percentages

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class BankCard {
    private val view : View;
    private val deposit_text_input : TextInputEditText;
    private val percentage_text_input : TextInputEditText;
    private val deposit_layout : TextInputLayout;
    private val percetage_layout : TextInputLayout;
    private val context : Context;

    constructor(_view : View, _context : Context) {
        view = _view;
        deposit_text_input = view.findViewById(R.id.bank_card_deposit_text);
        percentage_text_input = view.findViewById(R.id.bank_card_percentage_text);
        deposit_layout = view.findViewById(R.id.bank_card_deposit);
        percetage_layout = view.findViewById(R.id.bank_card_percentage);
        context = _context;


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
        return deposit_text_input.text.toString().toDouble();
    }

    public fun getPercentage() : Double {
        return percentage_text_input.text.toString().toDouble();
    }
}