package com.boongg.store.Fragments.VehicleInventoryFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boongg.store.Fragments.VehicleInventoryFragments.Steps.Step1;
import com.boongg.store.Fragments.VehicleInventoryFragments.Steps.Step2;
import com.boongg.store.Fragments.VehicleInventoryFragments.Steps.Step3;
import com.boongg.store.Fragments.VehicleInventoryFragments.Steps.Step4;
import com.boongg.store.R;

import java.util.ArrayList;

import me.drozdzynski.library.steppers.SteppersItem;
import me.drozdzynski.library.steppers.SteppersView;
import me.drozdzynski.library.steppers.interfaces.OnCancelAction;
import me.drozdzynski.library.steppers.interfaces.OnChangeStepAction;
import me.drozdzynski.library.steppers.interfaces.OnFinishAction;

public class AddBikeMain extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_add_bike_main, container, false);
        SteppersView.Config steppersViewConfig = new SteppersView.Config();
        steppersViewConfig.setOnFinishAction(new OnFinishAction() {
            @Override
            public void onFinish() {
                // Action on last step Finish button
            }
        });

        steppersViewConfig.setOnCancelAction(new OnCancelAction() {
            @Override
            public void onCancel() {
                // Action when click cancel on one of steps
            }
        });

        steppersViewConfig.setOnChangeStepAction(new OnChangeStepAction() {
            @Override
            public void onChangeStep(int position, SteppersItem activeStep) {
                // Action when click continue on each step
            }
        });

// Setup Support Fragment Manager for fragments in steps
        steppersViewConfig.setFragmentManager(getActivity().getSupportFragmentManager());

        ArrayList<SteppersItem> steps = new ArrayList<>();

        SteppersItem stepFirst = new SteppersItem();
        stepFirst.setLabel("Select Bike");
        stepFirst.setSubLabel("Choose a Bike");
        stepFirst.setFragment(new Step1());
        stepFirst.setPositiveButtonEnable(true);
        steps.add(stepFirst);


        SteppersItem stepSecond = new SteppersItem();
        stepSecond.setLabel("Add Bike Details");
        stepSecond.setSubLabel("Add Correct Details");
        stepSecond.setFragment(new Step2());
        stepSecond.setPositiveButtonEnable(true);
        steps.add(stepSecond);

        SteppersItem stepThird = new SteppersItem();
        stepThird.setLabel("Add Owner Details");
        stepThird.setFragment(new Step3());
        stepThird.setPositiveButtonEnable(true);
        steps.add(stepThird);

        SteppersItem stepFour = new SteppersItem();
        stepFour.setLabel("Add Bike Cost Details");
        stepFour.setFragment(new Step4());
        stepFour.setPositiveButtonEnable(true);
        steps.add(stepFour);
        SteppersView steppersView = (SteppersView) rootView.findViewById(R.id.steppersView);
        steppersView.setConfig(steppersViewConfig);
        steppersView.setItems(steps);
        steppersView.build();
        return rootView;
    }

    }
