package com.dev.mygrocery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.mygrocery.R
import com.dev.mygrocery.models.SuggestionResponse
import kotlinx.android.synthetic.main.suggestion_adapter_row_item.view.*

class SuggestionAdapter(private val context: Context, var suggestionList: List<SuggestionResponse.Data.Suggestion>) : RecyclerView.Adapter<SuggestionAdapter.SuggestionViewHolder>() {

    private val TAG : String = "SuggestionAdapter";

    class SuggestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val suggested_item_name = itemView.suggested_item_name!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionViewHolder {

        val inflatedView = LayoutInflater.from(context).inflate(R.layout.suggestion_adapter_row_item, parent, false)
        return SuggestionViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {

        return suggestionList.size
    }

    override fun onBindViewHolder(holder: SuggestionViewHolder, position: Int) {

        val suggestionResponse = suggestionList[position]

        holder.suggested_item_name.text = suggestionResponse.name
    }
}