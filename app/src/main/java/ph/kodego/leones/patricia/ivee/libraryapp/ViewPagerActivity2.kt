package ph.kodego.leones.patricia.ivee.libraryapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import ph.kodego.leones.patricia.ivee.libraryapp.adapter.FragmentAdapter
import ph.kodego.leones.patricia.ivee.libraryapp.databinding.ActivityViewPagerBinding
import ph.kodego.leones.patricia.ivee.libraryapp.fragments.librarylist.LibraryListFragment
import ph.kodego.leones.patricia.ivee.libraryapp.fragments.SearchFragment
import ph.kodego.leones.patricia.ivee.libraryapp.fragments.TransactionFragment
import ph.kodego.leones.patricia.ivee.libraryapp.fragments.ZoomOutPageTransformer
import ph.kodego.leones.patricia.ivee.libraryapp.fragments.librarylist.LibraryListViewModel

class ViewPagerActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityViewPagerBinding
    private final var LOGINFO = "VIEWPAGERACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        Log.d(LOGINFO,"${bundle!!.getString("userNameBundle")}")
        Log.d(LOGINFO,"${bundle!!.getString("passwordBundle")}")

        val data = Bundle()

        data.putString("userNameBundle", "${bundle!!.getString("userNameBundle")}" )
        data.putString("passwordBundle", "${bundle!!.getString("passwordBundle")}")

        val libraryListFragment = LibraryListFragment()
        libraryListFragment.arguments = data

        var fragmentAdapter = FragmentAdapter(supportFragmentManager,lifecycle)
        fragmentAdapter.addFragment(libraryListFragment)
        fragmentAdapter.addFragment(SearchFragment())
        fragmentAdapter.addFragment(TransactionFragment())



        with(binding.viewPager2){
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            setPageTransformer(ZoomOutPageTransformer())
            adapter = fragmentAdapter

        }

        val tabTitles = arrayOf("Home", "Search", "Transaction")
        TabLayoutMediator(binding.tabLayout,binding.viewPager2){
                tab, position ->
            tab.text = tabTitles[position]
        }.attach()

    }

    override fun onBackPressed() {
        if(binding.viewPager2.currentItem == 0){
            super.onBackPressed()
        }else{
            binding.viewPager2.currentItem = binding.viewPager2.currentItem - 1
        }
    }
}
// ON CREATE
//        val libraryListViewModel = ViewModelProvider(this).get(LibraryListViewModel::class.java)
//        libraryListViewModel.userNameBundle.value = userNameBundle
//        libraryListViewModel.passwordBundle.value = passwordBundle