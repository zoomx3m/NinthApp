package com.example.asus.ninthapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asus.ninthapp.R;
import com.example.asus.ninthapp.Utils.Constants;
import com.example.asus.ninthapp.Utils.Person;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class DataHeadlessFragment extends Fragment {

    private Person currentPerson;
    private List<Person> list;
    private String text = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            list = (List<Person>) savedInstanceState.getSerializable(Constants.LIST_KEY);
            currentPerson = (Person) savedInstanceState.getSerializable(Constants.PERSON_KEY);
        }
        if (list == null) {
            list = new LinkedList<>();
        }
        setRetainInstance(true);
        return null;
    }

        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            outState.putSerializable(Constants.LIST_KEY, (Serializable) list);
            outState.putSerializable(Constants.PERSON_KEY, currentPerson);
        }

        public void registerPerson(Person person) {
            String login = person.getLogin();
            String password = person.getPassword();
            if (serchRegistredUser(login, password) == null) {
                list.add(person);
                currentPerson = person;
            } else {
                Toast.makeText(getActivity(), person.getFirstName() + getString(R.string.already_registered), Toast.LENGTH_SHORT).show();
            }
        }

        public Person serchRegistredUser(String login, String password) {
            for (Person u : list) {
                if (u.getLogin().equals(login) || u.getPassword().equals(password)) {
                    return u;
                }
            }
        return null;
        }

        public boolean loginUsed(Person person) {

            for (Person u : list){
                if (u.getLogin().equals(person.getLogin())){
                    return true;
                }
            }
            return false;
        }

    public void setCurrentPerson (Person currentPerson){
        this.currentPerson = currentPerson;
    }

    public String getText() {
    return text;
    }

    public void storeText(String text){
        this.text = text;
    }
}
