package com.cj.mycollege.knownall;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cj.mycollege.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link KnownAllFragment.OnKnownAllFragmentListener} interface
 * to handle interaction events.

 */
public class KnownAllFragment extends Fragment {

    private OnKnownAllFragmentListener mListener;

    public KnownAllFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_known_all, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_knownAll);
        ArrayList<String> dataSource = new ArrayList<String>();

        KnownAllAdapter adapter = new KnownAllAdapter(getActivity(), dataSource);
        recyclerView.setAdapter(adapter);
        //设置网格布局管理器
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        //设置item动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onKnownAllFragment(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnKnownAllFragmentListener) {
            mListener = (OnKnownAllFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnKnownAllFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnKnownAllFragmentListener {
        // TODO: Update argument type and name
        void onKnownAllFragment(Uri uri);
    }
}
