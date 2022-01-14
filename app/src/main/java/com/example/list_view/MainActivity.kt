package com.example.list_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.list_view.databinding.ActivityMainBinding

/*
    RecyclerViewのメリット
    ・　ListViewより柔軟なカスタマイズができる
    ・　リストを作成するための役割がクラスごとに分かれてるため把握しやすい
    ・　ビューを再利用しながら表示するので大きなデータを表示するのに向いている
    RecyclerViewのデメリット
    ・　コードが長くなりがち
    ・　構造が複雑で理解が難しい

    実装手順
    ・　RecyclerViewレイアウトを配置
    ・　表示したい値をもつデータクラスを作成(ListItem.kt)
    ・　CardViewレイアウトを作成（list_item.xml）
    ・  Holderクラスを作成(MyViewHolder.kt)
    ・　Adapterクラスを作成(MyListAdapter.kt)
    ・　レイアウトマネージャーを設定
    ・　AdapterをRecyclerViewにセット
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = listOf(
            ListItem(1, "嫌われる勇気", "精神学", "アドラーなんとか"),
            ListItem(2, "博士号の取り方", "ビジネス", "学生と指導教官のためのハンドブック"),
            ListItem(3, "メモのまりょく", "自己啓発", "人生が変わるメモ活用術"),
            ListItem(4, "ゼロ", "堀江貴文", "俺に入れてもらうことできるか？"),
        )

        // サイズを固定した時にパフォーマンスを向上させる
        binding.rv.setHasFixedSize(true)
        // レイアウトマネージャーの準備
        binding.rv.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL // 縦向き
        }
        // アダプターをRecyclerManagerに設定
        binding.rv.adapter = MyListAdapter(data)
    }
}