package polinema.ac.id.dtsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class WelcomeSlideCalendarActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_slide);
        sharedPreferences = getSharedPreferences(
                WelcomeBackActivity.KEY_SHARE_PREF, Context.MODE_PRIVATE);

        //get value
        String userName = sharedPreferences.getString(WelcomeBackActivity.USERNAME_KEY,"");

        Toast.makeText(getApplicationContext(),userName,Toast.LENGTH_SHORT).show();
    }

    public void clickGetStarted(View view) {
        Intent i = new Intent(WelcomeSlideCalendarActivity.this, WelcomeSlideSuperheroActivity.class);
        startActivity(i);
    }

    public void clickLogin(View view) {
        Intent i = new Intent(WelcomeSlideCalendarActivity.this, WelcomeBackActivity.class);
        startActivity(i);
    }
}
