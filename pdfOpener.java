package com.example.view_pdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class pdfOpener extends AppCompatActivity {
PDFView mypdfviewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_opener);
        mypdfviewer=(PDFView)findViewById(R.id.pdfViewer);
        String getItem=getIntent().getStringExtra("pdfFileName");
        if(getItem.equals("dsp lab"))
        {
            mypdfviewer.fromAsset("DSP lab.pdf").load();
        }

        if(getItem.equals("p1"))
        {
            mypdfviewer.fromAsset("p1.pdf").load();
        }

        if(getItem.equals("p2"))
        {
            mypdfviewer.fromAsset("p2.pdf").load();
        }
    }
}
