package com.example.asus.ninthapp.Fragment;


import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;

import com.example.asus.ninthapp.R;
import com.example.asus.ninthapp.Utils.Constants;

public class MyDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString(Constants.TITLE_KEY);
        String message = getArguments().getString(Constants.MESSAGE_KEY);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        return builder.create();

    }

    public static MyDialogFragment newInstance (String title,String message){
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        Bundle argum = new Bundle();
        argum.putString(Constants.TITLE_KEY, title);
        argum.putString(Constants.MESSAGE_KEY, message);
        myDialogFragment.setArguments(argum);
        return myDialogFragment;
    }

}
