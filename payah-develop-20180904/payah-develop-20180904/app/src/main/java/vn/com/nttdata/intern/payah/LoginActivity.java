package vn.com.nttdata.intern.payah;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static vn.com.nttdata.intern.payah.SignUpActivity.PREFE_REGISTER;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin, btnSigup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btn_loging);
        btnSigup = findViewById(R.id.btnSignUp);
        btnLogin.setOnClickListener(this);
        btnSigup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_loging:
                clickBtnLogin();
                break;

            case R.id.btnSignUp:
                clickBtnSignUp();
                break;
        }
    }

    private void clickBtnLogin() {
        Intent intent = new Intent(LoginActivity.this, ContainerMainActivity.class);
        startActivity(intent);
        finish();
    }

    private void clickBtnSignUp() {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }





}
