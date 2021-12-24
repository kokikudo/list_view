package com.example.list_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.CheckedTextView
import android.widget.Toast
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
        val data = mutableListOf("もやし", "カルパッチョ", "なす", "まいたけ", "ヨーグルト")

        // Adapterを定義してリストにセット
        binding.list.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_checked, // 項目にチェックができるリスト
            data
        )

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

    }
}