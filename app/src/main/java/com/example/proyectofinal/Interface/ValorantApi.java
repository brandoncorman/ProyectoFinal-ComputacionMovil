package com.example.proyectofinal.Interface;

import com.example.proyectofinal.Model.Agents;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ValorantApi {

    @GET("v1/agents?language=es-ES&isPlayableCharacter=true")
    Call<Agents> getAgents();
}
