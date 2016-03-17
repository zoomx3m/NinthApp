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
import android.widget.TextView;

import com.example.asus.ninthapp.Handler.EventHandler;
import com.example.asus.ninthapp.MainActivity;
import com.example.asus.ninthapp.R;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private TextView tvHead;
    private EditText etLogin;
    private EditText etPassword;
    private TextView btnRegister;
    private Button btnLogin;
    private EventHandler eventHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login, container, false);

        tvHead = (TextView) view.findViewById(R.id.headText_AM);
        etLogin = (EditText) view.findViewById(R.id.et_Login_AM);
        etPassword = (EditText) view.findViewById(R.id.et_Password_AM);
        btnRegister = (TextView) view.findViewById(R.id.tv_register_AM);
        btnLogin = (Button) view.findViewById(R.id.btn_login_AM);
        eventHandler = (EventHandler) getActivity();
        etLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_login_AM:
                String login = etLogin.getText().toString();
                String password = etPassword.getText().toString();
                eventHandler.onButtonLoginPressed(login, password);
                break;
            case R.id.tv_register_AM:
                eventHandler.onButtonRegisterPressed();
                break;

        }

    }

    public void refreshHead (String greeting){
        tvHead.setText(greeting);
    }

    @Override
    public void onResume() {
        super.onResume();
        String message = ((MainActivity) getActivity()).getDataFragment().getText();
        if (TextUtils.isEmpty(message)){
            refreshHead (getString(R.string.hello));
        }else {
            refreshHead(message);
        }

    }
}
