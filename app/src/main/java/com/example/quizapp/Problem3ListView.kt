package com.example.quizapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.databinding.ActivityProblem3ListViewBinding

class Problem3ListView : AppCompatActivity() {

    private lateinit var binding: ActivityProblem3ListViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProblem3ListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var products = ArrayList<Product>()
        val arrImages = resources.getStringArray(R.array.bookTitles2Image);
        val arrTitles = resources.getStringArray(R.array.bookTitles2);
        val arrDetail = resources.getStringArray(R.array.bookTitles2Details);
        val arrPrice = resources.getStringArray(R.array.bookTitles2Price);
        for (i in arrImages.indices) {
            products.add(Product(arrTitles[i], arrPrice[i], arrImages[i], arrDetail[i]))
        }

        binding.rv.layoutManager = LinearLayoutManager(this)
        // Create an object for the MyAdapter
        val adapter = MyAdapter(this, products)
        // Set adapter to your RecyclerView
        binding.rv.adapter = adapter

    }

    class MyAdapter(var context: Context, var products : ArrayList<Product>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
            val v = LayoutInflater.from(parent?.context).inflate(R.layout.card_layout_item, parent, false)
            return MyViewHolder(v);
        }

        override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
            // Values assigned to the respective View components in the card_layout.xml
            holder.txt1.text = products[position].title
            holder.txt2.text = products[position].price
            val imageId = context.resources.getIdentifier(products[position].image, "drawable", context.packageName)
            holder.img.setImageResource(imageId)
            // Implement the click Listener in the using the layout.
            holder.rlayout.setOnClickListener{
                // User clicks the list Item to open the DetailActivity
                val intent = Intent(context, Problem3DetailActivity::class.java)

                // Pass data to the Detail Activity
                intent.putExtra("image", imageId)
                intent.putExtra("name", "${products[position].title} \n ${products[position].price}")
                intent.putExtra("detail",products[position].desc)
                context.startActivity(intent)
            }

        }

        override fun getItemCount() = products.size

        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            // Instance fields
            var rlayout: RelativeLayout
            var txt1:TextView
            var txt2: TextView
            var img: ImageView
            // Initialization of Instance fields using init block
            init{
                rlayout = itemView.findViewById(R.id.playout) as RelativeLayout
                txt1 = itemView.findViewById(R.id.tv1) as TextView
                txt2 = itemView.findViewById(R.id.tv2) as TextView
                img = itemView.findViewById(R.id.imageView) as ImageView
            }
        }
    }
}