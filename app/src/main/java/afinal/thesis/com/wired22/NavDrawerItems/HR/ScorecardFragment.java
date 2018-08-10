package afinal.thesis.com.wired22.NavDrawerItems.HR;

import android.animation.Animator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import afinal.thesis.com.wired22.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScorecardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ScorecardFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    EditText etHRComment;
    FloatingActionButton fab, fabSave, fabSubmit, fabCheckGuideline;
    LinearLayout fabSaveLayout, fabSubmitLayout, fabCheckGuidelineLayout;
    View fabBGLayout;
    boolean isFabOpen = false;


    public ScorecardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hr__scorecard, container, false);

        etHRComment = view.findViewById(R.id.etHRComment);

        if (etHRComment.performClick()){
            etHRComment.setCursorVisible(true);
        }

        fabSaveLayout = view.findViewById(R.id.fabSaveLayout);
        fabSubmitLayout = view.findViewById(R.id.fabSubmitLayout);
        fabCheckGuidelineLayout = view.findViewById(R.id.fabCheckGuidelineLayout);
        fab = view.findViewById(R.id.fab);
        fabSave = view.findViewById(R.id.fabSave);
        fabSubmit = view.findViewById(R.id.fabSubmit);
        fabCheckGuideline = view.findViewById(R.id.fabCheckGuideline);
        fabBGLayout = view.findViewById(R.id.fabBGLayout);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFabOpen){
                    showFabMenu();
                }else{
                    closeFabMenu();
                }
            }
        });

        fabBGLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeFabMenu();
            }
        });

        fabSaveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Saved.", Toast.LENGTH_SHORT).show();
            }
        });

        fabSubmitLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Submitted.", Toast.LENGTH_SHORT).show();
            }
        });

        fabCheckGuidelineLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext(), "Guidelines.", Toast.LENGTH_SHORT).show();


//TODO: CHANGE THIS DIRECT IMPLEMENTATION of ALERTDIALOG maybe into DIALOGFRAGMENT or FIND a way to solve this issue "Can not perform this action after onSaveInstanceState"
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(R.string.ratingScaleTitle);
                builder.setView(R.layout.fab_check_guideline_layout);
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                builder.show();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.YELLOW));
            }

        });
        return view;
    }

    private void showFabMenu(){
        isFabOpen = true;
        fabSaveLayout.setVisibility(View.VISIBLE);
        fabSubmitLayout.setVisibility(View.VISIBLE);
        fabCheckGuidelineLayout.setVisibility(View.VISIBLE);
        fabBGLayout.setVisibility(View.VISIBLE);

        fab.animate().rotationBy(180);
        fabSaveLayout.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fabSubmitLayout.animate().translationY(-getResources().getDimension(R.dimen.standard_100));
        fabCheckGuidelineLayout.animate().translationY(-getResources().getDimension(R.dimen.standard_145));
    }

    private void closeFabMenu(){
        isFabOpen = false;
        fabBGLayout.setVisibility(View.GONE);
        fab.animate().rotationBy(-180);
        fabSaveLayout.animate().translationY(0);
        fabSubmitLayout.animate().translationY(0);
        fabCheckGuidelineLayout.animate().translationY(0).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if (!isFabOpen){
                    fabSaveLayout.setVisibility(View.GONE);
                    fabSubmitLayout.setVisibility(View.GONE);
                    fabCheckGuidelineLayout.setVisibility(View.GONE);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
