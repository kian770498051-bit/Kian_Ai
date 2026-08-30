package com.kianai.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import org.json.*;

public class MainActivity extends Activity {
    TextView chat; EditText input; Button send;
    // Set this to your secure backend URL. Never put an OpenAI secret key in the APK.
    static final String BACKEND_URL = BuildConfig.BACKEND_URL;

    @Override public void onCreate(Bundle b) {
        super.onCreate(b); setContentView(R.layout.activity_main);
        chat=findViewById(R.id.chat); input=findViewById(R.id.input); send=findViewById(R.id.send);
        send.setOnClickListener(v -> ask());
    }
    void ask() {
        final String q=input.getText().toString().trim(); if(q.isEmpty()) return;
        chat.append("\n\nأنت: "+q+"\nKian AI: جاري التفكير...");
        input.setText(""); send.setEnabled(false);
        new Thread(() -> {
            String answer;
            try {
                HttpURLConnection c=(HttpURLConnection)new URL(BACKEND_URL).openConnection();
                c.setRequestMethod("POST"); c.setRequestProperty("Content-Type","application/json; charset=UTF-8");
                c.setDoOutput(true);
                JSONObject body=new JSONObject(); body.put("message",q);
                try(OutputStream o=c.getOutputStream()){o.write(body.toString().getBytes(StandardCharsets.UTF_8));}
                InputStream is=(c.getResponseCode()<400)?c.getInputStream():c.getErrorStream();
                String s=new BufferedReader(new InputStreamReader(is,StandardCharsets.UTF_8)).lines().reduce("",(a,x)->a+x);
                answer=new JSONObject(s).optString("answer",s);
            } catch(Exception e){ answer="تعذر الاتصال بالخادم. تأكد من إعداد BACKEND_URL."; }
            final String a=answer;
            runOnUiThread(() -> { chat.append(a); send.setEnabled(true); });
        }).start();
    }
}
