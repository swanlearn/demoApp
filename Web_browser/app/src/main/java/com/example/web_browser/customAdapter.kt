package com.example.web_browser

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import java.lang.ArithmeticException



class customAdapter(private val activity: FragmentActivity, val list:ArrayList<data>,val model :viewmodels.glob
):RecyclerView.Adapter<customAdapter.viewholder>() {
    class viewholder(view: View):RecyclerView.ViewHolder(view){
        lateinit var btn:ImageButton
        lateinit var text:TextView
        init {
            btn = view.findViewById(R.id.imbtn)
            text = view.findViewById(R.id.texth)
        }
    }
    private var link:String=""
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.itam,parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        var text = list[position].text

        holder.text.text = list[position].name
        holder.btn.setOnClickListener {
            activity.findViewById<TabLayout>(R.id.tab_view).visibility = View.GONE
            link = list[position].text.toString()
            model.link.value = link
            activity.supportFragmentManager.beginTransaction().replace(R.id.frag_view,PlayFrag()).addToBackStack("ply").commit()
        }
    }

    override fun getItemCount()= list.size
}


