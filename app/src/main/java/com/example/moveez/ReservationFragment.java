package com.example.moveez;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ReservationFragment extends Fragment {

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;
        private long id;


        public ReservationFragment() {
            // Required empty public constructor
        }

        public ReservationFragment(long id) {

            this.id = id;
        }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HistoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        public static ReservationFragment newInstance(String param1, String param2) {
            ReservationFragment fragment = new ReservationFragment();
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, param1);
            args.putString(ARG_PARAM2, param2);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mParam1 = getArguments().getString(ARG_PARAM1);
                mParam2 = getArguments().getString(ARG_PARAM2);


            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.reservation_layout, container, false);
            List<Reservation> res = MovieDatabase.getInstance(getActivity()).reservationDao().getReservation(id);
            String[] menuItems = new String[res.size()];
            int i = 0;
            for (Reservation r : res) {
                menuItems[i] = "\nReservation for movie: " + r.getMovie_name() + "\n" +
                        "\nProjection: " + r.getProjection();
                i++;
            }

            ListView listView = (ListView) view.findViewById(R.id.reservation_list);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    getActivity(), android.R.layout.simple_list_item_1, menuItems


            );

            listView.setAdapter(adapter);
            return view;
        }


    }