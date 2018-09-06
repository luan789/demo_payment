package vn.com.nttdata.intern.payah;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class ContainerMainActivity extends AppCompatActivity implements View.OnClickListener, FragmentTopupClass.InterfaceTopupListener {
    private Button btnScan, btnTopup, btnPay, btnTransfer, btnHome, btnHistory, btnMe;
    private FrameLayout layoutMain;
    LayoutInflater inflater;
    //fragment container
    private FragmentTopupClass fragmentTopupClass;
    private FragmentTopupSubmit fragmentTopupSubmit;
    private FragmentMainHome fragmentMainHome;
    //////////////////
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container_main);

        findById();//find id view in activity_container_main

        inflater = (LayoutInflater) getSystemService(this.LAYOUT_INFLATER_SERVICE);

        btnScan.setOnClickListener(this);
        btnPay.setOnClickListener(this);
        btnTopup.setOnClickListener(this);
        btnTransfer.setOnClickListener(this);
        btnHome.setOnClickListener(this);
        btnMe.setOnClickListener(this);
        btnHistory.setOnClickListener(this);

        //define fragment manager
        fragmentManager = getSupportFragmentManager();
        //define fragment transaction
        fragmentTransaction = fragmentManager.beginTransaction();
        //define fragment
        fragmentTopupClass = new FragmentTopupClass();
        fragmentTopupSubmit = new FragmentTopupSubmit();
        fragmentMainHome =new FragmentMainHome();
        //default screen start
        fragmentTransaction.add(R.id.layout_container_main, fragmentMainHome);
        fragmentTransaction.commit();
    }

    private void findById() {
        btnScan = findViewById(R.id.button_top_scan);
        btnHistory = findViewById(R.id.button_bot_history);
        btnHome = findViewById(R.id.button_bot_home);
        btnMe = findViewById(R.id.button_bot_me);
        btnTransfer = findViewById(R.id.button_top_transfer);
        btnTopup = findViewById(R.id.button_top_topup);
        btnPay = findViewById(R.id.button_top_pay);
        layoutMain = findViewById(R.id.layout_container_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_top_scan:
                clickBtnScan();
                break;
            case R.id.button_top_topup:
                clickBtnTopup();
                break;
            case R.id.button_top_pay:
                clickBtnPay();
                break;
            case R.id.button_top_transfer:
                clickBtnTransfer();
                break;
            case R.id.button_bot_home:
                clickBtnHome();
                break;
            case R.id.button_bot_me:
                clickBtnMe();
                break;
            case R.id.button_bot_history:
                clickBtnHistory();
                break;
        }
    }

    private void clickBtnScan() {
    }

    private void clickBtnTopup() {
        FragmentTransaction ft_rep = fragmentManager.beginTransaction();
        ft_rep.replace(R.id.layout_container_main, fragmentTopupClass);
        ft_rep.commit();
        //fragmentTransaction.add(R.id.layout_container_main, fragmentTopupClass);
        //fragmentTransaction.commit();
        fragmentTopupClass.setOnclickListener(this);
    }

    private void clickBtnTransfer() {

    }

    private void clickBtnPay() {

    }

    private void clickBtnHome() {
        FragmentTransaction ft_rep = fragmentManager.beginTransaction();
        ft_rep.replace(R.id.layout_container_main, fragmentMainHome);
        ft_rep.commit();
    }

    private void clickBtnMe() {
    }

    private void clickBtnHistory() {
    }



    @Override
    public void clickBtnTopupListener() {
        FragmentTransaction ft_rep = fragmentManager.beginTransaction();
        ft_rep.replace(R.id.layout_container_main, fragmentTopupSubmit);
        ft_rep.commit();
    }

//
//    @Override
//    public void onClickBtnTopup() {
//        Log.d("tag", "click");
//    }
}
