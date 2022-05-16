package hcmute.G7.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import hcmute.G7.R;
public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }
    public  void registerHandler(View v){
        Intent intent=new Intent(ForgotPassword.this,Register.class);
        startActivity(intent);
//        finish();
    }
    public  void loginHandler(View v){
        Intent intent=new Intent(ForgotPassword.this,Login.class);
        startActivity(intent);
//        finish();
    }
}