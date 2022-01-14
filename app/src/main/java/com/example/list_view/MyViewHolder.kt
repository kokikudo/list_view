package com.example.list_view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Holderクラス: Viewが保持するwidgetを保持するためのクラス
// RecyclerViewの場合はRecyclerView.ViewHolderを継承したクラスを作る

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    // 表示させたい値を定義
    val title = itemView.findViewById<TextView>(R.id.title)
    val tag = itemView.findViewById<TextView>(R.id.tag)
    val desc = itemView.findViewById<TextView>(R.id.desc)
}
