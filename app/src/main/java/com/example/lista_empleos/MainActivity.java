package com.example.lista_empleos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lista_empleos.Adaptador.Adaptador;
import com.example.lista_empleos.Modelo.Empleo;
import com.example.lista_empleos.WebService.Asynchtask;
import com.example.lista_empleos.WebService.WebService;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity  implements Asynchtask {
    private RecyclerView recyclerView;
    private Empleo empleo;
    private ArrayList<Empleo> lista;
    private Adaptador adaptador;
    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //adaptador=new Adaptador(this, lista);
        lista=new ArrayList<>();
        recyclerView= findViewById(R.id.rclRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptador);
        llamadoWS();
    }



    private void llamadoWS(){
        String url ="https://api.jsonbin.io/b/5efe857d0bab551d2b6af8b1";
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService(url,
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Empleo> lstEmpleos;

        try {
            JSONArray jsonlista= new JSONArray(result);
            lstEmpleos = Empleo.JsonObjectsBuild(jsonlista);
            Adaptador adapator = new Adaptador(this, lstEmpleos);
            recyclerView.setAdapter(adapator);

        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}