package com.adgvit.iosfusion2017;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class AboutUs extends Fragment implements View.OnClickListener {

    private ImageButton insta;
    private ImageButton fb;
    private ImageButton linkedin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.aboutus, container, false);
        insta=(ImageButton) rootView.findViewById(R.id.insta);
        fb=(ImageButton) rootView.findViewById(R.id.facebook);
        linkedin=(ImageButton)rootView.findViewById(R.id.linkedin);
        insta.setOnClickListener(this);
        fb.setOnClickListener(this);
        linkedin.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.facebook:
                Intent face=new Intent(Intent.ACTION_VIEW);
                face.setData(Uri.parse("https://www.facebook.com/vitios/"));
                startActivity(face);
                break;
            case R.id.insta:
                Intent insta=new Intent(Intent.ACTION_VIEW);
                insta.setData(Uri.parse("https://www.instagram.com/adgvit/"));
                startActivity(insta);
                break;
            case R.id.linkedin:
                Intent linkedin=new Intent(Intent.ACTION_VIEW);
                linkedin.setData(Uri.parse("https://www.linkedin.com"));
                startActivity(linkedin);
                break;
        }

    }
}
