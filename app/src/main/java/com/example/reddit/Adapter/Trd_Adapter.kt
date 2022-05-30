package com.example.reddit.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reddit.Item.Treds
import com.example.reddit.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tred_item.*
import kotlinx.android.synthetic.main.tred_item.view.*

/*
У цьому файлы ми завантажуэмо данні. Зображення додається за допомогою бібліотеки Picasso
У MyViewHolder ми вказуємо до яких елементів треба записати данні
У onCreateViewHolder ми повертаємо заповнений itemView
У onBindViewHolder вказується які змінні треба викорисовувати для завантаження даних
*/
class Trd_Adapter (private val context: Context, private val trdList: MutableList<Treds>): RecyclerView.Adapter<Trd_Adapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image : ImageView
        var autor : TextView
        var date : TextView
        var comm : TextView

        init {
            image = itemView.img_trd
            autor = itemView.autor_trd
            date = itemView.date_trd
            comm = itemView.date_trd
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.tred_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.get().load(trdList[position].url).into(holder.image)
        holder.autor.text = trdList[position].author
        holder.date.text = trdList[position].created
        holder.comm.text = trdList[position].num_comments
    }

    override fun getItemCount(): Int {
        return trdList.size
    }
}