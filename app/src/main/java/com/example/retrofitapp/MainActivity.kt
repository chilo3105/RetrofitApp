package com.example.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofitapp.remote.PokemonEntry
import com.example.retrofitapp.remote.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = RetrofitBuilder.create()
        val response = retrofit.getPokemonById("27")

        response.enqueue(object : Callback<PokemonEntry>{
            override fun onResponse(call: Call<PokemonEntry>, response : Response<PokemonEntry>){
                Log.d("retrofitResponse", "res: ${response.body()}" )
                val stats = response.body()?.stats
                if (stats != null){
                    for (stat in stats){
                        Log.d("retrofitResponse", "${stat.stat.stat_value} : ${stat.base_stat}" )
                    }
                }
                //types name
                val types = response.body()?.types
                if(types != null){
                    for (type in  types){
                        Log.d("retrofitResponse", "name type : ${type.type.name}" )
                    }
                }

                //imprimir front_default

                var front = response.body()?.sprites

                if (front != null) {
                    Log.d("retrofitResponse", "front_default : ${front.front_default}")
                }
            }

            override fun onFailure(call: Call<PokemonEntry>, t: Throwable){
                Log.e("retrofitResponse", "error: ${t.message}")
            }
        })
    }
}