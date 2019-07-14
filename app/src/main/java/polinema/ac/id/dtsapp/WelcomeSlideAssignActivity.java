package polinema.ac.id.dtsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeSlideAssignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_slide_assign);
    }

    public void clickGetStarted(View view) {
        Intent i = new Intent(WelcomeSlideAssignActivity.this, WelcomeBackActivity.class);
        startActivity(i);
    }

    public void clickLogin(View view) {
        Intent i = new Intent(WelcomeSlideAssignActivity.this, WelcomeBackActivity.class);
        startActivity(i);
    }
}
