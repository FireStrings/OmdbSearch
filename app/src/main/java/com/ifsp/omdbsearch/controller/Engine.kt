package com.ifsp.omdbsearch.controller

import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.ifsp.omdbsearch.activity.MainActivity
import com.ifsp.omdbsearch.model.*
import org.json.JSONException
import org.json.JSONObject

class Engine(val mainActivity: MainActivity) {

    fun main() {
        val filaRequisicaoTraducao: RequestQueue = Volley.newRequestQueue(mainActivity)
// Monta a requisição que será colocada na fila. Esse objeto é uma instância de uma classe anônima
        var traducaoJORequest: JsonObjectRequest =
            object : JsonObjectRequest(
                Request.Method.GET, // Método HTTP de requisição
                "http://www.omdbapi.com/?t=Guardians&apikey=b37f9b95", // URL
                null, // Objeto de requisição - somente em POST
                RespostaListener(), // Listener para tratar resposta
                ErroListener() // Listener para tratar erro
            ) {
                // Corpo do objeto
                // Sobreescrevendo a função para passar cabeçalho na requisição
                override fun getHeaders(): MutableMap<String, String> {
                    // Cabeçalho composto por Map com app_id, app_key e seus valores
                    var parametros: MutableMap<String, String> = mutableMapOf()
//                    parametros.put("apikey", "b37f9b95")
//                    parametros.put("i", "tt3896198")
                    Log.v("TESTE", "PARAMETROS")
                    return parametros
                }
            }
// Adiciona a requisição a fila
        filaRequisicaoTraducao.add(traducaoJORequest)
        Log.v("TESTE", traducaoJORequest.url)
        Log.v("TESTE", traducaoJORequest.bodyContentType)
        Log.v("TESTE", traducaoJORequest.headers.toString())


    }

    inner class RespostaListener : Response.Listener<JSONObject> {
        override fun onResponse(response: JSONObject?) {
            try {

                Log.v("TESTE", "NO RESPOSTA")
                Log.v("TESTE", response.toString())

//                // Cria um objeto Gson que consegue fazer reflexão de um Json para Data Class
                val gson: Gson = Gson()
//                // Reflete a resposta (que é um Json) num objeto da classe Resposta
                val resposta: Resposta = gson.fromJson(response.toString(), Resposta::class.java)


                Log.v("TESTE", resposta.results!!.size.toString())
//                // StringBuffer para armazenar o resultado das traduções
//                var traduzidoSb = StringBuffer()
//                // Parseando o objeto e adicionando as traduções ao StringBuffer, O(N^5)
//                resposta.results?.forEach {
//                    it?.lexicalEntries?.forEach {
//                        it?.entries?.forEach {
//                            it?.senses?.forEach {
//                                it?.translations?.forEach {
//                                    traduzidoSb.append("${it?.text}, ")
//                                }
//                            }
//                        }
//                    }
//                }
//                // Enviando as tradução ao Handler da thread de UI para serem mostrados na tela
//                mainActivity.tradutoHandler.obtainMessage(
//                    RESPOSTA_TRADUCAO,
//                    traduzidoSb.toString().substringBeforeLast(',')
//                ).sendToTarget()
            } catch (jse: JSONException) {
//                mainActivity.mainLl.snackbar("Erro na conversão JSON")
            }
        }
    }

    // Trata erros na requisição ao WS
    inner class ErroListener : Response.ErrorListener {
        override fun onErrorResponse(error: VolleyError?) {
            Log.v("TESTE", error.toString())
            //mainActivity.mainLl.snackbar("Erro na requisição: ${error.toString()}")
        }
    }

}