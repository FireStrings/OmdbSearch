package com.ifsp.omdbsearch.activity

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ifsp.omdbsearch.R
import com.ifsp.omdbsearch.controller.Engine
import com.ifsp.omdbsearch.model.Constantes
import kotlinx.android.synthetic.main.activity_search_by_id.*
import kotlinx.android.synthetic.main.activity_search_by_id.view.*

class SearchByIdActivity : Fragment() {

    lateinit var mensagemHandler: SearchByIdActivity.MensagemHandler
    private lateinit var listView : ListView

    inner class MensagemHandler: Handler() {
        override fun handleMessage(msg: Message?) {
            if (msg?.what == 1) {

                val gson = Gson()
                val listItems = mutableListOf<String>()

                val newList: Map<String, Any> = gson.fromJson(msg.obj.toString(), object : TypeToken<Map<String, Any>>() {}.type)

                newList.forEach {
                        k, v ->
                    listItems.add("$k : $v")
                }

                val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, listItems)
                listView.adapter = adapter

            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v: View = inflater!!.inflate(R.layout.activity_search_by_id, container, false)

        listView = v.resultFilmeID
        mensagemHandler = MensagemHandler()

        v.btnBuscar.setOnClickListener { v ->
            val t = Engine(this, Constantes.APP_IMDB_FIELD, campoId.text.toString())
            t.main()
        }
        return v

    }
}
