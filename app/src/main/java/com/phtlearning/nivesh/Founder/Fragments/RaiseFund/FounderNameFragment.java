package com.phtlearning.nivesh.Founder.Fragments.RaiseFund;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.phtlearning.nivesh.R;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FounderNameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FounderNameFragment extends Fragment {
    Button FounderNameNxtBtn;
    EditText FounderNameEditText;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FounderNameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FounderNameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FounderNameFragment newInstance(String param1, String param2) {
        FounderNameFragment fragment = new FounderNameFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_founder_name, container, false);
        FounderNameNxtBtn = (Button) view.findViewById(R.id.founder_name_nxt_btn);
        FounderNameEditText = (EditText) view.findViewById(R.id.founder_name_edt_txt);
        String CompanyName = getArguments().getString("CompanyName");

        FounderNameNxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FounderName = FounderNameEditText.getText().toString().trim();
                if(TextUtils.isEmpty(FounderName))
                {
                    Toast.makeText(getContext(), "This Field Can't be Empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    CoverImageFragment obj = new CoverImageFragment();
                    Bundle args = new Bundle();
                    args.putString("CompanyName", CompanyName);
                    args.putString("FounderName", FounderName);
                    obj.setArguments(args);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag, obj).commit();
                }

            }
        });

        return view;
    }
}