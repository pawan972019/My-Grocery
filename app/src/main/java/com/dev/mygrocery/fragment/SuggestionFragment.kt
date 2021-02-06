package com.dev.mygrocery.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.mygrocery.R
import com.dev.mygrocery.adapter.SuggestionAdapter
import com.dev.mygrocery.dbManager.DatabaseClient
import com.dev.mygrocery.dbManager.GroceryListEntity
import com.dev.mygrocery.models.SuggestionResponse
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_suggestion.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset


class SuggestionFragment : Fragment() {

    private var suggestionList = arrayListOf<GroceryListEntity>()
    private var suggestionAdapter : SuggestionAdapter? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

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

        suggestion_recycler_view_list.layoutManager = LinearLayoutManager(activity)

        suggestionAdapter = activity?.let { SuggestionAdapter(it, suggestionList!!) }
        suggestion_recycler_view_list.adapter = suggestionAdapter

        CoroutineScope(IO).launch {

            var itemList =
                DatabaseClient.getInstance(context!!)?.appDatabase?.getGroceryListDao()?.all as ArrayList<GroceryListEntity>

            suggestionList.addAll(itemList)

            updateAdapterOnDataChanged()
        }


    }

    suspend fun updateAdapterOnDataChanged(){

        CoroutineScope(Main).launch {
            suggestionAdapter?.notifyDataSetChanged()
        }
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

