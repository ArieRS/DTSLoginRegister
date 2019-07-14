package polinema.ac.id.dtsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ProfileActivity extends AppCompatActivity
{
    // Komponen
    private EditText edtUsername;
    private EditText edtPassword;
    private EditText edtEmail;
    private EditText edtPhoneNumber;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        this.loadData();
        this.initComponents();
    }

    private void loadData()
    {

    }

    private void initComponents()
    {
        this.edtUsername = this.findViewById(R.id.edt_username);
        this.edtPassword = this.findViewById(R.id.edt_password);
        this.edtEmail = this.findViewById(R.id.edt_email);
        this.edtPhoneNumber = this.findViewById(R.id.edt_phone_number);
        this.btnSave = this.findViewById(R.id.btn_save);
    }

    public void onBtnSave_Click(View view)
    {
        Toast.makeText(this, "Your data has been updated!", Toast.LENGTH_SHORT).show();
    }

    public void onTxvDeleteAccount_Click(View view)
    {
        Toast.makeText(this, "Your data has been deleted..", Toast.LENGTH_SHORT).show();
    }
}
