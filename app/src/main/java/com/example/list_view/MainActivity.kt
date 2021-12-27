package com.example.list_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.core.view.forEach
import com.example.list_view.databinding.ActivityMainBinding

// ListViewをカスタマイズする用のレイアウトファイルを作成(list_item.xml)
// layoutフォルダからリソースファイルを作成
// New Resource File画面からファイル名を決めてOK
// SimpleAdapterを定義してリストにセット
// シンプルに実装できる分、制約も多い

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // リストアイテム
        val data = listOf(
            mapOf("title" to "革命のエチュード", "tag" to "ピアノ", "desc" to "ピアノの詩人と言われたショパンの代表的なピアノ曲です"),
            mapOf("title" to "革命のエチュード2", "tag" to "ピアノ2", "desc" to "ピアノの詩人と言われたショパンの代表的なピアノ曲です2"),
            mapOf("title" to "革命のエチュード3", "tag" to "ピアノ3", "desc" to "ピアノの詩人と言われたショパンの代表的なピアノ曲です3"),
            mapOf("title" to "革命のエチュード4", "tag" to "ピアノ4", "desc" to "ピアノの詩人と言われたショパンの代表的なピアノ曲です4"),
        )

        // Adapterを定義してリストにセット
        val adapter = SimpleAdapter(
            this,
            data,
            R.layout.list_item, // 作ったレイアウトファイル
            arrayOf("title", "tag", "desc"), // キーの設定
            intArrayOf(R.id.item_title, R.id.item_tag, R.id.item_desc) // 割り当てるデータ
        )
        binding.list.adapter = adapter


    }
}