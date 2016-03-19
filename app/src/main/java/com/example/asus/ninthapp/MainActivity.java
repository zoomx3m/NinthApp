package com.example.asus.ninthapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.ninthapp.Fragment.DataHeadlessFragment;
import com.example.asus.ninthapp.Fragment.LoginFragment;
import com.example.asus.ninthapp.Fragment.MyDialogFragment;
import com.example.asus.ninthapp.Fragment.RegisterFragment;
import com.example.asus.ninthapp.Handler.EventHandler;
import com.example.asus.ninthapp.Utils.Constants;
import com.example.asus.ninthapp.Utils.Person;

public class MainActivity extends AppCompatActivity implements EventHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        commitDataHeadlessFragment();
        commitLoginFragment();
    }

    private void commitLoginFragment(){
        if (getSupportFragmentManager().findFragmentByTag(Constants.LOGIN_FRAGMENT_TAG) ==null){
            LoginFragment loginFragment = new LoginFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.actFragment,loginFragment,Constants.LOGIN_FRAGMENT_TAG)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(Constants.LOGIN_FRAGMENT_TAG)
                    .commit();
        }
    }

    private void commitRegisterFragment(){
        RegisterFragment registerFragment = new RegisterFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.actFragment,registerFragment,Constants.REGISTER_FRAGMENT_TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(Constants.REGISTER_FRAGMENT_TAG)
                .commit();
    }

    private void commitDataHeadlessFragment(){
        if (getDataFragment() == null){
            DataHeadlessFragment dataHeadlessFragment = new DataHeadlessFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(dataHeadlessFragment,Constants.HEADLESS_FRAGMENT_TAG)
                    .commit();

        }
    }

    public DataHeadlessFragment getDataFragment(){
        return (DataHeadlessFragment) getSupportFragmentManager().findFragmentByTag(Constants.HEADLESS_FRAGMENT_TAG);
    }

    public LoginFragment getLoginFragment(){
        return (LoginFragment) getSupportFragmentManager().findFragmentByTag(Constants.LOGIN_FRAGMENT_TAG);
    }


    @Override
    public boolean onButtonLoginPressed(String login, String password) {
        DataHeadlessFragment dataFragment = getDataFragment();
        LoginFragment loginFragment = getLoginFragment();

        Person person = dataFragment.serchRegistredUser(login, password);
        dataFragment.setCurrentPerson(person);
        if (person != null){
            String fullPersonName = person.getHeadLineName();
            String greeting = getString(R.string.hello) + " " + fullPersonName + getString(R.string.exclamation);
            getDataFragment().storeText(greeting);
            loginFragment.refreshHead(greeting);

            String dialogTitle = getString(R.string.login_succesful);
            String dialogMessage = getString(R.string.welcome) + fullPersonName + getString(R.string.exclamation);
            showFragmentDialog(dialogTitle, dialogMessage);
            return true;

        }else {
            String dialogTitle = getString(R.string.login_fail);
            String dialogMessage = getString(R.string.person) + login + getString(R.string.no_exist);
            showAlertDialog(dialogTitle, dialogMessage);
            return false;
        }
    }

    private void showFragmentDialog (String title, String message ){
        MyDialogFragment dialog = MyDialogFragment.newInstance(title, message);
        dialog.show(this.getFragmentManager(), Constants.DIALOG_FRAGMENT_TAG);
    }

    @Override
    public void onButtonRegisterPressed() {
        commitRegisterFragment();
    }

    @Override
    public void onButtonRegisterOk(Person person) {
        DataHeadlessFragment dataFragment = getDataFragment();

        String fullPersonName = person.getHeadLineName();
        String greeting = getString(R.string.hello) + " " + fullPersonName + getString(R.string.exclamation);
        //stores the text that will be shown in login fragment
        getDataFragment().storeText(greeting);

        if (!dataFragment.loginUsed(person)) {
            dataFragment.registerPerson(person);
            String dialogTitle = getString(R.string.reg_succes);
            String dialogMessage = fullPersonName + getString(R.string.registered);
            showFragmentDialog(dialogTitle, dialogMessage);
        } else {
            String dialogTitle = getString(R.string.Try_againe);
            String dialogMessage = getString(R.string.login)
                    + person.getLogin() + getString(R.string.already_used);
            showFragmentDialog(dialogTitle, dialogMessage);
        }

    }

    private void showAlertDialog(String title, String message) {
        AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
        ad.setTitle(title);
        ad.setMessage(message);
        ad.setCancelable(false);
        ad.setNegativeButton(getString(R.string.ok),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = ad.create();
        alert.show();
    }


    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1){
            finish();
        }else {
            super.onBackPressed();
        }
    }

}
