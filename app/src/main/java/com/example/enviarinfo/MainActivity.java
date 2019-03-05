package com.example.enviarinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String URL="http://nuevo.rnrsiilge-org.mx/nombre";
    EditText edtxt;
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtxt=findViewById(R.id.edit);
        btn=findViewById(R.id.send);
        btn.setOnClickListener(this);
        txt=findViewById(R.id.txt);

    }




    @Override
    public void onClick(View view) {
        JSONObject n=new JSONObject();
        try {
            n.put("Nombre","kiike");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest js=new JsonObjectRequest(
                Request.Method.POST,
                URL,
                n/*aqui es donde voy a enviar el nombre*/,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        txt.setText(response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        txt.setText("nachos");
                    }
                }
        );

        VolleyS.getInstance(this).getmRequestQueue().add(js);
    }
}
