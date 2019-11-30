package com.example.view_pdf;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
ListView pdfListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfListView=(ListView)findViewById(R.id.myPDFlist);
        String[] pdffiles={"dsp lab","p1","p2"};

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.single_row,R.id.textView5,pdffiles)
        {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
               View view=super.getView(position,convertView,parent);
                TextView mytext=(TextView)view.findViewById(android.R.id.text1);
                return view;
            }
        };

        pdfListView.setAdapter(adapter);

        pdfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
           String item=pdfListView.getItemAtPosition(i).toString();
                Intent start=new Intent(getApplicationContext(),pdfOpener.class);
                start.putExtra("pdfFileName",item);
                startActivity(start);
            }
        });
        // context menu
        //on long click there are two menus will appear name as delete and share added in menu folder
        registerForContextMenu(pdfListView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId())
        {
            case R.id.share:

                /*ApplicationInfo applicationInfo=getApplicationContext().getApplicationInfo();
                String apkpath=applicationInfo.sourceDir;
                File file=new File(apkpath);
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("application/pdf");
                intent.putExtra(Intent.EXTRA_TEXT,"message");
                intent.putExtra(Intent.EXTRA_STREAM,Uri.fromFile(file));
                startActivity(Intent.createChooser(intent,"share via"));*/

               /* Intent sendIntent=new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "message");

                if(isOnlyWhatsapp)
                {
                    sendIntent.setPackage("com.whatsapp");
                }
                Uri uri=Uri.fromFile(attachment);
                sendIntent.putExtra(Intent.EXTRA_STREAM,uri);
                sendIntent.setType("application/pdf");
                startActivity(sendIntent);
                */

        }
        return  true;
    }


}
