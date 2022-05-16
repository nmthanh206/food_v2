package hcmute.G7.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import hcmute.G7.Database;
import hcmute.G7.R;

public class Login extends AppCompatActivity {
    private Database db;
    EditText name;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new Database(this);
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
    }

    public void registerHandler(View v) {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
//        finish();
    }

    public void forgotPasswordHandler(View v) {
        Intent intent = new Intent(Login.this, ForgotPassword.class);
        startActivity(intent);
//        finish();
    }

    public void onLoginHandler(View v) {
        if (name.getText().toString().matches("") ||password.getText().toString().matches("")) {
            Toast.makeText(this, "UserName or Password cant be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        Boolean isValid= db.authenticateUser(name.getText().toString(),password.getText().toString());

        if(isValid){
            Intent intent = new Intent(Login.this, Home.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_LONG).show();
        }


    }
}