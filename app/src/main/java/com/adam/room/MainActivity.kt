package com.adam.room

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.adam.leo.LeoAdapter
import com.adam.leo.setupAdapter
import com.adam.room.db.AppDatabase
import com.adam.room.db.table.PhoneData
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private lateinit var leoAdapter: LeoAdapter<PhoneData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            toast("Fab")
        }

        leoAdapter = recycler.setupAdapter(R.layout.recycler_item) {
            bind { view, _, item ->
                view.findViewById<TextView>(R.id.userName).text = item.userName
                view.findViewById<TextView>(R.id.phoneNumber).text = item.phoneNumber

                view.setOnClickListener {
                    toast(item.userName)
                }

                view.setOnLongClickListener {
                    toast(item.phoneNumber)

                    true
                }
            }
        }

        executeNewSingleThread {
            val list: List<PhoneData> = AppDatabase.INSTANCE.taskDao.getData()
            recycler.post {
                leoAdapter.submitList(list)
            }
        }
    }

    private fun toast(mes: String) {
        Toast.makeText(this, mes, Toast.LENGTH_SHORT).show()
    }

    private inline fun executeNewSingleThread(crossinline block: () -> Unit): Unit =
        Executors.newSingleThreadExecutor().execute {
            try {
                block()
            } catch (e: Exception) {
                Log.e("TTT", e.message ?: "Error App Database")
            }
        }
}
