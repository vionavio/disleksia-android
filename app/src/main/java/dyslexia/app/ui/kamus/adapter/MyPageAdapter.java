package dyslexia.app.ui.kamus.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

//berfungsi untuk membuat fragment
public class MyPageAdapter extends FragmentPagerAdapter {

    List<Fragment> pages = new ArrayList<>();

    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pages.get(position).toString();
    }

    public void addPage(Fragment f) {
        pages.add(f);
    }
}