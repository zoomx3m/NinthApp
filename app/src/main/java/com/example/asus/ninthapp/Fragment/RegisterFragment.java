package com.example.asus.ninthapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.asus.ninthapp.Handler.EventHandler;
import com.example.asus.ninthapp.R;
import com.example.asus.ninthapp.Utils.Gender;
import com.example.asus.ninthapp.Utils.Person;

public class RegisterFragment extends Fragment {

    private TextView tvHead;
    private EditText etLogin;
    private EditText etPassword;
    private EditText etFirstName;
    private EditText etLastName;
    private RadioButton btnFemale;
    private RadioButton btnMale;
    private Button btnRegister;
    private EventHandler eventHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viev = inflater.inflate(R.layout.activity_login, container, false);
        tvHead = (TextView) viev.findViewById(R.id.headText_RF);
        etLogin = (EditText) viev.findViewById(R.id.et_Login_RF);
        etPassword = (EditText) viev.findViewById(R.id.et_Password_RF);
        etFirstName = (EditText) viev.findViewById(R.id.et_firstName_RF);
        etLastName = (EditText) viev.findViewById(R.id.et_lastName_RF);
        btnFemale = (RadioButton) viev.findViewById(R.id.radio_female_RF);
        btnMale = (RadioButton) viev.findViewById(R.id.radio_male_RF);
        eventHandler = (EventHandler) getActivity();
        btnRegister = (Button) viev.findViewById(R.id.btn_registe_RF);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person();
                String loginn = etLogin.getText().toString();
                String password = etLogin.getText().toString();
                String firstName = etFirstName.getText().toString();
                String lastName = etLastName.getText().toString();

                if (btnFemale.isChecked()){
                    person.setGender(Gender.female);
                }
                if (btnMale.isChecked()){
                    person.setGender(Gender.male);
                }
                eventHandler.onButtonRegisterOk(person);

            }
        });
        return viev;

    }


}




