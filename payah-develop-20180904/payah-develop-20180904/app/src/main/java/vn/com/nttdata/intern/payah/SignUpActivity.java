package vn.com.nttdata.intern.payah;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {
    private Spinner spnnerPhoneNumber;
    private EditText editName;
    private EditText editId;
    private EditText editPin;
    private EditText editConfirmPin;
    private EditText editPhoneNumber;
    private EditText editEmail;
    private EditText editAdress;
    private Button btnRegister;
    private Button btnClear;
    public static final String PREFE_REGISTER = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Init();

        editName = (EditText) findViewById(R.id.editName);
        editId = (EditText) findViewById(R.id.editId);
        editPin = (EditText) findViewById(R.id.editPin);
        editConfirmPin = (EditText) findViewById(R.id.editConfrimPin);
        editPhoneNumber = (EditText) findViewById(R.id.editPhoneNumber);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editAdress = (EditText) findViewById(R.id.editAdress);
        btnRegister = (Button) findViewById(R.id.btnRegisterSignup);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(PREFE_REGISTER, MODE_PRIVATE);
                String newName = editName.getText().toString();
                String newId = editId.getText().toString();
                String newPin = editId.getText().toString();
                String newPhoneNumber =editPhoneNumber.getText().toString();
                String newEmail =editEmail.getText().toString();
                String newAdress =editAdress.getText().toString();
                SharedPreferences.Editor editor =preferences.edit();
                editor.putString("Name",newName);
                editor.putString("ID",newId);
                editor.putString("Phone",newPhoneNumber);
                editor.putString("Email",newEmail);
                editor.putString("Adress",newAdress);
                editor.commit();
                Toast.makeText(SignUpActivity.this,"Success",Toast.LENGTH_SHORT).show();

            }
        });


    }


    public void Init() {

        spnnerPhoneNumber = (Spinner) findViewById(R.id.spinnerPhoneNumber);
        ArrayList<Country> arrayList = new ArrayList<Country>();
        arrayList.add(new Country(R.drawable.ic_malaysia, "+60"));
        arrayList.add(new Country(R.drawable.ic_thailand, "+61"));
        arrayList.add(new Country(R.drawable.ic_singapore, "+62"));
        CountryAdapter adapter = new CountryAdapter(SignUpActivity.this, R.layout.item_country_current, arrayList);
        spnnerPhoneNumber.setAdapter(adapter);
    }
}
