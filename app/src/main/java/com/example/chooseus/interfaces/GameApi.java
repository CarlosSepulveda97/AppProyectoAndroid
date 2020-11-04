package com.example.chooseus.interfaces;

import com.example.chooseus.models.TwitchRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface GameApi {

    @Headers({
            "Accept: application/vnd.twitchtv.v5+json",
            "Client-ID: yjser400nrhvikd18armok2ho4eedp"}
    )
    @GET("top")
    Call<TwitchRespuesta> obtenerListaJuegos();

}
