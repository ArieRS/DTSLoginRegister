package polinema.ac.id.dtsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import polinema.ac.id.dtsapp.db.DTSAppDatabase;
import polinema.ac.id.dtsapp.db.entities.User;

public class RegisterActivity extends AppCompatActivity
{
    private EditText edtUsername;
    private EditText edtPassword;
    private EditText edtEmail;
    private EditText edtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.initComponents();
    }

    private void initComponents()
    {
        this.edtUsername = this.findViewById(R.id.edt_username);
        this.edtPassword = this.findViewById(R.id.edt_password);
        this.edtEmail = this.findViewById(R.id.edt_email);
        this.edtPhoneNumber = this.findViewById(R.id.edt_phone_number);
    }

    public void onBtnRegisterNow_Click(View view)
    {
        User mUser = new User();
        mUser.setEmail(edtEmail.getText().toString().trim());
        mUser.setPassword(edtPassword.getText().toString().trim());
        mUser.setPhoneNumber(edtPhoneNumber.getText().toString().trim());
        mUser.setUsername(edtUsername.getText().toString().trim());

        if ( (edtEmail.getText().toString().trim().length()>0) &&
                (edtPassword.getText().toString().trim().length()>0)   &&
                (edtPhoneNumber.getText().toString().trim().length()>0) &&
                (edtUsername.getText().toString().trim().length()>0)){
            DTSAppDatabase dtsAppDatabase = DTSAppDatabase.getInstance(
                    getApplicationContext());

            dtsAppDatabase.insertUser(mUser);
            // Tampilkan pesan konfirmasi
            Toast.makeText(this, "Register Success!, Kembali Ke halaman Login", Toast.LENGTH_LONG).show();

            // Kembali ke halaman login
            Intent intent = new Intent(getApplicationContext(), WelcomeBackActivity.class);
            this.finish();
        }else{
            Toast.makeText(getApplicationContext(),"Semua Field Harap Diisi",Toast.LENGTH_LONG).show();
        }




    }
}
