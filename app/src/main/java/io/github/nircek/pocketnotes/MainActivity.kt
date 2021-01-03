package io.github.nircek.pocketnotes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button2.setOnClickListener {
            (it as Button).text = getString(R.string.trytyty)
        }
        val sp = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        // TODO: embrace JSON
        val list = Gson().fromJson<ArrayList<String>>(sp.getString("list", "[\"abc\"]"), object : TypeToken<ArrayList<String>>() {}.type)

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(this) // could be grid
        recycler_view.adapter = Adapter(list)
        list.add("cde")
        (recycler_view.adapter as Adapter).notifyDataSetChanged()

        // val intent = Intent(this, MainActivity::class.java)
        // startActivity(intent)
        // TODO: arrow to go back

        /*
        * https://material.io/components/buttons/android#types
        * https://www.google.com/search?client=firefox-b-d&q=gradle+standard+plugins
        * https://stackoverflow.com/questions/46101908/error1-0-plugin-with-id-kotlin-android-extensions-not-found
        * https://github.com/google/gson
        * https://www.untitledkingdom.com/blog/refactoring-recyclerview-adapter-to-data-binding-5631f239095f-0
        * */
    }
}