package com.dev.mygrocery.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.mygrocery.R
import com.dev.mygrocery.adapter.SuggestionAdapter
import com.dev.mygrocery.dbManager.DatabaseClient
import com.dev.mygrocery.dbManager.GroceryListEntity
import kotlinx.android.synthetic.main.fragment_suggestion.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch


class SuggestionFragment : Fragment() {

    private val TAG:String = "SuggestionFragment"

    private var suggestionList = arrayListOf<GroceryListEntity>()
    private var suggestionAdapter : SuggestionAdapter? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.e(TAG, "onCreateView: ")
        return inflater.inflate(R.layout.fragment_suggestion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "onViewCreated: ")

        bindDataView()
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: ")
    }

    private fun bindDataView() {

        Log.e(TAG, "bindDataView: ")

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

    private suspend fun updateAdapterOnDataChanged(){

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

