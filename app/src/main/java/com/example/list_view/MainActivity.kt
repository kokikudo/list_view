package com.example.list_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.list_view.databinding.ActivityMainBinding

// SimpleAdapterより自由度の高いレイアウトを作るためには、
// 1.項目をデータモデル化したファイル
// 2.レイアウトファイル
// 3.1と2を関連付けするアダプター
// の3つを作る
// ImageViewを設置したりできる
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // リストアイテム
        val data = listOf(
            ListItem(1, "革命のエチュード", "ピアノ", "ピアノの詩人と言われたショパンの代表的なピアノ曲です", R.drawable.ham),
            ListItem(2, "革命のエチュード2", "ピアノ2", "ピアノの詩人と言われたショパンの代表的なピアノ曲です2", R.drawable.pet),
            ListItem(3, "革命のエチュード3", "ピアノ3", "ピアノの詩人と言われたショパンの代表的なピアノ曲です3", R.drawable.sea),
            ListItem(4, "革命のエチュード4", "ピアノ4", "ピアノの詩人と言われたショパンの代表的なピアノ曲です4", R.drawable.seal)
        )

        // ListItem配列とレイアウトを関連付ける
        binding.list.adapter = MyListAdapter(this, data, R.layout.list_item)

    }
}