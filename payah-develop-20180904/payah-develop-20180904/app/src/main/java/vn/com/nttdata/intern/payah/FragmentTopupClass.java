package vn.com.nttdata.intern.payah;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentTopupClass extends android.support.v4.app.Fragment {
    Button btnTopup;
    InterfaceTopupListener listener;

    public void setOnclickListener(InterfaceTopupListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_topup, container, false);
        btnTopup = view.findViewById(R.id.btn_topup_main_topup);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnTopup.setOnClickListener(new View.OnClickListener() {//click button top up switch activity submit
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.clickBtnTopupListener();
                }
            }
        });
    }

    public interface InterfaceTopupListener {
        void clickBtnTopupListener();
    }
}
