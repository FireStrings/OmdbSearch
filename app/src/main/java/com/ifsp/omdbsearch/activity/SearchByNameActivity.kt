package com.ifsp.omdbsearch.activity

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ifsp.omdbsearch.R
import com.ifsp.omdbsearch.controller.Engine
import kotlinx.android.synthetic.main.activity_search_by_name.*

class SearchByNameActivity : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        //Log.v("clique", "CLICOU!")

        /*btnBuscarNome.setOnClickListener {
            Log.v("clique", "CLICOU")
        }*/

        /*btnBuscarNome.setOnClickListener {
            // Testa se o usuário digitou alguma coisa para buscar
            Log.v("clique", "CLICOU")
            if (campoTitulo.text.isNotEmpty()) {
                // Instancia um engine para fazer a chamada ao WS
                //val engine: Engine = Engine()
                // Solicita a busca com base nos parâmetros selecionados pelo usuário
                //engine.main()
            }
            else {
                // Senão, mostra uma mensagem na parte debaixo do LinearLayout
                //mainLl.snackbar("É preciso digitar uma palavra para ser traduzida")
            }
        }*/


        return inflater?.inflate(R.layout.activity_search_by_name, null)

    }
}
