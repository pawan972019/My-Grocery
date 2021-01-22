package com.dev.mygrocery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.mygrocery.R
import kotlinx.android.synthetic.main.main_adapter_row_item.view.*

class CreateListAdapter(private val context: Context) : RecyclerView.Adapter<CreateListAdapter.ViewHolder>() {

    private  var itemNameList = arrayListOf<String>()

    fun setItemList(list: List<String>){
        itemNameList.addAll(list)
        notifyDataSetChanged()
    }

    fun updateMainAdapterList(list: List<String>){
        val previousSize = itemNameList.size
        itemNameList.clear()
        itemNameList.addAll(list)
        notifyItemInserted(previousSize)
    }

    fun getItemList(): List<String>{
        return itemNameList;
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val itemName = v.country_text!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(context)
            .inflate(R.layout.main_adapter_row_item, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemName = itemNameList[position]

        holder?.itemName?.text = itemName
    }

    override fun getItemCount(): Int {
        return itemNameList.size
    }
}