package com.example.mydatabook;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BioFragment extends Fragment {
    public static final String USER_PREF = "USER_PREF";
    Button btn;
    TextView tv;

    SharedPreferences pref;

    public BioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.biofragment, container, false);
        btn = v.findViewById(R.id.btn);
        tv = v.findViewById(R.id.tv);
        pref = getActivity().getSharedPreferences(USER_PREF, Context.MODE_PRIVATE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
                View mView = getLayoutInflater().inflate(R.layout.dialog, null);
                final EditText etInput = mView.findViewById(R.id.et);
                etInput.setText(tv.getText().toString());
                mBuilder.setTitle("Edit Bio").setView(mView).setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String text = etInput.getText().toString();
                                tv.setText(text);
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog alertDialog = mBuilder.create();
                alertDialog.show();
            }
        });
        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("bio_data", tv.getText().toString());
        editor.commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        String data = pref.getString("bio_data", "Default Text");
        tv.setText(data);
    }
}
