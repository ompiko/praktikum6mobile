package com.example.modul6;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //on below is define item from view main_activity.xml
    private EditText editTextName;
    private EditText editTextDesg;
    private EditText editTextSal;

    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize from view layout
        editTextName = (EditText) findViewById(R.id.editTextNama);
        editTextDesg = (EditText) findViewById(R.id.editTextJurusan);
        editTextSal = (EditText) findViewById(R.id.editTextEmail);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);

        //Setting listeners to button
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }


    //On below is method for add student
    private void addStudent(){

        final String nama = editTextName.getText().toString().trim();
        final String jurusan = editTextDesg.getText().toString().trim();
        final String email = editTextSal.getText().toString().trim();

        class AddMahasiswa extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Adding...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(connection.KEY_MHS_NAMA,nama);
                params.put(connection.KEY_MHS_JURUSAN,jurusan);
                params.put(connection.KEY_MHS_EMAIl,email);

                requestHandler rh = new requestHandler();
                String res = rh.sendPostRequest(connection.URL_ADD, params);
                return res;
            }
        }

        AddMahasiswa am = new AddMahasiswa();
        am.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonAdd){
            addStudent();
        }

        if(v == buttonView){
            startActivity(new Intent(this, ActivityRead.class));
        }
    }
}