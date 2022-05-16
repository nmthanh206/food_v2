package hcmute.G7.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import hcmute.G7.Database;
import hcmute.G7.Model.User;
import hcmute.G7.R;

public class Register extends AppCompatActivity {
    private Database db;
    EditText name;
    EditText password;
    EditText rePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new Database(this);
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        rePassword = (EditText) findViewById(R.id.repassword);
    }

    public void loginHandler(View v) {
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
//        finish();
    }

    public void onRegisterHandler(View v) {
        if (name.getText().toString().matches("")
                || password.getText().toString().matches("")
                || rePassword.getText().toString().matches("")
        ) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password.getText().toString().equals(rePassword.getText().toString())) {
            Toast.makeText(this, "Password and confirm password does not match", Toast.LENGTH_LONG).show();
            return;
        }
        Boolean isExist = db.checkUserName(name.getText().toString());
        if (isExist) {
            Toast.makeText(this, "Username have existed, please choose another one", Toast.LENGTH_LONG).show();
        } else {
            User user = new User(name.getText().toString(), password.getText().toString());
            db.createUser(user);

            Toast.makeText(this, "Successful account registration", Toast.LENGTH_LONG).show();

            this.loginHandler(null);
        }
    }
}