package com.example.games.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.games.R;
import com.example.games.data.MoviesAdapter;
import com.example.games.data.MoviesAdapter;
import com.example.games.model.Movies;
import com.example.games.model.Movies;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MoviesAdapter moviesAdapter;
    private ArrayList<Movies> moviesArr;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        moviesArr = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);

        getMovie();
    }

    private void getMovie() {

        String url = "http://www.omdbapi.com/?apikey=d74745ce&s=matrix";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("Search");

                    for (int i = 0; i < jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String title = jsonObject.getString("Title");
                        String released = jsonObject.getString("Year");
                        String posterUrl = jsonObject.getString("Poster");

                        Movies movie = new Movies();
                        movie.setTitle(title);
                        movie.setReleased(released);
                        movie.setPosterUrl(posterUrl);

                        moviesArr.add(movie);
                    }

                    moviesAdapter = new MoviesAdapter(MainActivity.this, moviesArr);

                    recyclerView.setAdapter(moviesAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(request);

    }
}