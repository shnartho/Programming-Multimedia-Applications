package com.malkinfo.puzzlegames

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView

class PuzzlePiece(context: Context?) : AppCompatImageView(context!!) {
    var xCoord = 0
    var yCoord = 0
    var pieceWidth = 0
    var pieceHeight = 0
    var canMove = true
}