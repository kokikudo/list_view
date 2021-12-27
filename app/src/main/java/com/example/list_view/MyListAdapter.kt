package com.example.list_view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter // BaseAdapter
import android.widget.ImageView
import android.widget.TextView

// BaseAdapterを継承したクラス
// 4つの関数をオーバーライド
class MyListAdapter(
    // 表示に必須なプロパティ
    private val context: Context,
    private val data: List<ListItem>,
    private val resource: Int, // レイアウトリソースID
) : BaseAdapter() {

    // レイアウトをViewに変換するメソッドを使うために定義
    private val inflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    // データの個数を取得
    override fun getCount(): Int {
        return data.size
    }

    // position番目の項目を取得
    override fun getItem(position: Int): ListItem {
        return data[position]
    }

    // position番目のIDを取得
    override fun getItemId(position: Int): Long {
        return data[position].id
    }

    // position番目の項目をリストに表示するためのViewを取得
    override fun getView(
        position: Int,
        convertView: View?, // 再利用可能な古いView
        parent: ViewGroup? // Viewの親(ListView)
    ): View {
        val item = getItem(position) // 項目

        // レイアウトファイルをViewオブジェクトへ変換
        // 再利用可能な古いViewの解析に時間がかかる場合があるらしい
        // nullチェック(解析失敗の確認)を同時に実行してる(?:で値があれば左辺、nullであれば右辺を返す)
        val sview = convertView ?: inflater.inflate(resource, null)

        // データを入れる
        sview.findViewById<TextView>(R.id.item_title).text = item.title
        sview.findViewById<TextView>(R.id.item_tag).text = item.tag
        sview.findViewById<TextView>(R.id.item_desc).text = item.desc

        // 画像のリソースを更新する
        val image = sview.findViewById<ImageView>(R.id.item_imege)
        image.setImageResource(item.imageResource)

        return sview
    }

}