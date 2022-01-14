package com.example.list_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


// RecyclerView.Adapter<T: 使うホルダークラス>を継承したAdapterクラス
// コンストラクタで表示させたいリストデータを受け取っている
class MyListAdapter(private val data: List<ListItem>) : RecyclerView.Adapter<MyViewHolder>() {

    // ビューホルダー生成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // レイアウトからViewを生成し、それを引数としたホルダーを返す
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    // ビューにデータを割り当て、リスト項目を作成
    // positionに現在のリストのインデックスが割り当てられてる
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.tag.text = data[position].tag
        holder.desc.text = data[position].desc
    }

    // データの数だけ項目を生成
    override fun getItemCount(): Int {
        return data.size
    }
}