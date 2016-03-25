package com.bashitha.myapplication;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.speech.tts.TextToSpeech;
import android.widget.EditText;

import java.util.Locale;


    public class TTS_Regular extends ActionBarActivity implements TextToSpeech.OnInitListener{

        private TextToSpeech engine;
        private EditText text;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tts__regular);

            text = (EditText) findViewById(R.id.text);
            engine = new TextToSpeech(this, this);
        }



        public void speakText(View v) {

            String textContents = text.getText().toString();
            //speak() would work on if you have set minSDK version 21 or higher
            //engine.speak(textContents, TextToSpeech.QUEUE_FLUSH, null, null);
            //this is for apk 20
            engine.speak(textContents, TextToSpeech.QUEUE_FLUSH, null);

        }


        @Override
        public void onInit(int i) {


            if (i == TextToSpeech.SUCCESS) {
                //Setting speech Language
                engine.setLanguage(Locale.CANADA);
                engine.setPitch(1);
            }
        }

    }
