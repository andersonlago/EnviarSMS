package com.example.anderson.enviarsms;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
   }

    public void onClick(View v){

        EditText txtnumero = (EditText) findViewById (R.id.txtnumero);
        EditText txtmsg =  (EditText) findViewById( R.id.txtmsg );
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(txtnumero.getText().toString(), null, txtmsg.getText().toString(), null, null);

        tts = new TextToSpeech(this, this);
    }

    @Override
    public void onInit(int status) {

       tts.setLanguage( new Locale("pt_BR"));
       EditText txtmsg =  (EditText) findViewById( R.id.txtmsg );
       tts.speak(txtmsg.getText().toString(), TextToSpeech.QUEUE_ADD,null);
  }
}


