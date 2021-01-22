package com.dev.mygrocery.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.mygrocery.R
import com.dev.mygrocery.adapter.SuggestionAdapter
import com.dev.mygrocery.models.SuggestionResponse
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_suggestion.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset


class SuggestionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_suggestion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindDataView()
    }

    private fun bindDataView() {

        val gson = Gson()

        val suggestionList = gson.fromJson(loadJSONFromAsset(), SuggestionResponse::class.java)
        suggestion_recycler_view_list.layoutManager = LinearLayoutManager(activity)
        suggestion_recycler_view_list.adapter = activity?.let { SuggestionAdapter(it, suggestionList.data.suggestionList) }

    }

    fun loadJSONFromAsset(): String? {
        var json: String? = null

        json = try {

            val `is`: InputStream = activity!!.assets.open("suggestion.json")
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()

            val charset: Charset = Charsets.UTF_8
            String(buffer, charset)

        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */

        @JvmStatic
        fun newInstance() = SuggestionFragment()

    }
}