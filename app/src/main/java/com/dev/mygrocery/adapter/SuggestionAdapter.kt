package com.dev.mygrocery.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.mygrocery.R
import com.dev.mygrocery.dbManager.GroceryListEntity
import com.dev.mygrocery.models.SuggestionResponse
import kotlinx.android.synthetic.main.suggestion_adapter_row_item.view.*

class SuggestionAdapter(private val context: Context, var suggestionList: List<GroceryListEntity>) : RecyclerView.Adapter<SuggestionAdapter.SuggestionViewHolder>() {

    private val TAG : String = "SuggestionAdapter";

    inner class SuggestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        val textViewTask = itemView.textViewTask!!
        val textViewStatus = itemView.textViewStatus!!

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            Log.e(TAG, "onClick: ")
        }
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

        holder.textViewTask.text = suggestionResponse.listName?.trim()

        if(suggestionResponse.isFinished){
            holder.textViewStatus.text = "Completed"
        }else{
            holder.textViewStatus.text = "Not Completed"
        }
    }
}