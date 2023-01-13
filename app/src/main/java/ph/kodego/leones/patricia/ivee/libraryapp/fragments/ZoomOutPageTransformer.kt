package ph.kodego.leones.patricia.ivee.libraryapp.fragments

import android.view.View
import androidx.viewpager2.widget.ViewPager2

private const val MIN_SCALE = 0.85f
private const val MIN_ALPHA = 0.5f

class ZoomOutPageTransformer:ViewPager2.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        view.apply{
            val pageWidth = width
            val pageHeight = height
            when{
                position < -1 -> { // [-Infinity, -1]
//                    This page is way off-screen to the left.
//                    No Animation Going Left
                    alpha = 0f
                }
                position <= 1 -> { // [-1,1]

//                    percent how much the fragment will shrink
                    val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
//                    Margin
                    val vertMargin = pageHeight * (1 - scaleFactor) / 2
                    val horzMargin = pageWidth * (1 - scaleFactor) / 2
                    translationX = if(position < 0) {
                        horzMargin - vertMargin / 2
                    } else {
                        horzMargin +vertMargin / 2
                    }

//                    Scale the page down (between MIN_SCALE and 1)
                    scaleX = scaleFactor
                    scaleY = scaleFactor

//                    Fade the page relative to its size.
                    alpha = (MIN_ALPHA +
                            (((scaleFactor - MIN_SCALE)/ (1 - MIN_SCALE)) * (1 - MIN_SCALE)))
                }
                else -> {
//                    This page is way off-screen to the right
                    alpha = 0f
//                    When it goes at the end of the Fragments No animations as well (stops)
                }
            }
        }
    }

}