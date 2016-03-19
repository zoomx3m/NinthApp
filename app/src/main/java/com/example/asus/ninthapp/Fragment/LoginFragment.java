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
    TextView tvHead;
    EditText etLogin;
    EditText etPassword;
    TextView btn_Register;
    Button btnLogin;
    EventHandler evHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login, container, false);

        initElements(view);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_login_AM:
                String login = etLogin.getText().toString();
                String password = etPassword.getText().toString();
                evHandler.onButtonLoginPressed(login, password);
                break;
            case R.id.tv_register_AM:
                evHandler.onButtonRegisterPressed();
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

    private void initElements(View view) {
        tvHead = (TextView) view.findViewById(R.id.headText_AM);
        etLogin = (EditText) view.findViewById(R.id.et_Login_AM);
        etPassword = (EditText) view.findViewById(R.id.et_Password_AM);
        btn_Register = (TextView) view.findViewById(R.id.tv_register_AM);
        btnLogin = (Button) view.findViewById(R.id.btn_login_AM);
        evHandler = (EventHandler) getActivity();
        btnLogin.setOnClickListener(this);
        btn_Register.setOnClickListener(this);
    }
}
