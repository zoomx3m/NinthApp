package com.example.asus.ninthapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.asus.ninthapp.Handler.EventHandler;
import com.example.asus.ninthapp.R;
import com.example.asus.ninthapp.Utils.Gender;
import com.example.asus.ninthapp.Utils.Person;

public class RegisterFragment extends Fragment {
    private EditText etLogin;
    private EditText etPassword;
    private EditText etFirstName;
    private EditText etLastName;
    private RadioButton btnFemale;
    private RadioButton btnMale;
    private Button btnRegister;
    private EventHandler evHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_register, container, false);
        initElements(view);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person();
                String login = etLogin.getText().toString();
                String password = etPassword.getText().toString();
                String firstName = etFirstName.getText().toString();
                String lastName = etLastName.getText().toString();

                if (TextUtils.isEmpty(login) || TextUtils.isEmpty(password) ||
                        TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName)){
                    Toast.makeText(getActivity(), R.string.fill_in_fields, Toast.LENGTH_SHORT).show();
                } else {
                    person.setLogin(login);
                    person.setPassword(password);
                    person.setFirstName(firstName);
                    person.setLastName(lastName);

                    if (btnFemale.isChecked()){
                        person.setGender(Gender.female);
                    }
                    if (btnMale.isChecked()){
                        person.setGender(Gender.male);
                    }
                    evHandler.onButtonRegisterOk(person);
                }
            }
        });
        return view;
    }

    private void initElements (View view) {
        etLogin = (EditText) view.findViewById(R.id.et_Login_RF);
        etPassword = (EditText) view.findViewById(R.id.et_Password_RF);
        etFirstName = (EditText) view.findViewById(R.id.et_firstName_RF);
        etLastName = (EditText) view.findViewById(R.id.et_lastName_RF);
        btnFemale = (RadioButton) view.findViewById(R.id.radio_female_RF);
        btnMale = (RadioButton) view.findViewById(R.id.radio_male_RF);
        btnRegister = (Button) view.findViewById(R.id.btn_register_RF);
        evHandler = (EventHandler) getActivity();

    }

}




