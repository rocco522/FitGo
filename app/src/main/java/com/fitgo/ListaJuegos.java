package com.fitgo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class ListaJuegos extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_juegos);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_juegos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);

            // Crear un FoodFragment con el nombre como argumento
            Fragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();

            /*ImageView img = (ImageView)findViewById(R.id.imageView) ;
            if( this.getItemPosition(this) == 0 )
                img.setImageResource(R.drawable.img1);

            else if ( this.getItemPosition(this) == 1 )
                img.setImageResource(R.drawable.img2);

            Button boton = (Button) findViewById(R.id.btnMasInformacion);*/

            args.putString(PlaceholderFragment.ARG_SECTION_NAME, getPageTitle(i).toString());
            args.putString(PlaceholderFragment.ARG_SECTION_DESCRIPTION, getPageDescription(i).toString());
            args.putString(PlaceholderFragment.ARG_SECTION_FECHA, getPageFecha(i).toString());
            args.putString(PlaceholderFragment.ARG_SECTION_LUGAR, getPageLugar(i).toString());
            args.putInt(PlaceholderFragment.ARG_SECTION_IMAGE, i);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
                default: return "";
            }
        }

        public CharSequence getPageDescription(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.descripcion_section1);
                case 1:
                    return getString(R.string.descripcion_section2);
                case 2:
                    return getString(R.string.descripcion_section3);
                default: return "";
            }
        }


        public CharSequence getPageFecha(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.fecha_section1);
                case 1:
                    return getString(R.string.fecha_section2);
                case 2:
                    return getString(R.string.fecha_section3);
                default: return "";
            }
        }


        public CharSequence getPageLugar(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.lugar_section1);
                case 1:
                    return getString(R.string.lugar_section2);
                case 2:
                    return getString(R.string.lugar_section3);
                default: return "";
            }
        }


    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        public static final String ARG_SECTION_NAME = "section_name";
        public static final String ARG_SECTION_DESCRIPTION = "section_description";
        public static final String ARG_SECTION_FECHA = "section_fecha";
        public static final String ARG_SECTION_LUGAR = "section_lugar";
        public static final String ARG_SECTION_IMAGE = "section_image";

        private Button boton;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_content, container, false);

            Bundle args = getArguments();

            // imagen al fragmento
            //ImageView image = (ImageView)rootView.
            //        findViewById(R.id.imageView);
            //image.setImageResource(imgIds[args.getInt(ARG_SECTION_IMAGE)]);


            // texto
            ((TextView) rootView.findViewById(R.id.txtTitulo)).setText(
                    args.getString(ARG_SECTION_NAME));

            ((TextView) rootView.findViewById(R.id.txtDescripcion)).setText(
                    args.getString(ARG_SECTION_DESCRIPTION));

            ((TextView) rootView.findViewById(R.id.txtFecha)).setText( "Fecha y hora: "+
                    args.getString(ARG_SECTION_FECHA));

            ((TextView) rootView.findViewById(R.id.txtLugar)).setText( "Lugar: "+
                    args.getString(ARG_SECTION_LUGAR));

            boton = (Button)rootView.findViewById(R.id.btnMasInformacion);



            return rootView;
        }
    }

    public void masInformacion(View view){
                Intent intent = new Intent(this, Informacion.class);
                startActivity(intent);
    }

}
