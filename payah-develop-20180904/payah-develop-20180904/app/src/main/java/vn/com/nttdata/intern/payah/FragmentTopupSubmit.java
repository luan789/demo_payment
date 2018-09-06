package vn.com.nttdata.intern.payah;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentTopupSubmit extends Fragment implements View.OnClickListener {
    TextView num1, num9, num8, num7, num6, num5, num4, num3, num2, num0;
    ImageView numBackspace;
    Button btnSubmitTopUp, btnBackTopupsubmit;
    TextView tvValueCurrent, tvTitleCurrent;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main_topup_submit, container, false);
        findIdLayout(v);
        tvValueCurrent.setText("");
        return v;
    }

    private void findIdLayout(View v) {
        num0 = v.findViewById(R.id.keyboard_num_0);
        numBackspace = v.findViewById(R.id.keyboard_num_backspace);
        num1 = v.findViewById(R.id.keyboard_num_1);
        num2 = v.findViewById(R.id.keyboard_num_2);
        num3 = v.findViewById(R.id.keyboard_num_3);
        num4 = v.findViewById(R.id.keyboard_num_4);
        num5 = v.findViewById(R.id.keyboard_num_5);
        num6 = v.findViewById(R.id.keyboard_num_6);
        num7 = v.findViewById(R.id.keyboard_num_7);
        num8 = v.findViewById(R.id.keyboard_num_8);
        num9 = v.findViewById(R.id.keyboard_num_9);
        btnBackTopupsubmit = v.findViewById(R.id.btn_back_topupsubmit);
        btnSubmitTopUp = v.findViewById(R.id.btn_submit_topup);
        tvTitleCurrent = v.findViewById(R.id.textview_current_title_topupsubmit);
        tvValueCurrent = v.findViewById(R.id.textview_current_value_topupsubmit);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setOnclickButton();
    }

    //set onclick button
    private void setOnclickButton() {
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        numBackspace.setOnClickListener(this);
        btnSubmitTopUp.setOnClickListener(this);
        btnBackTopupsubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.keyboard_num_0:
                getTextKeyBoard(num0.getText().toString());
                break;
            case R.id.keyboard_num_1:
                getTextKeyBoard(num1.getText().toString());
                break;
            case R.id.keyboard_num_2:
                getTextKeyBoard(num2.getText().toString());
                break;
            case R.id.keyboard_num_3:
                getTextKeyBoard(num3.getText().toString());
                break;
            case R.id.keyboard_num_4:
                getTextKeyBoard(num4.getText().toString());
                break;
            case R.id.keyboard_num_5:
                getTextKeyBoard(num5.getText().toString());
                break;
            case R.id.keyboard_num_6:
                getTextKeyBoard(num6.getText().toString());
                break;
            case R.id.keyboard_num_7:
                getTextKeyBoard(num7.getText().toString());
                break;
            case R.id.keyboard_num_8:
                getTextKeyBoard(num8.getText().toString());
                break;
            case R.id.keyboard_num_9:
                getTextKeyBoard(num9.getText().toString());
                break;
            case R.id.btn_submit_topup:
                //getTextKeyBoard(num9.getText().toString());
                Log.d("tag", "aaaa");
                break;
            case R.id.keyboard_num_backspace:
                clickBackspace();
                break;
            case R.id.btn_back_topupsubmit:

                break;
        }
    }

    private void getTextKeyBoard(String a) {
        if (tvValueCurrent.getText().length() < 5) {
            if (tvValueCurrent.getText().length() == 2) {
                tvValueCurrent.setText(tvValueCurrent.getText() + ".");
            }
            tvValueCurrent.setText(tvValueCurrent.getText() + a);
        }
    }

    private void clickBackspace() {
        int n = tvValueCurrent.getText().length();
        if (n > 0) {
            tvValueCurrent.setText(tvValueCurrent.getText().toString().substring(0, n - 1));
            if (tvValueCurrent.getText().length() == 3)
                tvValueCurrent.setText(tvValueCurrent.getText().toString().substring(0, tvValueCurrent.getText().length() - 1));
        }
    }


}
