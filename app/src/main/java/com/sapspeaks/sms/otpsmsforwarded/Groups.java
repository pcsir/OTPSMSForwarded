package com.sapspeaks.sms.otpsmsforwarded;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Groups extends Fragment {

    EditText editText;
    String result;
    ArrayList<String> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_groups, container, false);

        ListView listView = rootView.findViewById(R.id.groups_list);
        editText = rootView.findViewById(R.id.groupsInput);

        arrayList = new ArrayList<String>();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,
                android.R.id.text1, arrayList);
        listView.setAdapter(arrayAdapter);


        FloatingActionButton fab = rootView.findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertBoxGroups();
            }

        });


        return rootView;
    }

    public void alertBoxGroups() {

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        final EditText edittext = new EditText(getContext());
        alert.setMessage("Enter Your Message");
        alert.setTitle("Enter Your Title");

        alert.setView(edittext);

        alert.setPositiveButton("Yes Option", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //What ever you want to do with the value

                //OR
                result = edittext.getText().toString();
                arrayList.add(result);
            }
        });

        alert.setNegativeButton("No Option", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // what ever you want to do with No option.
            }
        });

        alert.show();

    }

}

