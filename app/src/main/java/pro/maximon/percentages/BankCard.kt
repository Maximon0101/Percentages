package pro.maximon.percentages

import android.content.Context
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText

class BankCard {
    private val view : View;
    private val deposit_text_input : TextInputEditText;
    private val percentage_text_input : TextInputEditText;

    constructor(_view : View, _context : Context) {
        view = _view;
        deposit_text_input = view.findViewById(R.id.bank_card_deposit_text);
        percentage_text_input = view.findViewById(R.id.bank_card_percentage_text);

        deposit_text_input.addTextChangedListener {

        }
    }
}