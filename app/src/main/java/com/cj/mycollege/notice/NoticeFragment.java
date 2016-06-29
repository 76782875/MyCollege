package com.cj.mycollege.notice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cj.mycollege.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NoticeFragment.OnNoticeFragmentListener} interface
 * to handle interaction events.
 */
public class NoticeFragment extends Fragment {

    private OnNoticeFragmentListener mListener;


    public NoticeFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_notice, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_notice);
        ArrayList<String> dataSource = new ArrayList<String>();
        dataSource.add("寻物启事");
        dataSource.add("String 2");
        dataSource.add("招领启事");
        dataSource.add("String 4");
        dataSource.add("String 5");
        dataSource.add("String 6");
        dataSource.add("String 7");
        dataSource.add("String 8");
        dataSource.add("String 9");
        dataSource.add("String 10");
        dataSource.add("String 11");
        dataSource.add("String 12");
        dataSource.add("String 13");
        dataSource.add("String 14");
        dataSource.add("String 15");
        dataSource.add("String 16");


        NoticeAdapter adapter = new NoticeAdapter(getActivity(), dataSource);
        recyclerView.setAdapter(adapter);
        //设置网格布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置item动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onNoticeFragment(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNoticeFragmentListener) {
            mListener = (OnNoticeFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnNoticeFragmentListener");
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
    public interface OnNoticeFragmentListener {
        // TODO: Update argument type and name
        void onNoticeFragment(Uri uri);
    }
}
