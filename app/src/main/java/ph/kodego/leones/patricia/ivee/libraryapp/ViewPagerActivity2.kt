package ph.kodego.leones.patricia.ivee.libraryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import ph.kodego.leones.patricia.ivee.libraryapp.adapter.FragmentAdapter
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.ActivityViewPagerBinding
import ph.kodego.leones.patricia.ivee.libraryapp.fragments.LibraryListFragment
import ph.kodego.leones.patricia.ivee.libraryapp.fragments.SearchFragment
import ph.kodego.leones.patricia.ivee.libraryapp.fragments.TransactionFragment
import ph.kodego.leones.patricia.ivee.libraryapp.fragments.ZoomOutPageTransformer

class ViewPagerActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var fragmentAdapter = FragmentAdapter(supportFragmentManager,lifecycle)
        fragmentAdapter.addFragment(LibraryListFragment())
        fragmentAdapter.addFragment(SearchFragment())
        fragmentAdapter.addFragment(TransactionFragment())



        with(binding.viewPager2){
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            setPageTransformer(ZoomOutPageTransformer())
            adapter = fragmentAdapter

        }

    }

    override fun onBackPressed() {
        if(binding.viewPager2.currentItem == 0){
            super.onBackPressed()
        }else{
            binding.viewPager2.currentItem = binding.viewPager2.currentItem - 1
        }
    }
}