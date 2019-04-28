package com.example.leo.omdbsearch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    object codigosMensagen {
        // Constante usada para envio de mensagens ao Handler
        val RESPOSTA_TRADUCAO = 0
    }
    // Idiomas de origem e destino. Dependem da API do Oxford Dict.
    val idiomas = listOf("pt", "en")
    // Handler da thread de UI
    lateinit var tradutoHandler: TradutoHandler
    inner class TradutoHandler: Handler() {
        override fun handleMessage(msg: Message?) {
            if (msg?.what == codigosMensagen.RESPOSTA_TRADUCAO) {
                // Alterar o conteúdo do TextView
                traduzidoTv.text = msg?.obj.toString()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}
