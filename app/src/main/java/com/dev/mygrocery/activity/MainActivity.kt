package com.dev.mygrocery.activity

import android.app.Dialog
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.Window
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import com.dev.mygrocery.R
import com.dev.mygrocery.adapter.MainViewPagerAdapter
import com.dev.mygrocery.dbManager.DatabaseClient
import com.dev.mygrocery.dbManager.GroceryListEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_list_dialog.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val TAG : String = "MainActivity"
    var mainAdapter : MainViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e(TAG, "onCreate: ")
        bindView()
    }

    private fun bindView() {

        mainAdapter = MainViewPagerAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
            this
        )
        main_view_pager.adapter = mainAdapter
        main_tab_layout.setupWithViewPager(main_view_pager)

        fab_action_button.setOnClickListener(View.OnClickListener {

            var dialog = Dialog(this);
            dialog.setContentView(R.layout.add_list_dialog)

             dialog.list_add_button.setOnClickListener(View.OnClickListener {
                dialog.dismiss()

                if(TextUtils.isEmpty(dialog.edt_text_list_name.text.toString())){

                }else {

                    val groceryListEntity = GroceryListEntity()
                    groceryListEntity.listName = dialog.edt_text_list_name.text.toString()

                    CoroutineScope(IO).launch {

                        DatabaseClient.getInstance(this@MainActivity)
                            ?.appDatabase
                            ?.getGroceryListDao()
                            ?.insertListName(groceryListEntity)
                    }

                    mainAdapter!!.notifyDataSetChanged()
                }
            })

            val window: Window? = dialog.window
            window?.setLayout(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            window?.setGravity(Gravity.CENTER)

            dialog.show()

        })
    }

    override fun onClick(v: View?) {
       TODO("ON click of main activity")
    }

}