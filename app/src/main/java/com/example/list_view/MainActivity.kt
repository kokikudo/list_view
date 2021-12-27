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

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // リスト項目データ
        val data = mutableListOf(
            "もやし", "カルパッチョ", "なす", "まいたけ", "ヨーグルト")

        // Adapterを定義してリストにセット
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_checked, // 項目にチェックができるリスト
            data
        )
        binding.list.adapter = adapter

        // 検索機能用にフィルターを有効化
        binding.list.isTextFilterEnabled = true

        // 長押しすると選択モードに移動するリスナー
        binding.list.setMultiChoiceModeListener(
        object : AbsListView.MultiChoiceModeListener {

            // モードの状態やリストの変化に応じて実行する関数
            // モード起動時
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                Log.d("Mode", "Mode Start")
                return true
            }
            // モード準備中
            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                Log.d("Mode", "Mode Prepare")
                return true
            }
            // チェック状態が変化した時
            override fun onItemCheckedStateChanged(
                mode: ActionMode?,
                position: Int,
                id: Long,
                checked: Boolean
            ) {
                Log.d("Mode", "Change Item Check")
            }
            // 項目をタップした時
            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                Log.d("Mode", "Item Clicked")
                return true
            }
            // モード終了時
            override fun onDestroyActionMode(mode: ActionMode?) {
                Log.d("Mode", "Mode End")

                // 空のリストを作り、チェックが入ってる項目のみ追加
                val msg = mutableListOf<CharSequence>()
                binding.list.forEach {
                    val check = it as CheckedTextView
                    if (check.isChecked) msg.add(check.text)
                }
                // トースト出力
                Toast.makeText(
                    this@MainActivity,
                    "選択したのは、${msg.joinToString()}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })

        // リスト末尾まで表示したら次のリストを表示させる
        binding.list.setOnScrollListener(
            object : AbsListView.OnScrollListener {
                override fun onScroll(
                    view: AbsListView?,
                    firstVisibleItem: Int,
                    visibleItemCount: Int,
                    totalItemCount: Int
                ) {
                    if (firstVisibleItem + visibleItemCount + 3 > totalItemCount) {
                        adapter.add("次　1")
                        adapter.add("次　2")
                        adapter.add("次　3")
                    }
                }

                override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {
                }
            }
        )

        // 検索ボックスに入力された時の処理
        binding.searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText.isNullOrBlank())
                        binding.list.clearTextFilter()
                     else
                        binding.list.setFilterText(newText)

                    return false
                }

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }
            }
        )

    }
}