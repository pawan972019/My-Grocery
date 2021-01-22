package com.dev.mygrocery.activity

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dev.mygrocery.R
import com.dev.mygrocery.adapter.CreateListAdapter
import kotlinx.android.synthetic.main.create_list_activity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class CreateListActivity : AppCompatActivity(), View.OnClickListener {

    val TAG: String = "CreateListActivity"

    lateinit var createListAdapter: CreateListAdapter
    var itemNameList = arrayListOf<String>()
    val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_list_activity)
        Log.e(TAG, "onCreate: ")

        bindViewData()
        createListAdapter = CreateListAdapter(this)
        createListAdapter.setItemList(itemNameList)

        recycler_view_layout.adapter = createListAdapter
    }

    private fun bindViewData() {

        add_item_imageView.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        if (view == add_item_imageView) {

            if (!TextUtils.isEmpty(item_editText.text)) {
                val itemName = item_editText.text
                itemNameList.add(itemName.toString())
                createListAdapter.updateMainAdapterList(itemNameList)
                item_editText.setText("")

            } else {
                Toast.makeText(this, "Please enter item name", Toast.LENGTH_LONG).show()
            }
        } else if (view == list_done) {

        }
    }
}