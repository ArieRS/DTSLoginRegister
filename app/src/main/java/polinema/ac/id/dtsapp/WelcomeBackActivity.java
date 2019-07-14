package polinema.ac.id.dtsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

import polinema.ac.id.dtsapp.db.DTSAppDatabase;
import polinema.ac.id.dtsapp.db.entities.User;

public class WelcomeBackActivity extends AppCompatActivity {

    private static final String DUMMY_USERNAME = "dtsawardee";
    private static final String DUMMY_PASSWORD = "dtsrocks";

    // Komponen
    private EditText edtUsername;
    private EditText edtPassword;
    private CheckBox chkRememberUsername;
    private CheckBox chkKeepLogin;

    private SharedPreferences sharedPrefs;
    public static final String USERNAME_KEY = "key_username";
    public static final String KEEP_LOGIN_KEY = "key_keep_login";
    public static  final String KEY_SHARE_PREF = "dtsapp_sharedprefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_back);


        this.initComponents();

        sharedPrefs = getSharedPreferences(KEY_SHARE_PREF, Context.MODE_PRIVATE);
        loadSavedUsername();

    }

    private void initComponents()
    {
        // Init components
        this.edtUsername = this.findViewById(R.id.edt_username);
        this.edtPassword = this.findViewById(R.id.edt_password);
        this.chkRememberUsername = this.findViewById(R.id.chk_remember_username);
        this.chkKeepLogin = this.findViewById(R.id.chk_keep_login);
    }

    // Click Actions

    public void onTxvForgotPassword_Click(View view)
    {
        Intent i = new Intent(WelcomeBackActivity.this, ForgotPasswordActivity.class);
        startActivity(i);
    }

    public void onBtnLogin_Click(View view)
    {
        if ((edtUsername.getText().toString().trim().length()>0) &&
           (edtPassword.getText().toString().length()>0)){


            DTSAppDatabase dtsAppDatabase = DTSAppDatabase.getInstance(getApplicationContext());
            User mUser = dtsAppDatabase.getUserByUsername(edtUsername.getText().toString().trim(), edtPassword.getText().toString().trim());

            if(mUser==null){
                Toast.makeText(getApplicationContext(),"User Name Dan Password Pastikan Diisi Dengan Benar", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"User Name Dan Password Benar", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(WelcomeBackActivity.this, HomeActivity.class);
                startActivity(i);
                this.saveUsername();
            }

            this.makeAutoLogin();


        }
        else{
            Toast.makeText(getApplicationContext(),"User Name Dan Password Harap Diisi", Toast.LENGTH_SHORT).show();
        }

    }

    public void onBtnRegister_Click(View view)
    {
        Intent i = new Intent(WelcomeBackActivity.this, RegisterActivity.class);
        startActivity(i);
    }

    // End of Click Actions

    private void saveUsername()
    {
        // Menyimpan username bila diperlukan
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(USERNAME_KEY, edtUsername.getText().toString());
        editor.apply();
    }

    private void loadSavedUsername()
    {
        // Memeriksa apakah sebelumnya ada username yang tersimpan?
        // Jika ya, maka tampilkan username tersebut di EditText username.
        String savedUsername  = this.sharedPrefs.getString(USERNAME_KEY,"");
        edtUsername.setText(savedUsername);
    }


    private void makeAutoLogin()
    {
        // Mengatur agar selanjutnya pada saat aplikasi dibuka menjadi otomatis login
    }

    // QUIZ!
    private void autoLogin()
    {
        // Cek apakah sebelumnya aplikasi diatur agar bypass login?
        // Jika ya maka langsung buka activity berikutnya
    }
}
