package com.ifsp.omdbsearch.controller

import android.support.v4.app.Fragment
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.ifsp.omdbsearch.activity.MainActivity
import com.ifsp.omdbsearch.activity.SearchByIdActivity
import com.ifsp.omdbsearch.activity.SearchByNameActivity
import com.ifsp.omdbsearch.model.*
import org.json.JSONException
import org.json.JSONObject

class Engine(val genActivity: Fragment, val field : String, val value : String) {

    fun main() {
        val filaRequisicaoTraducao : RequestQueue = Volley.newRequestQueue(genActivity.context)

        val urlBase = Constantes.URL_BASE
        val idField = Constantes.APP_ID_FIELD
        val idValue = Constantes.APP_ID_VALUE

        val urlComplete = "$urlBase?$field=$value&$idField=$idValue"

        var traducaoJORequest: JsonObjectRequest =
            object : JsonObjectRequest(
                urlComplete, // URL
                null,
                RespostaListener(),
                ErroListener()
            ) {
                override fun getHeaders(): MutableMap<String, String> {

                    var parametros: MutableMap<String, String> = mutableMapOf()
                    return parametros
                }
            }
        filaRequisicaoTraducao.add(traducaoJORequest)
    }

    inner class RespostaListener : Response.Listener<JSONObject> {
        override fun onResponse(response: JSONObject?) {
            try {
                val activity : Any

                if (field == "t") {
                    activity = (genActivity as SearchByNameActivity)
                    activity.mensagemHandler.obtainMessage(
                        1,
                        response.toString()
                    ).sendToTarget()

                } else {
                    activity =  (genActivity as SearchByIdActivity)
                    activity.mensagemHandler.obtainMessage(
                        1,
                        response.toString()
                    ).sendToTarget()
                }


            } catch (jse: JSONException) {

            }
        }
    }

    inner class ErroListener : Response.ErrorListener {
        override fun onErrorResponse(error: VolleyError?) {

            //mainActivity.mainLl.snackbar("Erro na requisição: ${error.toString()}")
        }
    }

}