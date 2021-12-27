package com.example.list_view

import android.media.Image

// データモデルクラス
// idはLong型。BaseAdapterを継承した時にオーバーライド必須の関数の一つにidを参照する関数があり、
// Long型で定義されてるため。
data class ListItem(
    val id: Long,
    val title: String,
    val tag: String,
    val desc: String,
    val imageResource: Int
)
