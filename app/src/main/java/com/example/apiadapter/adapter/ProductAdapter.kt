package com.example.apiadapter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.apiadapter.R
import com.example.apiadapter.api.MyData
import com.example.apiadapter.api.Product
import com.squareup.picasso.Picasso

class ProductAdapter(val context: Context,val productList:List<Product>) :
    RecyclerView.Adapter<ProductAdapter.MyProductviewHolder>() {


    class MyProductviewHolder (itemview:View): RecyclerView.ViewHolder(itemview) {
     var brand:TextView
     var title:TextView
     var discountPercentage: TextView
     var price:TextView
     var discription:TextView
     var productImage:ImageView

     init {
         brand=itemview.findViewById(R.id.brand)
         title=itemview.findViewById(R.id.title)
         discountPercentage=itemview.findViewById(R.id.discount)
         price=itemview.findViewById(R.id.price)
         discription=itemview.findViewById(R.id.discription)
         productImage=itemview.findViewById(R.id.productImage)
     }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductviewHolder {
        val itemview= LayoutInflater.from(context).inflate(R.layout.sample_product,parent,false)
        return MyProductviewHolder(itemview)
    }

    override fun getItemCount(): Int {
      return productList.size
    }

    override fun onBindViewHolder(holder: MyProductviewHolder, position: Int) {
        val currentItem=productList[position]
        holder.title.text=currentItem.title
        holder.brand.text=currentItem.brand
        holder.discountPercentage.text= currentItem.discountPercentage.toString()
        holder.price.text= currentItem.price.toString()
        holder.discription.text=currentItem.description
        Picasso.get().load(currentItem.thumbnail).into(holder.productImage);

    }
}