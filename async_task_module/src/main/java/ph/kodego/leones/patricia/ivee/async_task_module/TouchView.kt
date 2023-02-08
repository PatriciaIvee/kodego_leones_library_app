package ph.kodego.leones.patricia.ivee.async_task_module

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class TouchView(context: Context, attrs: AttributeSet): AppCompatImageView(context, attrs){

    fun loadImage(uri: Uri){
        var newBitmap: Bitmap? = null

        val bmpFactoryOptions = BitmapFactory.Options()
        bmpFactoryOptions.inJustDecodeBounds = true

        val widthRatio =
            ceil((0 / viewWidth).toDouble()).toInt()
        val heightRatio =
            ceil((0 / viewHeight).toDouble()).toInt()
        if (heightRatio > widthRatio) {
            bmpFactoryOptions.inSampleSize = heightRatio
        } else {
            bmpFactoryOptions.inSampleSize = heightRatio
        }
        bmpFactoryOptions.inJustDecodeBounds = false
        newBitmap = BitmapFactory.decodeStream(context.contentResolver.openInputStream(uri),
            null, bmpFactoryOptions)

        path.reset()

        extraBitmap = createBitmap(viewWidth, viewHeight, Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawBitmap(newBitmap!!, 0f,0f, paint)
        invalidate()

    }
}